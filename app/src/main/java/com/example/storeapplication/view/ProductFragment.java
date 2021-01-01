package com.example.storeapplication.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.storeapplication.Adapter.ProductAdapter;
import com.example.storeapplication.R;
import com.example.storeapplication.model.Product;
import com.example.storeapplication.viewModel.ShoppingViewModel;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProductFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProductFragment extends Fragment {
private RecyclerView mRecyclerView;
private ShoppingViewModel mViewModel;
private ProductAdapter mAdapter;


    public ProductFragment() {

    }

    public static ProductFragment newInstance() {
        ProductFragment fragment = new ProductFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ShoppingViewModel.class);
        mViewModel.getProductListNew();
        mViewModel.getProductListPopular();
        mViewModel.getProductListRate();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

      View view= inflater.inflate(R.layout.fragment_product, container, false);
      mRecyclerView=view.findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        mRecyclerView.setLayoutManager(layoutManager);
        mViewModel.getProductLiveDataNew().observe(this, new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> products) {

                setupAdapterNew(products);
            }
        });

      return view;
    }

    private void setupAdapterNew(List<Product> items) {
        if (mAdapter == null) {
            mAdapter = new ProductAdapter(getContext(),items);
            mRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.setProducts(items);
            mAdapter.notifyDataSetChanged();
        }
    }
}