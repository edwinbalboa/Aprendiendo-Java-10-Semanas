import modelo.Tarea;
import servicio.GestorTareas;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GestorTareas gestor = new GestorTareas();
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n=== GESTOR DE TAREAS POO ===");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Listar todas");
            System.out.println("3. Listar pendientes");
            System.out.println("4. Listar completadas");
            System.out.println("5. Completar tarea (por ID)");
            System.out.println("6. Eliminar tarea (por ID)");
            System.out.println("7. Estadísticas");
            System.out.println("8. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    System.out.print("Título: ");
                    String tit = sc.nextLine();
                    System.out.print("Descripción: ");
                    String desc = sc.nextLine();
                    gestor.agregar(tit, desc);
                    break;
                case 2: gestor.listar("TODAS"); break;
                case 3: gestor.listar("PENDIENTE"); break;
                case 4: gestor.listar("COMPLETADA"); break;
                case 5:
                    System.out.print("ID a completar: ");
                    gestor.completarTarea(sc.nextInt());
                    break;
                case 6:
                    System.out.print("ID a eliminar: ");
                    gestor.eliminar(sc.nextInt());
                    break;
                case 7: gestor.mostrarEstadisticas(); break;
                case 8: System.out.println("¡Adiós!"); break;
                default: System.out.println("Opción no válida.");
            }
        } while (opcion != 8);
    }
}
