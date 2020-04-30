package Modelo;

public class Transportista {
    private String nombre;
    private Tipo tipoEnvio;

    public Transportista(String nombre, Tipo tipoEnvio) {
        this.nombre = nombre;
        this.tipoEnvio = tipoEnvio;
    }

    public float calcularCosto(Envio envio) {
        return tipoEnvio.calcularCosto(envio);
    }

    public void setTipoEnvio(Tipo tipoEnvio) {
        this.tipoEnvio = tipoEnvio;
    }
}
