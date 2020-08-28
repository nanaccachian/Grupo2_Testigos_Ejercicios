package Servicios;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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

    }
}
