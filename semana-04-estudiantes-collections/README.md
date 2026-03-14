//Descripcion del sistema

La idea principal no es solo guardar datos, sino entender cómo elegir la herramienta adecuada 
(Listas, Sets o Mapas) según lo que necesitemos hacer permitiendo búsquedas eficientes, 
ordenamiento automático y mantenimiento de un historial de operaciones.

//Tabla comparativa de las tres colecciones usadas: por qué se eligió
cada una y qué problema resuelve.

HashMap<String, Estudiante> c: Utilizado para el almacenamiento por carnet, permitiendo búsquedas de complejidad
TreeSet<Estudiante> r: Gestiona el ranking de promedios de forma automática. Al implementar Comparable, el set se mantiene ordenado de menor a mayor promedio.
ArrayList<String> h: Registra cronológicamente cada acción (agregar, actualizar, eliminar) realizada en el sistema.

//Como compilar el programa.

Registro: Agrega nuevos estudiantes validando que el carnet no esté duplicado en el HashMap.

Búsqueda: Recuperación instantánea de datos mediante la clave del carnet.

Actualización de Promedio: Modifica la nota de un estudiante.

Nota Crítica: Debido a que el TreeSet no detecta cambios internos en los objetos, el sistema elimina el objeto (r.remove(e)), actualiza el valor y lo vuelve a insertar (r.add(e)) para reestablecer el orden.

Ranking y Top 5: Visualización de los estudiantes con mejor desempeño académico.

Filtrado: Búsqueda de estudiantes pertenecientes a una carrera específica.

Estadísticas: Cálculo de promedio general, identificación del mejor y peor estudiante de la lista.

//Ejemplo de salida del programa

Al iniciar el sistema, se precargan 10 registros de prueba. El ranking mostrará a los estudiantes ordenados, por ejemplo:

Peor promedio: Pedro Vargas (55.0) 

Mejor promedio: Patricia Lima (95.0)


