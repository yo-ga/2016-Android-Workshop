package com.yoga.example7;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btChange = (Button) findViewById(R.id.chang_activity);
        btChange.setOnClickListener(btListener);
    }

    private Button.OnClickListener btListener = new Button.OnClickListener(){
        @Override
        public void onClick(View view){
            Intent intent = new Intent();
            intent.setClass(MainActivity.this,second.class);
            startActivity(intent);
        }
    };
}
