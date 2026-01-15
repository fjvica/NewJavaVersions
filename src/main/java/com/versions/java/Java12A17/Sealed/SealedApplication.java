package com.versions.java.Java12A17.Sealed;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SealedApplication {

    /**
     * Metodo para ejecutar ejemplo de sealed y non-sealed
     * <p>
     * Incluye:
     * 1️⃣ Clase sellada con subclases final y non-sealed
     * 2️⃣ Subclases derivadas de non-sealed
     * 3️⃣ Uso polimorfico
     */
    public static void ejecutar() {
        System.out.println("=== Ejemplo sealed y non-sealed ===\n");

        Animal perro = new Perro();
        Animal gato = new Gato();
        Animal pajaro = new Pajaro();
        Animal loro = new Loro();
        Animal canario = new Canario();

        perro.hacerSonido();
        gato.hacerSonido();
        pajaro.hacerSonido();
        loro.hacerSonido();
        canario.hacerSonido();

        System.out.println("\n=== Fin del ejemplo ===");
    }

    // Clase sellada
    public sealed static abstract class Animal permits Perro, Gato, Pajaro {
        public abstract void hacerSonido();
    }

    // Subclases finales
    public static final class Perro extends Animal {
        @Override
        public void hacerSonido() {
            System.out.println("Guau");
        }
    }

    public static final class Gato extends Animal {
        @Override
        public void hacerSonido() {
            System.out.println("Miau");
        }
    }

    // Subclase non-sealed
    public static non-sealed class Pajaro extends Animal {
        @Override
        public void hacerSonido() {
            System.out.println("Pio Pio");
        }
    }

    // Subclases de Pajaro, libres de extenderse
    public static class Loro extends Pajaro {
        @Override
        public void hacerSonido() {
            System.out.println("Hola!");
        }
    }

    public static class Canario extends Pajaro {
        @Override
        public void hacerSonido() {
            System.out.println("Trino");
        }
    }
}

