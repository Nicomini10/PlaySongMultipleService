package com.example.playsongservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void playSong(View view){

        Intent myIntent = new Intent(this, PlaySongService.class);

        this.startService(myIntent);

    }


    public void stopSong(View view){

        Intent myIntent = new Intent(this, PlaySongService.class);
        this.stopService(myIntent);
    }
}
