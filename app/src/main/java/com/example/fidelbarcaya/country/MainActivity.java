package com.example.fidelbarcaya.country;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.fidelbarcaya.country.countryApi.CountryApiService;
import com.example.fidelbarcaya.country.models.Country;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private Retrofit retrofit;
    private static  final String TAG = "COUNTRYDEX";
    private RecyclerView recyclerView;
    private CountryListAdapter countryListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        countryListAdapter = new CountryListAdapter(this);
        recyclerView.setAdapter(countryListAdapter);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(layoutManager);


        retrofit = new Retrofit.Builder()
                .baseUrl("https://restcountries.eu/rest/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        getData();
    }

    private void getData() {
        CountryApiService service = retrofit.create(CountryApiService.class);
        Call<List<Country>> countryListResponse =  service.getListCountry();
        countryListResponse.enqueue(new Callback<List<Country>>() {
            @Override
            public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {
                if(response.isSuccessful())
                {
                    List<Country> countries = response.body();
                    for(Country country: countries){
                        Log.i(TAG, country.getName() +" code is "+ country.getAlpha2Code());
                    }
                   countryListAdapter.addCountryList(countries);
                }else{
                    Log.e(TAG, " on response " + response.errorBody());

                }
            }

            @Override
            public void onFailure(Call<List<Country>> call, Throwable t) {
                Log.e(TAG, " on Failure " + t.getMessage());

            }
        });
    }

}
