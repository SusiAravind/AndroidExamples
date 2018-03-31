package com.aravind.androidexamples.RecyclerViewExample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.aravind.androidexamples.ListViewExample.ListAdapter;
import com.aravind.androidexamples.ListViewExample.ListPojo;
import com.aravind.androidexamples.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<ListPojo> listPojos=new ArrayList<>();

RecyclerAdapter recyclerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        recyclerView = findViewById(R.id.recyclerView);



        recyclerAdapter=new RecyclerAdapter(listPojos);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(recyclerAdapter);

        addData("Aravind", "aravind@gmail.com");
        addData("Arul", "arul@gmail.com");
        addData("Arun", "arun@gmail.com");
        addData("Amar", "amar@gmail.com");
        addData("Sugan", "sugan@gmail.com");
        addData("Saravanan", "saravana@gmail.com");
        addData("Suresh", "suresh@gmail.com");
        addData("Rajesh", "rajesh@gmail.com");
        addData("Murugan", "murugan@gmail.com");
        addData("Muthu", "muthu@gmail.com");

    }

    public void addData(String name, String number) {
        listPojos.add(new ListPojo(name, number));
        recyclerAdapter.notifyDataSetChanged();

    }
}
