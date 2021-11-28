package com.hilow.searchcar;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListToyotaAdapter extends RecyclerView.Adapter<ListToyotaAdapter.ViewHolder> {

    private Context context;
    private List<Toyota> toyotaList;

    public ListToyotaAdapter(Context context, List<Toyota> toyotaList) {
        this.context = context;
        this.toyotaList = toyotaList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list_toyota, viewGroup, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        Toyota toyota = toyotaList.get(i);

        viewHolder.btnListToyota.setText(toyota.getBtntoyota());

    }

    @Override
    public int getItemCount() {
        return toyotaList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        Button btnListToyota;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            btnListToyota = itemView.findViewById(R.id.btnListToyota);
            btnListToyota.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    switch (getAdapterPosition()){
                        case 0 :
                            intent = new Intent(context, ToyotaAvanza.class);
                            break;

                        case 1 :
                            intent = new Intent(context, ToyotaAgya.class);
                            break;

                        case 2 :
                            intent = new Intent(context, ToyotaKijangInnova.class);
                            break;

                        case 3 :
                            intent= new Intent(context, ToyotaCalya.class);
                            break;
                    }
                    context.startActivity(intent);
                }
            });
        }
    }


}
