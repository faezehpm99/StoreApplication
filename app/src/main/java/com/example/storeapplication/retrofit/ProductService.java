package com.example.storeapplication.retrofit;

import com.example.storeapplication.model.Product;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface ProductService {
    @GET("products")
    Call<List<Product>> getResponse(@QueryMap Map<String, String> queries);
}
