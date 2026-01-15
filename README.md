# Proyecto: Novedades de Java 9

Este proyecto contiene ejemplos prácticos de las **nuevas características de Java 9** comparadas con Java 8, organizados por puntos y versiones.  
Cada ejemplo tiene su clase independiente y un método `ejecutar()` para poder probarlo de manera individual.

---

## 📌 Ejemplo 1.1: Colecciones Inmutables

### Descripción

En Java 9 se introdujeron **fábricas de colecciones inmutables**: `List.of`, `Set.of`, y `Map.of`.  
Estas colecciones tienen las siguientes características:

- **Inmutables**: no se pueden añadir, eliminar ni modificar elementos.
- **No aceptan `null`**: intentar poner un `null` lanza `NullPointerException`.
- **Más eficientes** que las colecciones tradicionales de Java 8.

### Diferencias entre List, Set y Map

| Colección | Orden | Duplicados | Acceso | Ejemplo Java 9 |
|-----------|-------|------------|--------|----------------|
| **List**  | Sí    | Sí         | Por índice | `List.of("A","B")` |
| **Set**   | No garantizado | No | Iterador | `Set.of("A","B")` |
| **Map**   | Clave-valor | Claves únicas | Por clave | `Map.of("A",1,"B",2)` |

### Ejemplo de uso

```java
List<String> lista = List.of("A", "B", "C");
Set<String> conjunto = Set.of("Perro", "Gato", "Conejo");
Map<String, Integer> mapa = Map.of("Uno", 1, "Dos", 2, "Tres", 3);
