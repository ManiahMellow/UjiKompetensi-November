package com.hilow.searchcar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ListDaihatsu extends AppCompatActivity {

    RecyclerView recyclerView;
    ListDaihatsuAdapter adapter;
    List<Daihatsu> daihatsuList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_daihatsu);

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
        recyclerView = findViewById(R.id.rcvListDaihatsu);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void isiData(){
        daihatsuList = new ArrayList<Daihatsu>();

        daihatsuList.add(new Daihatsu("Ayla"));
        daihatsuList.add(new Daihatsu("Terios"));
        daihatsuList.add(new Daihatsu("Sigra"));
        daihatsuList.add(new Daihatsu("Rocky"));

        adapter = new ListDaihatsuAdapter(this, daihatsuList);
        recyclerView.setAdapter(adapter);
    }
}