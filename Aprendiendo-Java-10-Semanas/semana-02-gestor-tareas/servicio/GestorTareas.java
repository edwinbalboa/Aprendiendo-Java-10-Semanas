package servicio;
import modelo.Tarea;
import java.util.ArrayList;
public class GestorTareas {
    private ArrayList<Tarea> tareas;
    private int proximoId;
    public GestorTareas() {
        this.tareas = new ArrayList<>();
        this.proximoId = 1;
    }
    public void agregar(String titulo, String descripcion) {
        Tarea nueva = new Tarea(proximoId++, titulo, descripcion);
        tareas.add(nueva);
        System.out.println("Tarea agregada con ID: " + nueva.getId());
    }
    public void listar(String filtro) {
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas para mostrar.");
            return;
        }
        for (Tarea t : tareas) {
            if (filtro.equals("TODAS") || t.getEstado().equals(filtro)) {
                t.mostrarInfo();
            }
        }
    }
    public void completarTarea(int id) {
        for (Tarea t : tareas) {
            if (t.getId() == id) {
                if (t.estaCompletada()) {
                    System.out.println("La tarea ya estaba completada.");
                } else {
                    t.completar();
                    System.out.println("Tarea marcada como COMPLETADA.");
                }
                return;
            }
        }
        System.out.println("ID no encontrado.");
    }
    public void eliminar(int id) {
        for (int i = 0; i < tareas.size(); i++) {
            if (tareas.get(i).getId() == id) {
                tareas.remove(i);
                System.out.println("Tarea eliminada exitosamente.");
                return;
            }
        }
        System.out.println("Error: ID no existe.");
    }
    public void mostrarEstadisticas() {
        int total = tareas.size();
        int completadas = 0;
        for (Tarea t : tareas) {
            if (t.estaCompletada()) completadas++;
        }
        int pendientes = total - completadas;
        System.out.println("=== ESTADISTICAS ===");
        System.out.println("Total de tareas: " + total);
        System.out.println("Pendientes: " + pendientes);
        System.out.println("Completadas: " + completadas);
        if (total > 0) {
            System.out.printf("Porcentaje completado: %.1f%%%n", (completadas * 100.0 / total));
        }
    }
}
