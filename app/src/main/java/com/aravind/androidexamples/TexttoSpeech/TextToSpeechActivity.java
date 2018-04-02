package com.aravind.androidexamples.TexttoSpeech;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.aravind.androidexamples.R;

import java.util.Locale;

public class TextToSpeechActivity extends AppCompatActivity {


    TextToSpeech textToSpeech;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_to_speech);
        textView = findViewById(R.id.textForSpeech);


        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    textToSpeech.setLanguage(Locale.UK);
                }
            }
        });

    }

    public void textSpeech(View view) {
        textToSpeech.speak(textView.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
    }


    public void onPause() {
        if (textToSpeech != null) {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
        super.onPause();
    }

}
