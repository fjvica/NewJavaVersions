package com.versions.java.Java19A21.virtualThread;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.concurrent.*;

/**
 * Ejemplo 3.1: Virtual Threads (Project Loom)
 *
 * Este ejemplo muestra:
 * 1️⃣ Creacion de hilos virtuales con Thread.ofVirtual()
 * 2️⃣ Uso de un ExecutorService con hilos virtuales
 * 3️⃣ Ejecucion concurrente masiva simulando tareas de IO
 * 4️⃣ Medicion de rendimiento frente a hilos tradicionales
 */
@SpringBootApplication
public class VirtualThreadsApplication {

    /**
     * Metodo principal del ejemplo
     */
    public static void ejecutar() throws Exception {
        System.out.println("=== Ejemplo 3.1: Virtual Threads (Project Loom) ===\n");

        // Numero de tareas simuladas (simulando muchas operaciones IO)
        int numTareas = 1000;

        System.out.println("Ejecucion concurrente de " + numTareas + " tareas con Virtual Threads...\n");

        // Medimos el tiempo con hilos virtuales
        Instant inicioVirtual = Instant.now();
        ejecutarConVirtualThreads(numTareas);
        Instant finVirtual = Instant.now();

        // Medimos el tiempo con hilos tradicionales
        Instant inicioTradicional = Instant.now();
        ejecutarConPlatformThreads(numTareas);
        Instant finTradicional = Instant.now();

        // Resultados comparativos
        System.out.println("\n--- Resultados comparativos ---");
        System.out.println("Virtual Threads: " + Duration.between(inicioVirtual, finVirtual).toMillis() + " ms");
        System.out.println("Platform Threads: " + Duration.between(inicioTradicional, finTradicional).toMillis() + " ms");

        System.out.println("\n=== Fin del ejemplo 3.1 ===");
    }

    /**
     * Metodo que ejecuta tareas concurrentes usando hilos virtuales
     */
    private static void ejecutarConVirtualThreads(int numTareas) throws Exception {
        // Creamos un ExecutorService que lanza un hilo virtual por tarea
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {

            List<Callable<String>> tareas = crearTareas(numTareas, "Virtual");

            // Ejecutamos todas las tareas
            List<Future<String>> resultados = executor.invokeAll(tareas);

            // Esperamos su finalizacion y mostramos los primeros resultados
            for (int i = 0; i < 5; i++) {
                System.out.println(resultados.get(i).get());
            }
        }
    }

    /**
     * Metodo que ejecuta tareas concurrentes usando hilos tradicionales (platform threads)
     */
    private static void ejecutarConPlatformThreads(int numTareas) throws Exception {
        // Pool fijo de hilos del sistema operativo
        try (ExecutorService executor = Executors.newFixedThreadPool(100)) {

            List<Callable<String>> tareas = crearTareas(numTareas, "Tradicional");

            // Ejecutamos todas las tareas
            List<Future<String>> resultados = executor.invokeAll(tareas);

            // Esperamos su finalizacion y mostramos los primeros resultados
            for (int i = 0; i < 5; i++) {
                System.out.println(resultados.get(i).get());
            }
        }
    }

    /**
     * Crea una lista de tareas simulando operaciones de IO
     * Cada tarea duerme 100 ms para representar una llamada bloqueante
     */
    private static List<Callable<String>> crearTareas(int numTareas, String tipo) {
        return java.util.stream.IntStream.range(0, numTareas)
                .mapToObj(i -> (Callable<String>) () -> {
                    Thread.sleep(100); // Simula una operacion bloqueante (IO)
                    return "Tarea " + i + " completada por " + tipo + " thread -> " + Thread.currentThread();
                })
                .toList();
    }

    /**
     * Metodo main independiente para ejecutar este ejemplo dentro del proyecto
     */
    public static void main(String[] args) throws Exception {
        SpringApplication.run(VirtualThreadsApplication.class, args);
        ejecutar();
    }
}

