package com.alivepython.safeonline.homeItem.social_site;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.alivepython.safeonline.HomeActivity;
import com.alivepython.safeonline.HomeItemGridPojo;
import com.alivepython.safeonline.R;
import com.alivepython.safeonline.homeItem.search_engine.SearchEngineAdapter;
import com.alivepython.safeonline.homeItem.search_engine.Search_engine;

import java.util.ArrayList;
import java.util.Objects;

public class SocialSiteActivity extends AppCompatActivity {
    ArrayList<HomeItemGridPojo> arrayList;
    RecyclerView recyclerView;
    SocialSiteAdapter homeItem_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_social_site);
        this.setTitle("Best Social Site");

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        gridListData();
        recyclerView = findViewById(R.id.home_item_recyclerView);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 3);
        gridLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManager);

        homeItem_adapter = new SocialSiteAdapter(getApplicationContext(), arrayList);
        recyclerView.setAdapter(homeItem_adapter);



    }

    private void gridListData() {
        arrayList = new ArrayList<>();
        arrayList.add(new HomeItemGridPojo("Mastodon", R.drawable.test_image));
        arrayList.add(new HomeItemGridPojo("Reddit", R.drawable.test_image));
        arrayList.add(new HomeItemGridPojo("Linkedin", R.drawable.test_image));
        arrayList.add(new HomeItemGridPojo("Keybase", R.drawable.test_image));
        arrayList.add(new HomeItemGridPojo("twitter", R.drawable.test_image));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
            startActivity(new Intent(getApplicationContext(), HomeActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), HomeActivity.class));
        super.onBackPressed();
    }

}