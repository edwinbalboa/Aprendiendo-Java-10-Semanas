import modelo.Estudiante;
import servicio.GestorEstudiantes;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); 
        GestorEstudiantes g = new GestorEstudiantes();
        cargarDatosPrueba(g);
        int o; 
        do {
            System.out.println("\n=== SISTEMA DE ESTUDIANTES ===");
            System.out.println("1. Agregar estudiante");
            System.out.println("2. Buscar por carnet");
            System.out.println("3. Actualizar promedio");
            System.out.println("4. Eliminar estudiante");
            System.out.println("5. Ver ranking completo");
            System.out.println("6. Ver top 5");
            System.out.println("7. Filtrar por carrera");
            System.out.println("8. Estadisticas");
            System.out.println("9. Historial");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");
            o = s.nextInt();
            s.nextLine(); 
            switch (o) {
                case 1: agregarEstudiante(s, g); break;
                case 2: buscarEstudiante(s, g); break;
                case 3: actualizarPromedio(s, g); break;
                case 4: eliminarEstudiante(s, g); break;
                case 5: g.mostrarRanking(); break;
                case 6: g.mostrarTop5(); break;
                case 7:
                    System.out.print("Carrera: ");
                    g.filtrarPorCarrera(s.nextLine());
                    break;
                case 8: g.mostrarEstadisticas(); break;
                case 9: g.mostrarHistorial(); break;
                case 0: System.out.println("Hasta luego."); break;
                default: System.out.println("Opcion invalida.");
            }
        } while (o != 0);
        s.close();
    }
    private static void agregarEstudiante(Scanner s, GestorEstudiantes g) {
        System.out.print("Carnet   : "); String c = s.nextLine(); 
        System.out.print("Nombre   : "); String n = s.nextLine();
        System.out.print("Carrera  : "); String r = s.nextLine(); 
        System.out.print("Promedio : "); double p = s.nextDouble();
        s.nextLine();
        boolean ok = g.agregar(new Estudiante(c, n, r, p));
        System.out.println(ok ? "Estudiante registrado." : "Error: carnet ya existe.");
    }
    private static void buscarEstudiante(Scanner s, GestorEstudiantes g) {
        System.out.print("Carnet a buscar: ");
        Estudiante e = g.buscar(s.nextLine()); 
        if (e != null) System.out.println(e);
        else System.out.println("Carnet no encontrado.");
    }
    private static void actualizarPromedio(Scanner s, GestorEstudiantes g) {
        System.out.print("Carnet     : "); String c = s.nextLine();
        System.out.print("Nuevo prom : "); double p = s.nextDouble();
        s.nextLine();
        boolean ok = g.actualizarPromedio(c, p);
        System.out.println(ok ? "Promedio actualizado." : "Carnet no encontrado.");
    }
    private static void eliminarEstudiante(Scanner s, GestorEstudiantes g) {
        System.out.print("Carnet a eliminar: ");
        boolean ok = g.eliminar(s.nextLine());
        System.out.println(ok ? "Estudiante eliminado." : "Carnet no encontrado.");
    }
    private static void cargarDatosPrueba(GestorEstudiantes g) {
        g.agregar(new Estudiante("2021001", "Ana Torres", "Sistemas", 75.5));
        g.agregar(new Estudiante("2021002", "Carlos Quispe", "Industrial", 88.0));
        g.agregar(new Estudiante("2021003", "Maria Condori", "Sistemas", 92.3));
        g.agregar(new Estudiante("2021004", "Luis Mamani", "Civil", 61.0));
        g.agregar(new Estudiante("2021005", "Rosa Flores", "Industrial", 79.5));
        g.agregar(new Estudiante("2021006", "Pedro Vargas", "Sistemas", 55.0));
        g.agregar(new Estudiante("2021007", "Silvia Choque", "Civil", 83.5));
        g.agregar(new Estudiante("2021008", "Hugo Espejo", "Industrial", 70.0));
        g.agregar(new Estudiante("2021009", "Patricia Lima", "Sistemas", 95.0));
        g.agregar(new Estudiante("2021010", "Diego Arce", "Civil", 67.5));
    }
}