package Modelo;

public class Paquete {
    private String descripcion;
    private float peso;

    public Paquete(String descripcion, float peso) {
        this.descripcion = descripcion;
        this.peso = peso;
    }

    public float getPeso() {
        return peso;
    }
}
