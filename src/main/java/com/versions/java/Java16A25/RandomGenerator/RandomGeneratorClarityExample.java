package com.versions.java.Java16A25.RandomGenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;
import java.util.stream.IntStream;

/**
 * Ejemplo 6.2: RandomGenerator API en Java 17+
 *
 * Este ejemplo muestra:
 * 1️⃣ Como crear un generador aleatorio moderno
 * 2️⃣ Como generar números aleatorios simples
 * 3️⃣ Como generar un stream de números aleatorios
 * 4️⃣ Como usar un algoritmo específico
 */
@SpringBootApplication
public class RandomGeneratorClarityExample {

    public static void ejecutar() {
        System.out.println("=== Ejemplo 6.2: RandomGenerator API ===\n");

        // -------------------------------
        // 1️⃣ Crear un generador aleatorio por defecto
        // -------------------------------
        RandomGenerator rnd = RandomGenerator.getDefault(); // Devuelve un generador moderno por defecto
        System.out.println("Generador usado: " + rnd.getClass().getSimpleName());

        // -------------------------------
        // 2️⃣ Generar números aleatorios simples
        // -------------------------------
        int numeroEntero = rnd.nextInt(100); // Número entero entre 0 y 99
        double numeroDecimal = rnd.nextDouble(); // Número decimal entre 0.0 y 1.0

        System.out.println("Número entero aleatorio (0-99): " + numeroEntero);
        System.out.println("Número decimal aleatorio (0.0-1.0): " + numeroDecimal);

        // -------------------------------
        // 3️⃣ Generar un stream de números aleatorios
        // -------------------------------
        // Creamos 5 números aleatorios entre 1 y 49
        IntStream numerosAleatorios = rnd.ints(5, 1, 50);
        System.out.print("5 números aleatorios generados con stream: ");
        numerosAleatorios.forEach(n -> System.out.print(n + " "));
        System.out.println();

        // -------------------------------
        // 4️⃣ Usar un algoritmo específico
        // -------------------------------
        // Podemos elegir un algoritmo moderno, por ejemplo "Xoroshiro128PlusPlus"
        RandomGenerator xoroshiro = RandomGeneratorFactory.of("Xoroshiro128PlusPlus").create();

        // Generamos un número entero entre 0 y 99 usando este algoritmo
        int numeroXoroshiro = xoroshiro.nextInt(100);
        System.out.println("Número aleatorio con Xoroshiro128PlusPlus (0-99): " + numeroXoroshiro);

        System.out.println("\n=== Fin del ejemplo 6.2 ===");
    }

    // Main independiente para ejecutar solo este ejemplo
    public static void main(String[] args) {
        SpringApplication.run(RandomGeneratorClarityExample.class, args);
        ejecutar();
    }
}

