package com.example.kholis.doctorx.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.kholis.doctorx.Model.JadwalDokter;
import com.example.kholis.doctorx.R;

import java.util.List;

public class JadwalDokterAdapter extends BaseAdapter {
    public List<JadwalDokter> jadwalDokterList;
    Activity activity;

    public JadwalDokterAdapter(List<JadwalDokter> jadwalDokterList, Activity activity) {
        this.jadwalDokterList = jadwalDokterList;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return jadwalDokterList.size();
    }

    @Override
    public Object getItem(int position) {
        return jadwalDokterList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder {
        TextView namaView;
        TextView hariView;
        TextView jammulaiView;
        TextView jamselesaiView;
        TextView keahlianView;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        LayoutInflater inflater = activity.getLayoutInflater();

        if (convertView == null){
            convertView = inflater.inflate(R.layout.recordjadwaldokter, null);
            holder = new ViewHolder();
            holder.namaView = (TextView) convertView.findViewById(R.id.nama);
            holder.hariView = (TextView) convertView.findViewById(R.id.hari);
            holder.jammulaiView = (TextView) convertView.findViewById(R.id.jammulai);
            holder.jamselesaiView = (TextView) convertView.findViewById(R.id.jamselesai);
            holder.keahlianView = (TextView) convertView.findViewById(R.id.keahlian);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        JadwalDokter item = jadwalDokterList.get(position);
        holder.namaView.setText(item.getNama_dokter().toString());
        holder.hariView.setText(item.getHari().toString());
        holder.jammulaiView.setText(item.getJam_mulai().toString());
        holder.jamselesaiView.setText(item.getJam_selesai().toString());
        holder.keahlianView.setText(item.getKeahlian_dokter().toString());

        return convertView;
    }
}
