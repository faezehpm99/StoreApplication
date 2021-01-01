package com.example.storeapplication.view;

import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.storeapplication.R;

public class ProductPageFragment extends Fragment {
    private static final String EXTRA_PRODUCT_PAGE_URI = "productPageUri";
    private WebView mWebView;

private Uri mProductUri;

    public ProductPageFragment() {
        // Required empty public constructor
    }

    public static ProductPageFragment newInstance(Uri uri) {
        ProductPageFragment fragment = new ProductPageFragment();
        Bundle args = new Bundle();
        args.putParcelable(EXTRA_PRODUCT_PAGE_URI, uri);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mProductUri = getArguments().getParcelable(EXTRA_PRODUCT_PAGE_URI);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_product_page, container, false);
        mWebView=view.findViewById(R.id.webView);
        mWebView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return false;
            }
        });

mWebView.loadUrl(String.valueOf(mProductUri));
        return view;
    }
}