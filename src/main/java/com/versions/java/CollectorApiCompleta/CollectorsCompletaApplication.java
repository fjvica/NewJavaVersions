package com.versions.java.CollectorApiCompleta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class CollectorsCompletaApplication {

    /**
     * Metodo para ejecutar ejemplo completo de Collectors en la API Stream
     *
     * Incluye:
     * 1️⃣ Recoleccion basica (toList, toSet, toMap, toCollection)
     * 2️⃣ Operaciones numericas (counting, summing, averaging, summarizing)
     * 3️⃣ Operaciones de texto (joining)
     * 4️⃣ Agrupacion y particion (groupingBy, partitioningBy)
     * 5️⃣ Transformacion y composicion (mapping, flatMapping, filtering, collectingAndThen)
     * 6️⃣ Combinacion avanzada (teeing)
     */
    public static void ejecutar() {
        System.out.println("=== Ejemplo completo: Collectors ===\n");

        List<String> nombres = List.of("Ana", "Juan", "Pedro", "Maria", "Ana", "Jose");

        // -------------------------------
        // 1️⃣ RECOLECCION BASICA
        // -------------------------------
        System.out.println("-- Recoleccion basica --");

        // toList: convierte stream en lista
        List<String> lista = nombres.stream().collect(Collectors.toList());
        System.out.println("toList: " + lista);

        // toSet: convierte stream en conjunto (elimina duplicados)
        Set<String> set = nombres.stream().collect(Collectors.toSet());
        System.out.println("toSet: " + set);

        // toCollection: especifica la implementacion de coleccion destino
        LinkedList<String> linked = nombres.stream()
                .collect(Collectors.toCollection(LinkedList::new));
        System.out.println("toCollection (LinkedList): " + linked);

        // toMap: convierte a mapa (clave -> longitud, valor -> nombre)
        Map<Integer, String> mapa = nombres.stream()
                .collect(Collectors.toMap(String::length, n -> n, (a, b) -> a + "," + b));
        System.out.println("toMap (longitud -> nombre): " + mapa);

        System.out.println();

        // -------------------------------
        // 2️⃣ OPERACIONES NUMERICAS
        // -------------------------------
        System.out.println("-- Operaciones numericas --");

        List<Integer> numeros = List.of(5, 2, 8, 3, 7, 1, 4);

        long total = numeros.stream().collect(Collectors.counting());
        System.out.println("counting: " + total);

        int suma = numeros.stream().collect(Collectors.summingInt(Integer::intValue));
        System.out.println("summingInt: " + suma);

        double promedio = numeros.stream().collect(Collectors.averagingInt(Integer::intValue));
        System.out.println("averagingInt: " + promedio);

        IntSummaryStatistics stats = numeros.stream()
                .collect(Collectors.summarizingInt(Integer::intValue));
        System.out.println("summarizingInt: " + stats);

        System.out.println();

        // -------------------------------
        // 3️⃣ OPERACIONES DE TEXTO
        // -------------------------------
        System.out.println("-- Operaciones de texto --");

        String unido = nombres.stream().collect(Collectors.joining(", "));
        System.out.println("joining: " + unido);

        String formateado = nombres.stream()
                .collect(Collectors.joining(" | ", "[", "]"));
        System.out.println("joining con formato: " + formateado);

        System.out.println();

        // -------------------------------
        // 4️⃣ AGRUPACION Y PARTICION
        // -------------------------------
        System.out.println("-- Agrupacion y particion --");

        // groupingBy: agrupa por longitud
        Map<Integer, List<String>> agrupado = nombres.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println("groupingBy (longitud): " + agrupado);

        // groupingBy con colector adicional (counting)
        Map<Integer, Long> agrupadoConContador = nombres.stream()
                .collect(Collectors.groupingBy(String::length, Collectors.counting()));
        System.out.println("groupingBy con counting: " + agrupadoConContador);

        // partitioningBy: divide en dos grupos segun condicion
        Map<Boolean, List<String>> particionado = nombres.stream()
                .collect(Collectors.partitioningBy(n -> n.startsWith("A")));
        System.out.println("partitioningBy (empieza con A): " + particionado);

        System.out.println();

        // -------------------------------
        // 5️⃣ TRANSFORMACION Y COMPOSICION
        // -------------------------------
        System.out.println("-- Transformacion y composicion --");

        // mapping: aplica una funcion antes de recolectar
        List<Integer> longitudes = nombres.stream()
                .collect(Collectors.mapping(String::length, Collectors.toList()));
        System.out.println("mapping (longitudes): " + longitudes);

        // flatMapping: aplana resultados antes de recolectar
        List<String> letras = Stream.of("AB", "CD", "EF")
                .collect(Collectors.flatMapping(
                        s -> s.chars().mapToObj(c -> String.valueOf((char) c)),
                        Collectors.toList()
                ));
        System.out.println("flatMapping (letras): " + letras);

        // filtering: filtra dentro del colector
        List<String> soloA = nombres.stream()
                .collect(Collectors.filtering(n -> n.startsWith("A"), Collectors.toList()));
        System.out.println("filtering (empiezan con A): " + soloA);

        // collectingAndThen: aplica una transformacion al resultado final
        Set<String> conjuntoInmutable = nombres.stream()
                .collect(Collectors.collectingAndThen(Collectors.toSet(), Collections::unmodifiableSet));
        System.out.println("collectingAndThen (set inmutable): " + conjuntoInmutable);

        System.out.println();

        // -------------------------------
        // 6️⃣ COMBINACION AVANZADA (TEEING)
        // -------------------------------
        System.out.println("-- Combinacion avanzada (teeing) --");

        Map<String, Double> sumaYPromedio = numeros.stream()
                .collect(Collectors.teeing(
                        Collectors.summingDouble(Double::valueOf),
                        Collectors.averagingDouble(Double::valueOf),
                        (sumaTotal, prom) -> Map.of("suma", sumaTotal, "promedio", prom)
                ));
        System.out.println("teeing (suma y promedio): " + sumaYPromedio);

        Map<String, Object> extremos = numeros.stream()
                .collect(Collectors.teeing(
                        Collectors.minBy(Integer::compareTo),
                        Collectors.maxBy(Integer::compareTo),
                        (min, max) -> Map.of("min", min.orElse(-1), "max", max.orElse(-1))
                ));
        System.out.println("teeing (min y max): " + extremos);

        System.out.println("\n=== Fin del ejemplo completo de Collectors ===");
    }

    public static void main(String[] args) {
        SpringApplication.run(CollectorsCompletaApplication.class, args);
        ejecutar();
    }
}
