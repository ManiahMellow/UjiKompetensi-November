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

public class ListHondaAdapter extends RecyclerView.Adapter<ListHondaAdapter.ViewHolder> {

    private Context context;
    private List<Honda> hondaList;

    public ListHondaAdapter(Context context, List<Honda> hondaList) {
        this.context = context;
        this.hondaList = hondaList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list_honda, viewGroup, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        Honda honda = hondaList.get(i);

        viewHolder.btnListHonda.setText(honda.getBtnhonda());

    }

    @Override
    public int getItemCount() {

        return hondaList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        Button btnListHonda;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            btnListHonda = itemView.findViewById(R.id.btnListHonda);
            btnListHonda.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    switch (getAdapterPosition()){
                        case 0 :
                            intent= new Intent(context, HondaJazz.class);
                            break;

                        case 1 :
                            intent = new Intent(context, HondaMobilio.class);
                            break;

                        case 2 :
                            intent = new Intent(context, HondaBrio.class);
                            break;

                        case 3 :
                            intent= new Intent(context, HondaHrV.class);
                            break;
                    }
                    context.startActivity(intent);
                }
            });
        }
    }

}
