package Domain;

import java.util.ArrayList;
import java.util.List;

public class ProvinciaGR {
    public int cantidad;
    public int inicio;
    public Parametro parametro;
    public List<Provincia> provincias;
    public int total;

    private class Provincia {
        public Centroide centroide;
        public String id;
        public String nombre;

        public String getId() {
            return id;
        }
    }

    private class Parametro {
        public String nombre;
    }

    private class Centroide {
        double lat;
        double lon;
    }

    public int getId() {
        return Integer.parseInt(provincias.get(0).getId());
    }
}
