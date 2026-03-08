package servicio;

import modelo.Estudiante;
import java.util.HashMap;
import java.util.TreeSet;
import java.util.ArrayList;

public class GestorEstudiantes {
    private HashMap<String, Estudiante> c; 
    private TreeSet<Estudiante> r;       
    private ArrayList<String> h;      
    public GestorEstudiantes() 
    {
        c = new HashMap<>();
        r = new TreeSet<>();
        h = new ArrayList<>();
    }
    public boolean agregar(Estudiante e) 
    {
        if (c.containsKey(e.getCarnet())) { return false; }
        c.put(e.getCarnet(), e);
        r.add(e);
        h.add("AGREGAR  : " + e.getCarnet() + " - " + e.getNombre());
        return true;
    }
    public Estudiante buscar(String k) {
        return c.get(k);
    }
    public boolean actualizarPromedio(String k, double nP) {
        Estudiante e = c.get(k);
        if (e == null) return false;
        r.remove(e);
        e.setPromedio(nP);
        r.add(e);

        h.add("ACTUALIZAR: " + k + " promedio -> " + nP);
        return true;
    }
    public boolean eliminar(String k) {
        Estudiante e = c.remove(k);
        if (e == null) return false;
        r.remove(e);
        h.add("ELIMINAR : " + k + " - " + e.getNombre());
        return true;
    }
    public void mostrarRanking() {
        System.out.println("\n=== Ranking de estudiantes ===");
        int i = 1;
        for (Estudiante e : r) {
            System.out.printf("%3d. %s\n", i++, e);
        }
    }
    public void mostrarTop5() {
        System.out.println("\n=== Top 5 estudiantes ===");
        int i = 0;
        Estudiante[] a = r.toArray(new Estudiante[0]);
        int s = Math.max(0, a.length - 5);
        for (int j = a.length - 1; j >= s; j--) {
            System.out.printf("%d. %s\n", ++i, a[j]);
        }
    }
    public void filtrarPorCarrera(String f) {
        System.out.println("\n=== Carrera: " + f + " ===");
        boolean x = false;
        for (Estudiante e : c.values()) {
            if (e.getCarrera().equalsIgnoreCase(f)) {
                System.out.println(e);
                x = true;
            }
        }
        if (!x) System.out.println("Ninguno encontrado.");
    }
    public void mostrarEstadisticas() {
        if (r.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }
        double s = 0;
        for (Estudiante e : r) s += e.getPromedio();
        System.out.println("\n=== Estadisticas ===");
        System.out.println(" Total     : " + r.size());
        System.out.printf (" Promedio  : %.2f\n", s / r.size());
        System.out.println(" Mejor     : " + r.last());
        System.out.println(" Peor      : " + r.first());
    }
    public void mostrarHistorial() {
        System.out.println("\n=== Historial de operaciones ===");
        if (h.isEmpty()) {
            System.out.println("Sin operaciones registradas.");
            return;
        }
        for (String l : h) System.out.println(" " + l);
    }
    public int getTotalEstudiantes() {
        return c.size();
    }
}