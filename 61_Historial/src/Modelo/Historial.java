package Modelo;

import java.util.ArrayList;

public class Historial {

    private ArrayList<Registro> registros;
    private static Historial historial;

    private Historial() {
        this.registros = new ArrayList<Registro>();
    }

    public static Historial getInstance() {
        if (historial == null) {
            historial = new Historial();
        }
        return historial;
    }

    public void agregarRegistro(Registro registro) {
        registros.add(registro);
    }
}