package com.aravind.androidexamples.SharedPref;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.aravind.androidexamples.R;

public class SharedPrefActivity extends AppCompatActivity {

    String SharedPrefName = "spData";
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    EditText name, phone;
    Button save, retrieve;
    TextView tx_name, tx_phone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_pref);


        //initialize

        sharedPreferences = getSharedPreferences(SharedPrefName, MODE_PRIVATE);
        editor = sharedPreferences.edit();

        name = findViewById(R.id.sp_name);
        phone = findViewById(R.id.sp_phone);
        save = findViewById(R.id.sp_save);
        retrieve = findViewById(R.id.sp_retrieve);
        tx_name = findViewById(R.id.sp_tx_name);
        tx_phone = findViewById(R.id.sp_tx_phone);

        //save data to shared preference
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if ( name.getText().toString().isEmpty()|| phone.getText().toString().isEmpty()){

                    Toast.makeText(SharedPrefActivity.this, "Field Cannot be empty", Toast.LENGTH_SHORT).show();


                }else {

                    editor.putString("name", name.getText().toString());
                    editor.putString("phone", phone.getText().toString());
                    editor.commit();

                    name.setText("");
                    phone.setText("");

                    Toast.makeText(SharedPrefActivity.this, "Successfully  saved to shared preference", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //retrieve data from shared preference
        retrieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String sName = sharedPreferences.getString("name", null);
                String sPhone = sharedPreferences.getString("phone", null);

                if (sName != null && sPhone != null) {
                    tx_name.setText(sName);
                    tx_phone.setText(sPhone);
                }


            }
        });


    }
}
