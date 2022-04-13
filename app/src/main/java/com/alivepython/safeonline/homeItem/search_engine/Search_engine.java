package com.alivepython.safeonline.homeItem.search_engine;

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

import java.util.ArrayList;
import java.util.Objects;

public class Search_engine extends AppCompatActivity {

    ArrayList<HomeItemGridPojo> arrayList;
    RecyclerView recyclerView;
    SearchEngineAdapter homeItem_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_search_engine);
        this.setTitle("Best Search Engine");

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        gridListData();
        recyclerView = findViewById(R.id.home_item_recyclerView);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(Search_engine.this, 3);
        gridLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManager);

        homeItem_adapter = new SearchEngineAdapter(Search_engine.this, arrayList);
        recyclerView.setAdapter(homeItem_adapter);



    }

    private void gridListData() {
        arrayList = new ArrayList<>();
        arrayList.add(new HomeItemGridPojo("DuckDuckGo", R.drawable.test_image));
        arrayList.add(new HomeItemGridPojo("Searx.me", R.drawable.test_image));
        arrayList.add(new HomeItemGridPojo("Ecosia", R.drawable.test_image));
        arrayList.add(new HomeItemGridPojo("StartPage", R.drawable.test_image));
        arrayList.add(new HomeItemGridPojo("Qwant", R.drawable.test_image));
        arrayList.add(new HomeItemGridPojo("Yandex", R.drawable.test_image));
        arrayList.add(new HomeItemGridPojo("DocFile", R.drawable.test_image));
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