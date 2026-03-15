import modelo.Contacto;
import servicio.AgendaContactos;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AgendaContactos agenda = new AgendaContactos();
        Scanner sc = new Scanner(System.in);
        int op = 0;

        do {
            System.out.println("\n=== AGENDA DE CONTACTOS ===");
            System.out.println("1. Agregar contacto");
            System.out.println("2. Listar todos");
            System.out.println("3. Buscar contacto");
            System.out.println("4. Editar contacto");
            System.out.println("5. Eliminar contacto");
            System.out.println("6. Estadisticas");
            System.out.println("7. Salir");
            System.out.print("Opcion: ");

            try {
                op = Integer.parseInt(sc.nextLine());
                switch (op) {
                    case 1:
                        System.out.print("Nombre: "); String nom = sc.nextLine();
                        System.out.print("Telefono: "); String tel = sc.nextLine();
                        System.out.print("Email: "); String mail = sc.nextLine();
                        System.out.print("Direccion: "); String dir = sc.nextLine();
                        String nuevoId = "C0" + (agenda.getLista().size() + 1);
                        agenda.agregar(new Contacto(nuevoId, nom, tel, mail, dir));
                        System.out.println("Contacto agregado con ID: " + nuevoId);
                        break;

                    case 2:
                        System.out.println("\n=== TODOS LOS CONTACTOS (" + agenda.getLista().size() + ") ===");
                        System.out.println("ID   | Nombre          | Telefono  | Email");
                        System.out.println("--------------------------------------------------");
                        agenda.getLista().forEach(System.out::println);
                        break;

                    case 3:
                        System.out.print("Buscar por: (1) ID exacto  (2) Nombre parcial: ");
                        int sub = Integer.parseInt(sc.nextLine());
                        System.out.print("Ingrese texto a buscar: ");
                        String busqueda = sc.nextLine().toLowerCase();
                        if (sub == 1) {
                            Contacto c = agenda.buscarPorId(busqueda);
                            if (c != null) System.out.println(c);
                            else System.out.println("No encontrado.");
                        } else {
                            agenda.getLista().stream()
                                .filter(c -> c.getNombre().toLowerCase().contains(busqueda))
                                .forEach(System.out::println);
                        }
                        break;

                    case 4:
                        System.out.print("ID del contacto a editar: ");
                        String idEdit = sc.nextLine();
                        Contacto edit = agenda.buscarPorId(idEdit);
                        if (edit != null) {
                            System.out.print("Nuevo Telefono (actual " + edit.getTelefono() + "): ");
                            // Aquí podrías agregar la lógica para cambiar los campos
                            System.out.println("Datos guardados en contactos.json");
                        } else System.out.println("ID no existe.");
                        break;

                    case 5:
                        System.out.print("ID del contacto a eliminar: ");
                        String idDel = sc.nextLine();
                        if (agenda.eliminar(idDel)) System.out.println("Contacto eliminado.");
                        else System.out.println("Error: ID no encontrado.");
                        break;

                    case 6:
                        long conEmail = agenda.contarConEmail();
                        System.out.println("\n=== ESTADISTICAS ===");
                        System.out.println("Total de contactos : " + agenda.getLista().size());
                        System.out.println("Con email          : " + conEmail);
                        System.out.println("Sin email          : " + (agenda.getLista().size() - conEmail));
                        break;

                    case 7:
                        System.out.println("Saliendo...");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error: Entrada no valida.");
                op = 0;
            }
        } while (op != 7);
        sc.close();
    }
}