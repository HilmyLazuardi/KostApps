package com.example.hilmylazuardi.studykasus.adapter;

import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.hilmylazuardi.studykasus.R;
import com.example.hilmylazuardi.studykasus.app.AppController;
import com.example.hilmylazuardi.studykasus.data.Data;

import java.util.List;

public class Adapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Data> items;

    public Adapter(Activity activity, List <Data> items){
        this.activity = activity;
        this.items = items;
    }
    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int location) {
        return items.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        if (inflater == null)
            inflater = (LayoutInflater) activity.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null)
            convertView = inflater.inflate(R.layout.list_row, null);

        TextView id_users = (TextView) convertView.findViewById(R.id.id_users);
        TextView nama = (TextView) convertView.findViewById(R.id.nama);
        TextView alamat = (TextView) convertView.findViewById(R.id.alamat);
        TextView status = (TextView) convertView.findViewById(R.id.status);

        Data data = items.get(position);

        id_users.setText(data.getId_users());
        nama.setText(data.getNama());
        alamat.setText(data.getAlamat());
        status.setText(data.getStatus());
        return convertView;
    }
}
