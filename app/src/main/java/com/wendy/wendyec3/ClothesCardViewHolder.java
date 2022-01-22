package com.wendy.wendyec3;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.toolbox.NetworkImageView;

public class ClothesCardViewHolder extends RecyclerView.ViewHolder {
    public NetworkImageView clothesImage;
    public TextView clothesTitle;
    public TextView clothesPrice;

    public ClothesCardViewHolder(@NonNull View itemView) {
        super(itemView);
        clothesImage = itemView.findViewById(R.id.clothes_image);
        clothesTitle = itemView.findViewById(R.id.title_clothes);
        clothesPrice = itemView.findViewById(R.id.clothes_price);

    }
}
