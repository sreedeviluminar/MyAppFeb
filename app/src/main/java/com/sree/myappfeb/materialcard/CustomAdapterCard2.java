package com.sree.myappfeb.materialcard;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.sree.myappfeb.R;

public class CustomAdapterCard2 extends RecyclerView.Adapter<CustomAdapterCard2.MyViewHolder> {

    private final String[] personNames;
    int[] personImages;
    Context context;
    public CustomAdapterCard2(CardWithRecycler context, String[] personNames, int[] personImages) {
        this.context = context;
        this.personNames = personNames;
        this.personImages=personImages;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
// infalte the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayoutcard, parent, false);
// set the view's size, margins, paddings and layout parameters
        MyViewHolder vh = new MyViewHolder(v); // pass the view to View Holder
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
// set the data in items
        holder.name.setText(personNames[position]);
        holder.image.setImageResource(personImages[position]);
// implement setOnClickListener event on item view.
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
// open another activity on item click
                Intent intent = new Intent(context, SecondActivityCard.class);
                intent.putExtra("image", personImages[position]); // put image data in Intent
                context.startActivity(intent); // start Intent
            }
        });

    }

    @Override
    public int getItemCount() {

        return personNames.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        // init the item view's
        TextView name;
        ImageView image;

        public MyViewHolder(View itemView) {
            super(itemView);

// get the reference of item view's
            name = (TextView) itemView.findViewById(R.id.name);
            image = (ImageView) itemView.findViewById(R.id.image);

        }
    }
}