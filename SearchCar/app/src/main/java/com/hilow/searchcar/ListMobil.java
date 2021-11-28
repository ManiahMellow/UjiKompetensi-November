package com.hilow.searchcar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.hilow.searchcar.Activity.Admin.TambahMobil;
import com.hilow.searchcar.Adapter.Admin.ListMobilAdapter;
import com.hilow.searchcar.Model.Mobil;

import java.util.ArrayList;
import java.util.List;

public class ListMobil extends AppCompatActivity {

    RecyclerView recyclerView;
    ListMobilAdapter adapter;
    List<Mobil> mobilList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_mobil);

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.tambah_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.iconTambah) {

            Intent intent = new Intent(ListMobil.this, TambahMobil.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void load(){
        recyclerView = findViewById(R.id.rcvListMobil);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void isiData(){
        mobilList = new ArrayList<Mobil>();
        mobilList.add(new Mobil("Toyota", "Avanza", "250000", R.drawable.avanza));

        adapter = new ListMobilAdapter(this, mobilList);
        recyclerView.setAdapter(adapter);
    }




}