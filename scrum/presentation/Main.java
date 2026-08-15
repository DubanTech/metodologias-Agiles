package presentation;

import config.Database;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, Scrum!");
        Database db = Database.getInstance();
        
        System.out.println("Database URL: " + db.getProperty("db.url", "jdbc:postgresql://localhost:5432/bikesharing_db"));
    }
}
