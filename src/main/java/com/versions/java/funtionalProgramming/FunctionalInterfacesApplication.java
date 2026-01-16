package com.versions.java.funtionalProgramming;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

/**
 * Ejemplo 2.1: Programacion funcional en Java (Lambdas + java.util.function)
 *
 * Incluye:
 * 1️⃣ Uso de Predicate, Function, Consumer y Supplier
 * 2️⃣ Combinacion de funciones (andThen, compose, and, or)
 * 3️⃣ Pipeline funcional completa con Stream
 * 4️⃣ Aplicacion sobre lista de empleados (simulacion de logica de negocio)
 */
@SpringBootApplication
public class FunctionalInterfacesApplication {

    // Clase interna para simular una entidad de negocio
    static class Empleado {
        private final String nombre;
        private final int edad;
        private final double salario;
        private final String departamento;

        public Empleado(String nombre, int edad, double salario, String departamento) {
            this.nombre = nombre;
            this.edad = edad;
            this.salario = salario;
            this.departamento = departamento;
        }

        public String getNombre() { return nombre; }
        public int getEdad() { return edad; }
        public double getSalario() { return salario; }
        public String getDepartamento() { return departamento; }

        @Override
        public String toString() {
            return nombre + " (" + edad + " años, " + departamento + ", $" + salario + ")";
        }
    }

    public static void ejecutar() {
        System.out.println("=== Ejemplo 2.1: Programacion funcional con Lambdas y java.util.function ===\n");

        // --------------------------------------------------------
        // 1️⃣ Datos de entrada simulados (lista de empleados)
        // --------------------------------------------------------
        List<Empleado> empleados = List.of(
                new Empleado("Ana", 28, 2400, "IT"),
                new Empleado("Luis", 45, 3100, "Ventas"),
                new Empleado("Marta", 33, 1800, "IT"),
                new Empleado("Carlos", 41, 4000, "Finanzas"),
                new Empleado("Sofia", 25, 2200, "IT")
        );

        // --------------------------------------------------------
        // 2️⃣ Predicate: condiciones logicas sobre objetos
        // --------------------------------------------------------
        Predicate<Empleado> esIT = e -> e.getDepartamento().equals("IT");
        Predicate<Empleado> ganaMasDe2000 = e -> e.getSalario() > 2000;

        // Combinamos predicados (empleados de IT y con salario > 2000)
        Predicate<Empleado> esITyBienPagado = esIT.and(ganaMasDe2000);

        // --------------------------------------------------------
        // 3️⃣ Function: transformaciones
        // --------------------------------------------------------
        Function<Empleado, String> obtenerResumen = e ->
                e.getNombre().toUpperCase() + " - " + e.getDepartamento() + " - $" + e.getSalario();

        // Composicion de funciones: primero resumen, luego añadir firma
        Function<Empleado, String> resumenConFirma = obtenerResumen.andThen(r -> r + " ✅ Validado");

        // --------------------------------------------------------
        // 4️⃣ Consumer: acciones que no devuelven resultado
        // --------------------------------------------------------
        Consumer<String> imprimirEmpleado = r -> System.out.println("Empleado -> " + r);
        Consumer<String> imprimirSeparador = r -> System.out.println("------------------");

        // Encadenamos consumers
        Consumer<String> pipelineImpresion = imprimirEmpleado.andThen(imprimirSeparador);

        // --------------------------------------------------------
        // 5️⃣ Supplier: genera un valor sin recibir parametros
        // --------------------------------------------------------
        Supplier<String> cabecera = () -> "\nListado generado: " + new Date();

        System.out.println(cabecera.get());
        System.out.println();

        // --------------------------------------------------------
        // 6️⃣ Uso funcional completo con Stream
        // --------------------------------------------------------
        List<String> resultados = empleados.stream()
                .filter(esITyBienPagado)         // Filtramos por condiciones (Predicate)
                .map(resumenConFirma)             // Transformamos cada empleado (Function)
                .peek(pipelineImpresion)          // Ejecutamos accion sobre cada elemento (Consumer)
                .collect(Collectors.toList());    // Recolectamos el resultado final

        // --------------------------------------------------------
        // 7️⃣ Ejemplo de composicion adicional: calcular promedio
        // --------------------------------------------------------
        Function<List<Empleado>, Double> promedioSalario = lista ->
                lista.stream()
                        .mapToDouble(Empleado::getSalario)
                        .average()
                        .orElse(0);

        double promedio = promedioSalario.apply(empleados);
        System.out.println("\nSalario promedio del equipo: $" + promedio);

        System.out.println("\n=== Fin del ejemplo 2.1 ===");
    }

    // Main independiente por si quieres ejecutar solo este ejemplo
    public static void main(String[] args) {
        SpringApplication.run(FunctionalInterfacesApplication.class, args);
        ejecutar();
    }
}

