package com.hilow.searchcar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ListToyota extends AppCompatActivity {

    RecyclerView recyclerView;
    ListToyotaAdapter adapter;
    List<Toyota> toyotaList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_toyota);

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
        recyclerView = findViewById(R.id.rcvListToyota);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void isiData(){
        toyotaList = new ArrayList<Toyota>();

        toyotaList.add(new Toyota("Avanza"));
        toyotaList.add(new Toyota("Agya"));
        toyotaList.add(new Toyota("Kijang Innova"));
        toyotaList.add(new Toyota("Calya"));

        adapter = new ListToyotaAdapter(this, toyotaList);
        recyclerView.setAdapter(adapter);
    }
}