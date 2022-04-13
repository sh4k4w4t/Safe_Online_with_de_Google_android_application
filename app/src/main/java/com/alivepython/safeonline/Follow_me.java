package com.alivepython.safeonline;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import java.util.Objects;

public class Follow_me extends AppCompatActivity implements View.OnClickListener{
    CardView facebook, twitter, mail_us;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_follow_me);
        this.setTitle("Follow Us");
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        facebook = findViewById(R.id.follow_us_facebook_id);
        twitter = findViewById(R.id.follow_us_twitter_id);
        mail_us = findViewById(R.id.follow_us_mail_us_id);


        facebook.setOnClickListener(this);
        mail_us.setOnClickListener(this);
        twitter.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.follow_us_twitter_id) {
            String full_address = getResources().getString(R.string.twitter_url);
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(full_address));
            startActivity(i);
        }

        if (v.getId() == R.id.follow_us_facebook_id) {
            String full_address = getResources().getString(R.string.facebook_url);
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(full_address));
            startActivity(i);
        }

        if (v.getId() == R.id.follow_us_mail_us_id) {
            Intent mailIntent = new Intent(Intent.ACTION_VIEW);
            Uri data = Uri.parse("mailto:?to=" + getResources().getString(R.string.email_me));
            mailIntent.setData(data);
            startActivity(Intent.createChooser(mailIntent, "Send mail...."));
        }

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