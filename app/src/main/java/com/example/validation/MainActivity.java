 package com.example.validation;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

 public class MainActivity extends AppCompatActivity {

    EditText ename,econtact,epass;
    Button submit,get;
     String id,name,contact,pass;
     Mydb db = new Mydb(this);
     int pos=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        ename = findViewById(R.id.ename);
//        econtact = findViewById(R.id.econtact);
//        epass = findViewById(R.id.epass);
//        submit = findViewById(R.id.submit);
//        get = findViewById(R.id.get);
//
//        submit.setOnClickListener(v -> {
//            String name = ename.getText().toString();
//            String contact = econtact.getText().toString();
//            String pass = epass.getText().toString();
////            if(name.isEmpty())
////            {
////                ename.setError("enter yoir name");
////                ename.requestFocus();
////            }
////            else if(name.length()<6)
////            {
////                ename.setError("name length should be 6 character");
////                ename.requestFocus();
////            }
////            else if(contact.isEmpty())
////            {
////                econtact.setError("enter your contact");
////                econtact.requestFocus();
////            }
////            else if(contact.charAt(0)!='6')
////            {
////                econtact.setError("contact no should start form 6");
////                econtact.requestFocus();
////            }
////            else if(contact.length()!=10)
////            {
////                econtact.setError("contact no. should be 10 digit");
////                econtact.requestFocus();
////            }
////            else if(pass.isEmpty())
////            {
////                epass.setError("enter your pass");
////                epass.requestFocus();
////            }
//            System.out.println("name = "+name);
//            System.out.println("contact = "+contact);
//            System.out.println("pass = "+pass);
//
//            db.insertdata(name,contact,pass);
//        });
//        get.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
//                startActivity(intent);
//            }
//        });
        ename = findViewById(R.id.ename);
        econtact = findViewById(R.id.econtact);
        epass = findViewById(R.id.epass);
        submit = findViewById(R.id.submit);
        get = findViewById(R.id.get);

        pos=getIntent().getIntExtra("pos",0);
        if(pos==1)
        {
            id=getIntent().getStringExtra("id");
            name=getIntent().getStringExtra("name");
            contact=getIntent().getStringExtra("contact");
            pass=getIntent().getStringExtra("pass");

            ename.setText(name);
            econtact.setText(contact);
            epass.setText(pass);

        }
//        submit.setOnClickListener(v -> {
//            String name = ename.getText().toString();
//            String contact = econtact.getText().toString();
//            String pass = epass.getText().toString();
////            if(name.isEmpty())
////            {
////                ename.setError("enter yoir name");
////                ename.requestFocus();
////            }
////            else if(name.length()<6)
////            {
////                ename.setError("name length should be 6 character");
////                ename.requestFocus();
////            }
////            else if(contact.isEmpty())
////            {
////                econtact.setError("enter your contact");
////                econtact.requestFocus();
////            }
////            else if(contact.charAt(0)!='6')
////            {
////                econtact.setError("contact no should start form 6");
////                econtact.requestFocus();
////            }
////            else if(contact.length()!=10)
////            {
////                econtact.setError("contact no. should be 10 digit");
////                econtact.requestFocus();
////            }
////            else if(pass.isEmpty())
////            {
////                epass.setError("enter your pass");
////                epass.requestFocus();
////            }
//            System.out.println("name = "+name);
//            System.out.println("contact = "+contact);
//            System.out.println("pass = "+pass);
//
//        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                {
                    if(pos==1)
                    {
                        String name = ename.getText().toString();
                        String contact = econtact.getText().toString();
                        String pass = epass.getText().toString();
                        db.updatedata(id,name,contact,pass);
                        Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                        startActivity(intent);
                    }
                    else {
                        String name = ename.getText().toString();
                         String contact = econtact.getText().toString();
                         String pass = epass.getText().toString();
                        db.insertdata(name,contact,pass);
                    }
                }
            }
        });
        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        });

    }
}