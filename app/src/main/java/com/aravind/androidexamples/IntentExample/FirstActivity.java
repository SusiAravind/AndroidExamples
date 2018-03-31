package com.aravind.androidexamples.IntentExample;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.aravind.androidexamples.R;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);


    }

    public void nextActivity(View view) {

        Intent nextAct = new Intent(getApplicationContext(), SecondActivity.class);
        startActivity(nextAct);

    }

    public void nextActivityWithData(View view) {

        Intent dataIntent = new Intent(getApplicationContext(), SecondActivity.class);
        dataIntent.putExtra("data", "This message from First Activity");
        startActivity(dataIntent);

    }

    public void intentWeb(View view) {
        Uri webpage = Uri.parse("http://www.google.com");
        Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(webIntent);
    }

    public void intentSEND(View view) {

        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"aravind.cse3@gmail.com"}); // recipients
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Enter subject here");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Leave a message here");
        emailIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse("content://path/to/email/attachment"));
        startActivity(emailIntent);

    }

    public void intentInsert(View view) {
        Intent calendarIntent = new Intent(Intent.ACTION_INSERT, CalendarContract.Events.CONTENT_URI);
        calendarIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, System.currentTimeMillis());
        calendarIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, System.currentTimeMillis());
        calendarIntent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, true);
        calendarIntent.putExtra(CalendarContract.Events.TITLE, "Aravind's Birthday");
        calendarIntent.putExtra(CalendarContract.Events.DESCRIPTION, "This is a sample description");
        calendarIntent.putExtra(CalendarContract.Events.EVENT_LOCATION, "India");
        startActivity(calendarIntent);
    }

    public void openApp(View view) {

        Intent i = getPackageManager().getLaunchIntentForPackage("com.whatsapp");
        if (i == null) {
            i.addCategory(Intent.CATEGORY_LAUNCHER);
            startActivity(i);
        } else {
            try {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + "com.whatsapp")));
            } catch (android.content.ActivityNotFoundException anfe) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" + "com.whatsapp")));
            }
        }
    }
}
