package com.iottech.demokotlinapp.retro;

import com.iottech.demokotlinapp.ModelList;
import com.iottech.demokotlinapp.ProductsModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {


    @GET("api/get-top-products")
    Call<ProductsModel> getusers();






}

