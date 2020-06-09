package com.example.dietkuy.recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dietkuy.R;
import com.example.dietkuy.retrofit.model.Latihan;

import org.w3c.dom.Text;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    List<Latihan> listLatihan;

    public Adapter(List<Latihan> listLatihan) {
        this.listLatihan = listLatihan;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_latihan, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(mView);
        return myViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
//        holder.jenisLatihan.setText(listLatihan.get(position).getOlahraga(position));
    }

    @Override
    public int getItemCount() {
        return listLatihan.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView jenisLatihan, waktuLatihan;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            jenisLatihan = (TextView) itemView.findViewById(R.id.jenisLatihan);
            waktuLatihan = (TextView) itemView.findViewById(R.id.waktuLatihan);
        }
    }
}
