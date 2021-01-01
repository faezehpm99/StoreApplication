package com.example.storeapplication;

import androidx.fragment.app.Fragment;

import com.example.storeapplication.view.ProductFragment;
import com.example.storeapplication.view.SingleFragmentActivity;

public class MainActivity extends SingleFragmentActivity {


    @Override
    public Fragment createFragment() {
        return ProductFragment.newInstance();
    }
}