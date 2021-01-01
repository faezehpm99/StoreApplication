package com.example.storeapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.storeapplication.retrofit.ProductFetcher;

public class MainActivity extends AppCompatActivity {
    private TextView mTst;
    private ProductFetcher mFetcher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTst=findViewById(R.id.tst);
     mFetcher.getProductListPopular();

    }


}