package Domain;

import java.util.List;

public class ListadoDeMunicipiosML {
    private String id;
    private String name;
    private CountryML country;
    private Geo_information geo_information;
    public List<MunicipioML> cities;

    private class Parametro {
        public List<String> campos;
        public int max;
        public List<String> provincia;
    }

    private class Geo_information {
        long latitude;
        long longitude;
    }
}
