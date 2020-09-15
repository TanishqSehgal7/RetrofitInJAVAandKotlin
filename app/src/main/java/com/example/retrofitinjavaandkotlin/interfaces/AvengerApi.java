package com.example.retrofitinjavaandkotlin.interfaces;

import com.example.retrofitinjavaandkotlin.JavaPart.Hero;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AvengerApi {

    String BASE_URL="https://simplifiedcoding.net/demos/";

    @GET("marvel")
    Call<List<Hero>> getHeroes();
}
