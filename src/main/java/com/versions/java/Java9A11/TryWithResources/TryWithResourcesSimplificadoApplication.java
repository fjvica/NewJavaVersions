package com.versions.java.Java9A11.TryWithResources;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResourcesSimplificadoApplication {

    public static void ejecutar() {
        System.out.println("=== Ejemplo 1.7: try-with-resources simplificado ===\n");

        // -------------------------------
        // 1️⃣ Recurso creado antes del try
        // -------------------------------
        try {
            BufferedReader reader = new BufferedReader(new FileReader("ejemplo.txt"));

            // -------------------------------
            // 2️⃣ Usando la variable en try simplificado
            // -------------------------------
            try (reader) {
                String linea = reader.readLine();
                System.out.println("Primera línea del archivo: " + linea);
            }

        } catch (IOException e) {
            System.out.println("Error leyendo el archivo: " + e);
        }

        System.out.println("\n=== Fin del ejemplo 1.7 ===");
    }

    public static void main(String[] args) {
        ejecutar();
    }
}

