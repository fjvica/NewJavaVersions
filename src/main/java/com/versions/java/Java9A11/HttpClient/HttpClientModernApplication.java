package com.versions.java.Java9A11.HttpClient;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientModernApplication {

    public static void ejecutar() {
        System.out.println("=== Ejemplo 1.4: HttpClient moderno ===\n");

        try {
            // -------------------------------
            // 1️⃣ Crear el cliente HTTP
            // -------------------------------
            HttpClient client = HttpClient.newHttpClient();

            // -------------------------------
            // 2️⃣ Crear la petición HTTP
            // -------------------------------
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://jsonplaceholder.typicode.com/todos/1"))
                    .GET() // tipo de petición: GET
                    .build();

            // -------------------------------
            // 3️⃣ Enviar la petición (síncrona)
            // -------------------------------
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // -------------------------------
            // 4️⃣ Imprimir la respuesta
            // -------------------------------
            System.out.println("Código de estado: " + response.statusCode());
            System.out.println("Cuerpo de la respuesta:\n" + response.body());

        } catch (Exception e) {
            System.out.println("Error al realizar la petición HTTP: " + e);
        }

        System.out.println("\n=== Fin del ejemplo 1.4 ===");
    }

    public static void main(String[] args) {
        ejecutar();
    }
}

