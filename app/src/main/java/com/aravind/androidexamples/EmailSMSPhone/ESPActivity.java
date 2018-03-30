package com.aravind.androidexamples.EmailSMSPhone;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.aravind.androidexamples.R;


public class ESPActivity extends AppCompatActivity {

    private static final int MY_PERMISSIONS_REQUEST = 0;

    EditText email, subject, message, number, sms, call_number;
    CardView sendEmail, sendSMS;
    CardView call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esp);


        email = findViewById(R.id.email);
        subject = findViewById(R.id.subject);
        message = findViewById(R.id.message1);
        number = findViewById(R.id.number);
        sms = findViewById(R.id.sms);
        call_number = findViewById(R.id.call_number);
        sendEmail = findViewById(R.id.email_send);
        sendSMS = findViewById(R.id.sms_send);
        call = findViewById(R.id.call);



        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[]{
                            Manifest.permission.SEND_SMS,
                            Manifest.permission.CALL_PHONE},
                    MY_PERMISSIONS_REQUEST);

        }



        sendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (email.getText().toString().isEmpty() || subject.getText().toString().isEmpty()|| message.getText().toString().isEmpty()){



                    if (email.getText().toString().isEmpty()){

                        email.setError("enter email address");


                    } else if (subject.getText().toString().isEmpty()){

                        subject.setError("enter the subject");


                    }else if (message.getText().toString().isEmpty()){

                        subject.setError("enter the message");


                    }


                    Toast.makeText(ESPActivity.this, "Enter all fields", Toast.LENGTH_SHORT).show();


                }else {

                    sendEmails(email.getText().toString(), subject.getText().toString(), message.getText().toString());


                }

            }
        });

        sendSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (number.getText().toString().isEmpty() || sms.getText().toString().isEmpty()){

                    if (number.getText().toString().isEmpty()){

                        email.setError("enter the number");


                    } else if (sms.getText().toString().isEmpty()){

                        subject.setError("enter the message");


                    }

                }else {

                    sendSMSMessage(number.getText().toString(), sms.getText().toString());

                }


            }
        });


        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (call_number.getText().toString().isEmpty()){

                    call_number.setError("enter the mobile number");

                }else {

                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:"+call_number.getText().toString()));

                    if (ActivityCompat.checkSelfPermission(ESPActivity.this,
                            Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        return;
                    }
                    startActivity(callIntent);
                }

            }

        });

    }

    protected void sendSMSMessage(String phoneNo,String smsMessage) {

        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(phoneNo, null, smsMessage, null, null);
        Toast.makeText(getApplicationContext(), "SMS sent.",
                Toast.LENGTH_LONG).show();

    }


    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST:

                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                } else {

                }
                return;
        }
    }

    protected void sendEmails(String email, String subject, String message) {
        String[] TO = {email};
        String[] CC = {""};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        emailIntent.putExtra(Intent.EXTRA_TEXT, message);
        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(ESPActivity.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }
}
