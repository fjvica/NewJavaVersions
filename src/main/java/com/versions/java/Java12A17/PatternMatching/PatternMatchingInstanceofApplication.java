package com.versions.java.Java12A17.PatternMatching;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PatternMatchingInstanceofApplication {

    /**
     * Metodo para ejecutar el ejemplo de Pattern Matching con instanceof
     *
     * Incluye:
     * 1️⃣ Comprobación de tipo y declaración de variable en un solo paso
     * 2️⃣ Uso con if-else
     * 3️⃣ Evita cast explícito
     */
    public static void ejecutar() {
        System.out.println("=== Ejemplo 2.2: Pattern Matching con instanceof ===\n");

        Object obj1 = "Hola mundo";
        Object obj2 = 42;
        Object obj3 = 3.14;

        comprobarTipo(obj1);
        comprobarTipo(obj2);
        comprobarTipo(obj3);

        System.out.println("\n=== Fin del ejemplo 2.2 ===");
    }

    public static void comprobarTipo(Object obj) {
        if (obj instanceof String texto) {
            System.out.println("Es un String: " + texto + " (longitud: " + texto.length() + ")");
        } else if (obj instanceof Integer numero) {
            System.out.println("Es un Integer: " + numero + " (doble: " + (numero * 2) + ")");
        } else if (obj instanceof Double decimal) {
            System.out.println("Es un Double: " + decimal);
        } else {
            System.out.println("Tipo desconocido: " + obj);
        }
    }

    // Main independiente por si quieres ejecutar solo este ejemplo
    public static void main(String[] args) {
        SpringApplication.run(PatternMatchingInstanceofApplication.class, args);
        ejecutar();
    }
}

