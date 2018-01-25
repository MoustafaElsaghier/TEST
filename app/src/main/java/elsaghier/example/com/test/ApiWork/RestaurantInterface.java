package elsaghier.example.com.test.ApiWork;

import elsaghier.example.com.test.Models.RestaurantResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

/**
 * Created by ELSaghier on 1/25/2018.
 */

public interface RestaurantInterface {
    //    @Header("")
    @GET("search")
    Call<RestaurantResponse> getRestaurants(@Header("user-key") String stringKey);
}
