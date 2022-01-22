package com.wendy.wendyec3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wendy.wendyec3.network.ClothesEntry;
import com.wendy.wendyec3.network.ImageRequest;

import java.util.List;

public class ClothesCardRecyclerViewAdapter  extends RecyclerView.Adapter<ClothesCardViewHolder>{
    private List<ClothesEntry> productList;
    private ImageRequest imageRequest;

    ClothesCardRecyclerViewAdapter(List<ClothesEntry> productList) {
        this.productList = productList;
        imageRequest = ImageRequest.getInstance();
    }

    @NonNull
    @Override
    public ClothesCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.clothes_card, parent, false);
        return new ClothesCardViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull ClothesCardViewHolder holder, int position) {
        if (productList != null && position < productList.size()) {
            ClothesEntry product = productList.get(position);
            holder.clothesTitle.setText(product.title);
            holder.clothesPrice.setText(product.price);
            imageRequest.setImageFromUrl(holder.clothesImage, product.url);
        }
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
}
