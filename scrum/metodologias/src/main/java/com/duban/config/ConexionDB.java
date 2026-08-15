package com.duban.config;
import java.io.InputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConexionDB {

    private static Properties prop = new Properties();

    static {
        // Cargar el archivo config.properties desde el classpath
        try (InputStream input = ConexionDB.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println("No se pudo encontrar el archivo config.properties");
            } else {
                prop.load(input);
                // Cargar el driver explícitamente (opcional en versiones modernas de JDBC, pero recomendado)
                Class.forName(prop.getProperty("db.driver"));
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        String url = prop.getProperty("db.url");
        String user = prop.getProperty("db.user");
        String password = prop.getProperty("db.password");

        return DriverManager.getConnection(url, user, password);
    }
}