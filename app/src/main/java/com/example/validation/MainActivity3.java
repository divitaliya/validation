package com.example.validation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity3 extends AppCompatActivity {

    EditText up_name,up_contact,up_pass;
    Button up_submit;
    String id,name,contact,pass;
    Mydb db = new Mydb(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        up_name = findViewById(R.id.up_name);
        up_contact = findViewById(R.id.up_contact);
        up_pass = findViewById(R.id.up_pass);
        up_submit = findViewById(R.id.up_submit);

        id=getIntent().getStringExtra("id");
        name=getIntent().getStringExtra("name");
        contact=getIntent().getStringExtra("contact");
        pass=getIntent().getStringExtra("pass");

        up_name.setText(name);
        up_contact.setText(contact);
        up_pass.setText(pass);

        up_submit.setOnClickListener(v -> {
            String name = up_name.getText().toString();
            String contact = up_contact.getText().toString();
            String pass = up_pass.getText().toString();

            db.updatedata(id,name,contact,pass);
            Intent intent = new Intent(MainActivity3.this,MainActivity2.class);
            startActivity(intent);
        });
    }
}