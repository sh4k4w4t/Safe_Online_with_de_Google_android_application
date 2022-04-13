package com.alivepython.safeonline.homeItem.email;

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

public class EmailActivity extends AppCompatActivity {
    ArrayList<HomeItemGridPojo> arrayList;
    RecyclerView recyclerView;
    EmailAdapter item_adapter;

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
        setContentView(R.layout.activity_email);
        this.setTitle("Best Email Options");

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        gridListData();
        recyclerView = findViewById(R.id.home_item_recyclerView);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(EmailActivity.this, 3);
        gridLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManager);

        item_adapter = new EmailAdapter(EmailActivity.this, arrayList);
        recyclerView.setAdapter(item_adapter);

    }

    private void gridListData() {
        arrayList = new ArrayList<>();
        arrayList.add(new HomeItemGridPojo("Yaani Mail", R.drawable.test_image));
        arrayList.add(new HomeItemGridPojo("Tutanota", R.drawable.test_image));
        arrayList.add(new HomeItemGridPojo("Yandex", R.drawable.test_image));
        arrayList.add(new HomeItemGridPojo("Protonmail", R.drawable.test_image));
        arrayList.add(new HomeItemGridPojo("cTemplar", R.drawable.test_image));
        arrayList.add(new HomeItemGridPojo("Aol", R.drawable.test_image));
        arrayList.add(new HomeItemGridPojo("GMX", R.drawable.test_image));
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