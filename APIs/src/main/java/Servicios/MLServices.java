package Servicios;

import Domain.ListadoDeMunicipiosML;
import Domain.*;
import retrofit2.Call;
import retrofit2.http.*;

public interface MLServices {
    @GET("countries/AR")
    Call<ListadoDeProvinciasML> provinciasML();

    @GET("countries/")
    Call<ListadoDeProvinciasML> provinciasML2(@Query("campos") String campos);

    @GET("states/{id}")
    Call<ListadoDeMunicipiosML> municipiosML(@Path("id") String id);

    @GET("states/")
    Call<ListadoDeMunicipiosML> municipiosML(@Query("id") String idProvincia, @Query("campos") String campos);

    @GET("states/")
    Call<ListadoDeMunicipiosML> municipiosML(@Query("id") String idProvincia, @Query("campos") String campos, @Query("max") int max);
}
