package Modelo;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Billete {

    private Pago pago;
    private Plaza plaza;
    private boolean preferencial;
    private Viaje viaje;
    private Viajero viajero;

    @Override
    public String toString() {
        return "Plaza: " + plaza.getNroPlaza().toString() + " Preferencial: " + preferencial + "Viaje: "
                + viaje.getHorario().toString() + "Viajero: " + viajero.toString() + "Pago: " + pago.toString();
    }

}
