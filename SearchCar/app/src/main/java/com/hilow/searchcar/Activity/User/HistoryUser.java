package com.hilow.searchcar.Activity.User;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.hilow.searchcar.Adapter.AdapterHistory;
import com.hilow.searchcar.Adapter.AdapterHistoryUser;
import com.hilow.searchcar.Adapter.User.HistoryUserAdapter;
import com.hilow.searchcar.Model.GetHistory;
import com.hilow.searchcar.Model.History;
import com.hilow.searchcar.Model.HistoryUserModel;
import com.hilow.searchcar.Model.Login;
import com.hilow.searchcar.R;
import com.hilow.searchcar.Rest.ApiClient;
import com.hilow.searchcar.Rest.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HistoryUser extends AppCompatActivity {

    ApiInterface mApiInterface;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static HistoryUser ma;
    HistoryUserAdapter adapter;
    List<HistoryUserModel> historyUserModels;
    Login getLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_user);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        mRecyclerView = (RecyclerView) findViewById(R.id.rcvHistoryUser);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        ma = this;

        jalankan();
        refresh();

//        load();
//        isiData();
    }

    private void jalankan() {
        Intent intent = getIntent();
        if (intent.getExtras() != null){
            getLogin =  (Login) intent.getSerializableExtra("data");
        }

        Integer idUser = getLogin.getId();
        intent.putExtra("IdUser", idUser);
    }


    public void refresh(){
        Call<GetHistory> historyCall = mApiInterface.getOrder();
        historyCall.enqueue(new Callback<GetHistory>() {
            @Override
            public void onResponse(Call<GetHistory> call, Response<GetHistory> response) {
                List<History> HistoryList = response.body().getData();
                Log.d("Retrofit Get", "Jumlah Data History User: " +
                        String.valueOf(HistoryList.size()));
                mAdapter = new AdapterHistoryUser(HistoryList);
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
//        recyclerView = findViewById(R.id.rcvHistoryUser);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//    }
//
//    public void isiData(){
//        historyUserModels = new ArrayList<HistoryUserModel>();
//
//        historyUserModels.add(new HistoryUserModel("Toyota", "Agya", "16 - 02 - 2021", "19 - 02 - 2021", "1000000"));
//        historyUserModels.add(new HistoryUserModel("Toyota", "Kijang Innova", "25 - 03 - 2021", "27 - 02 - 2021", "750000"));
//
//        adapter = new HistoryUserAdapter(this, historyUserModels);
//        recyclerView.setAdapter(adapter);
//
//    }
}