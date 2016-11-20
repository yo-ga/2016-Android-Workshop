package com.yoga.example9;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPlayer = new MediaPlayer();
        mPlayer = MediaPlayer.create(MainActivity.this,R.raw.light);
        mPlayer.setLooping(true);
    }

    @Override
    protected void onPause() {
        try{
            mPlayer.stop();
        }catch (Exception e){
            e.printStackTrace();
        }

        super.onPause();
    }

    @Override
    protected void onPostResume() {
        try{
            if(mPlayer!=null)
                mPlayer.stop();
            mPlayer.prepare();
            mPlayer.start();
        }catch (Exception e){
            e.printStackTrace();
        }
        super.onPostResume();
    }
}
