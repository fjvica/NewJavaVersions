package com.versions.java.Java12A17.Switch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SwitchExpresionApplication {

    /**
     * Metodo para ejecutar el ejemplo de Switch como expresión en Java 12+
     *
     * Incluye:
     * 1️⃣ Switch tradicional vs switch como expresión
     * 2️⃣ Agrupación de casos
     * 3️⃣ Uso de bloques con yield
     *
     * Beneficios del switch como expresión:
     * - Devuelve un valor directamente
     * - No requiere break
     * - Más conciso y legible
     */
    public static void ejecutar() {
        System.out.println("=== Ejemplo 2.1: Switch como Expresión ===\n");

        // -------------------------------
        // 1️⃣ Switch como expresión simple
        // -------------------------------
        int dia = 3;
        String nombreDia = switch (dia) {
            case 1 -> "Lunes";
            case 2 -> "Martes";
            case 3 -> "Miércoles";
            case 4 -> "Jueves";
            case 5 -> "Viernes";
            case 6, 7 -> "Fin de semana"; // varios casos agrupados
            default -> "Desconocido";
        };
        System.out.println("Día " + dia + ": " + nombreDia);
        System.out.println();

        // -------------------------------
        // 2️⃣ Switch con bloque y yield
        // -------------------------------
        int dia2 = 5;
        String mensaje = switch (dia2) {
            case 1, 2, 3, 4, 5 -> {
                System.out.println("Es un día laborable");
                yield "Laborable"; // yield devuelve el valor de la expresión
            }
            case 6, 7 -> {
                System.out.println("Es fin de semana");
                yield "Fin de semana";
            }
            default -> "Desconocido";
        };
        System.out.println("Día " + dia2 + ": " + mensaje);
        System.out.println();

        // -------------------------------
        // 3️⃣ Switch como retorno de método
        // -------------------------------
        System.out.println("Ejemplo de método con switch como expresión:");
        System.out.println("Día 2: " + obtenerTipoDia(2));
        System.out.println("Día 7: " + obtenerTipoDia(7));

        System.out.println("\n=== Fin del ejemplo 2.1 ===");
    }

    /**
     * Metodo que devuelve el tipo de día usando switch como expresión
     */
    public static String obtenerTipoDia(int dia) {
        return switch (dia) {
            case 1, 2, 3, 4, 5 -> "Laborable";
            case 6, 7 -> "Fin de semana";
            default -> "Desconocido";
        };
    }

    // Main independiente por si quieres ejecutar solo este ejemplo
    public static void main(String[] args) {
        SpringApplication.run(SwitchExpresionApplication.class, args);
        ejecutar();
    }
}

