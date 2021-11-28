package com.hilow.searchcar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.helper.widget.Carousel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class ListHonda extends AppCompatActivity {

    RecyclerView recyclerView;
    ListHondaAdapter adapter;
    List<Honda> hondaList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_honda);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);



        load();
        isiData();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public void load(){
        recyclerView = findViewById(R.id.rcvListHonda);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    public void isiData(){
        hondaList = new ArrayList<Honda>();

        hondaList.add(new Honda("Jazz"));
        hondaList.add(new Honda("Mobilio"));
        hondaList.add(new Honda("Brio"));
        hondaList.add(new Honda("HR-V"));

        adapter = new ListHondaAdapter(this, hondaList);
        recyclerView.setAdapter(adapter);

    }


}