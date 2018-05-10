package com.example.windows.myfoodapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AboutMeActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);
    }

    public void clickback(View view) {
        finish();
    }

    public void playSound(View view) {
        if (mediaPlayer != null) {
            mediaPlayer.stop();// ถ้ามีให้หยุดเล่น
            mediaPlayer.release();

        }
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.sound);
        mediaPlayer.start();
    }

    public void clickMap(View view) {
        String lat ="3.776233";
        String lng = "100.510757";
        String label = "มหาวิทยาลัยสวนดุสิต";
        Uri location = Uri.parse("http://map.google.com/maps?z=10&q=loc:" + lat + "," + lng + "(" + label + ")");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW,location);
        ///mapIntent.setPackage("com.google.android.app.maps");
        startActivity(mapIntent);


    }


}
