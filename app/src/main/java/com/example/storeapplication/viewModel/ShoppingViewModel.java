package com.example.storeapplication.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.storeapplication.model.Product;
import com.example.storeapplication.retrofit.ProductFetcher;

import java.util.List;

public class ShoppingViewModel extends AndroidViewModel {
    private ProductFetcher productFetcher = ProductFetcher.getInstance();

    public ShoppingViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<List<Product>> getProductLiveDataNew(){
        return productFetcher.getProductLiveDataNews();
    }
    public MutableLiveData<List<Product>> getProductLiveDataPopular(){
        return productFetcher.getProductLiveDataPopular();
    }
    public MutableLiveData<List<Product>> getProductLiveDataRate(){
        return productFetcher.getProductLiveDataRate();
    }

    public void getProductListNew(){
        productFetcher.getProductListNew();
    }
    public void getProductListRate(){
        productFetcher.getProductListRate();
    }
    public void getProductListPopular(){
        productFetcher.getProductListPopular();
    }

}
