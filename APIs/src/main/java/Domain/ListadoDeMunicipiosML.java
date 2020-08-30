package Domain;

import java.util.List;

public class ListadoDeMunicipiosML {
    private String id;
    private String name;
    private CountryML country;
    private String geo_information;
    public Parametro parametros;
    public List<MunicipioML> cities;

    private class Parametro {
        public List<String> campos;
        public int max;
        public List<String> provincia;
    }
}
