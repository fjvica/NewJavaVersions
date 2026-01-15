package com.versions.java.StreamApiComplete;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;
import java.util.stream.*;

@SpringBootApplication
public class StreamApiCompletaApplication {

    /**
     * Metodo para ejecutar un repaso completo de la API Stream en Java
     *
     * Incluye ejemplos de:
     * 1️⃣ Creacion de Streams
     * 2️⃣ Operaciones intermedias (transformaciones)
     * 3️⃣ Operaciones terminales
     * 4️⃣ Reduccion y coleccion
     * 5️⃣ Streams primitivos
     */
    public static void ejecutar() {
        System.out.println("=== Ejemplo: API completa de Streams ===\n");

        List<Integer> numeros = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // -------------------------------
        // 1️⃣ CREACION DE STREAMS
        // -------------------------------
        System.out.println("-- Creacion de Streams --");

        // Desde una lista
        Stream<Integer> stream1 = numeros.stream();

        // Desde valores individuales
        Stream<String> stream2 = Stream.of("A", "B", "C");

        // Desde un array
        Stream<Integer> stream3 = Arrays.stream(new Integer[]{1, 2, 3});

        // Stream infinito (limitamos para evitar bucle)
        Stream<Double> stream4 = Stream.generate(Math::random).limit(3);
        stream4.forEach(n -> System.out.println("Random: " + n));

        // Stream iterate con condicion (Java 9+)
        Stream.iterate(0, n -> n < 10, n -> n + 2)
                .forEach(n -> System.out.print(n + " "));
        System.out.println("\n");

        // -------------------------------
        // 2️⃣ OPERACIONES INTERMEDIAS
        // -------------------------------
        System.out.println("-- Operaciones intermedias --");

        numeros.stream()
                .filter(n -> n % 2 == 0) // filtra pares
                .map(n -> n * n) // eleva al cuadrado
                .sorted(Comparator.reverseOrder()) // ordena descendente
                .distinct() // elimina duplicados
                .peek(n -> System.out.print(n + " ")) // muestra intermedio
                .limit(3) // toma los 3 primeros
                .skip(1) // salta el primero
                .forEach(n -> System.out.println("\nProcesado: " + n));

        // takeWhile y dropWhile (Java 9+)
        System.out.println("\ntakeWhile (n < 6):");
        numeros.stream().takeWhile(n -> n < 6).forEach(System.out::print);
        System.out.println("\n\ndropWhile (n < 6):");
        numeros.stream().dropWhile(n -> n < 6).forEach(System.out::print);
        System.out.println("\n");

        // -------------------------------
        // 3️⃣ OPERACIONES TERMINALES
        // -------------------------------
        System.out.println("-- Operaciones terminales --");

        long count = numeros.stream().count();
        System.out.println("Cantidad total: " + count);

        Optional<Integer> primero = numeros.stream().findFirst();
        System.out.println("Primer elemento: " + primero.orElse(null));

        Optional<Integer> cualquiera = numeros.stream().findAny();
        System.out.println("Cualquier elemento: " + cualquiera.orElse(null));

        int min = numeros.stream().min(Integer::compareTo).orElse(-1);
        int max = numeros.stream().max(Integer::compareTo).orElse(-1);
        System.out.println("Minimo: " + min + ", Maximo: " + max);

        boolean algunoPar = numeros.stream().anyMatch(n -> n % 2 == 0);
        boolean todosMenores15 = numeros.stream().allMatch(n -> n < 15);
        boolean ningunoNegativo = numeros.stream().noneMatch(n -> n < 0);

        System.out.println("Hay algun par: " + algunoPar);
        System.out.println("Todos menores de 15: " + todosMenores15);
        System.out.println("Ninguno negativo: " + ningunoNegativo);
        System.out.println();

        // -------------------------------
        // 4️⃣ REDUCCION Y COLECCION
        // -------------------------------
        System.out.println("-- Reduccion y coleccion --");

        int suma = numeros.stream().reduce(0, Integer::sum);
        System.out.println("Suma total: " + suma);

        int producto = numeros.stream().reduce(1, (a, b) -> a * b);
        System.out.println("Producto total: " + producto);

        // Recoleccion en distintas estructuras
        List<Integer> pares = numeros.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
        Set<Integer> impares = numeros.stream().filter(n -> n % 2 != 0).collect(Collectors.toSet());
        Map<Integer, String> mapa = numeros.stream()
                .collect(Collectors.toMap(n -> n, n -> "Num" + n));

        System.out.println("Lista pares: " + pares);
        System.out.println("Set impares: " + impares);
        System.out.println("Mapa: " + mapa);

        // joining
        String cadena = Stream.of("Java", "Streams", "API")
                .collect(Collectors.joining(" - "));
        System.out.println("Joining: " + cadena);

        // groupingBy
        Map<String, List<Integer>> agrupado = numeros.stream()
                .collect(Collectors.groupingBy(n -> n % 2 == 0 ? "Pares" : "Impares"));
        System.out.println("GroupingBy: " + agrupado);

        // partitioningBy
        Map<Boolean, List<Integer>> particionado = numeros.stream()
                .collect(Collectors.partitioningBy(n -> n > 5));
        System.out.println("PartitioningBy: " + particionado);

        // teeing (Java 12+): combina dos colectores
        var resultado = numeros.stream().collect(
                Collectors.teeing(
                        Collectors.minBy(Integer::compareTo),
                        Collectors.maxBy(Integer::compareTo),
                        (minVal, maxVal) -> Map.of("min", minVal.orElse(-1), "max", maxVal.orElse(-1))
                ));
        System.out.println("Teeing (min y max): " + resultado);
        System.out.println();

        // -------------------------------
        // 5️⃣ STREAMS PRIMITIVOS
        // -------------------------------
        System.out.println("-- Streams primitivos --");

        IntStream.range(1, 6).forEach(n -> System.out.print(n + " "));
        System.out.println();

        IntStream.rangeClosed(1, 5)
                .map(n -> n * 10)
                .average()
                .ifPresent(avg -> System.out.println("Media: " + avg));

        double sumaDouble = DoubleStream.of(1.5, 2.5, 3.5).sum();
        System.out.println("Suma DoubleStream: " + sumaDouble);

        System.out.println("\n=== Fin del ejemplo completo de Stream API ===");
    }

    public static void main(String[] args) {
        SpringApplication.run(StreamApiCompletaApplication.class, args);
        ejecutar();
    }
}

