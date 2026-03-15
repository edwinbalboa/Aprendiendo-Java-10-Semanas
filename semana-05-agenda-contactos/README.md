1. Descripción del sistema en 2–3 oraciones

Este sistema es una aplicación de consola desarrollada en 
Java diseñada para la gestión integral de una agenda de contactos, permitiendo
realizar operaciones

2. Explicación del formato JSON que usa el programa

El programa utiliza el formato JSON (JavaScript Object Notation) para almacenar 
la lista de objetos de tipo Contacto de forma estructurada.

3. Tabla de excepciones personalizadas: cuál, cuándo se lanza, si es
checked o unchecked

NumberFormatException	
Cuando el usuario ingresa letras en lugar de números en el menú de opciones.	
Unchecked

IOException
Se lanza si ocurre un error al intentar leer o escribir los archivos contactos.json o su backup.
Checked

NullPointerException	
Podría lanzarse si se intenta procesar un contacto que no existe en la lista (manejo de búsquedas fallidas).
Unchecked

FileNotFoundException
Se captura internamente cuando el archivo de datos no existe por primera vez.	
Checked

4. Cómo instalar y ejecutar con Maven (mvn compile + mvn exec:java)

Para ejecutar el proyecto correctamente desde la terminal
asegúrate de estar en la carpeta raíz

Paso 1: Compilación
Este comando descarga las librerías necesarias (como GSON) y prepara los archivos .class.

mvn compile

Paso 2: Ejecución
Utilizamos el plugin exec de Maven para iniciar la clase principal sin errores de rutas o librerías faltantes.

mvn exec:java -Dexec.mainClass="Main"