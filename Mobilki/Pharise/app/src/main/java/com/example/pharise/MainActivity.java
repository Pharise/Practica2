package com.example.pharise;



import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class  MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btnAdd;
    EditText etEmail, etPassword;


    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);

        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);

        dbHelper = new DBHelper(this);
    }

    @Override
    public void onClick(View v) {
       String email = etEmail.getText().toString();
       String password = etPassword.getText().toString();

        SQLiteDatabase database = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        if(v.getId()==R.id.btnAdd) {
            contentValues.put(DBHelper.KEY_PASSWORD, password);
            contentValues.put(DBHelper.KEY_MAIL, email);

            database.insert(DBHelper.TABLE_CONTACTS, null, contentValues);
        }



        if(v.getId()==R.id.btnAdd){
                Cursor cursor = database.query(DBHelper.TABLE_CONTACTS, null, null, null, null, null, null);
                    if (cursor.moveToFirst()) {
                        int idIndex = cursor.getColumnIndex(DBHelper.KEY_ID);
                        int passwordIndex = cursor.getColumnIndex(DBHelper.KEY_PASSWORD);
                        int emailIndex = cursor.getColumnIndex(DBHelper.KEY_MAIL);
                            do {
                                Log.d("mLog", "ID = " + cursor.getInt(idIndex) +
                                        ", password = " + cursor.getString(passwordIndex) +
                                        ", email = " + cursor.getString(emailIndex));
                            } while (cursor.moveToNext());

                    } else
                        Log.d("mLog","0 rows");

                cursor.close();
                return ;





        }
        dbHelper.close();
    }
}
