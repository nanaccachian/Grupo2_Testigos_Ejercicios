package Domain;

import java.util.List;
import java.util.Optional;

public class ListadoDeProvinciasML {

//    private int id;
//    private String name;
//    private String locale;
//    private String currency_id;
//    private String decimal_separator;
//    private String thousands_separator;
//    private String time_zone;
    public Parametro parametros;
    public Geo_information geo_information;
    public List<ProvinciasML> states;

    public Optional<ProvinciasML> provinciaDeId(String id){
        return this.states.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    private class Parametro {
        public List<String> campos;
    }

    private class Geo_information {
        float latitude;
        float longitud;
    }
}
