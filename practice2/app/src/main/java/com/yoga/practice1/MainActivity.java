package com.yoga.practice1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText land;
    private EditText rate;
    private EditText number;
    private Button btn;
    private TextView result;
    private Button cleaner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        land = (EditText) findViewById(R.id.land);
        rate = (EditText) findViewById(R.id.rate);
        number = (EditText) findViewById(R.id.month);
        btn = (Button) findViewById(R.id.button);
        result = (TextView) findViewById(R.id.result);
        cleaner = (Button) findViewById(R.id.cleaner);

        btn.setOnClickListener(calculate);
        cleaner.setOnClickListener(clean);
    }

    private Button.OnClickListener calculate = new Button.OnClickListener(){

        @Override
        public void onClick(View view) {
            DecimalFormat nf = new DecimalFormat("0.00");

            double mon = (double) Integer.valueOf(land.getText().toString());
            double rat = (double) Integer.valueOf(rate.getText().toString())/1200;
            double num = (double) Integer.valueOf(number.getText().toString());

            double mon_all = mon * Math.pow(rat+1,num);

            result.setText("總額為"+ nf.format(mon_all));

        }
    };

    private Button.OnClickListener clean = new Button.OnClickListener() {
        @Override
        public void onClick(View view) {
            land.setText("");
            rate.setText("");
            number.setText("");
            result.setText("總額");
        }
    };
}
