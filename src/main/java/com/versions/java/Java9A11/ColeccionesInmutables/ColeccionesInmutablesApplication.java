package com.versions.java.Java9A11.ColeccionesInmutables;

import java.util.List;

import java.util.Set;
import java.util.Map;

public class ColeccionesInmutablesApplication {

    /**
     * Metodo para ejecutar el ejemplo de Colecciones Inmutables en Java 9
     *
     * Incluye:
     * 1️⃣ Lista inmutable (List.of)
     * 2️⃣ Conjunto inmutable (Set.of)
     * 3️⃣ Mapa inmutable (Map.of)
     *
     * Diferencias entre las colecciones:
     * - List: ordenada, permite duplicados, acceso por índice.
     * - Set: elementos únicos, sin orden garantizado.
     * - Map: pares clave-valor, claves únicas, acceso por clave.
     */
    public static void ejecutar() {
        System.out.println("=== Ejemplo 1.1: Colecciones Inmutables ===\n");

        // -------------------------------
        // 1️⃣ Lista inmutable
        // -------------------------------
        List<String> lista = List.of("A", "B", "C");
        System.out.println("Lista inmutable: " + lista);

        // Intento de modificar la lista (lanza UnsupportedOperationException)
        try {
            lista.add("D");
        } catch (UnsupportedOperationException e) {
            System.out.println("No se puede modificar la lista inmutable");
        }

        System.out.println();

        // -------------------------------
        // 2️⃣ Conjunto inmutable
        // -------------------------------
        Set<String> conjunto = Set.of("Perro", "Gato", "Conejo");
        System.out.println("Conjunto inmutable: " + conjunto);

        // Intento de modificar el conjunto
        try {
            conjunto.add("Hamster");
        } catch (UnsupportedOperationException e) {
            System.out.println("No se puede modificar el conjunto inmutable");
        }

        System.out.println();

        // -------------------------------
        // 3️⃣ Mapa inmutable
        // -------------------------------
        Map<String, Integer> mapa = Map.of(
                "Uno", 1,
                "Dos", 2,
                "Tres", 3
        );
        System.out.println("Mapa inmutable: " + mapa);

        // Acceso a valor por clave
        System.out.println("Valor de 'Dos': " + mapa.get("Dos"));

        // Intento de modificar el mapa
        try {
            mapa.put("Cuatro", 4);
        } catch (UnsupportedOperationException e) {
            System.out.println("No se puede modificar el mapa inmutable");
        }

        System.out.println("\n=== Fin del ejemplo 1.1 ===");
    }

    // Main independiente por si quieres ejecutar solo este ejemplo
    public static void main(String[] args) {
        ejecutar();
    }
}


