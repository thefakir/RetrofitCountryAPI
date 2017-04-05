package com.example.fidelbarcaya.country.countryApi;

import com.example.fidelbarcaya.country.models.Country;
import com.example.fidelbarcaya.country.models.CountryResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by fidel.barcaya on 4/3/2017.
 */

public interface CountryApiService {

    @GET("all")
    Call<List<Country>> getListCountry();
}
