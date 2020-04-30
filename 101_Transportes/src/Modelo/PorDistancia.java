package Modelo;

public class PorDistancia extends Tipo {
    private float tarifaPorDistancia;

    public PorDistancia(float tarifaPorDistancia) {
        this.tarifaPorDistancia = tarifaPorDistancia;
    }

    @Override
    public float calcularCosto(Envio envio) {
        return tarifaPorDistancia*envio.getDistancia();
    } //Inventamos esto para que sean un poco mas distintas y se justifique crear una clase aparte.
}
