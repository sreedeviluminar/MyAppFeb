package com.sree.myappfeb.basic;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.sree.myappfeb.R;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    public ImageAdapter(Context c) {
        mContext = c;
    }
    public int getCount() {
        return thumbImages.length;
    }
    public Object getItem(int position) {
        return null;
    }
    public long getItemId(int position) {
        return 0;
    }
    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {

        ImageView imageView = new ImageView(mContext);
        imageView.setLayoutParams(new GridView.LayoutParams(200, 200));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setPadding(8, 8, 8, 8);
        imageView.setImageResource(thumbImages[position]);

        return imageView;
    }
    // Add all our images to arraylist
    public Integer[] thumbImages = {
            R.drawable.girl, R.drawable.ic_account_box,
            R.drawable.ic_message, R.drawable.settings,
            R.drawable.bluetoothoff, R.drawable.house,
            R.drawable.ic_social, R.drawable.ic_content_cut,
            R.drawable.iconfeb, R.drawable.email,
            R.drawable.bluetoothoff, R.drawable.house,
            R.drawable.ic_social, R.drawable.ic_content_cut,
            R.drawable.iconfeb, R.drawable.email,

    };
}