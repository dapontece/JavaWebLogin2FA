package modelo;

import config.Conexion;
import java.sql.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class UsuarioDao {

    // Registrar usuario
    public boolean registrarUsuario(Usuario u) {
        String sql = "INSERT INTO usuario (email_profesor, contrasena) VALUES (?, ?)";
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, u.getEmail());
            ps.setString(2, cifrarPassword(u.getPassword()));
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Validar usuario
    public boolean validarUsuario(String email, String password) {
        String sql = "SELECT * FROM usuario WHERE email_profesor = ? AND contrasena = ?";
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, email);
            ps.setString(2, cifrarPassword(password));
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Cifrar password SHA-256
    public String cifrarPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hash) sb.append(String.format("%02x", b));
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Generar código aleatorio de 6 dígitos
    public String generarCodigo() {
        Random rand = new Random();
        int codigo = 100000 + rand.nextInt(900000);
        return String.valueOf(codigo);
    }
}
