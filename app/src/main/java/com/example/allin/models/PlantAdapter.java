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
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.allin.PlantInfoFragment;
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

        Bitmap imageBitmap = decodeBase64(plant.getImageData());
        holder.photoImageView.setImageBitmap(imageBitmap);

        holder.nameTextView.setText(plant.getName());
        holder.descriptionTextView.setText(plant.getDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlantInfoFragment dialogFragment = PlantInfoFragment.newInstance(
                        plant.getImageData(),
                        plant.getName(),
                        plant.getDescription(),
                        plant.getTemperature(),
                        plant.getLight(),
                        plant.getWater(),
                        plant.getDifficulty()
                );
                dialogFragment.show(((FragmentActivity) context).getSupportFragmentManager(), "PlantInfoFragment");
            }
        });
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

    public static Bitmap decodeBase64(String image) {
        if (image == null) return null;
        byte[] decodedByte = Base64.decode(image, 0);
        return BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.length);
    }
}