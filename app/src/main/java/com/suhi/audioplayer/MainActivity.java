package com.suhi.audioplayer;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button_play,button_pause,button_stop;
    MediaPlayer player;
    //for checking sound is playing or not
    boolean isPlaying=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_play=findViewById(R.id.button_play);
        button_pause=findViewById(R.id.button_pause);
        button_stop=findViewById(R.id.button_stop);

        player=MediaPlayer.create(MainActivity.this,R.raw.audio);

        button_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isPlaying==false)
                {
                    player.start();
                    isPlaying=true;//sound is now playing
                    button_play.setBackgroundColor(Color.BLUE);
                }


            }
        });

        button_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isPlaying==true)
                {
                    player.pause();
                    isPlaying=false;//sound is now playing
                }




            }
        });

        button_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isPlaying==true)
                {
                    player.stop();
                    isPlaying=false;//sound is now playing
                }

                MainActivity.this.finish();


            }
        });
    }

    @Override
    protected void onPause() {

        player.pause();
        super.onPause();
    }

//    @Override
//    protected void onResume() {
//
//        player.start();
//        super.onResume();
//    }
}
