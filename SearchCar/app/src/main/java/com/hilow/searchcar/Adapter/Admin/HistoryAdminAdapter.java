package com.hilow.searchcar.Adapter.Admin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hilow.searchcar.Model.HistoryAdminModel;
import com.hilow.searchcar.R;

import java.util.List;

public class HistoryAdminAdapter extends RecyclerView.Adapter<HistoryAdminAdapter.ViewHolder> {

    private Context context;
    private List<HistoryAdminModel> historyAdminList;

    public HistoryAdminAdapter(Context context, List<HistoryAdminModel> historyAdminList) {
        this.context = context;
        this.historyAdminList = historyAdminList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_history_admin, viewGroup, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        HistoryAdminModel historyAdminModel = historyAdminList.get(i);

        viewHolder.tvNamaPenyewa.setText(historyAdminModel.getNamapenyewa());
        viewHolder.tvAlamatPenyewa.setText(historyAdminModel.getAlamatpenyewa());
        viewHolder.tvTglSewa.setText(historyAdminModel.getTglsewa());
        viewHolder.tvTglKembali.setText(historyAdminModel.getTglkembali());
        viewHolder.tvJenisMobil.setText(historyAdminModel.getJenismobil());
        viewHolder.tvMerkMobil.setText(historyAdminModel.getMerkmobil());
        viewHolder.tvHargaTotal.setText(historyAdminModel.getHargatotal());
    }

    @Override
    public int getItemCount() {
        return historyAdminList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvNamaPenyewa, tvAlamatPenyewa, tvTglSewa, tvTglKembali, tvJenisMobil, tvMerkMobil, tvHargaTotal;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNamaPenyewa = itemView.findViewById(R.id.tvNamaPenyewa);
            tvAlamatPenyewa = itemView.findViewById(R.id.tvAlamatPenyewa);
            tvTglSewa = itemView.findViewById(R.id.tvTanggalMenyewa);
            tvTglKembali = itemView.findViewById(R.id.tvTanggalKembali);
            tvJenisMobil = itemView.findViewById(R.id.tvJenisMobil);
            tvMerkMobil = itemView.findViewById(R.id.tvHistoryMerk);
            tvHargaTotal = itemView.findViewById(R.id.tvHargaTotal);

        }
    }
}
