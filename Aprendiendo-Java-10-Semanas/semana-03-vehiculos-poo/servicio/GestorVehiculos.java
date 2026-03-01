package servicio;
import modelo.*;
import java.util.ArrayList;

public class GestorVehiculos {
    private ArrayList<Vehiculo> vehiculos = new ArrayList<>();
    public void agregar(Vehiculo v) { vehiculos.add(v); }
    public void listarTodos() {
        for (Vehiculo v : vehiculos) System.out.println(v.getInfo());
    }
    public void demostrarPolimorfismo() { 
        for (Vehiculo v : vehiculos) v.acelerar();
    }
    public void listarElectricos() { 
        for (Vehiculo v : vehiculos) {
            if (v instanceof Electrico) {
                Electrico e = (Electrico) v;
                System.out.println(v.getInfo() + " - Batería: " + e.getNivelBateria() + "%");
            }
        }
    }
    public void cargarBateriasBajas() { 
        for (Vehiculo v : vehiculos) {
            if (v instanceof Electrico e && e.necesitaCarga()) {
                System.out.print("Cargando " + v.getInfo() + "... ");
                e.cargarBateria();
                System.out.println("¡Listo!");
            }
        }
    }
    public void mostrarEstadisticas() { // RF7
        int elec = 0, necesitan = 0;
        for (Vehiculo v : vehiculos) {
            if (v instanceof Electrico e) {
                elec++;
                if (e.necesitaCarga()) necesitan++;
            }
        }
        System.out.println("Total: " + vehiculos.size() + " | Eléctricos: " + elec + " | Necesitan carga: " + necesitan);
    }
    public void filtrarPorTipo(String tipo) {
        String t = tipo.toLowerCase().trim();
        boolean found = false;
        for (Vehiculo v : vehiculos) {
            switch (t) {
                case "auto" -> { if (v instanceof Auto) { System.out.println(v.getInfo()); found = true; } }
                case "moto" -> { if (v instanceof Moto) { System.out.println(v.getInfo()); found = true; } }
                case "camion" -> { if (v instanceof Camion) { System.out.println(v.getInfo()); found = true; } }
                case "autoelectrico" -> { if (v instanceof AutoElectrico) { System.out.println(v.getInfo()); found = true; } }
                case "motoelectrica" -> { if (v instanceof MotoElectrica) { System.out.println(v.getInfo()); found = true; } }
                default -> {
                    String cls = v.getClass().getSimpleName().toLowerCase();
                    if (cls.contains(t)) {
                        System.out.println(v.getInfo());
                        found = true;
                    }
                }
            }
        }
        if (!found) System.out.println("No se encontraron vehículos del tipo: " + tipo);
    }
}
