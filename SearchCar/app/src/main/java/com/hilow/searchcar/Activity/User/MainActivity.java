package com.hilow.searchcar.Activity.User;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.hilow.searchcar.Adapter.AdapterMenu;
import com.hilow.searchcar.Adapter.AdapterMobil;
import com.hilow.searchcar.Adapter.User.DetailMobilAdapter;
import com.hilow.searchcar.LoginUser;
import com.hilow.searchcar.Model.DetailMobil;
import com.hilow.searchcar.Model.GetLogin;
import com.hilow.searchcar.Model.GetMenu;
import com.hilow.searchcar.Model.Login;
import com.hilow.searchcar.Model.Mobil;
import com.hilow.searchcar.R;
import com.hilow.searchcar.Rest.ApiClient;
import com.hilow.searchcar.Rest.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ApiInterface mApiInterface;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static MainActivity ma;
    Login getLogin;
    RecyclerView recyclerView;
    DetailMobilAdapter adapter;
    List<Mobil> mobilList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Intent intent = getIntent();
        if (intent.getExtras() != null){

           getLogin = (Login) intent.getSerializableExtra("data");
           Log.e("TAG", "===>" + getLogin.getEmail());


        }

        mRecyclerView = (RecyclerView) findViewById(R.id.rcvMobilUser);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        ma = this;
        refresh();


        Intent mintent = new Intent();
        mintent.putExtra("data", intent.getExtras());


//        load();
//        isiData();
    }

    public void refresh(){
        Call<GetMenu> menuCall = mApiInterface.getMenu();
        menuCall.enqueue(new Callback<GetMenu>() {

            @Override
            public void onResponse(Call<GetMenu> call, Response<GetMenu> response) {
                List<com.hilow.searchcar.Model.Menu> MenuList = response.body().getData();
                Log.d("Retrofit Get", "Jumlah data Kontak: " +
                        String.valueOf(MenuList.size()));
                mAdapter = new AdapterMobil(MenuList);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<GetMenu> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.profil_menu, menu);
        getMenuInflater().inflate(R.menu.history_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.iconProfil:
                if (getLogin != null){
                    Intent intent = new Intent(MainActivity.this, ProfilUser.class);
                    intent.putExtra("nama", getLogin.getNama());
                    intent.putExtra("alamat", getLogin.getAlamat());
                    intent.putExtra("telp", getLogin.getTelp());

                    startActivity(intent);
                }else{
                    Intent intent = new Intent(MainActivity.this, LoginUser.class);
                    startActivity(intent);
                }
                return true;

            case R.id.iconHistory:
                if (getLogin != null){
                    Intent intent = new Intent(MainActivity.this, HistoryUser.class).putExtra("data", getLogin);
                    startActivity(intent);
                }else {
                    Intent intent = new Intent(MainActivity.this, LoginUser.class);
                    startActivity(intent);
                }
                return true;
        }

//        int id = item.getItemId();
//
//        if (id == R.id.iconProfil) {
//
//            Intent intent = new Intent(MainActivity.this, ProfilUser.class);
//            startActivity(intent);
//            return true;
//        }
//
//        if (id == R.id.iconHistory){
//
//            Intent intent = new Intent(MainActivity.this, HistoryUser.class);
//            startActivity(intent);
//        }
        return super.onOptionsItemSelected(item);
    }

//    public void load(){
//        recyclerView = findViewById(R.id.rcvMobilUser);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//    }
//
//    public void isiData(){
//        mobilList = new ArrayList<Mobil>();
//
//        mobilList.add(new Mobil("Toyota", "Avanza", "250000", R.drawable.avanza));
//        mobilList.add(new Mobil("Toyota", "Avanza", "250000", R.drawable.avanza));
//        mobilList.add(new Mobil("Toyota", "Avanza", "250000", R.drawable.avanza));
//        mobilList.add(new Mobil("Toyota", "Avanza", "250000", R.drawable.avanza));
//        mobilList.add(new Mobil("Toyota", "Avanza", "250000", R.drawable.avanza));
//
//        adapter = new DetailMobilAdapter(this, mobilList);
//        recyclerView.setAdapter(adapter);
//
//    }

//    public void btnToyota(View view) {
//        Intent intent = new Intent(this, ListToyota.class);
//        startActivity(intent);
//    }
//
//    public void btnHonda(View view) {
//        Intent intent = new Intent(this, ListHonda.class);
//        startActivity(intent);
//    }
//
//    public void btnDaihatsu(View view) {
//        Intent intent = new Intent(this, ListDaihatsu.class);
//        startActivity(intent);
//    }
}