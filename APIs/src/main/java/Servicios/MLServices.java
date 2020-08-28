package Servicios;

import Domain.ListadoDeProvinciasML;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MLServices {
    @GET("countries")
    Call<ListadoDeProvinciasML> provinciasML(@Query("campos") String campos);
}
