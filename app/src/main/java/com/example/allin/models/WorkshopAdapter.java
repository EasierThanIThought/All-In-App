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
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.allin.WorkshopInfoFragment;
import com.example.allin.R;

import java.util.List;

public class WorkshopAdapter extends RecyclerView.Adapter<WorkshopAdapter.WorkshopViewHolder> {
    private Context context;
    private List<Workshop> workshopList;

    public WorkshopAdapter(Context context, List<Workshop> workshopList) {
        this.context = context;
        this.workshopList = workshopList;
    }

    @NonNull
    @Override
    public WorkshopAdapter.WorkshopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_workshop, parent, false);
        return new WorkshopAdapter.WorkshopViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WorkshopAdapter.WorkshopViewHolder holder, int position) {
        Workshop workshop = workshopList.get(position);

        Bitmap imageBitmap = decodeBase64(workshop.getImageData());
        holder.photoImageView.setImageBitmap(imageBitmap);

        holder.nameTextView.setText(workshop.getName());
        holder.descriptionTextView.setText(workshop.getDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WorkshopInfoFragment dialogFragment = WorkshopInfoFragment.newInstance(
                        workshop.getImageData(),
                        workshop.getName(),
                        workshop.getMaterials(),
                        workshop.getDescription(),
                        workshop.getTime(),
                        workshop.getPrice()
                );
                dialogFragment.show(((FragmentActivity) context).getSupportFragmentManager(), "WorkshopInfoFragment");
            }
        });
    }

    @Override
    public int getItemCount() {
        return workshopList.size();
    }

    public static class WorkshopViewHolder extends RecyclerView.ViewHolder {
        ImageView photoImageView;
        TextView nameTextView;
        TextView descriptionTextView;

        public WorkshopViewHolder(@NonNull View itemView) {
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
