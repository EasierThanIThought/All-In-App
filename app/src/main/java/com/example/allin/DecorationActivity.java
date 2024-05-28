package com.example.allin;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager2.widget.ViewPager2;

import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.allin.models.DBHelper;
import com.example.allin.models.Decoration;
import com.example.allin.models.DecorationAdapter;
import com.example.allin.models.MainPicture;
import com.example.allin.models.MainPictureAdapter;

import java.util.ArrayList;
import java.util.List;

public class DecorationActivity extends AppCompatActivity {


    DrawerLayout drawerLayout;
    ImageView menu;
    LinearLayout home, plants, pets, decor, workshop;
    private DBHelper dbHelper;
    private TextView decorationName, decorationDescription;
    private ImageView photoImageView;
    private VideoView videoView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_decoration);

//        dbHelper = new DBHelper(this);
//        decorationName = findViewById(R.id.decorationName);
//        decorationDescription = findViewById(R.id.decorationDescription);
//        photoImageView = findViewById(R.id.photoImageView);
//        videoView = findViewById(R.id.videoView);
//        List<Decoration> decorations = dbHelper.getAllDecorations();
//        if (!decorations.isEmpty()) {
//            Decoration decoration = decorations.get(0);
//
//            decorationName.setText(decoration.getName());
//            decorationDescription.setText(decoration.getDescription());
//
//
//            Bitmap imageBitmap = decodeBase64(decoration.getImageData());
//            photoImageView.setImageBitmap(imageBitmap);
//
//
//            Uri videoUri = Uri.parse(decoration.getVideoData());
//            videoView.setVideoURI(videoUri);
//            videoView.setMediaController(new MediaController(this));
//            videoView.requestFocus();
//            videoView.start();
//        }

        ViewPager2 viewPager2 = findViewById(R.id.viewPager);
        List<Decoration> decorationList = new ArrayList<>();

        dbHelper = new DBHelper(this);

        decorationList = dbHelper.getAllDecorations();
        DecorationAdapter adapter = new DecorationAdapter(this, decorationList);
        viewPager2.setAdapter(adapter);

        List<Decoration> finalDecorationList = decorationList;

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                if (position == finalDecorationList.size()) {
                    viewPager2.setCurrentItem(0, true);
                }
            }
        });


        View rootView = findViewById(R.id.drawerLayout);

        Window window = getWindow();
        window.setStatusBarColor(getResources().getColor(R.color.primary_variant_light));
        window.setNavigationBarColor(getResources().getColor(R.color.background_light));

        ViewCompat.setOnApplyWindowInsetsListener(rootView, new androidx.core.view.OnApplyWindowInsetsListener() {
            @Override
            public WindowInsetsCompat onApplyWindowInsets(View v, WindowInsetsCompat insets) {
                int statusBarHeight = insets.getInsets(WindowInsetsCompat.Type.systemBars()).top;
                int navigationBarHeight = insets.getInsets(WindowInsetsCompat.Type.systemBars()).bottom;

                ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) v.getLayoutParams();
                layoutParams.topMargin = statusBarHeight;
                layoutParams.bottomMargin = navigationBarHeight;
                v.setLayoutParams(layoutParams);

                return insets;
            }
        });

        drawerLayout = findViewById(R.id.drawerLayout);
        menu = findViewById(R.id.menu);
        home = findViewById(R.id.home);
        plants = findViewById(R.id.plants);
        pets = findViewById(R.id.pets);
        decor = findViewById(R.id.decoration);
        workshop = findViewById(R.id.workshop);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDrawer(drawerLayout);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(DecorationActivity.this, MainActivity.class);
            }
        });

        plants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(DecorationActivity.this, PlantsActivity.class);
            }
        });

        pets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(DecorationActivity.this, PetsActivity.class);
            }
        });

        decor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recreate();
            }
        });

        workshop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(DecorationActivity.this, WorkshopActivity.class);
            }
        });

    }

    public static void openDrawer(DrawerLayout drawerLayout) {
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public static void closeDrawer(DrawerLayout drawerLayout) {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    public static void redirectActivity(Activity activity, Class secondActivity) {
        Intent intent = new Intent(activity, secondActivity);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
        activity.overridePendingTransition(0, 0);
        activity.finish();
    }

    @Override
    protected void onPause() {
        super.onPause();
        closeDrawer(drawerLayout);
    }

    public static Bitmap decodeBase64(String image) {
        if (image == null) return null;
        byte[] decodedByte = Base64.decode(image, 0);
        return BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.length);
    }

}