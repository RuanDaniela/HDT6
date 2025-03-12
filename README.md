# HDT6
# Proyecto de Algoritmos y Estructura de Datos

## Descripción
Este proyecto realiza operaciones con mapas utilizando el Java Collection Framework (JCF) y aplica el patrón de diseño Factory para seleccionar la implementación de `Map`.

## Funcionalidades
1. **Agregar Pokémon**: El usuario ingresa el nombre del Pokémon para agregarlo a su colección.
2. **Mostrar datos de Pokémon**: El usuario ingresa el nombre del Pokémon y se muestran sus datos.
3. **Mostrar Pokémon del usuario**: Ordenados por tipo1.
4. **Mostrar todos los Pokémon**: Ordenados por tipo1.
5. **Mostrar Pokémon por habilidad**: El usuario ingresa la habilidad y se muestran los Pokémon con esa habilidad.

## Complejidad de Tiempo
### HashMap
O(n log n) debido a la necesidad de ordenar los elementos.
### TreeMap
O(n) ya que los elementos están ordenados por defecto.
### LinkedHashMap
O(n log n) similar a HashMap.

## Selección de la Colección del JCF
### HashMap
- **Complejidad**: O(1) para inserción y búsqueda.
- **Uso**: Acceso rápido sin orden.

### TreeMap
- **Complejidad**: O(log n) para inserción y búsqueda.
- **Uso**: Mantiene los elementos ordenados.

### LinkedHashMap
- **Complejidad**: O(1) para inserción y búsqueda.
- **Uso**: Mantiene el orden de inserción.

## Créditos
El código fue generado con la ayuda de Microsoft Copilot.