package com.example.kholis.doctorx.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.kholis.doctorx.Model.JadwalDokter;
import com.example.kholis.doctorx.R;

import java.util.List;

public class RecordAdapter extends BaseAdapter {

    Context recordContext;
    List<JadwalDokter> recordList;

    public RecordAdapter(Context recordContext, List<JadwalDokter> recordList) {
        this.recordContext = recordContext;
        this.recordList = recordList;
    }

    @Override
    public int getCount() {
        return recordList.size();
    }

    @Override
    public Object getItem(int position) {
        return recordList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        RecordAdapter.RecordViewHolder holder;

        if(view == null){
            LayoutInflater recordInflater = (LayoutInflater) recordContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            view = recordInflater.inflate(R.layout.recordjadwaldokter, null);
            holder = new RecordAdapter.RecordViewHolder();
            holder.hariView = (TextView) view.findViewById(R.id.record_hari);
            holder.namaView = (TextView) view.findViewById(R.id.record_nama);
            holder.jammulaiView = (TextView) view.findViewById(R.id.record_jammulai);
            holder.jamselesaiView = (TextView) view.findViewById(R.id.record_jamselesai);
            holder.keahlianView = (TextView) view.findViewById(R.id.record_keahlian);
            view.setTag(holder);
        }
        else {
            holder = (RecordAdapter.RecordViewHolder) view.getTag();
        }

        JadwalDokter record = (JadwalDokter) getItem(position);
        holder.namaView.setText(record.getNama_dokter());
        holder.hariView.setText(record.getHari());
        holder.jammulaiView.setText(record.getJam_mulai());
        holder.jamselesaiView.setText(record.getJam_selesai());
        holder.keahlianView.setText(record.getKeahlian_dokter());

        return view;
    }

    private static class RecordViewHolder {
        public TextView namaView;
        public TextView hariView;
        public TextView jammulaiView;
        public TextView jamselesaiView;
        public TextView keahlianView;
    }
}
