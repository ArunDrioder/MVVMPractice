package com.example.mvvmpractice;


import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient

{
    private static final String BASE_URL = "http://invele.com.sg/api/";

    private static Retrofit getRetrofitInstance()
    {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();


    }

    public static ApiInterface getApiInterface()
    {
        return getRetrofitInstance().create(ApiInterface.class);
    }



}