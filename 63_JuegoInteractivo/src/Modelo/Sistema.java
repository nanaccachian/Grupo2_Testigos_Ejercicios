package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Sistema {
    private static Sistema sistema;
    private List<Partida> partidas;
    private List<Personaje> personajes;

    private Sistema() {
        this.partidas = new ArrayList<Partida>();
        this.personajes = new ArrayList<Personaje>();
    }

    public static Sistema getInstance() {
        if (sistema == null)
            sistema = new Sistema();
        return sistema;
    }

    public void crearPartida(Personaje personaje) throws CloneNotSupportedException {
        partidas.add(new Partida(clonarPersonaje(personaje)));
    }

    public void nuevoPersonaje(Personaje personaje) {
        personajes.add(personaje);
    }

    public Personaje clonarPersonaje(Personaje teVamosAClonar) throws CloneNotSupportedException {
        return (Personaje) teVamosAClonar.clonar();
    }
}
