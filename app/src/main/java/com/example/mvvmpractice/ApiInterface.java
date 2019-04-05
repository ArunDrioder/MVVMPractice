package com.example.mvvmpractice;
import java.util.ArrayList;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiInterface
{
    @GET("mobile/Categories")
     Observable<DataPOJO> getData();


}


