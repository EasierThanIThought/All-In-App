package com.example.allin;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;


public class PlantInfoFragment extends DialogFragment {

    private ImageView plantImageView;
    private TextView nameTextView;
    private TextView descriptionTextView;
    private TextView temperatureTextView;
    private TextView lightTextView;
    private TextView waterTextView;
    private TextView difficultyTextView;

    private static final String ARG_IMAGE_DATA = "imageData";
    private static final String ARG_NAME = "name";
    private static final String ARG_DESCRIPTION = "description";
    private static final String ARG_TEMPERATURE = "temperature";
    private static final String ARG_LIGHT = "light";
    private static final String ARG_WATER = "water";
    private static final String ARG_DIFFICULTY = "difficulty";

    public static PlantInfoFragment newInstance(String imageData, String name, String description, String temperature, int light, int water, int difficulty) {
        PlantInfoFragment fragment = new PlantInfoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_IMAGE_DATA, imageData);
        args.putString(ARG_NAME, name);
        args.putString(ARG_DESCRIPTION, description);
        args.putString(ARG_TEMPERATURE, temperature);
        args.putInt(ARG_LIGHT, light);
        args.putInt(ARG_WATER, water);
        args.putInt(ARG_DIFFICULTY, difficulty);
        fragment.setArguments(args);
        return fragment;
    }

    public PlantInfoFragment() {
        // Required empty public constructor
    }

//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_plant_info, container, false);

        plantImageView = view.findViewById(R.id.plantImageView);
        nameTextView = view.findViewById(R.id.nameTextView);
        descriptionTextView = view.findViewById(R.id.descriptionTextView);
        temperatureTextView = view.findViewById(R.id.temperatureTextView);
        lightTextView = view.findViewById(R.id.lightTextView);
        waterTextView = view.findViewById(R.id.waterTextView);
        difficultyTextView = view.findViewById(R.id.difficultyTextView);

        if (getArguments() != null) {
            String photoPath = getArguments().getString(ARG_IMAGE_DATA);
            String name = getArguments().getString(ARG_NAME);
            String description = getArguments().getString(ARG_DESCRIPTION);
            String temperature = getArguments().getString(ARG_TEMPERATURE);
            int light = getArguments().getInt(ARG_LIGHT);
            int water = getArguments().getInt(ARG_WATER);
            int difficulty = getArguments().getInt(ARG_DIFFICULTY);

            Bitmap imageBitmap = decodeBase64(photoPath);
            plantImageView.setImageBitmap(imageBitmap);

            nameTextView.setText(name);
            descriptionTextView.setText(description);
            temperatureTextView.setText("Temperature: " + temperature);
            lightTextView.setText("Light: " + light);
            waterTextView.setText("Water: " + water);
            difficultyTextView.setText("Difficulty: " + difficulty);
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