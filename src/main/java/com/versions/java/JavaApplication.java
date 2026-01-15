package com.versions.java;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class JavaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(JavaApplication.class, args);
	}

	@Override
	public void run(String... args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("=== Ejecutor de ejemplos de Java ===");

		System.out.println("Elige el ejemplo a ejecutar (por ejemplo, 1.1): ");
		String ejemplo = scanner.nextLine();

		// Según la versión y el ejemplo, llamamos a la clase correspondiente

		com.versions.java.Java9.ColeccionesInmutables.ColeccionesInmutablesApplication.ejecutar();

		scanner.close();
	}

}
