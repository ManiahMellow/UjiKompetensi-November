package com.hilow.searchcar.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hilow.searchcar.Activity.User.HistoryUser;
import com.hilow.searchcar.Activity.User.MainActivity;
import com.hilow.searchcar.Model.History;
import com.hilow.searchcar.R;

import java.util.List;

public class AdapterHistoryUser extends RecyclerView.Adapter<AdapterHistoryUser.ViewHolder> {

    public static MainActivity ma;
    private Context context;
    private List<History> HistoryList;

    public AdapterHistoryUser(List<History> historyList) {
        HistoryList = historyList;
    }

    @NonNull
    @Override
    public AdapterHistoryUser.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_history_user, parent, false);
        return new AdapterHistoryUser.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterHistoryUser.ViewHolder holder, int position) {
        Intent intent = (HistoryUser.ma.getIntent());
        int value = intent.getIntExtra("IdUser", 0);

        if (HistoryList.get(position).getIduser() == value){
            holder.tvJenisUser.setText(HistoryList.get(position).getJenismobil());
            holder.tvMerkUser.setText(HistoryList.get(position).getMerkmobil());
            holder.tvTglSewa.setText(HistoryList.get(position).getTglorder());
            holder.tvTglKembali.setText(HistoryList.get(position).getTglkembali());
            holder.tvTotalHistory.setText(String.valueOf(HistoryList.get(position).getTotal()));
        }else{
            holder.itemView.setVisibility(View.GONE);
            holder.itemView.setLayoutParams(new RecyclerView.LayoutParams(0, 0));
        }

    }

    @Override
    public int getItemCount() {
        return HistoryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvJenisUser, tvMerkUser, tvTglSewa, tvTglKembali, tvTotalHistory;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvJenisUser = itemView.findViewById(R.id.tvJenisUser);
            tvMerkUser = itemView.findViewById(R.id.tvMerkUser);
            tvTglSewa = itemView.findViewById(R.id.tvTglSewa);
            tvTglKembali = itemView.findViewById(R.id.tvTglKembali);
            tvTotalHistory = itemView.findViewById(R.id.tvTotalHistory);
        }
    }
}
