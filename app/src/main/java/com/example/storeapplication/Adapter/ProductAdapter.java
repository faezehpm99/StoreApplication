package com.example.storeapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.storeapplication.R;
import com.example.storeapplication.model.Product;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductHolder> {
    private Context mContext;
    private List<Product>mProducts;

    public ProductAdapter(Context mContext, List<Product> mProducts) {
        this.mContext = mContext;
        this.mProducts = mProducts;
    }

    public Context getContext() {
        return mContext;
    }

    public void setContext(Context mContext) {
        this.mContext = mContext;
    }

    public List<Product> getProducts() {
        return mProducts;
    }

    public void setProducts(List<Product> mProducts) {
        this.mProducts = mProducts;
    }

    @NonNull
    @Override
    public ProductHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.list_item_product, parent, false);
        return new ProductHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductHolder holder, int position) {
        holder.bindResponse(mProducts.get(position));
    }

    @Override
    public int getItemCount() {
        return mProducts.size();
    }



    public class ProductHolder extends RecyclerView.ViewHolder{
        private ImageView mImageView;
        private TextView mTextView;
        private Product mProduct;
        public ProductHolder(@NonNull View itemView) {
            super(itemView);
            mImageView=itemView.findViewById(R.id.productView);
            mTextView=itemView.findViewById(R.id.ProductTextView);
        }

        public void bindResponse(Product product) {
            mProduct = product;
            mTextView.setText(mProduct.getName());
            Picasso.with(mContext)
                    .load(mProduct.getImages().get(0).getSrc())
                    .into(mImageView);

        }
    }
}
