1. Descripción del Proyecto
Este proyecto consiste en un Sistema de Gestión de Tareas desarrollado en Java bajo el paradigma de Programación Orientada a Objetos (POO).

2. Funcionalidades Implementadas

 * Creación de tareas con título, descripción e ID automático secuencial.
 * Atributos privados con métodos Getters y Setters que impiden el registro de títulos o descripciones vacías.
 * Visualización de todas las tareas almacenadas en un ArrayList.
 * Capacidad de listar tareas específicamente por su estado: "PENDIENTE" o "COMPLETADA".
 * Marcar tareas como completadas mediante su identificador único.
 * Borrado físico de tareas de la lista por ID.
 * Reporte del total de tareas, conteo por estado y cálculo del porcentaje de progreso.
 * Menú interactivo basado en Scanner que se repite hasta que el usuario decide salir.
3. Diagrama de Clases

A continuación se muestra la relación entre las clases principales del sistema:
+---------------------------+          +------------------------------+
|      modelo.Tarea         |          |   servicio.GestorTareas      |
+---------------------------+          +------------------------------+
| - id: int                 |          | - tareas: ArrayList<Tarea>   |
| - titulo: String          |          | - proximoId: int             |
| - descripcion: String     |          +------------------------------+
| - estado: String          |          | + agregar(tit, desc): void   |
+---------------------------+          | + listar(filtro): void       |
| + completar(): void       | <------- | + completarTarea(id): void   |
| + mostrarInfo(): void     |          | + eliminar(id): void         |
| + estaCompletada(): bool  |          | + mostrarEstadisticas(): void|
+---------------------------+          +------------------------------+
            ^
            |
      (Usa la clase)
            |
      +-------------+
      |    Main     |
      +-------------+
      | + main()    |
      +-------------+


