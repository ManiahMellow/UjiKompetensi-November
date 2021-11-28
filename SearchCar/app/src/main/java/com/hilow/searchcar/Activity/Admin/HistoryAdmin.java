package com.hilow.searchcar.Activity.Admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.hilow.searchcar.Adapter.AdapterHistory;
import com.hilow.searchcar.Adapter.Admin.HistoryAdminAdapter;
import com.hilow.searchcar.Model.GetHistory;
import com.hilow.searchcar.Model.History;
import com.hilow.searchcar.Model.HistoryAdminModel;
import com.hilow.searchcar.R;
import com.hilow.searchcar.Rest.ApiClient;
import com.hilow.searchcar.Rest.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HistoryAdmin extends AppCompatActivity {

    ApiInterface mApiInterface;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static HistoryAdmin ma;
    HistoryAdminAdapter adapter;
    List<HistoryAdminModel> historyAdminModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_admin);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        mRecyclerView = (RecyclerView) findViewById(R.id.rcvHistoryAdmin);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        ma = this;
        refresh();

//        load();
//        isiData();
    }

    public void refresh(){
        Call<GetHistory> historyCall = mApiInterface.getOrder();
        historyCall.enqueue(new Callback<GetHistory>() {
            @Override
            public void onResponse(Call<GetHistory> call, Response<GetHistory> response) {
                List<History> HistoryList = response.body().getData();
                Log.d("Retrofit Get", "Jumlah Data History: " +
                        String.valueOf(HistoryList.size()));
                mAdapter = new AdapterHistory(HistoryList);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<GetHistory> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
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

//    public void load(){
//        recyclerView = findViewById(R.id.rcvHistoryAdmin);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//    }
//
//    public void isiData(){
//        historyAdminModels = new ArrayList<HistoryAdminModel>();
//        historyAdminModels.add(new HistoryAdminModel("Penyewa 1", "Jl.Mawar", "28 - 02 -2021", "02 - 03 - 2021", "Toyota", "Avanza", "750000"));
//        historyAdminModels.add(new HistoryAdminModel("Penyewa 2", "Jl.Kamboja", "12 - 03 -2021", "14 - 03 - 2021", "Toyota", "Avanza", "750000"));
//        historyAdminModels.add(new HistoryAdminModel("Penyewa 3", "Jl.Melati", "17 - 03 -2021", "19 - 03 - 2021", "Toyota", "Avanza", "750000"));
//        historyAdminModels.add(new HistoryAdminModel("Penyewa 4", "Jl.Anggrek", "25 - 03 -2021", "27 - 03 - 2021", "Toyota", "Avanza", "750000"));
//
//
//        adapter = new HistoryAdminAdapter(this, historyAdminModels);
//        recyclerView.setAdapter(adapter);
//
//    }
}