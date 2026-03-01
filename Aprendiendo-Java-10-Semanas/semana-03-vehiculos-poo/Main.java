import modelo.*;
import servicio.GestorVehiculos;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GestorVehiculos gestor = new GestorVehiculos();
        Scanner sc = new Scanner(System.in);
        gestor.agregar(new Auto("Toyota", "Corolla", 2024, 4));
        gestor.agregar(new Moto("Honda", "CB500", 2023, false));
        gestor.agregar(new Camion("Volvo", "FH16", 2022, 24.0));
        gestor.agregar(new AutoElectrico("Tesla", "Model 3", 2024, 4, 15));
        gestor.agregar(new MotoElectrica("NIU", "MQi+", 2023, 85));
        int opcion;
        do {
            System.out.println("\n=== GESTIÓN DE VEHÍCULOS ===");
            System.out.println("1. Agregar vehiculo\n2. Listar todos\n3. Filtrar por tipo\n4. Ver electricos y baterias\n5. Cargar baterias bajas\n6. Demostrar polimorfismo\n7. Estadisticas\n8. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1 -> {
                    System.out.println("Tipo a agregar: 1)Auto 2)Moto 3)Camion 4)AutoElectrico 5)MotoElectrica");
                    System.out.print("Seleccione (1-5): ");
                    int t = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Marca: ");
                    String marca = sc.nextLine();
                    System.out.print("Modelo: ");
                    String modeloStr = sc.nextLine();
                    System.out.print("Año: ");
                    int anio = sc.nextInt();
                    sc.nextLine();
                    switch (t) {
                        case 1 -> {
                            System.out.print("Numero de puertas: ");
                            int puertas = sc.nextInt();
                            sc.nextLine();
                            gestor.agregar(new Auto(marca, modeloStr, anio, puertas));
                        }
                        case 2 -> {
                            System.out.print("Tiene sidecar (true/false): ");
                            boolean side = sc.nextBoolean();
                            sc.nextLine();
                            gestor.agregar(new Moto(marca, modeloStr, anio, side));
                        }
                        case 3 -> {
                            System.out.print("Capacidad (toneladas): ");
                            double ton = sc.nextDouble();
                            sc.nextLine();
                            gestor.agregar(new Camion(marca, modeloStr, anio, ton));
                        }
                        case 4 -> {
                            System.out.print("Numero de puertas: ");
                            int puertas = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Nivel bateria (0-100): ");
                            int bat = sc.nextInt();
                            sc.nextLine();
                            gestor.agregar(new AutoElectrico(marca, modeloStr, anio, puertas, bat));
                        }
                        case 5 -> {
                            System.out.print("Nivel bateria (0-100): ");
                            int bat = sc.nextInt();
                            sc.nextLine();
                            gestor.agregar(new MotoElectrica(marca, modeloStr, anio, bat));
                        }
                        default -> System.out.println("Tipo no válido.");
                    }
                }
                case 2 -> gestor.listarTodos();
                case 3 -> {
                    System.out.print("Ingrese tipo (Auto/Moto/Camion/AutoElectrico/MotoElectrica): ");
                    String tipo = sc.nextLine();
                    gestor.filtrarPorTipo(tipo);
                }
                case 4 -> gestor.listarElectricos();
                case 5 -> gestor.cargarBateriasBajas();
                case 6 -> gestor.demostrarPolimorfismo();
                case 7 -> gestor.mostrarEstadisticas();
                case 8 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 8);
    }
}
