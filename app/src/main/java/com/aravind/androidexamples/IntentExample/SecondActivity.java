package com.aravind.androidexamples.IntentExample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.aravind.androidexamples.R;

public class SecondActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textView = findViewById(R.id.textViewIntent);

        textView.setText("No Intent data");

        Intent intent = getIntent();

        if (intent != null) {

            textView.setText(intent.getStringExtra("data"));
        }else {

            textView.setText("No Intent data");
        }


    }
}
