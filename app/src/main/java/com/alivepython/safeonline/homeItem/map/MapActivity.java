package com.alivepython.safeonline.homeItem.map;

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
import com.alivepython.safeonline.homeItem.browser.BrowserActivity;
import com.alivepython.safeonline.homeItem.browser.BrowserAdapter;

import java.util.ArrayList;
import java.util.Objects;

public class MapActivity extends AppCompatActivity {
    ArrayList<HomeItemGridPojo> arrayList;
    RecyclerView recyclerView;
    MapAdapter item_adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_map);
        this.setTitle("Best Map Option");

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        gridListData();
        recyclerView = findViewById(R.id.home_item_recyclerView);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(MapActivity.this, 3);
        gridLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManager);

        item_adapter = new MapAdapter(MapActivity.this, arrayList);
        recyclerView.setAdapter(item_adapter);



    }

    private void gridListData() {
        arrayList = new ArrayList<>();
        arrayList.add(new HomeItemGridPojo("Maps.me", R.drawable.test_image));
        arrayList.add(new HomeItemGridPojo("Bing Maps", R.drawable.test_image));
        arrayList.add(new HomeItemGridPojo("Waze", R.drawable.test_image));
        arrayList.add(new HomeItemGridPojo("OsMand", R.drawable.test_image));
        arrayList.add(new HomeItemGridPojo("Here WeGo", R.drawable.test_image));
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