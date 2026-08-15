package com.duban;

import java.sql.Connection;
import java.sql.SQLException;

import com.duban.config.ConexionDB;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        try (Connection conexion = ConexionDB.getConnection()) {
            if (conexion != null && !conexion.isClosed()) {
                System.out.println("¡Conexión exitosa a PostgreSQL!");
            }
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos:");
            e.printStackTrace();
        }
    }
}
