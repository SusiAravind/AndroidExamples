package com.aravind.androidexamples.SplashScreenExample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.aravind.androidexamples.Alert.AlertDialog;
import com.aravind.androidexamples.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        ImageView imageView=findViewById(R.id.splash);


        Glide.with(SplashScreen.this).load(R.drawable.android_animation).asGif().diskCacheStrategy(DiskCacheStrategy.SOURCE).crossFade().into(imageView);

        Button go=findViewById(R.id.go);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                        Intent i = new Intent(SplashScreen.this, AlertDialog.class);
                        startActivity(i);
                        // close this activity
                        finish();
            }
        });

        
    }
}
