package com.versions.java.Java12A17.StreamApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class StreamApiApplication {

    /**
     * Metodo para demostrar nuevos metodos en Stream API
     *
     * Incluye:
     * 1️⃣ takeWhile
     * 2️⃣ dropWhile
     * 3️⃣ iterate mejorado
     */
    public static void ejecutar() {
        System.out.println("=== Ejemplo 2.7: Stream API (takeWhile, dropWhile, iterate) ===\n");

        List<Integer> numeros = List.of(1, 2, 3, 4, 5, 6, 7);

        // -------------------------------
        // 1️⃣ takeWhile: toma mientras se cumpla la condicion
        // -------------------------------
        System.out.println("takeWhile (n < 4):");
        numeros.stream()
                .takeWhile(n -> n < 4)
                .forEach(n -> System.out.print(n + " "));
        System.out.println("\n");

        // -------------------------------
        // 2️⃣ dropWhile: descarta hasta que la condicion no se cumpla
        // -------------------------------
        System.out.println("dropWhile (n < 4):");
        numeros.stream()
                .dropWhile(n -> n < 4)
                .forEach(n -> System.out.print(n + " "));
        System.out.println("\n");

        // -------------------------------
        // 3️⃣ iterate mejorado: incluye condicion de parada
        // -------------------------------
        System.out.println("iterate con condicion (n < 10):");
        Stream.iterate(0, n -> n < 10, n -> n + 2)
                .forEach(n -> System.out.print(n + " "));
        System.out.println("\n");

        System.out.println("=== Fin del ejemplo 2.7 ===");
    }

    // Main independiente por si quieres ejecutar solo este ejemplo
    public static void main(String[] args) {
        SpringApplication.run(StreamApiApplication.class, args);
        ejecutar();
    }
}

