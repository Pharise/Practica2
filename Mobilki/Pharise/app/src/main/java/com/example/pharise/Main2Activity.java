package com.example.pharise;

import android.content.Intent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Main2Activity extends AppCompatActivity {

    public void fot(View v) {
        Intent intent = new Intent(this, FifthActivity.class);
        startActivity(intent);
    }


}
