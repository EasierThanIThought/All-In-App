package com.example.allin;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class WorkshopInfoFragment extends DialogFragment {

    private ImageView workshopImageView;
    private TextView nameTextView;
    private TextView materialsTextView;
    private TextView descriptionTextView;
    private TextView timeTextView;
    private TextView priceTextView;

    private static final String ARG_IMAGE_DATA = "imageData";
    private static final String ARG_NAME = "name";
    private static final String ARG_MATERIALS = "materials";
    private static final String ARG_DESCRIPTION = "description";
    private static final String ARG_TIME = "time";
    private static final String ARG_PRICE = "price";

    public WorkshopInfoFragment() {}

    public static WorkshopInfoFragment newInstance(String imageData, String name, String materials, String description, int time, int price) {
        WorkshopInfoFragment fragment = new WorkshopInfoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_IMAGE_DATA, imageData);
        args.putString(ARG_NAME, name);
        args.putString(ARG_MATERIALS, materials);
        args.putString(ARG_DESCRIPTION, description);
        args.putInt(ARG_TIME, time);
        args.putInt(ARG_PRICE, price);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_workshop_info, container, false);

        workshopImageView = view.findViewById(R.id.workshopImageView);
        nameTextView = view.findViewById(R.id.nameTextView);
        materialsTextView = view.findViewById(R.id.materialsTextView);
        descriptionTextView = view.findViewById(R.id.descriptionTextView);
        timeTextView = view.findViewById(R.id.timeTextView);
        priceTextView = view.findViewById(R.id.priceTextView);

        if (getArguments() != null) {
            String photoPath = getArguments().getString(ARG_IMAGE_DATA);
            String name = getArguments().getString(ARG_NAME);
            String materials = getArguments().getString(ARG_MATERIALS);
            String description = getArguments().getString(ARG_DESCRIPTION);
            int time = getArguments().getInt(ARG_TIME);
            int price = getArguments().getInt(ARG_PRICE);

            Bitmap imageBitmap = decodeBase64(photoPath);
            workshopImageView.setImageBitmap(imageBitmap);

            nameTextView.setText(name);
            descriptionTextView.setText(description);
            materialsTextView.setText("Materials:\n" + materials);

            timeTextView.setText("Duration: " + time + "H");
            priceTextView.setText("Price: " + price + "PLN");
        }

        return view;
    }

    private Bitmap decodeBase64(String input) {
        byte[] decodedBytes = Base64.decode(input, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.length);
    }

    @Override
    public void onStart() {
        super.onStart();
        if (getDialog() != null && getDialog().getWindow() != null) {
            getDialog().getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }
    }
}