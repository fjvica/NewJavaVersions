package com.versions.java.Java9.ProcessHandle;

public class ProcessHandleApplication {

    public static void ejecutar() {
        System.out.println("=== Ejemplo 1.5: ProcessHandle y nueva Process API ===\n");

        // -------------------------------
        // 1️⃣ Proceso actual
        // -------------------------------
        ProcessHandle procesoActual = ProcessHandle.current();
        System.out.println("PID del proceso actual: " + procesoActual.pid());

        // Información detallada
        ProcessHandle.Info info = procesoActual.info();
        System.out.println("Comando: " + info.command().orElse("Desconocido"));
        System.out.println("Argumentos: " + String.join(" ", info.arguments().orElse(new String[]{})));
        System.out.println("Hora de inicio: " + info.startInstant().map(Object::toString).orElse("Desconocida"));

        // -------------------------------
        // 2️⃣ Listar procesos hijos (si existen)
        // -------------------------------
        System.out.println("\nProcesos hijos:");
        procesoActual.children().forEach(child ->
                System.out.println("PID hijo: " + child.pid() + ", estado: " + (child.isAlive() ? "vivo" : "terminado"))
        );

        // -------------------------------
        // 3️⃣ Listar algunos procesos del sistema (máx 5 para ejemplo)
        // -------------------------------
        System.out.println("\nAlgunos procesos del sistema:");
        ProcessHandle.allProcesses()
                .limit(5)
                .forEach(p -> System.out.println("PID: " + p.pid() + ", comando: " + p.info().command().orElse("Desconocido")));

        System.out.println("\n=== Fin del ejemplo 1.5 ===");
    }

    public static void main(String[] args) {
        ejecutar();
    }
}

