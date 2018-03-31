package com.aravind.androidexamples.RecyclerViewExample;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.amulyakhare.textdrawable.util.ColorGenerator;
import com.aravind.androidexamples.ListViewExample.ListPojo;
import com.aravind.androidexamples.R;

import java.util.List;

/**
 * Created by Aravind on 3/31/2018.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    List<ListPojo> listPojos;
    ColorGenerator mColorGenerator = ColorGenerator.DEFAULT;
TextDrawable mDrawableBuilder;
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View listView= LayoutInflater.from(parent.getContext()).inflate(R.layout.sql_item,parent,false);



        return new ViewHolder(listView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {


        ListPojo listPojo=listPojos.get(position);

        holder.name.setText(listPojo.getName());
        holder.email.setText(listPojo.getNumber());


        String nn = listPojo.getName();

        String letter = "A";

        if (nn != null && !nn.isEmpty()) {
            letter = nn.substring(0, 1);
        }
        int color = mColorGenerator.getRandomColor();

        // Create a circular icon consisting of  a random background colour and first letter of title
        mDrawableBuilder = TextDrawable.builder()
                .buildRound(letter, color);
        holder.imageView.setImageDrawable(mDrawableBuilder);

    }

    @Override
    public int getItemCount() {
        return listPojos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name, email;
        public ImageView imageView;


        public ViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.sql_name);
            email = (TextView) view.findViewById(R.id.sql_phone);
            imageView = view.findViewById(R.id.sql_image);

        }
    }

    public RecyclerAdapter(List<ListPojo> listPojos) {
        this.listPojos = listPojos;
    }
}
