package com.sree.myappfeb.basic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.sree.myappfeb.R;

public class CustomAdapter extends BaseAdapter {
    Context context;
    int icons[];
    String districts[];
    LayoutInflater inflater;

    public CustomAdapter(Context applicationContext, int[] icons, String[] districts) {
        context=applicationContext;
        this.icons=icons;
        this.districts=districts;
        inflater = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return icons.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View layout, ViewGroup parent) {
        layout = inflater.inflate(R.layout.custom_spinner,null);
        ImageView icon = (ImageView)layout.findViewById(R.id.customimage);
        TextView district = (TextView)layout.findViewById(R.id.customtext);
        icon.setImageResource(icons[position]);
        district.setText(districts[position]);
        return layout;
    }
}
