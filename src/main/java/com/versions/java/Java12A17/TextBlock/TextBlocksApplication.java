package com.versions.java.Java12A17.TextBlock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TextBlocksApplication {

    /**
     * Metodo para ejecutar ejemplo de Text Blocks (Bloques de texto)
     *
     * Incluye:
     * 1️⃣ String multilinea con tres comillas dobles
     * 2️⃣ Indentacion preservada
     * 3️⃣ Uso de variables en text block
     */
    public static void ejecutar() {
        System.out.println("=== Ejemplo 2.5: Text Blocks ===\n");

        // -------------------------------
        // 1️⃣ Bloque de texto HTML
        // -------------------------------
        String html = """
                      <html>
                          <body>
                              <p>Hola mundo desde Text Blocks!</p>
                          </body>
                      </html>
                      """;
        System.out.println("HTML:\n" + html);
        System.out.println();

        // -------------------------------
        // 2️⃣ Bloque de texto con variable
        // -------------------------------
        String nombre = "Fran";
        String mensaje = """
                         Hola %s,
                         Bienvenido a los Text Blocks en Java 15!
                         """.formatted(nombre);
        System.out.println(mensaje);

        System.out.println("\n=== Fin del ejemplo 2.5 ===");
    }

    // Main independiente por si quieres ejecutar solo este ejemplo
    public static void main(String[] args) {
        SpringApplication.run(TextBlocksApplication.class, args);
        ejecutar();
    }
}

