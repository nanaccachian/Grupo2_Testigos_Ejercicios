package Modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.Getter;

public class Vagon {

    @Getter
    private int nroVagon;

    @Getter
    private List<Plaza> plazas = new ArrayList<Plaza>();

    public boolean esFumador() {
        return Arrays.asList(3, 4, 5, 6).contains(nroVagon);
    }

    public boolean esPreferencial() {
        return Arrays.asList(1, 2, 3, 4).contains(nroVagon);
    }

    public Vagon(int id, List<Plaza> plazas) throws Exception {
        this.nroVagon = id;

        if (plazas.size() == 60)
            // Falta chequear si son 30 y 30.
            this.plazas = plazas;
        else
            throw new Exception("No hay 60 plazas");
    }

}
