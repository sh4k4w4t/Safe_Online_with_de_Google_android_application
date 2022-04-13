package com.alivepython.safeonline.homeItem.calender;

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

public class CalenderActivity extends AppCompatActivity {
    ArrayList<HomeItemGridPojo> arrayList;
    RecyclerView recyclerView;
    CalenderAdapter item_adapter;

    TextView id1, id2;
    AlertDialog.Builder builder;
    ViewGroup viewGroup;
    View dialogView;
    AlertDialog alertDialog;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_calender);
        this.setTitle("Best Calender Options");

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        gridListData();
        recyclerView = findViewById(R.id.home_item_recyclerView);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(CalenderActivity.this, 3);
        gridLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManager);

        item_adapter = new CalenderAdapter(CalenderActivity.this, arrayList);
        recyclerView.setAdapter(item_adapter);



    }

    private void gridListData() {
        arrayList = new ArrayList<>();
        arrayList.add(new HomeItemGridPojo("Tutanota", R.drawable.test_image));
        arrayList.add(new HomeItemGridPojo("Outlook", R.drawable.test_image));
        arrayList.add(new HomeItemGridPojo("Proton", R.drawable.test_image));
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

    private void passTitleAndDescription(String title, String description) {
        builder = new AlertDialog.Builder(this);
        viewGroup = findViewById(android.R.id.content);
        dialogView = LayoutInflater.from(this).inflate(R.layout.custom_layout_for_item_with_button, viewGroup, false);
        id1 = dialogView.findViewById(R.id.titleId);
        id2 = dialogView.findViewById(R.id.descriptionId);
        btn= dialogView.findViewById(R.id.website_button);
        id1.setText(title);
        id2.setText(description);
        builder.setView(dialogView);
        alertDialog = builder.create();
        alertDialog.show();
    }

}