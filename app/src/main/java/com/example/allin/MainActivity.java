package com.example.allin;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.allin.models.DBHelper;
import com.example.allin.models.Plant;

import java.io.ByteArrayOutputStream;


public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ImageView menu;
    LinearLayout home, plants, pets, decor, workshop;
    DBHelper dbHelper;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        View rootView = findViewById(R.id.drawerLayout);

        Window window = getWindow();
        window.setStatusBarColor(getResources().getColor(R.color.light_green));
        window.setNavigationBarColor(getResources().getColor(R.color.white));
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

        dbHelper = new DBHelper(this);

        insertSampleData();

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
                recreate();
                overridePendingTransition(0, 0);
            }
        });

        plants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(MainActivity.this, PlantsActivity.class);
            }
        });

        pets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(MainActivity.this, PetsActivity.class);
            }
        });

        decor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(MainActivity.this, DecorationActivity.class);
            }
        });

        workshop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(MainActivity.this, WorkshopActivity.class);
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

    private void insertSampleData() {
        Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.plant1);
        String plant1Base64 = encodeToBase64(bitmap1);

        Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.plant2);
        String plant2Base64 = encodeToBase64(bitmap2);

        dbHelper.insertPlant(new Plant(1, plant1Base64, "Chlorophytum", "Loved one", "18-24°C", 4, 4, 1));
        dbHelper.insertPlant(new Plant(2, plant2Base64, "Senecio stapeliaeformis", "Pickle Plant", "12-25°C", 5, 1, 1));
        dbHelper.insertPlant(new Plant(3, encodeToBase64(BitmapFactory.decodeResource(getResources(), R.drawable.plant3)), "Peperomia dolabriformis", "Prayer Pepper", "12-25°C", 5, 4, 1));
        dbHelper.insertPlant(new Plant(4, encodeToBase64(BitmapFactory.decodeResource(getResources(), R.drawable.plant4)), "Callisia repens", "Creeping Inchplant", "12-25°C", 5, 1, 1));
        dbHelper.insertPlant(new Plant(5, encodeToBase64(BitmapFactory.decodeResource(getResources(), R.drawable.plant5)), "Kalanchoe tomentosa", "Pussy Ears", "12-25°C", 5, 4, 1));

    }

    private String encodeToBase64(Bitmap image) {
        if (image == null) return null;

        Bitmap resizedImage = Bitmap.createScaledBitmap(image, 800, 800, true);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        resizedImage.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        return Base64.encodeToString(byteArray, Base64.DEFAULT);
    }


}