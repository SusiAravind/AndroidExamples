package com.aravind.androidexamples.SqliteExample;

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

import java.util.ArrayList;

/**
 * Created by Design Experts on 3/30/2018.
 */

public class SqlAdapter extends ArrayAdapter {

    ArrayList arrayList;
    Context context;

    DBHelper mydb;

    public SqlAdapter(@NonNull Context context, ArrayList arrayList) {
        super(context, 0, arrayList);
        this.arrayList = arrayList;
        this.context = context;
        mydb = new DBHelper(context);

    }


    @Override
    public int getPosition(@Nullable Object item) {
        return super.getPosition(item);
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder;
        ColorGenerator mColorGenerator = ColorGenerator.DEFAULT;
        TextDrawable mDrawableBuilder;
        final View result;


        if (convertView == null) {


            viewHolder = new ViewHolder();

            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.sql_item, parent, false);
            viewHolder.txtName =  convertView.findViewById(R.id.sql_name);
            viewHolder.info = convertView.findViewById(R.id.sql_phone);
            viewHolder.letterImage = convertView.findViewById(R.id.sql_image);

            result = convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }



        Cursor rs = mydb.getData(position + 1);
        rs.moveToFirst();

        String nam = rs.getString(rs.getColumnIndex(DBHelper.CONTACTS_COLUMN_NAME));
        String phon = rs.getString(rs.getColumnIndex(DBHelper.CONTACTS_COLUMN_PHONE));
        String emai = rs.getString(rs.getColumnIndex(DBHelper.CONTACTS_COLUMN_EMAIL));
        String stree = rs.getString(rs.getColumnIndex(DBHelper.CONTACTS_COLUMN_STREET));
        String plac = rs.getString(rs.getColumnIndex(DBHelper.CONTACTS_COLUMN_CITY));

        String nn = nam;

        String letter = "A";

        if (nn != null && !nn.isEmpty()) {
            letter = nn.substring(0, 1);
        }
        int color = mColorGenerator.getRandomColor();

        // Create a circular icon consisting of  a random background colour and first letter of title
        mDrawableBuilder = TextDrawable.builder()
                .buildRound(letter, color);
        viewHolder.letterImage.setImageDrawable(mDrawableBuilder);
        //  viewHolder.letterImage.setVisibility(View.VISIBLE);

        viewHolder.txtName.setText(nam);
        viewHolder.info.setText(phon);
        // Return the completed view to render on screen
        return convertView;

    }

    // View lookup cache
    private class ViewHolder {
        TextView txtName;
        TextView info;
        ImageView letterImage;
    }
}

