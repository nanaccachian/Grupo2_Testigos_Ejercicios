package Domain;

import java.util.List;

public class MunicipioML{
    private String id;
    private String name;

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public boolean estaEnLista(List<Municipio> municipios) {
        return municipios.stream().anyMatch(mun -> mun.getNombre().equalsIgnoreCase(name));
    }

    public MunicipioML(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
