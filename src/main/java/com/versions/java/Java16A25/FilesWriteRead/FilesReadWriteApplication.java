package com.versions.java.Java16A25.FilesWriteRead;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Ejemplo 6.1: Files.readString / Files.writeString en Java 11+
 *
 * Incluye:
 * 1️⃣ Escritura de un archivo de texto
 * 2️⃣ Lectura del archivo completo
 * 3️⃣ Uso de Path y manejo simple de IOException
 */
@SpringBootApplication
public class FilesReadWriteApplication {

    public static void ejecutar() throws IOException {
        System.out.println("=== Ejemplo 6.1: Files.readString / writeString ===\n");

        Path archivo = Path.of("ejemplo.txt");

        // -------------------------------
        // 1️⃣ Escribir contenido en un archivo
        // -------------------------------
        String contenidoEscribir = "Hola mundo!\nJava moderno es genial.";
        Files.writeString(archivo, contenidoEscribir);
        System.out.println("Archivo escrito: ejemplo.txt");

        // -------------------------------
        // 2️⃣ Leer contenido completo del archivo
        // -------------------------------
        String contenidoLeido = Files.readString(archivo);
        System.out.println("Contenido leído:\n" + contenidoLeido);

        System.out.println("\n=== Fin del ejemplo 6.1 ===");
    }

    // Main independiente por si quieres ejecutar solo este ejemplo
    public static void main(String[] args) throws IOException {
        SpringApplication.run(FilesReadWriteApplication.class, args);
        ejecutar();
    }
}

