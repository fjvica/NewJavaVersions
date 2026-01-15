package com.versions.java.Java12A17.record;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RecordApplication {

    /**
     * Metodo para ejecutar el ejemplo de Clases record en Java 14+
     *
     * Incluye:
     * 1️⃣ Creación de un record simple
     * 2️⃣ Acceso a sus campos con métodos automáticos
     * 3️⃣ Comparación de objetos y uso de toString()
     */
    public static void ejecutar() {
        System.out.println("=== Ejemplo 2.3: Clases record ===\n");

        // -------------------------------
        // 1️⃣ Creación de records
        // -------------------------------
        Persona p1 = new Persona("Fran", 28);
        Persona p2 = new Persona("Ana", 32);
        Persona p3 = new Persona("Fran", 28);

        // Acceso a campos
        System.out.println("Nombre p1: " + p1.nombre());
        System.out.println("Edad p2: " + p2.edad());

        // toString automático
        System.out.println("p1: " + p1);
        System.out.println("p2: " + p2);

        // Comparación con equals
        System.out.println("p1.equals(p3): " + p1.equals(p3)); // true
        System.out.println("p1.equals(p2): " + p1.equals(p2)); // false

        System.out.println("\n=== Fin del ejemplo 2.3 ===");
    }

    // Definición del record
    public record Persona(String nombre, int edad) {}

    // Main independiente por si quieres ejecutar solo este ejemplo
    public static void main(String[] args) {
        SpringApplication.run(RecordApplication.class, args);
        ejecutar();
    }
}

