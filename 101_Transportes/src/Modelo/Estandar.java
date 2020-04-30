package Modelo;

public class Estandar extends Tipo{
    private float tarifaPorKilo;
    private float tarifaDistancia;
    private float limiteKilometros;

    public Estandar(float tarifaPorKilo, float tarifaDistancia, float limiteKilometros) {
        this.tarifaPorKilo = tarifaPorKilo;
        this.tarifaDistancia = tarifaDistancia;
        this.limiteKilometros = limiteKilometros;
    }

    public boolean esLargaDistancia(Envio envio) {
        return envio.getDistancia() > limiteKilometros;
    }

    @Override
    public float calcularCosto(Envio envio) {
        if(esLargaDistancia(envio))
            return tarifaDistancia*envio.peso(); //Supusimos que la tarifa por kilo era mayor en distancia
        else
            return tarifaPorKilo*envio.peso();
    }

    public void setTarifaPorKilo(float tarifaPorKilo) {
        this.tarifaPorKilo = tarifaPorKilo;
    }

    public void setTarifaDistancia(float tarifaDistancia) {
        this.tarifaDistancia = tarifaDistancia;
    }

    public void setLimiteKilometros(float limiteKilometros) {
        this.limiteKilometros = limiteKilometros;
    }
}
