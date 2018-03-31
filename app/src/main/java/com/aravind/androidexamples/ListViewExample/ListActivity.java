package com.aravind.androidexamples.ListViewExample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.aravind.androidexamples.R;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<ListPojo> listPojos;
    ListAdapter listAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listView = findViewById(R.id.listview_example);
        listPojos = new ArrayList<>();

        addData("Aravind", "1234567890");
        addData("Arul", "1234567890");
        addData("Arun", "1234567890");
        addData("Amar", "1234567890");
        addData("Sugan", "1234567890");
        addData("Saravanan", "1234567890");
        addData("Suresh", "1234567890");
        addData("Rajesh", "1234567890");
        addData("Murugan", "1234567890");
        addData("Muthu", "1234567890");
        listAdapter = new ListAdapter(this, listPojos);
        listView.setAdapter(listAdapter);

    }

    public void addData(String name, String number) {
        listPojos.add(new ListPojo(name, number));

    }
}
