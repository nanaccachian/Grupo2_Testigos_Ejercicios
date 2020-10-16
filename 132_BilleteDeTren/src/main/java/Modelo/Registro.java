package Modelo;

import java.util.List;

import lombok.Getter;

import java.util.ArrayList;

public class Registro {

    private static Registro instance = null;

    @Getter
    private static List<Viaje> viajes = new ArrayList<Viaje>();

    @Getter
    private static List<Tren> trenes = new ArrayList<Tren>();

    private Registro() {
    }

    public static Registro getInstance() {
        if (instance == null)
            instance = new Registro();
        return instance;
    }
}
