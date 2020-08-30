package Servicios;

import Domain.ListadoDeMunicipios;
import Domain.ListadoDeMunicipiosML;
import Domain.*;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MLServices {
    @GET("countries/")
    Call<ListadoDeProvinciasML> provinciasML(@Query("provincias") String idProvincia);

    @GET("countries/")
    Call<ListadoDeProvinciasML> provinciasML2(@Query("campos") String campos);

    @GET("states")
    Call<ListadoDeMunicipiosML> municipiosML(@Query("provincia") String idProvincia);

    @GET("states")
    Call<ListadoDeMunicipiosML> municipiosML(@Query("provincia") String idProvincia, @Query("campos") String campos);

    @GET("states")
    Call<ListadoDeMunicipiosML> municipiosML(@Query("provincia") String idProvincia, @Query("campos") String campos, @Query("max") int max);
}
