package com.example.kholis.doctorx.Adapter;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kholis.doctorx.EditActivity;
import com.example.kholis.doctorx.Model.Pasien;
import com.example.kholis.doctorx.R;

import java.util.List;

public class PasienAdapter extends RecyclerView.Adapter<PasienAdapter.MyViewHolder>{
    List<Pasien> mPasienList;

    public PasienAdapter(List<Pasien> pasienList){
        mPasienList = pasienList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.pasien_list, parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(mView);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PasienAdapter.MyViewHolder holder, final int position) {
        holder.mTextViewId.setText(mPasienList.get(position).getId());
        holder.mTextViewNamaLengkap.setText(mPasienList.get(position).getNamalengkap());
        holder.mTextViewNamaPanggilan.setText(mPasienList.get(position).getNamapanggilan());
        holder.mTextViewJenisKelamin.setText(mPasienList.get(position).getJeniskelamin());
        holder.mTextViewTanggalLahir.setText(mPasienList.get(position).getTanggallahir());
        holder.mTextViewStatusPernikahan.setText(mPasienList.get(position).getStatuspernikahan());
        holder.mTextViewTempatLahir.setText( mPasienList.get(position).getTempatlahir());
        holder.mTextViewAlamat.setText(mPasienList.get(position).getAlamat());
        holder.mTextViewProvinsi.setText(mPasienList.get(position).getProvinsi());
        holder.mTextViewKabupatenKota.setText(mPasienList.get(position).getKabupatenkota());
        holder.mTextViewKodepos.setText(mPasienList.get(position).getKodepos());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(v.getContext(), EditActivity.class);
                mIntent.putExtra("Id = ", mPasienList.get(position).getId());
                mIntent.putExtra("Nama Lengkap = ", mPasienList.get(position).getNamalengkap());
                mIntent.putExtra("Nama Panggilan = ", mPasienList.get(position).getNamapanggilan());
                mIntent.putExtra("Jenis Kelamin = ", mPasienList.get(position).getJeniskelamin());
                mIntent.putExtra("Tanggal Lahir = ", mPasienList.get(position).getTanggallahir());
                mIntent.putExtra("Status Pernikahan = ", mPasienList.get(position).getStatuspernikahan());
                mIntent.putExtra("Tempat Lahir = ", mPasienList.get(position).getTempatlahir());
                mIntent.putExtra("Alamat = ", mPasienList.get(position).getAlamat());
                mIntent.putExtra("Provinsi = ", mPasienList.get(position).getProvinsi());
                mIntent.putExtra("Kabupaten/Kota = ", mPasienList.get(position).getKabupatenkota());
                mIntent.putExtra("Kodepos = ", mPasienList.get(position).getKodepos());
                v.getContext().startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mPasienList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewId, mTextViewNamaLengkap, mTextViewNamaPanggilan, mTextViewJenisKelamin, mTextViewTanggalLahir, mTextViewStatusPernikahan, mTextViewTempatLahir,
                mTextViewAlamat, mTextViewProvinsi, mTextViewKabupatenKota, mTextViewKodepos;

        public MyViewHolder (View itemView){
            super(itemView);
            mTextViewId                 = (TextView) itemView.findViewById(R.id.tvhasilId);
            mTextViewNamaLengkap        = (TextView) itemView.findViewById(R.id.tvhasilNamaLengkap);
            mTextViewNamaPanggilan      = (TextView) itemView.findViewById(R.id.tvNahasilmaPanggilan);
            mTextViewJenisKelamin       = (TextView) itemView.findViewById(R.id.tvhasilJenisKelamin);
            mTextViewTanggalLahir       = (TextView) itemView.findViewById(R.id.tvhasilTanggalLahir);
            mTextViewStatusPernikahan   = (TextView) itemView.findViewById(R.id.tvhasilStatusPernikahan);
            mTextViewTempatLahir        = (TextView) itemView.findViewById(R.id.tvhasilTempatLahir);
            mTextViewAlamat             = (TextView) itemView.findViewById(R.id.tvhasilAlamat);
            mTextViewProvinsi           = (TextView) itemView.findViewById(R.id.tvhasilProvinsi);
            mTextViewKabupatenKota      = (TextView) itemView.findViewById(R.id.tvhasilKabupatenKota);
            mTextViewKodepos            = (TextView) itemView.findViewById(R.id.tvhasilKodepos);
        }
    }
}
