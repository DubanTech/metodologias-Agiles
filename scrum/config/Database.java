package config;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Database {
    private static Database instance;
    private final Properties properties = new Properties();

    private Database() {
        try (InputStream input = Database.class.getClassLoader()
                .getResourceAsStream("config.properties")) {
            if (input == null) {
                System.err.println("Ojo: no se encontró el archivo config.properties. Se usarán valores predeterminados.");
            } else {
                properties.load(input);
            }
        } catch (Exception e) {
            System.err.println("Error cargando config.properties: " + e.getMessage());
        }

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Error registrando PostgreSQL Driver: " + e.getMessage());
        }
    }


    public static synchronized Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }

    public Connection getConnection() throws SQLException {
        String url = getProperty("db.url", "jdbc:postgresql://localhost:5432/metodologias_agiles");
        String user = getProperty("db.user", "duban");
        String pass = getProperty("db.password", "DubanPro123!");
        return DriverManager.getConnection(url, user, pass);
    }
}
