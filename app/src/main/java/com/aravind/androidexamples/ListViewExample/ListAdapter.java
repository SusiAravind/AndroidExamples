package com.aravind.androidexamples.ListViewExample;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.amulyakhare.textdrawable.util.ColorGenerator;
import com.aravind.androidexamples.R;
import com.aravind.androidexamples.SqliteExample.DBHelper;
import com.aravind.androidexamples.SqliteExample.SqlAdapter;

import java.util.ArrayList;

/**
 * Created by Design Experts on 3/31/2018.
 */

public class ListAdapter extends ArrayAdapter<ListPojo> {
    ArrayList<ListPojo> listPojos;
    Context context;
    ViewHolder viewHolder;


    public ListAdapter(@NonNull Context context, ArrayList<ListPojo> listPojos) {
        super(context, 0,listPojos);

        this.listPojos=listPojos;
        this.context=context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ListPojo listPojo= getItem(position);

        ColorGenerator mColorGenerator = ColorGenerator.DEFAULT;
        TextDrawable mDrawableBuilder;
        final View result;



        if (convertView == null) {

            viewHolder = new ViewHolder();

            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.sql_item, parent, false);
            viewHolder.name = convertView.findViewById(R.id.sql_name);
            viewHolder.number = convertView.findViewById(R.id.sql_phone);
            viewHolder.imageView = convertView.findViewById(R.id.sql_image);

            result = convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }



        String name=listPojo.getName();
        String number=listPojo.getNumber();


        String nn = name;

        String letter = "A";

        if (nn != null && !nn.isEmpty()) {
            letter = nn.substring(0, 1);
        }
        int color = mColorGenerator.getRandomColor();

        // Create a circular icon consisting of  a random background colour and first letter of title
        mDrawableBuilder = TextDrawable.builder()
                .buildRound(letter, color);
        viewHolder.imageView.setImageDrawable(mDrawableBuilder);
        viewHolder.name.setText(name);
        viewHolder.number.setText(number);
        // Return the completed view to render on screen
        return convertView;
    }

    public class ViewHolder{



        TextView name,number;
        ImageView imageView;


    }
}
