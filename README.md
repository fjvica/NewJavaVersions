# Evolución de Java: De la Modernización a la Expresividad (Java 9–17)

Este proyecto contiene ejemplos prácticos de las principales características introducidas en Java desde la versión 9 hasta la 17. Cada versión se organiza en carpetas, y dentro de ellas, cada punto corresponde a una mejora o nueva funcionalidad del lenguaje y su API. Los ejemplos son ejecutables para que puedas probar directamente los cambios y entender su comportamiento.

---

## 📑 Tabla de Contenidos

- [1. Modernización del lenguaje (Java 9–11)](#1-modernización-del-lenguaje-java-9–11)
    - [1.1. Colecciones inmutables](#11-colecciones-inmutables-listof-setof-mapof)
    - [1.2. Inferencia de tipos con var](#12-inferencia-de-tipos-con-var)
    - [1.3. Nuevos métodos de String](#13-nuevos-métodos-de-string)
    - [1.4. HttpClient moderno](#14-httpclient-moderno)
    - [1.5. ProcessHandle y nueva Process API](#15-processhandle-y-nueva-process-api)
    - [1.6. Modularidad (JPMS)](#16-modularidad-jpms)
    - [1.7. try-with-resources simplificado](#17-try-with-resources-simplificado)
    - [1.8. jshell](#18-jshell)
- [2. Expresividad del lenguaje (Java 12–17)](#2-expresividad-del-lenguaje-java-12–17)
    - [2.1. switch como expresión](#21-switch-como-expresión)
    - [2.2. Pattern Matching con instanceof](#22-pattern-matching-con-instanceof)
    - [2.3. Clases record](#23-clases-record)
    - [2.4. Clases selladas (sealed)](#24-clases-selladas-sealed)
    - [2.5. Bloques de texto (Text Blocks)](#25-bloques-de-texto-text-blocks)
    - [2.6. NullPointerException mejorado](#26-nullpointerexception-mejorado)
    - [2.7. Stream API: nuevos métodos](#27-stream-api-nuevos-métodos-takewhile-dropwhile-iterate-mejorado)
    - [2.8. Nuevos métodos en Collectors](#28-nuevos-métodos-en-collectors-teeing)

---

## 1. Modernización del lenguaje (Java 9–11)

Java 9–11 introdujo mejoras para modernizar la escritura del código, simplificar la gestión de procesos y recursos, y ofrecer APIs más completas.

### 1.1. Colecciones inmutables (`List.of`, `Set.of`, `Map.of`)
Permiten crear colecciones de forma concisa e inmutable, evitando errores de modificación accidental.

### 1.2. Inferencia de tipos con `var`
El compilador infiere el tipo de las variables locales, haciendo el código más limpio y legible.

### 1.3. Nuevos métodos de `String`
Se añaden métodos como `isBlank()`, `lines()`, `repeat()` y `strip()`, que facilitan la manipulación de cadenas.

### 1.4. `HttpClient` moderno
Reemplaza a la antigua `HttpURLConnection`, permitiendo realizar llamadas HTTP de forma más sencilla y moderna, con soporte para HTTP/2.

### 1.5. `ProcessHandle` y nueva Process API
Proporciona una forma de gestionar procesos del sistema, obtener información y controlarlos de manera más sencilla.

### 1.6. Modularidad (JPMS)
Introduce el sistema de módulos, permitiendo estructurar aplicaciones grandes y controlar dependencias de manera más estricta.

### 1.7. `try-with-resources` simplificado
Permite usar variables ya declaradas en un bloque `try-with-resources` sin necesidad de redeclararlas.

### 1.8. `jshell`
Un REPL para Java que permite probar fragmentos de código de manera interactiva, ideal para aprendizaje y experimentación.

---

## 2. Expresividad del lenguaje (Java 12–17)

Estas versiones se centraron en mejorar la expresividad, legibilidad y seguridad del código, ofreciendo nuevas construcciones y simplificaciones.

### 2.1. `switch` como expresión
El `switch` puede devolver un valor directamente, haciendo el código más compacto y evitando errores comunes.

### 2.2. Pattern Matching con `instanceof`
Simplifica la comprobación y conversión de tipos, reduciendo boilerplate en condicionales.

### 2.3. Clases `record`
Permiten crear clases inmutables y con atributos finales de forma concisa, ideal para DTOs y estructuras de datos.

### 2.4. Clases selladas (`sealed`)
Controlan qué clases pueden extenderlas, ofreciendo un mayor control sobre la jerarquía de herencia.

### 2.5. Bloques de texto (Text Blocks)
Permiten definir strings multilínea de forma más legible y con formato limpio, evitando concatenaciones complicadas.

### 2.6. `NullPointerException` mejorado
Proporciona mensajes más claros y precisos indicando qué variable era null, facilitando la depuración.

### 2.7. Stream API: nuevos métodos (`takeWhile`, `dropWhile`, `iterate` mejorado)
Amplía la capacidad de procesar flujos de datos de manera más flexible y expresiva.

### 2.8. Nuevos métodos en `Collectors` (`teeing`)
Permite combinar múltiples operaciones de reducción sobre un stream en un solo paso, simplificando cálculos complejos.

---

Cada punto incluye una carpeta con un ejemplo ejecutable en Java, mostrando cómo se usa la funcionalidad en la práctica. Este repositorio sirve como guía de referencia rápida y laboratorio de pruebas para desarrolladores que quieran actualizarse en las novedades de Java 9–17.
