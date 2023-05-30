package com.example.pharise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FifthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);
    }
    public void goBack(View v) {
        Intent intent = new Intent(this,Main2Activity.class);
        startActivity(intent);

    }
    public void startNewActivity(View v) {
        Intent intent = new Intent(this,ThirdActivity.class);
        startActivity(intent);
    }
    public void startSecondActivity(View v) {
        Intent intent = new Intent(this,FourthActivity.class);
        startActivity(intent);
    }
    public void startThirdActivity(View v) {
        Intent intent = new Intent(this,SixthActivity.class);
        startActivity(intent);
    }
}