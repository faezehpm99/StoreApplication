package com.example.storeapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.storeapplication.retrofit.ProductFetcher;
import com.example.storeapplication.view.ProductFragment;
import com.example.storeapplication.view.SingleFragmentActivity;

public class MainActivity extends SingleFragmentActivity {


    @Override
    public Fragment createFragment() {
        return ProductFragment.newInstance();
    }
}