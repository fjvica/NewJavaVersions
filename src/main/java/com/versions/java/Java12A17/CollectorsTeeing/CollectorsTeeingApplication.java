package com.versions.java.Java12A17.CollectorsTeeing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;
import java.util.stream.Collectors;

@SpringBootApplication
public class CollectorsTeeingApplication {

    /**
     * Metodo para ejecutar ejemplo de Collectors.teeing (Java 12+)
     *
     * Incluye:
     * 1️⃣ Combinacion de dos colectores (min y max)
     * 2️⃣ Calculo de estadisticas en una sola pasada del stream
     * 3️⃣ Ejemplo avanzado combinando teeing con otros colectores
     */
    public static void ejecutar() {
        System.out.println("=== Ejemplo 2.8: Collectors.teeing ===\n");

        List<Integer> numeros = List.of(3, 7, 2, 10, 5, 8);

        // -------------------------------
        // 1️⃣ Minimo y maximo en una sola pasada
        // -------------------------------
        Map<String, Integer> extremos = numeros.stream()
                .collect(Collectors.teeing(
                        Collectors.minBy(Integer::compareTo),
                        Collectors.maxBy(Integer::compareTo),
                        (min, max) -> Map.of(
                                "min", min.orElse(-1),
                                "max", max.orElse(-1)
                        )
                ));

        System.out.println("Resultado min y max: " + extremos);
        System.out.println();

        // -------------------------------
        // 2️⃣ Calculo de suma y promedio
        // -------------------------------
        var sumaPromedio = numeros.stream()
                .collect(Collectors.teeing(
                        Collectors.summingInt(Integer::intValue),
                        Collectors.averagingInt(Integer::intValue),
                        (suma, promedio) -> Map.of(
                                "suma", suma,
                                "promedio", promedio
                        )
                ));

        System.out.println("Resultado suma y promedio: " + sumaPromedio);
        System.out.println();

        // -------------------------------
        // 3️⃣ Combinacion avanzada con toList
        // -------------------------------
        var resultadoAvanzado = numeros.stream()
                .collect(Collectors.teeing(
                        Collectors.filtering(n -> n % 2 == 0, Collectors.toList()), // pares
                        Collectors.filtering(n -> n % 2 != 0, Collectors.toList()), // impares
                        (pares, impares) -> Map.of(
                                "pares", pares,
                                "impares", impares
                        )
                ));

        System.out.println("Resultado avanzado (pares e impares): " + resultadoAvanzado);
        System.out.println();

        System.out.println("=== Fin del ejemplo 2.8 ===");
    }

    // Main independiente por si quieres ejecutar solo este ejemplo
    public static void main(String[] args) {
        SpringApplication.run(CollectorsTeeingApplication.class, args);
        ejecutar();
    }
}

