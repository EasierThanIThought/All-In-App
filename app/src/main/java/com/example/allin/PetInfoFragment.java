package com.example.allin;

import android.os.Bundle;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

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


public class PetInfoFragment extends DialogFragment {

    private ImageView petImageView;
    private TextView nameTextView;
    private TextView descriptionTextView;
    private TextView furTextView;
    private TextView breedTextView;
    private TextView ageTextView;

    private static final String ARG_IMAGE_DATA = "imageData";
    private static final String ARG_NAME = "name";
    private static final String ARG_DESCRIPTION = "description";
    private static final String ARG_FUR = "fur";
    private static final String ARG_BREED = "breed";
    private static final String ARG_AGE = "age";

    public PetInfoFragment() {
        // Required empty public constructor
    }

    public static PetInfoFragment newInstance(String imageData, String name, String description, String fur, String breed, int age) {
        PetInfoFragment fragment = new PetInfoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_IMAGE_DATA, imageData);
        args.putString(ARG_NAME, name);
        args.putString(ARG_DESCRIPTION, description);
        args.putString(ARG_FUR, fur);
        args.putString(ARG_BREED, breed);
        args.putInt(ARG_AGE, age);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_pet_info, container, false);

        petImageView = view.findViewById(R.id.petImageView);
        nameTextView = view.findViewById(R.id.nameTextView);
        descriptionTextView = view.findViewById(R.id.descriptionTextView);
        furTextView = view.findViewById(R.id.furTextView);
        breedTextView = view.findViewById(R.id.breedTextView);
        ageTextView = view.findViewById(R.id.ageTextView);

        if (getArguments() != null) {
            String photoPath = getArguments().getString(ARG_IMAGE_DATA);
            String name = getArguments().getString(ARG_NAME);
            String description = getArguments().getString(ARG_DESCRIPTION);
            String fur = getArguments().getString(ARG_FUR);
            String breed = getArguments().getString(ARG_BREED);
            int age = getArguments().getInt(ARG_AGE);

            Bitmap imageBitmap = decodeBase64(photoPath);
            petImageView.setImageBitmap(imageBitmap);

            nameTextView.setText(name);
            descriptionTextView.setText(description);
            furTextView.setText("Fur: " + fur);
            breedTextView.setText("Breed: " + breed);
            ageTextView.setText("Age: " + age);
        }

        return view;
    }

    private Bitmap decodeBase64(String input) {
        byte[] decodedBytes = Base64.decode(input, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.length);
    }
}