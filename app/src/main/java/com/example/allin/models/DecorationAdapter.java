package com.example.allin.models;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.allin.R;

import java.util.List;

public class DecorationAdapter extends RecyclerView.Adapter<DecorationAdapter.DecorationViewHolder> {

    private List<Decoration> decorationList;
    private Context context;

    public DecorationAdapter(Context context, List<Decoration> decorationList) {
        this.context = context;
        this.decorationList = decorationList;
    }

    @NonNull
    @Override
    public DecorationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_decoration, parent, false);
        return new DecorationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DecorationViewHolder holder, int position) {
        Decoration decoration = decorationList.get(position);

        Bitmap imageBitmap = decodeBase64(decoration.getImageData());
        holder.photoImageView.setImageBitmap(imageBitmap);
        holder.photoImageView.setScaleType(ImageView.ScaleType.FIT_CENTER); // Or FIT_CENTER, depending on your needs
        holder.photoImageView.setAdjustViewBounds(true);

        Uri videoUri = Uri.parse(decoration.getVideoData());
        holder.videoView.setVideoURI(videoUri);
        holder.videoView.setMediaController(new MediaController(context));
        holder.videoView.requestFocus();
        holder.videoView.start();

        holder.decorationName.setText(decoration.getName());

        String info = decoration.getDescription();
        info += "\n" + decoration.getMaterial() + "\n";
        info += String.valueOf(decoration.getPrice());
        info += " PLN";
        holder.decorationInfo.setText(info);

    }

    @Override
    public int getItemCount() {
        return decorationList.size();
    }

    public static Bitmap decodeBase64(String image) {
        if (image == null) return null;
        byte[] decodedByte = Base64.decode(image, 0);
        return BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.length);
    }

    public static class DecorationViewHolder extends RecyclerView.ViewHolder {
        ImageView photoImageView;
        VideoView videoView;
        TextView decorationName, decorationInfo;

        public DecorationViewHolder(@NonNull View itemView) {
            super(itemView);
            photoImageView = itemView.findViewById(R.id.photoImageView);
            videoView = itemView.findViewById(R.id.videoView);
            decorationName = itemView.findViewById(R.id.decorationName);
            decorationInfo = itemView.findViewById(R.id.decorationInfo);
        }
    }
}