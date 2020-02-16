package com.example.databasetest;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class MainActivity extends AppCompatActivity
{
    EditText srollnum,sname,smobile,semail;
    Spinner sp;
    Button submit;

    FirebaseStorage storage;
    StorageReference storageReference;
    FirebaseDatabase database;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        srollnum=findViewById(R.id.s_roll);
        sname=findViewById(R.id.s_name);
        sp=findViewById(R.id.sectionspinner);
        smobile=findViewById(R.id.s_mobile);
        semail=findViewById(R.id.s_email);
        storage=FirebaseStorage.getInstance();
        storageReference=storage.getReference();
        database=FirebaseDatabase.getInstance();
        reference=database.getReference();

        submit=findViewById(R.id.save);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String rollnum=srollnum.getText().toString();
                final String name=sname.getText().toString();
                final String section=sp.getSelectedItem().toString();
                final String mobilenum=smobile.getText().toString();
                final String email=semail.getText().toString();
                if (rollnum.isEmpty()||name.isEmpty()||mobilenum.isEmpty()||email.isEmpty()){
                    Toast.makeText(MainActivity.this, "please fill the fields", Toast.LENGTH_SHORT).show();
                }else {
                    Student s = new Student(rollnum, name, mobilenum, section,email);
                    reference.child("students").child(section).push().setValue(s);
                    Toast.makeText(MainActivity.this, "saved success", Toast.LENGTH_SHORT).show();
                    srollnum.setText("");
                    sname.setText("");
                    smobile.setText("");
                    semail.setText("");

                }


            }
        });

    }


}
