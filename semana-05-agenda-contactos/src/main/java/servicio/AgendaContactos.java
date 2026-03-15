package servicio;

import modelo.Contacto;
import util.ManejadorJSON;
import java.util.ArrayList;

public class AgendaContactos {
    private ArrayList<Contacto> lista;
    private final String RUTA = "data/contactos.json";
    private final String BACKUP = "data/contactos.backup.json";

    public AgendaContactos() {
        this.lista = ManejadorJSON.cargar(RUTA);
        System.out.println("Agenda cargada con " + lista.size() + " contactos.");
    }

    public void agregar(Contacto c) {
        lista.add(c);
        guardarTodo();
    }

    public boolean eliminar(String id) {
        boolean removido = lista.removeIf(c -> c.getId().equalsIgnoreCase(id));
        if (removido) guardarTodo();
        return removido;
    }

    public Contacto buscarPorId(String id) {
        return lista.stream()
                .filter(c -> c.getId().equalsIgnoreCase(id))
                .findFirst()
                .orElse(null);
    }

    public void guardarTodo() {
        ManejadorJSON.guardarConBackup(lista, RUTA, BACKUP);
    }

    public ArrayList<Contacto> getLista() {
        return lista;
    }

    // Estadísticas para la opción 6
    public long contarConEmail() {
        return lista.stream().filter(c -> c.getEmail() != null && c.getEmail().contains("@")).count();
    }
}