package com.example.allin.models;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.allin.R;

import java.util.List;


public class MainPictureAdapter extends RecyclerView.Adapter<MainPictureAdapter.MainPictureViewHolder> {

    private Context context;
    private List<MainPicture> pictureList;

    public MainPictureAdapter(Context context, List<MainPicture> pictureList) {
        this.context = context;
        this.pictureList = pictureList;
    }

    @NonNull
    @Override
    public MainPictureViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_main_picture, parent, false);
        return new MainPictureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainPictureViewHolder holder, int position) {
        MainPicture picture = pictureList.get(position);
        Bitmap imageBitmap = decodeBase64(picture.getImageData());
        holder.imageView.setImageBitmap(imageBitmap);
        holder.nameTextView.setText(picture.getName());
        holder.yearTextView.setText(String.valueOf(picture.getYear()));
    }

    @Override
    public int getItemCount() {
        return pictureList.size();
    }

    public static Bitmap decodeBase64(String image) {
        if (image == null) return null;
        byte[] decodedByte = Base64.decode(image, 0);
        return BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.length);
    }

    public static class MainPictureViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView nameTextView;
        TextView yearTextView;

        public MainPictureViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            yearTextView = itemView.findViewById(R.id.yearTextView);
        }
    }

}
