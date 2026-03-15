package modelo;

public class Contacto {
    private String id;
    private String nombre;
    private String telefono;
    private String email;
    private String direccion;

    public Contacto(String id, String nombre, String telefono, String email, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getTelefono() { return telefono; }
    public String getEmail() { return email; }
    public String getDireccion() { return direccion; }

    @Override
    public String toString() {
        return String.format("ID: %-4s | Nom: %-15s | Tel: %-10s | Email: %s", 
                             id, nombre, telefono, email);
    }
}