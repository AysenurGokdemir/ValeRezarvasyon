package com.example.valerezarvasyon.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ClientApi {

    public static final String BASE_URL="http://192.168.43.82:9999/_RESTful_JDBC_CRUD/rest/";
    private static Retrofit retrofit=null;
    public static Retrofit RequestRetrofit(){
        if ((retrofit==null)){
            retrofit=new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
