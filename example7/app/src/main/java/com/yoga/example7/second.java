package com.yoga.example7;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by YOGA on 2016/11/20.
 */

public class second extends AppCompatActivity{

    private Button btBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        btBack = (Button) findViewById(R.id.back_activity);
        btBack.setOnClickListener(btBackListener);

    }

    private Button.OnClickListener btBackListener = new Button.OnClickListener() {
        @Override
        public void onClick(View view) {
            finish();
        }
    };
}
