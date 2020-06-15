package com.example.activity_test;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaplayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnFinish=findViewById(R.id.btnFinish);
        Button btnDial=findViewById(R.id.btnDial);
        Button btnPage2=findViewById(R.id.btnPage2);
        Button btnPlay=findViewById(R.id.play_button);

        //sharing myListener Click event
        btnFinish.setOnClickListener(myListener);
        btnDial.setOnClickListener(myListener);
        btnPage2.setOnClickListener(myListener);
        btnPlay.setOnClickListener(myListener);
        Toast.makeText(getApplicationContext(),"OnCreate(1)",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStart(){
        super.onStart();
        Toast.makeText(getApplicationContext(),"Onstart(1)",Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onResume(){
        super.onResume();
        Toast.makeText(getApplicationContext(),"onResume(1)",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Toast.makeText(getApplicationContext(),"onRestart(1)",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause(){
        super.onPause();
        Toast.makeText(getApplicationContext(),"onPause(1)",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop(){
        super.onStop();
        Toast.makeText(getApplicationContext(),"onStop(1)",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Toast.makeText(getApplicationContext(),"onDestroy(1)",Toast.LENGTH_LONG).show();
    }


    private Button.OnClickListener myListener=new Button.OnClickListener(){
        public void onClick(View v){
            if (v.getId() == R.id.btnDial){
                Uri uri= Uri.parse("tel:0999123456");
                Intent intent=new Intent(Intent.ACTION_DIAL,uri);
                startActivity(intent);
            }else if(v.getId() == R.id.btnPage2){
                Intent intent=new Intent();
                intent.setClass(MainActivity.this,Second.class);
                startActivity(intent);
            }else if(v.getId() == R.id.play_button){
                mediaplayer=MediaPlayer.create(getApplicationContext(),R.raw.bai_ri);
                mediaplayer.start();
            }else if (v.getId() == R.id.btnFinish) finish();
        }
    };
}
