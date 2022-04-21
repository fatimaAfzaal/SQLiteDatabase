package com.example.mydatabase;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper mydb;
    EditText e_name,s_name,e_marks,e_cnic,e_bg,e_address;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mydb=new DatabaseHelper(this);

        e_name=(EditText) findViewById(R.id.editTextTextPersonName);
        s_name=(EditText) findViewById(R.id.editTextTextEmailAddress);
        e_marks=(EditText) findViewById(R.id.editTextPhone);
        e_cnic=(EditText) findViewById(R.id.editTextcnic);
        e_bg=(EditText) findViewById(R.id.editTextbg);
        e_address=(EditText) findViewById(R.id.editTextAddress);
    }

    public void onc(View view) {
        boolean isinserted=mydb.insertData(e_name.getText().toString(),s_name.getText().toString(),e_marks.getText().toString(),e_cnic.getText().toString(),e_bg.getText().toString(),e_address.getText().toString());

        if(isinserted==true)
            Toast.makeText(this,"Data inserted",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this,"Data not inserted",Toast.LENGTH_LONG).show();
    }

    public void oncl(View view) {
        Cursor res=mydb.getAllData();
        if(res.getCount() == 0)
        {
            showMessage("Error!!!", "Nothing found");
            return;
        }
        StringBuffer buffer=new StringBuffer();
        while (res.moveToNext()){
            buffer.append("ID : "+res.getString(0)+"\n");
            buffer.append("Name : "+res.getString(1)+"\n");
            buffer.append("Surname : "+res.getString(2)+"\n");
            buffer.append("MARKS : "+res.getString(3)+"\n");
            buffer.append("CNIC : "+res.getString(4)+"\n");
            buffer.append("Blood Group : "+res.getString(5)+"\n");
            buffer.append("Address : "+res.getString(6)+"\n\n");
        }
        showMessage("Data", buffer.toString());
    }

    private  void showMessage(String m,String message)
    {
        AlertDialog dig=new AlertDialog.Builder(MainActivity.this)
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