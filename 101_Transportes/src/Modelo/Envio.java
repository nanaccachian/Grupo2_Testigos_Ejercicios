package Modelo;

public class Envio {
    private float distancia;
    private Transportista transportista;
    private Paquete paquete;

    public Envio(float distancia, Transportista transportista, Paquete paquete) {
        this.distancia = distancia;
        this.transportista = transportista;
        this.paquete = paquete;
    }

    public float costoEnvio() {
        return transportista.calcularCosto(this);
    }

    public float getDistancia() {
        return distancia;
    }

    public float peso() {
        return paquete.getPeso();
    }
}
