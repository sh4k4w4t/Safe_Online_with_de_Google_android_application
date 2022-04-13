package com.alivepython.safeonline;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import java.util.Objects;

public class Feedback_activity extends AppCompatActivity implements View.OnClickListener{

    Button sendButton, clearButton;
    EditText nameText, messageText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_feedback);
        this.setTitle("Send Your Feedback");

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        sendButton = findViewById(R.id.feedback_send_Id);
        clearButton = findViewById(R.id.feedback_clear_Id);
        nameText = findViewById(R.id.feedback_Name_Id);
        messageText = findViewById(R.id.feedback_message_Id);

        sendButton.setOnClickListener(this);
        clearButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String name = nameText.getText().toString();
        String message = messageText.getText().toString();

        String name_test = name.trim();
        String message_test = message.trim();

        if (TextUtils.isEmpty(name_test) || TextUtils.isEmpty(message_test)) {
            if (TextUtils.isEmpty(name_test)) {
                nameText.setError("please fill out this field");
            }
            if (TextUtils.isEmpty(message_test)) {
                messageText.setError("please fill out this field");
            }
        } else {
            if (v.getId() == R.id.feedback_send_Id) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/email");
                i.putExtra(Intent.EXTRA_EMAIL, new String[]{"md.shakawat.hossain@yandex.com"});
                //also can use more one email with this array
                i.putExtra(Intent.EXTRA_SUBJECT, "Feedback from de-Google Apps");
                i.putExtra(Intent.EXTRA_TEXT, "Name: " + name + "\nMessage: " + message);
                startActivity(Intent.createChooser(i, "Feedback with"));
            }
            if (v.getId() == R.id.feedback_clear_Id) {
                nameText.setText("");
                messageText.setText("");
            }
        }
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), HomeActivity.class));
        super.onBackPressed();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
            startActivity(new Intent(getApplicationContext(), HomeActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

}