package com.example.allin.models;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.allin.R;

import java.util.List;

public class PlantAdapter extends RecyclerView.Adapter<PlantAdapter.PlantViewHolder> {
    private Context context;
    private List<Plant> plantList;

    public PlantAdapter(Context context, List<Plant> plantList) {
        this.context = context;
        this.plantList = plantList;
    }

    @NonNull
    @Override
    public PlantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_plant, parent, false);
        return new PlantViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlantViewHolder holder, int position) {
        Plant plant = plantList.get(position);

        // Reconstructing the Uri object
        Uri photoUri = Uri.parse(plant.getPhotoUri());

        // Load image from URI using Glide or Picasso
        Glide.with(context).load(photoUri).into(holder.photoImageView);

        holder.nameTextView.setText(plant.getName());
        holder.descriptionTextView.setText(plant.getDescription());
        // Add other bindings here
    }

    @Override
    public int getItemCount() {
        return plantList.size();
    }

    public static class PlantViewHolder extends RecyclerView.ViewHolder {
        ImageView photoImageView;
        TextView nameTextView;
        TextView descriptionTextView;

        public PlantViewHolder(@NonNull View itemView) {
            super(itemView);
            photoImageView = itemView.findViewById(R.id.photoImageView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
        }
    }
}