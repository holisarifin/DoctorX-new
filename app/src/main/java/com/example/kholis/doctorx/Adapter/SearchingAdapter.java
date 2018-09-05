package com.example.kholis.doctorx.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kholis.doctorx.Model.Pasien;
import com.example.kholis.doctorx.R;

import java.util.List;

public class SearchingAdapter extends RecyclerView.Adapter<SearchingAdapter.MyViewHolder>{
    List<Pasien> mSearchingList;

    public SearchingAdapter(List<Pasien> mSearchingList) {
        this.mSearchingList = mSearchingList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.searching_list, parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(mView);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.mTextViewId.setText(mSearchingList.get(position).getId());
        holder.mTextViewNamaLengkap.setText(mSearchingList.get(position).getNamalengkap());
    }

    @Override
    public int getItemCount() {
        return mSearchingList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewId, mTextViewNamaLengkap;

        public MyViewHolder (View itemView){
            super(itemView);
            mTextViewId                 = (TextView) itemView.findViewById(R.id.tvhasilIdSearching);
            mTextViewNamaLengkap        = (TextView) itemView.findViewById(R.id.tvhasilNamaLengkapSearching);
            }
    }

}
