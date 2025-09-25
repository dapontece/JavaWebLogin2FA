<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Bienvenido</title>
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
            background: #d4edda; /* verde suave */
            padding: 40px 30px;
            border-radius: 10px;
            box-shadow: 0 5px 15px rgba(0,0,0,0.1);
            width: 350px;
            text-align: center;
            color: #155724; /* texto verde oscuro */
        }

        h1 {
            margin-bottom: 20px;
            font-size: 24px;
        }

        p {
            margin-bottom: 30px;
        }

        button {
            width: 100%;
            padding: 10px;
            border: none;
            border-radius: 5px;
            background-color: #28a745; /* verde fuerte */
            color: white;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        button:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Bienvenido, ${usuario}!</h1>
        <p>Has ingresado correctamente al sistema.</p>
        <form action="login.jsp" method="get">
            <button type="submit">Salir</button>
        </form>
    </div>
</body>
</html>
