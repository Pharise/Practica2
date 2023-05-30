package com.example.pharise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SixthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixth);
    }
    public void goBeack(View v) {
        Intent intent = new Intent(this,Main2Activity.class);
        startActivity(intent);
    }
    public void goMBack(View v) {
        Intent intent = new Intent(this,FifthActivity.class);
        startActivity(intent);
    }
}