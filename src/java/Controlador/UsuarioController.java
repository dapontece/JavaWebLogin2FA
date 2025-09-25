package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Usuario;
import modelo.UsuarioDao;
import modelo.CorreoUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/UsuarioController")
public class UsuarioController extends HttpServlet {
    private UsuarioDao dao = new UsuarioDao();
    private Map<String, String> codigos = new HashMap<>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");

        switch (accion) {
            case "Registrar": registrar(request, response); break;
            case "Login": login(request, response); break;
            case "Verificar": verificar(request, response); break;
        }
    }

    private void registrar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String email = request.getParameter("email");
        String pass = request.getParameter("password");
        String confPass = request.getParameter("confirmar");
        if (!pass.equals(confPass)) {
            request.setAttribute("mensaje", "Las contraseñas no coinciden");
            request.getRequestDispatcher("registrar.jsp").forward(request, response);
            return;
        }
        Usuario u = new Usuario(email, pass);
        if (dao.registrarUsuario(u)) request.setAttribute("mensaje", "Registro exitoso");
        else request.setAttribute("mensaje", "Error al registrar");
        request.getRequestDispatcher("registrar.jsp").forward(request, response);
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String email = request.getParameter("email");
        String pass = request.getParameter("password");

        if (dao.validarUsuario(email, pass)) {
            String codigo = dao.generarCodigo();
            codigos.put(email, codigo);
            CorreoUtil.enviarCodigo(email, codigo);
            request.setAttribute("email", email);
            request.getRequestDispatcher("verificar.jsp").forward(request, response);
        } else {
            request.setAttribute("mensaje", "Usuario o contraseña incorrectos");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    private void verificar(HttpServletRequest request, HttpServletResponse response) 
        throws IOException, ServletException {
    String email = request.getParameter("email");
    String codigoIngresado = request.getParameter("codigo");
    String codigoReal = codigos.get(email);

    if (codigoReal != null && codigoReal.equals(codigoIngresado)) {
        // Código correcto → ir a bienvenido.jsp
        request.setAttribute("usuario", email);
        request.getRequestDispatcher("bienvenido.jsp").forward(request, response);
    } else {
        // Código incorrecto → volver a verificar.jsp
        request.setAttribute("mensaje", "Acceso denegado");
        request.setAttribute("email", email);
        request.getRequestDispatcher("verificar.jsp").forward(request, response);
    }
}

}
