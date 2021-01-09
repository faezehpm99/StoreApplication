package com.example.storeapplication.Repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.storeapplication.model.Product;
import com.example.storeapplication.retrofit.NetworkParams;
import com.example.storeapplication.retrofit.ProductService;
import com.example.storeapplication.retrofit.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductRepository {




    private ProductService mProductService;
    private List<Product>mProducts;


    public List<Product> getProducts() {
        return mProducts;
    }

    public void setProducts(List<Product> mProducts) {
        this.mProducts = mProducts;
    }





    public ProductRepository() {
        mProductService= RetrofitInstance.getInstance().create(ProductService.class);
    }
    public void fetchPopularProductList(){

       Call<List<Product>> callAsync= mProductService.getResponse(NetworkParams.highRatedProductList);
       callAsync.enqueue(new Callback<List<Product>>() {
           @Override
           public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
              List<Product> popularList=response.body();


           }

           @Override
           public void onFailure(Call<List<Product>> call, Throwable t) {
               Log.d("error in fetching ",t.getMessage());
           }
       });


    }
}
