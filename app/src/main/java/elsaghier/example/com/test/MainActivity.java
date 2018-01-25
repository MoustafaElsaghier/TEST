package elsaghier.example.com.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import elsaghier.example.com.test.ApiWork.ApiClient;
import elsaghier.example.com.test.ApiWork.RestaurantInterface;
import elsaghier.example.com.test.Models.RestaurantResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RestaurantInterface anInterface;
    retrofit2.Call<RestaurantResponse> call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anInterface = ApiClient.getClient().create(RestaurantInterface.class);
        call = anInterface.getRestaurants(
                "55a1d18014dd0c0dac534c02598a3368");
        call.enqueue(new Callback<RestaurantResponse>() {
            @Override
            public void onResponse(Call<RestaurantResponse> call, Response<RestaurantResponse> response) {
                Toast.makeText(MainActivity.this, "G", Toast.LENGTH_SHORT).show();
                System.out.println("RES : " + response.body().getRestaurants().get(0).getName());
//                ((TextView)findViewById(R.id.asd)).setText(response.body().getResultsStart());
            }

            @Override
            public void onFailure(Call<RestaurantResponse> call, Throwable t) {
                System.out.println("Error : " + t.getMessage());
            }
        });


    }
}
