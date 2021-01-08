package com.example.storeapplication.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SearchView;

import com.example.storeapplication.Adapter.ProductAdapter;
import com.example.storeapplication.R;
import com.example.storeapplication.model.Product;
import com.example.storeapplication.retrofit.ProductFetcher;
import com.example.storeapplication.viewModel.ShoppingViewModel;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
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
private ProductFetcher mFetcher;


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
        setHasOptionsMenu(true);
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


        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(layoutManager);

        mViewModel.getProductLiveDataPopular().observe(this, new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> products) {

                setupAdapterNew(products);
            }
        });

      return view;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
       inflater.inflate(R.menu.fragment_product,menu);
        MenuItem searchMenuItem = menu.findItem(R.id.menu_item_search);
        SearchView searchView = (SearchView) searchMenuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

               /* mViewModel.fetchSearchItemsAsync(query);
                mViewModel.setQueryInPreferences(query);*/
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        searchView.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* String query = mViewModel.getQueryFromPreferences();
                if (query != null)
                    searchView.setQuery(query, false);*/
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
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