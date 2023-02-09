package com.example.validation;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    ArrayList id,name,contact,pass;
    Mydb db = new Mydb(this);
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        listView = findViewById(R.id.list);
        id = new ArrayList();
        name = new ArrayList();
        contact = new ArrayList();
        pass = new ArrayList();
        Cursor c = db.getdata();

            while (c.moveToNext())
            {
                id.add(c.getInt(0));
                name.add(c.getString(1));
                contact.add(c.getString(2));
                pass.add(c.getString(3));
            }
            System.out.println("id="+id);
            System.out.println("name="+name);
            System.out.println("contact="+contact);
            System.out.println("pass="+pass);
        MainActivity2_adapter mainActivity2_adapter = new MainActivity2_adapter(this,id,name,contact,pass);
        listView.setAdapter(mainActivity2_adapter);
        };
}