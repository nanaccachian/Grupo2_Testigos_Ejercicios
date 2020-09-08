package Domain;

import java.util.List;

public class Municipio {
    private int id;
    private String nombre;

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean estaEnLista(List<MunicipioML> municipiosML) {
        return municipiosML.stream().anyMatch(mun -> mun.getName().equalsIgnoreCase(nombre));
    }

    public Municipio(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
}
