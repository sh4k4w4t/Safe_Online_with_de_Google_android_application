package com.alivepython.safeonline;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    NavigationView navigationView;
    DrawerLayout drawerLayout;
    Toolbar toolbar;

    ArrayList<HomeItemGridPojo> arrayList;
    RecyclerView recyclerView;
    HomeItemAdapter homeItem_adapter;

    ViewFlipper flipper;

    TextView id1, id2;
    AlertDialog.Builder builder;
    ViewGroup viewGroup;
    View dialogView;
    AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Safe & Secure Online World");
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        navigationView = findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener((NavigationView.OnNavigationItemSelectedListener) this);

        gridListData();
        recyclerView = findViewById(R.id.home_item_recyclerView);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(HomeActivity.this, 2);
        gridLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManager);

        homeItem_adapter = new HomeItemAdapter(HomeActivity.this, arrayList);
        recyclerView.setAdapter(homeItem_adapter);

        //this section for image slider
        int[] imgArray = {R.drawable.header_image_1, R.drawable.header_image_2};
        flipper = findViewById(R.id.viewFlipperID);
        for (int j : imgArray) {
            showImage(j);
        }
    }

    private void gridListData() {
        arrayList = new ArrayList<>();
        arrayList.add(new HomeItemGridPojo("Search Engine", R.drawable.ic_baseline_search_50));
        arrayList.add(new HomeItemGridPojo("Email", R.drawable.ic_baseline_email_24));
        arrayList.add(new HomeItemGridPojo("Drive", R.drawable.ic_baseline_add_to_drive_24));
        arrayList.add(new HomeItemGridPojo("OS", R.drawable.ic_baseline_settings_system_daydream_24));
        arrayList.add(new HomeItemGridPojo("Social Site", R.drawable.ic_baseline_comment_24));
        arrayList.add(new HomeItemGridPojo("Calender", R.drawable.ic_baseline_calendar_month_24));
        arrayList.add(new HomeItemGridPojo("Chat Apps", R.drawable.ic_baseline_voice_chat_24));
        arrayList.add(new HomeItemGridPojo("Map", R.drawable.ic_baseline_map_24));
        arrayList.add(new HomeItemGridPojo("Browser", R.drawable.ic_baseline_broadcast_on_personal_24));
        arrayList.add(new HomeItemGridPojo("Remote Client", R.drawable.ic_baseline_settings_remote_24));
        arrayList.add(new HomeItemGridPojo("Host", R.drawable.ic_baseline_archive_24));
    }

    public void showImage(int img) {
        ImageView imageView = new ImageView(getApplicationContext());
        imageView.setBackgroundResource(img);

        flipper.addView(imageView);
        flipper.setFlipInterval(3000);
        flipper.setAutoStart(true);

        flipper.setInAnimation(getApplicationContext(), android.R.anim.slide_in_left);
        flipper.setOutAnimation(getApplicationContext(), android.R.anim.slide_out_right);
    }


    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:
                recreate();
                break;

            default:
                Toast.makeText(getApplicationContext(), "This Section Still Working...", Toast.LENGTH_SHORT).show();
                break;

            case R.id.nav_why_de_google:
                passTitleAndDescription("tahsin", "Great Point");
                break;

            case R.id.nav_faq:
                Toast.makeText(getApplicationContext(), "This Section Still Working...", Toast.LENGTH_SHORT).show();
                break;

            case R.id.nav_feedback:
                startActivity(new Intent(getApplicationContext(), Feedback_activity.class));
                break;

            case R.id.nav_Developer_information:
                passTitleAndDescription("tahsin", "Great Point");
                break;

            case R.id.nav_follow_me:
                startActivity(new Intent(getApplicationContext(), Follow_me.class));
                break;


        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }


    private void passTitleAndDescription(String title, String description) {
        builder = new AlertDialog.Builder(this);
        viewGroup = findViewById(android.R.id.content);
        dialogView = LayoutInflater.from(this).inflate(R.layout.custom_layout_for_title_info, viewGroup, false);
        id1 = dialogView.findViewById(R.id.titleId);
        id2 = dialogView.findViewById(R.id.descriptionId);
        id1.setText(title);
        id2.setText(description);
        builder.setView(dialogView);
        alertDialog = builder.create();
        alertDialog.show();
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage("Do you want to exit?");
        builder.setPositiveButton("Yes", (dialog, which) -> {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        });
        builder.setNegativeButton("No", (dialog, which) -> dialog.cancel());
        AlertDialog alert = builder.create();
        alert.show();
    }
}