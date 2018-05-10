package com.example.nishan.retrofit.Rest;



import com.example.nishan.retrofit.Model.Actor;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("api/utilitiesapi/getsearch?q=anmol")
    Call<List<Actor>> findAll();

  //  @GET("movie/{id}")
    //Call<Actor> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey);
}
