package com.example.mydatabase;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;

public class MainActivity3 extends AppCompatActivity {
    DatabaseHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        getSupportActionBar().hide();
        mydb=new DatabaseHelper(this);
    }

    public void oni(View view) {
        Intent intent =new Intent(MainActivity3.this,MainActivity4.class);
        startActivity(intent);
    }

    public void ons(View view) {
        Intent intent =new Intent(MainActivity3.this,MainActivity2.class);
        startActivity(intent);
    }

    public void onu(View view) {
        Intent intent =new Intent(MainActivity3.this,MainActivity.class);
        startActivity(intent);
    }

    public void ond(View view) {
        Cursor res = mydb.getAllData();

        showMessage("No. of rows","Total records : "+res.getCount());
    }

    private void showMessage(String m, String message) {
        AlertDialog dig = new AlertDialog.Builder(MainActivity3.this)
                .setTitle(m)
                .setMessage(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .create();
        dig.show();
    }
}