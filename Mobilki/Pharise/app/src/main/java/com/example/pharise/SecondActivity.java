package com.example.pharise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }
    public void startNewActivity(View v) {
        Intent intent = new Intent(this,FifthActivity.class);
        startActivity(intent);
    }

    public void goBack(View v) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);

    }
}