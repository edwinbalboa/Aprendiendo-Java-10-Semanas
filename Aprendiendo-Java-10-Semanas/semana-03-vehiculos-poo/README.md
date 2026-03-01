1. Descripción del Sistema
Este sistema es una plataforma de gestión de flotas que permite registrar, listar y controlar diversos tipos de vehículos, incluyendo modelos de combustión y eléctricos. Utiliza los pilares de la POO para aplicar comportamientos específicos (como la aceleración o la carga de batería) de forma uniforme a través de una jerarquía de clases y una interfaz compartida.

3. Decisiones de Diseño
 * ¿Por qué Vehiculo es una clase abstracta?
   * Se definió como abstract porque representa un concepto genérico; no tiene sentido crear un objeto "Vehículo" a secas, sino tipos específicos como autos o camiones.
   * Permite definir el método acelerar() sin implementación, obligando a cada clase hija a definir su propia lógica de movimiento.
 
* ¿Por qué Electrico es una interfaz?

   * Se eligió una interfaz porque no todos los vehículos son eléctricos. Al ser interfaz, permite que tanto un Auto como una Moto adquieran capacidades de carga sin forzarlos a pertenecer a una misma rama de herencia rígida.
   * Java no permite herencia múltiple, pero sí implementar múltiples interfaces, lo que otorga mayor flexibilidad al diseño.

4. Cómo compilar y ejecutar el proyecto
Para ejecutar el programa desde la terminal, asegúrate de estar dentro de la carpeta semana-03-vehiculos-poo/ y sigue estos pasos:
 * Compilar las clases:
   javac modelo/*.java servicio/*.java Main.java

 * Ejecutar la aplicación:
   java Main

5. Ejemplo de salida del programa
[cite_start]Al iniciar, el programa muestra la demostración obligatoria de polimorfismo:
== acelerar () en toda la flota ==
Toyota (auto) acelera suavemente.
Honda (moto) acelera rápido.
Volvo (camion, 24.0t) acelera despacio.
Tesla (auto electrico) acelera en silencio. Bateria: 75%
NIU (moto electrica) acelera. Bateria: 57%

=== GESTION DE VEHICULOS ===
1. Agregar vehiculo
2. Listar todos
3. Filtrar por tipo
4. Ver electricos y baterias
5. Cargar baterias bajas
6. Demostrar polimorfismo
7. Estadisticas
8. Salir
Opcion: 7

=== Estadisticas ===
Total vehiculos: 5
Electricos: 2
Necesitan carga: 0