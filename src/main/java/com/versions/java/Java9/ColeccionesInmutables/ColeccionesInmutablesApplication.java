package com.versions.java.Java9.ColeccionesInmutables;

import java.util.List;

public class ColeccionesInmutablesApplication {

    // Metodo para ejecutar el ejemplo
    public static void ejecutar() {
        System.out.println("=== Ejemplo 1.1: Colecciones Inmutables ===");

        List<String> lista = List.of("A", "B", "C");
        System.out.println("Lista inmutable: " + lista);

        try {
            lista.add("D"); // Esto lanzará UnsupportedOperationException
        } catch (UnsupportedOperationException e) {
            System.out.println("No se puede modificar la lista inmutable");
        }
    }

    // Main independiente por si quieres ejecutar solo este ejemplo
    public static void main(String[] args) {
        ejecutar();
    }
}

