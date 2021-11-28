package com.hilow.searchcar.Adapter.User;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hilow.searchcar.Model.HistoryUserModel;
import com.hilow.searchcar.R;

import java.util.List;

public class HistoryUserAdapter extends RecyclerView.Adapter<HistoryUserAdapter.ViewHolder> {

    private Context context;
    private List<HistoryUserModel> historyUserModels;

    public HistoryUserAdapter(Context context, List<HistoryUserModel> historyUserModels) {
        this.context = context;
        this.historyUserModels = historyUserModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_history_user, viewGroup, false);

       return  new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        HistoryUserModel historyUserModel = historyUserModels.get(i);

        viewHolder.tvJenisUser.setText(historyUserModel.getJenisuser());
        viewHolder.tvMerkuser.setText(historyUserModel.getMerkuser());
        viewHolder.tvTglSewa.setText(historyUserModel.getSewauser());
        viewHolder.tvTglKembali.setText(historyUserModel.getKembaliuser());
        viewHolder.tvTotalHistory.setText(historyUserModel.getTotaluser());

    }

    @Override
    public int getItemCount() {
        return historyUserModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvJenisUser, tvMerkuser, tvTglSewa, tvTglKembali, tvTotalHistory;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvJenisUser = itemView.findViewById(R.id.tvJenisUser);
            tvMerkuser = itemView.findViewById(R.id.tvMerkUser);
            tvTglSewa = itemView.findViewById(R.id.tvTglSewa);
            tvTglKembali = itemView.findViewById(R.id.tvTglKembali);
            tvTotalHistory = itemView.findViewById(R.id.tvTotalHistory);

        }
    }

}
