package com.example.hariprasad.assignment11;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.io.IOException;


public class MainActivity extends Activity implements View.OnClickListener{

    MediaPlayer anthemSong;

    Button Song0, Song1, SONG2, SONG3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout mainLayout = new LinearLayout(this);
        mainLayout.setOrientation(LinearLayout.VERTICAL);
        mainLayout.setGravity(Gravity.CENTER);
        mainLayout.setBackgroundResource(R.drawable.haripic);

        Song0 = new Button(this);
        Song0.setBackgroundColor(Color.DKGRAY);
        Song0.setText(" Song0 chitiya kalaiya ");
        Song0.setTextSize(25);
        Song0.setTypeface(null, Typeface.BOLD);
        Song0.setPadding(5, 5, 5, 5);
        mainLayout.addView(Song0);

        Song0.setOnClickListener(this);

        Song1 = new Button(this);
        Song1.setBackgroundColor(Color.BLUE);
        Song1.setText("Song1 JEENA JEENA ");
        Song1.setTextSize(25);
        Song1.setTypeface(null, Typeface.BOLD);
        Song1.setPadding(5, 5, 5, 5);
        mainLayout.addView(Song1);

        Song1.setOnClickListener(this);

        SONG2 = new Button(this);
        SONG2.setBackgroundColor(Color.DKGRAY);
        SONG2.setText("SONG2 SUN SATHIYA ");
        SONG2.setTextSize(25);
        SONG2.setTypeface(null, Typeface.BOLD);
        SONG2.setPadding(5, 5, 5, 5);
        mainLayout.addView(SONG2);

        SONG2.setOnClickListener(this);

        SONG3 = new Button(this);
        SONG3.setBackgroundColor(Color.BLUE);
        SONG3.setText("SONG3 SOORAJ B");
        SONG3.setTextSize(25);
        SONG3.setTypeface(null, Typeface.BOLD);
        SONG3.setPadding(5, 5, 5, 5);
        mainLayout.addView(SONG3);

        SONG3.setOnClickListener(this);
        setContentView(mainLayout);
    }

    @Override
    public void onClick(View v) {

        Log.e("onClick", "Started");

        Button b = (Button)v;
        String buttontext = b.getText().toString();

        Log.e("ButtonText", ""+buttontext);

        if(anthemSong == null)
            anthemSong = MediaPlayer.create(getApplicationContext(), R.raw.jeena_jeena);


        anthemSong.start();

        anthemSong.setOnPreparedListener(songPListener);
        anthemSong.setOnCompletionListener(songCListener);

    }

    private MediaPlayer.OnPreparedListener songPListener = new MediaPlayer.OnPreparedListener()
    {
        @Override
        public void onPrepared(MediaPlayer mp)
        {
           // playSong();
        }
    };

    private MediaPlayer.OnCompletionListener songCListener = new MediaPlayer.OnCompletionListener()
    {
        @Override
        public void onCompletion(MediaPlayer mp)
        {
            //playSong();
        }
    };

    public void playSong()
    {
        Log.e("playSong", "Started");

        if (anthemSong.isPlaying())
        {
            anthemSong.stop();
            anthemSong.release();
            Log.e("playSong", "Stopped");
        }
/*        if(anthemSong.getCurrentPosition() != 1)
        {
            //anthemSong.seekTo(1);
            Log.e("playSong", "Seek");
        }*/
       // anthemSong.start();
    }
}
