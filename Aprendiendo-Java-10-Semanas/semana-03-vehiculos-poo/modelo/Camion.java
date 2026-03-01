package modelo;
public class Camion extends Vehiculo {
    private double capacidadToneladas;
    public Camion(String marca, String modelo, int anio, double ton) {
        super(marca, modelo, anio);
        this.capacidadToneladas = ton;
    }
    @Override
    public void acelerar() {
        System.out.println(marca + " (camión) acelera despacio con " + capacidadToneladas + "t.");
    }
}
