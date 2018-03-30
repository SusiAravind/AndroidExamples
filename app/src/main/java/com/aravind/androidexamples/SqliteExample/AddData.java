package com.aravind.androidexamples.SqliteExample;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.aravind.androidexamples.R;


public class AddData extends AppCompatActivity {

    EditText name, phone, email, street, place;
    String sName, sPhone, sEmail, sStreet, sPlace;
    Button save,update;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);

        name = findViewById(R.id.name);
        phone = findViewById(R.id.phone);
        email = findViewById(R.id.email);
        street = findViewById(R.id.street);
        place = findViewById(R.id.place);
        save = findViewById(R.id.save);
        update = findViewById(R.id.update);
        update.setVisibility(View.GONE);


        final DBHelper dbHelper = new DBHelper(AddData.this);

        Intent gI=getIntent();
        id=gI.getIntExtra("id",0);

        if (id==1){

            update.setVisibility(View.VISIBLE);

            save.setVisibility(View.GONE);

            Cursor rs = dbHelper.getData(id);
            rs.moveToFirst();

            String nam = rs.getString(rs.getColumnIndex(DBHelper.CONTACTS_COLUMN_NAME));
            String phon = rs.getString(rs.getColumnIndex(DBHelper.CONTACTS_COLUMN_PHONE));
            String emai = rs.getString(rs.getColumnIndex(DBHelper.CONTACTS_COLUMN_EMAIL));
            String stree = rs.getString(rs.getColumnIndex(DBHelper.CONTACTS_COLUMN_STREET));
            String plac = rs.getString(rs.getColumnIndex(DBHelper.CONTACTS_COLUMN_CITY));


            name.setText(nam);
            phone.setText(phon);
            email.setText(emai);
            street.setText(stree);
            place.setText(plac);




        }




        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sName = name.getText().toString();
                sPhone = phone.getText().toString();
                sEmail = email.getText().toString();
                sStreet = street.getText().toString();
                sPlace = place.getText().toString();

                dbHelper.insertContact(sName, sPhone, sEmail, sStreet, sPlace);

                Intent intent=new Intent(getApplicationContext(),SqliteMain.class);
                startActivity(intent);
                finish();


            }
        });


        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sName = name.getText().toString();
                sPhone = phone.getText().toString();
                sEmail = email.getText().toString();
                sStreet = street.getText().toString();
                sPlace = place.getText().toString();

                dbHelper.updateContact(id,sName, sPhone, sEmail, sStreet, sPlace);

                Intent intent=new Intent(getApplicationContext(),SqliteMain.class);
                startActivity(intent);
                finish();


            }
        });


    }
}
