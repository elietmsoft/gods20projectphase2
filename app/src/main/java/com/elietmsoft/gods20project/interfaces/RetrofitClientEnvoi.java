package com.elietmsoft.gods20project.interfaces;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientEnvoi {
    private static final String BASE_URL = "https://docs.google.com/forms/d/e/";
    private static RetrofitClientEnvoi mInstance;
    private Retrofit retrofit;

    private RetrofitClientEnvoi(){
        retrofit = new Retrofit.Builder()
                  .baseUrl(BASE_URL)
                  .addConverterFactory(GsonConverterFactory.create())
                  .build();
    }

    public static synchronized RetrofitClientEnvoi getInstance(){
        if(mInstance==null){
            mInstance = new RetrofitClientEnvoi();
        }
        return mInstance;
    }

    public Api getApi(){
        return retrofit.create(Api.class);
    }

}
