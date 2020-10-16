package Modelo;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

public class Tren {

    private Vagon locomotora = new Vagon(0, null);

    @Getter
    private List<Vagon> vagones = new ArrayList<Vagon>();

    public Tren(List<Vagon> vagonesl) throws Exception {
        if (vagonesl.size() == 8)
            this.vagones = vagonesl;
        else
            throw new Exception("No hay 8 vagones");
    }
}
