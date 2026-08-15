package com.duban.util;

public class NombresUtil {

    public static String nombreCompleto(String nombre, String apellido) {
        if (nombre == null || apellido == null) {
            throw new IllegalArgumentException("Nombre y apellido no pueden ser nulos");
        }
        return nombre.trim() + " " + apellido.trim();
    }

}
