package Domain;

import java.util.ArrayList;
import java.util.List;

public class Cajero {
    private static Cajero instance = null;
    private static Ticket ticket = null;
    private static float precioPorHora = 100;
    private static List<Recibo> recibos = new ArrayList<>();
    private static float cambioEnCajero = 1500;

    private Cajero() {
    }

//    public Cajero getInstance() {
//        if (instance == null)
//            instance = new Cajero();
//        return instance;
//    }

    public static float calcularImporte(Ticket ticket) {
        return ticket.getTime()*precioPorHora;
    }

    public static boolean tenesCambio(float cambio) {
        if(cambioEnCajero > cambio) {
            cambioEnCajero-=cambio;
            return true;
        } else
            return false;
    }

    public static Recibo generarRecibo(float importeAPagar, Ticket ticket) {
        Recibo recibo = new Recibo(importeAPagar,ticket);
        recibos.add(recibo);
        return recibo;
    }
}
