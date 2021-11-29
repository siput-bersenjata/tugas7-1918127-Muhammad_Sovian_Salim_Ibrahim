package com.example.tgsprak7;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Game> Game;
    public CustomListAdapter(Activity activity, List<Game>
            Game) {
        this.activity = activity;
        this.Game = Game;
    }
    @Override
    public int getCount() {
        return Game.size();
    }
    @Override
    public Object getItem(int location) {
        return Game.get(location);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup
            parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity

                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.costom_list,null);
        TextView nama = (TextView)
                convertView.findViewById(R.id.text_nama);
        TextView kelas = (TextView)
                convertView.findViewById(R.id.text_kelas);
        ImageView imageView = (ImageView)
                convertView.findViewById(R.id.iconid);
        Game m = Game.get(position);
        nama.setText("Nama : "+ m.get_nama());
        kelas.setText("Kelas : "+ m.get_kelas());
        return convertView;
    }
}
