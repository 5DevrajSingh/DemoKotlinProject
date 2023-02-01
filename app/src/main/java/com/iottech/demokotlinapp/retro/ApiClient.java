package com.iottech.demokotlinapp.retro;


import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiClient {

// public static final String BASE_URL = "https://icomhealth.in/icom/api/auth/";  // Client side Live Url
 public static final String BASE_URL = "https://iottechbazaar.com/";  // Client side Live Url



    public static Retrofit retrofit = null;


    public static Retrofit getClient() {
        if (retrofit == null) {

            OkHttpClient client = new OkHttpClient.Builder()
                    .connectTimeout(8000, TimeUnit.SECONDS)
                    .readTimeout(8000, TimeUnit.SECONDS).build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
