package com.example.kholis.doctorx.Adapter;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kholis.doctorx.EditActivity;
import com.example.kholis.doctorx.Model.History;
import com.example.kholis.doctorx.R;

import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.MyViewHolder>{
        List<History> mHistoryList;

public HistoryAdapter(List<History> historyList){
    mHistoryList = historyList;
        }

@NonNull
@Override
public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.history_list, parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(mView);
        return myViewHolder;
        }

@Override
public void onBindViewHolder(@NonNull HistoryAdapter.MyViewHolder holder, final int position) {
        holder.mTextViewId.setText("Id = " + mHistoryList.get(position).getId());
        holder.mTextViewNama.setText("Nama = " + mHistoryList.get(position).getNama());
        holder.mTextViewDokter.setText("Dokter = " + mHistoryList.get(position).getDokter());
        holder.mTextViewTreatment.setText("Treatment = " + mHistoryList.get(position).getTreatment());
        holder.mTextViewHari.setText("Hari = " + mHistoryList.get(position).getHari());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
        Intent mIntent = new Intent(v.getContext(), EditActivity.class);
        mIntent.putExtra("Id = ", mHistoryList.get(position).getId());
        mIntent.putExtra("Nama = ", mHistoryList.get(position).getNama());
        mIntent.putExtra("Dokter = ", mHistoryList.get(position).getDokter());
        mIntent.putExtra("Treatment = ", mHistoryList.get(position).getTreatment());
        mIntent.putExtra("Hari = ", mHistoryList.get(position).getHari());

        v.getContext().startActivity(mIntent);
        }
        });
        }

@Override
public int getItemCount() {
        return mHistoryList.size();
        }

public class MyViewHolder extends RecyclerView.ViewHolder {
    public TextView mTextViewId, mTextViewNama, mTextViewDokter, mTextViewTreatment, mTextViewHari;

    public MyViewHolder (View itemView){
        super(itemView);
        mTextViewId                 = (TextView) itemView.findViewById(R.id.tvIdHistory);
        mTextViewNama               = (TextView) itemView.findViewById(R.id.tvNamaHistory);
        mTextViewDokter             = (TextView) itemView.findViewById(R.id.tvDokterHistory);
        mTextViewTreatment          = (TextView) itemView.findViewById(R.id.tvTreatmentHistory);
        mTextViewHari               = (TextView) itemView.findViewById(R.id.tvDayHistory);

    }
}
}

