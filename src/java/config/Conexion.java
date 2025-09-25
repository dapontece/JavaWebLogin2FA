package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String URL =
        "jdbc:sqlserver://LAPTOP-IC6TU90C:1433;"
      + "databaseName=master;"
      + "encrypt=true;"
      + "trustServerCertificate=true;"
      + "applicationName=NetBeansApp;"
      + "loginTimeout=30;";

    private static final String USER = "sa";
    private static final String PASSWORD = "admin123";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver JDBC de SQL Server no encontrado. Agrega el JAR al proyecto.", e);
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
