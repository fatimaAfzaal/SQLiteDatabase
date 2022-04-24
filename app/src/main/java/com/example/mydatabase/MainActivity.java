package com.example.mydatabase;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper mydb;
    EditText e_id,e_name,s_name,e_marks,e_cnic,e_bg,e_address;
    Button btnviewUpdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        mydb=new DatabaseHelper(this);

        e_id=(EditText) findViewById(R.id.editTextId);
        e_name=(EditText) findViewById(R.id.editTextTextPersonName);
        s_name=(EditText) findViewById(R.id.editTextTextEmailAddress);
        e_marks=(EditText) findViewById(R.id.editTextPhone);
        e_cnic=(EditText) findViewById(R.id.editTextcnic);
        e_bg=(EditText) findViewById(R.id.editTextbg);
        e_address=(EditText) findViewById(R.id.editTextAddress);
        btnviewUpdate=(Button) findViewById(R.id.buttonupdate);

        btnviewUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isUpdate= mydb.updateData(e_id.getText().toString(),e_name.getText().toString(),s_name.getText().toString(),e_marks.getText().toString(),e_cnic.getText().toString(),e_bg.getText().toString(),e_address.getText().toString());
                if(isUpdate==true)
                {
                    Toast.makeText(MainActivity.this, "Data Update", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(MainActivity.this, "Data not updated", Toast.LENGTH_SHORT).show();
            }
        });
    }


    public void oncl(View view) {
        Intent intent=new Intent(MainActivity.this,MainActivity2.class);
        startActivity(intent);
    }

}