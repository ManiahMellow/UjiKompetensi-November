package com.hilow.searchcar.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hilow.searchcar.Model.History;
import com.hilow.searchcar.R;

import java.util.List;

public class AdapterHistory extends RecyclerView.Adapter<AdapterHistory.ViewHolder> {

    private Context context;
    private List<History> HistoryList;

    public AdapterHistory(List<History> historyList) {
        HistoryList = historyList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_history_admin, parent, false);
        return new AdapterHistory.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterHistory.ViewHolder holder, int position) {

        holder.tvNamaPenyewa.setText(HistoryList.get(position).getPenyewa());
        holder.tvAlamatPenyewa.setText(HistoryList.get(position).getAlamat());
        holder.tvTanggalMenyewa.setText(HistoryList.get(position).getTglorder());
        holder.tvTanggalKembali.setText(HistoryList.get(position).getTglkembali());
        holder.tvJenisMobil.setText(HistoryList.get(position).getJenismobil());
        holder.tvHistoryMerk.setText(HistoryList.get(position).getMerkmobil());
        holder.tvHargaTotal.setText(String.valueOf(HistoryList.get(position).getTotal()));

    }

    @Override
    public int getItemCount() {
        return HistoryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNamaPenyewa, tvAlamatPenyewa, tvTanggalMenyewa, tvTanggalKembali, tvJenisMobil, tvHistoryMerk, tvHargaTotal;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNamaPenyewa = itemView.findViewById(R.id.tvNamaPenyewa);
            tvAlamatPenyewa = itemView.findViewById(R.id.tvAlamatPenyewa);
            tvTanggalMenyewa = itemView.findViewById(R.id.tvTanggalMenyewa);
            tvTanggalKembali = itemView.findViewById(R.id.tvTanggalKembali);
            tvJenisMobil = itemView.findViewById(R.id.tvJenisMobil);
            tvHistoryMerk = itemView.findViewById(R.id.tvHistoryMerk);
            tvHargaTotal = itemView.findViewById(R.id.tvHargaTotal);
        }
    }
}
