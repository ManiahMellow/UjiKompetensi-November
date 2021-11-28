package com.hilow.searchcar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.hilow.searchcar.Adapter.User.DetailMobilAdapter;
import com.hilow.searchcar.Model.DetailMobil;

import java.util.ArrayList;
import java.util.List;

public class ToyotaAgya extends AppCompatActivity {

    RecyclerView recyclerView;
    DetailMobilAdapter adapter;
    List<DetailMobil> detailMobilList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toyota_agya);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        load();
//        isiData();
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
        recyclerView = findViewById(R.id.rcvDetailAgya);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

//    public void isiData(){
//        detailMobilList = new ArrayList<DetailMobil>();
//        detailMobilList.add(new DetailMobil("Agya", "Agya","25000", R.drawable.avanza));
//
//        adapter = new DetailMobilAdapter(this, detailMobilList);
//        recyclerView.setAdapter(adapter);
//    }

}