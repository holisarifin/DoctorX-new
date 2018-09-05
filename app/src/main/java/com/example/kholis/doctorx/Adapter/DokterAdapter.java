package com.example.kholis.doctorx.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.kholis.doctorx.Model.Dokter;
import com.example.kholis.doctorx.R;

import java.util.List;

public class DokterAdapter extends ArrayAdapter<Dokter>{
    private final LayoutInflater mInflater;
    private final Context mContext;
    private final List<Dokter> dokterList;
    private final int mResource;

    public DokterAdapter(@NonNull Context context, int resource, @NonNull List<Dokter> objects) {
        super(context, resource, objects);

        mContext = context;
        mInflater = LayoutInflater.from(context);
        mResource = resource;
        dokterList = objects;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return createItemView(position, convertView, parent);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return createItemView(position, convertView, parent);
    }

    private View createItemView(int position, View convertView, ViewGroup parent) {
        final View view = mInflater.inflate(mResource, parent, false);

        TextView spinnerTxt = (TextView) view.findViewById(R.id.spinnerTxt);

        spinnerTxt.setText(dokterList.get(position).getNama_dokter());
        return view;
    }
}
