package com.example.storeapplication.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.example.storeapplication.R;

public class ProductPageActivity extends SingleFragmentActivity {
    private static final String EXTRA_PRODUCT_PAGE_URI = "productPageUri";

    public static Intent newIntent(Context context, Uri uri) {
        Intent intent = new Intent(context, ProductPageActivity.class);
        intent.putExtra(EXTRA_PRODUCT_PAGE_URI, uri);
        return intent;
    }

    @Override
    public Fragment createFragment() {
        Uri productPageUri = getIntent().getParcelableExtra(EXTRA_PRODUCT_PAGE_URI);
        return ProductPageFragment.newInstance(productPageUri);
    }
}