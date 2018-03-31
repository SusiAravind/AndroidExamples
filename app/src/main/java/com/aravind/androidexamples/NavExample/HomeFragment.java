package com.aravind.androidexamples.NavExample;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.aravind.androidexamples.Alert.AlertDialog;
import com.aravind.androidexamples.R;

/**
 * Created by Design Experts on 3/31/2018.
 */

public class HomeFragment extends Fragment{


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_home,container,false);


        Button alert=view.findViewById(R.id.home);
        alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                android.app.AlertDialog.Builder builder=new android.app.AlertDialog.Builder(getContext());
                builder.setMessage("Welcome Home");
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        return;


                    }
                });

                builder.show();

            }
        });




        return view;
    }
}
