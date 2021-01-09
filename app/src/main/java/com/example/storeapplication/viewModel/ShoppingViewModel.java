package com.example.storeapplication.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.storeapplication.Repository.ProductRepository;
import com.example.storeapplication.model.Product;

import java.util.List;

public class ShoppingViewModel extends AndroidViewModel {
private ProductRepository mRepository;
    private final LiveData<List<Product>> mPopularProductLiveData;


    public ShoppingViewModel(@NonNull Application application) {
        super(application);
        mRepository=new ProductRepository();
        mPopularProductLiveData=mRepository.getProductLiveDataPopular();
    }

    public LiveData<List<Product>> getPopularProductLiveData() {
        return mPopularProductLiveData;
    }

    /*public LiveData<List<Product>> getNewProductLiveData() {
            return mpopularProductLiveData;
        }*/
    public void fetchPopularProductList(){
        mRepository.fetchPopularProductList();
    }

}
