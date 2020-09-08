package Servicios;

import Domain.ListadoDeMunicipios;
import Domain.ListadoDeProvincias;
import Domain.ListadoDeProvinciasML;
import Domain.*;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class MercadoLibre {

    public static class ServicioML {

        private static MercadoLibre.ServicioML instancia = null;
        private static int maximaCantidadRegistrosDefault = 200;
        private Retrofit retrofit;

        private ServicioML() {
            this.retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.mercadolibre.com/classified_locations/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        public static MercadoLibre.ServicioML instancia() {
            if (instancia == null)
                instancia = new ServicioML();

            return instancia;
        }

        public ListadoDeProvinciasML listadoDeProvinciasML() throws IOException {
            MLServices MLServices = this.retrofit.create(MLServices.class);

            Call<ListadoDeProvinciasML> requestProvinciasArgentinas = MLServices.provinciasML();

            Response<ListadoDeProvinciasML> responseProvinciasArgentinas = requestProvinciasArgentinas.execute();

            ListadoDeProvinciasML provinciasArgentinas = responseProvinciasArgentinas.body();

            return provinciasArgentinas;
        }

        public ListadoDeMunicipiosML listadoDeMunicipiosDeProvinciaML(ProvinciasML provincia) throws IOException {
            MLServices MLServices = this.retrofit.create(MLServices.class);

            Call<ListadoDeMunicipiosML> requestListadoDeMunicipios = MLServices.municipiosML(provincia.getId());

            Response<ListadoDeMunicipiosML> responseListadoDeMunicipios = requestListadoDeMunicipios.execute();

            ListadoDeMunicipiosML listadoDeMunicipiosML = responseListadoDeMunicipios.body();

            return listadoDeMunicipiosML;
        }
    }
}
