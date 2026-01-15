package com.versions.java.Java9.MetodosString;

public class NuevosMetodosStringApplication {

    public static void ejecutar() {
        System.out.println("=== Ejemplo 1.3: Nuevos métodos de String ===\n");

        String texto = "   Hola Mundo   ";
        String multilinea = "Linea1\nLinea2\nLinea3";

        // -------------------------------
        // 1️⃣ isBlank
        // -------------------------------
        String vacio = "   ";
        System.out.println("isBlank() vacio: " + vacio.isBlank()); // true
        System.out.println("isBlank() texto: " + texto.isBlank()); // false

        // -------------------------------
        // 2️⃣ strip / stripLeading / stripTrailing
        // -------------------------------
        System.out.println("strip(): '" + texto.strip() + "'");
        System.out.println("stripLeading(): '" + texto.stripLeading() + "'");
        System.out.println("stripTrailing(): '" + texto.stripTrailing() + "'");

        // -------------------------------
        // 3️⃣ lines()
        // -------------------------------
        System.out.println("\nlines():");
        multilinea.lines().forEach(line -> System.out.println("> " + line));

        // -------------------------------
        // 4️⃣ repeat()
        // -------------------------------
        String repetido = "Hola".repeat(3);
        System.out.println("\nrepeat(3): " + repetido);

        // -------------------------------
        // 5️⃣ indent()
        // -------------------------------
        String indentado = "Linea indentada".indent(4);
        System.out.println("\nindent(4):\n" + indentado);

        System.out.println("\n=== Fin del ejemplo 1.3 ===");
    }

    public static void main(String[] args) {
        ejecutar();
    }
}

