package com.example.mydatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity4 extends AppCompatActivity {

    DatabaseHelper mydb;
    EditText e_id,e_name,s_name,e_marks,e_cnic,e_bg,e_address;
    Button btnviewUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

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
    }

    public void onclic(View view) {
        boolean isinserted=mydb.insertData(e_name.getText().toString(),s_name.getText().toString(),e_marks.getText().toString(),e_cnic.getText().toString(),e_bg.getText().toString(),e_address.getText().toString());

        if(isinserted==true)
            Toast.makeText(this,"Data inserted",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this,"Data not inserted",Toast.LENGTH_LONG).show();
    }
}