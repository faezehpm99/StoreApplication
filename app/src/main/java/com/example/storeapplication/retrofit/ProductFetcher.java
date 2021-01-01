package com.example.storeapplication.retrofit;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductFetcher {
    public static final String BASE_URL = "https://woocommerce.maktabsharif.ir/wp-json/wc/v3/";
    public static final String Customer_KEY="ck_73763d7336a571c2e0d968cddd88a903f35d64a9";
    public static final String Customer_secret="cs_3c114bbbdd0ef95a2e519af96c60aeaeb7fd1345";
    private Map<String, String> mQueries;
    private Retrofit mRetrofit;
    private ProductService mProductService;
    private static ProductFetcher instance;

    private MutableLiveData<List<Product>> mProductLiveDataNews = new MutableLiveData<>();
    private MutableLiveData<List<Product>> mProductLiveDataPopular = new MutableLiveData<>();
    private MutableLiveData<List<Product>> mProductLiveDataRate = new MutableLiveData<>();

    public MutableLiveData<List<Product>> getProductLiveDataNews() {
        return mProductLiveDataNews;
    }

    public MutableLiveData<List<Product>> getProductLiveDataPopular() {
        return mProductLiveDataPopular;
    }

    public MutableLiveData<List<Product>> getProductLiveDataRate() {
        return mProductLiveDataRate;
    }

    public static ProductFetcher getInstance() {
        if (instance == null)
            instance = new ProductFetcher();
        return instance;
    }
    private ProductFetcher() {

        mQueries = new HashMap<String, String>() {{
            put("consumer_key", Customer_KEY);
            put("consumer_secret", Customer_secret);

        }};

        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mProductService = mRetrofit
                .create(ProductService.class);
    }
    public void getProductListNew(){


        mProductService.getResponse(mQueries).enqueue(getRetrofitCallback("New"));

    }
    public void getProductListPopular(){
        HashMap<String ,String>mNewQueries=new HashMap<>();
        mNewQueries.putAll(mQueries);

        mNewQueries.put("orderby","popularity");
        mProductService.getResponse(mNewQueries).enqueue(getRetrofitCallback("popularity"));

    }
    public void getProductListRate(){
        HashMap<String ,String>mNewQueries=new HashMap<>();
        mNewQueries.putAll(mQueries);
        mNewQueries.put("orderby","rating");
        mProductService.getResponse(mNewQueries).enqueue(getRetrofitCallback("rating"));

    }
    private Callback<List<Product>> getRetrofitCallback(final String s) {
        return new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                Log.d("fail on rsp", "onResponse: " + response.message());

                if (response.isSuccessful()) {
                    Log.d("trouble in success", "isSuccessful: ");

                    List<Product> products = response.body();
                    if(s.equals("New"))
                        mProductLiveDataNews.setValue(products);
                    else if (s.equals("popularity"))
                        mProductLiveDataPopular.setValue(products);
                    else if (s.equals("rating"))
                        mProductLiveDataRate.setValue(products);

                }
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Log.e("fail", t.getMessage(), t);
            }
        };
    }


}
