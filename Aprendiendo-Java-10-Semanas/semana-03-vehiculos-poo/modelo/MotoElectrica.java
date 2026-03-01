package modelo;
public class MotoElectrica extends Moto implements Electrico {
    private int nivelBateria;
    public MotoElectrica(String marca, String modelo, int anio, int bateria) {
        super(marca, modelo, anio, false);
        this.nivelBateria = bateria;
    }
    @Override
    public void cargarBateria() { this.nivelBateria = 100; }
    @Override
    public int getNivelBateria() { return nivelBateria; }
    @Override
    public boolean necesitaCarga() { return nivelBateria < 20; }
    @Override
    public void acelerar() {
        nivelBateria -= 2;
        System.out.println(marca + " (moto eléctrica) acelera. Batería: " + nivelBateria + "%");
    }
}
