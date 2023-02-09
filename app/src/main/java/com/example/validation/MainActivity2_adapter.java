package com.example.validation;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity2_adapter extends BaseAdapter {
    MainActivity2 mainActivity2;
    ArrayList id,name,contact,pass;
    int a=0;

    public MainActivity2_adapter(MainActivity2 mainActivity2, ArrayList id, ArrayList name, ArrayList contact, ArrayList pass) {
    this.mainActivity2=mainActivity2;
    this.id=id;
    this.name=name;
    this.contact=contact;
    this.pass=pass;
    }

    @Override
    public int getCount() {
        return id.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(mainActivity2).inflate(R.layout.mainactivity2_item,parent,false);

        TextView textView1 = convertView.findViewById(R.id.text1);
        TextView textView2 = convertView.findViewById(R.id.text2);
        TextView textView3 = convertView.findViewById(R.id.text3);
        TextView textView4 = convertView.findViewById(R.id.text4);

        textView1.setText(id.get(position).toString());
        textView2.setText(name.get(position).toString());
        textView3.setText(contact.get(position).toString());
        textView4.setText(pass.get(position).toString());

        Mydb db = new Mydb(mainActivity2);

        Button delete,update;

        delete = convertView.findViewById(R.id.delete);
        delete.setOnClickListener(v -> {
            db.deletdata(id.get(position).toString());
            Intent intent = new Intent(mainActivity2,MainActivity2.class);
            mainActivity2.startActivity(intent);
            mainActivity2.finish();
        });

        update = convertView.findViewById(R.id.update);
//        update.setOnClickListener(v -> {
//            Intent intent = new Intent(mainActivity2,MainActivity3.class);
//            intent.putExtra("name",name.get(position).toString());
//            intent.putExtra("id",id.get(position).toString());
//            intent.putExtra("contact",contact.get(position).toString());
//            intent.putExtra("pass",pass.get(position).toString());
//            mainActivity2.startActivity(intent);
//        });
        update.setOnClickListener(v -> {
            Intent intent = new Intent(mainActivity2,MainActivity.class);
            a = 1;
            intent.putExtra("name",name.get(position).toString());
            intent.putExtra("pos",a);
            intent.putExtra("id",id.get(position).toString());
            intent.putExtra("contact",contact.get(position).toString());
            intent.putExtra("pass",pass.get(position).toString());
            mainActivity2.startActivity(intent);
        });
        return convertView;
    }
}
