<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Registro</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background: #f0f2f5;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .container {
            background: #ffffff;
            padding: 40px 30px;
            border-radius: 10px;
            box-shadow: 0 5px 15px rgba(0,0,0,0.1);
            width: 350px;
        }

        h1 {
            text-align: center;
            color: #333333;
            margin-bottom: 30px;
        }

        input {
            width: 100%;
            padding: 10px;
            margin: 8px 0;
            border-radius: 5px;
            border: 1px solid #ccc;
        }

        button {
            width: 100%;
            padding: 10px;
            margin-top: 15px;
            border: none;
            border-radius: 5px;
            background-color: #28a745;
            color: white;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        button:hover {
            background-color: #1e7e34;
        }

        p {
            text-align: center;
            margin-top: 15px;
        }

        a {
            color: #007bff;
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }

        .error-msg {
            color: red;
            text-align: center;
            margin-bottom: 10px;
        }

    </style>
</head>
<body>
    <div class="container">
        <h1>Registro de Usuario</h1>
        <c:if test="${not empty mensaje}">
            <p class="error-msg">${mensaje}</p>
        </c:if>
        <form action="${pageContext.request.contextPath}/UsuarioController" method="post">
            <input type="hidden" name="accion" value="Registrar">
            <input type="text" name="email" placeholder="Email" required>
            <input type="password" name="password" placeholder="Contraseña" required>
            <input type="password" name="confirmar" placeholder="Confirmar Contraseña" required>
            <button type="submit">Registrar</button>
        </form>
        <p>Ya tienes cuenta? <a href="login.jsp">Volver al Login</a></p>
    </div>
</body>
</html>
