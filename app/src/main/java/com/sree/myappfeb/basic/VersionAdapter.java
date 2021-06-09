package com.sree.myappfeb.basic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.sree.myappfeb.R;

import java.util.ArrayList;
import java.util.List;

public class VersionAdapter extends ArrayAdapter<Versions>{

    Context context;
    List<Versions> list = new ArrayList<>();


    public VersionAdapter(@NonNull Context context, int resource, List<Versions> list) {
        super(context, resource, list);
        this.context = context;
        this.list = list;
        list.addAll(list);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        VersionHolder holder = new VersionHolder();

        if (convertView == null){

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_row,null);


            holder.checkBox = convertView.findViewById(R.id.check_box);
            holder.textView = convertView.findViewById(R.id.tv_name);

            holder.checkBox.setOnCheckedChangeListener((ListViewWithCheckBoxActivity)context);

            convertView.setTag(holder);

        }else{
            holder = (VersionHolder) convertView.getTag();
        }

        Versions versions  = list.get(position);
        holder.textView.setText(versions.getVersion());

        holder.checkBox.setTag(list);

        return convertView;
    }

    public static class VersionHolder{
        public CheckBox checkBox;
        public TextView textView;
    }
}