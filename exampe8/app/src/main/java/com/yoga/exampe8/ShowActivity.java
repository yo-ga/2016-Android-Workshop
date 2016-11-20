package com.yoga.exampe8;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class ShowActivity extends AppCompatActivity {

    private Bundle mBundle;
    private Intent mIntent;
    private Button btBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        mIntent = this.getIntent();
        mBundle = mIntent.getExtras();
        String gender = mBundle.getString("gender");
        Double height = mBundle.getDouble("height");
        Double weight = mBundle.getDouble("weight");
        String result = this.getBmi(height, weight);
        String advice = this.getAdvice(gender, height, weight);

        TextView tvBmi = (TextView) findViewById(R.id.tvBmi);
        tvBmi.setText(result);
        TextView tvAdv = (TextView) findViewById(R.id.tvAdvice);
        tvAdv.setText(advice);

        btBack = (Button) findViewById(R.id.btBack);
        btBack.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowActivity.this.setResult(RESULT_OK, mIntent);
                ShowActivity.this.finish();
            }
        });
    }

    private String format(double num) {
        DecimalFormat nf = new DecimalFormat("0.00");
        String s = nf.format(num);
        return s;
    }

    private String getAdvice(String gender, Double height, Double weight) {
        boolean suit;
        double bmi = weight /(height*height);
        double bmiMax, bmiMin;
        if (gender.equals("M")){
            bmiMax=25.0;
            bmiMin=22.0;
        }
        else{
            bmiMax=22.0;
            bmiMin=18.0;
        }
        if (bmi>bmiMax)
            return "您過重了！請注意";
        else if(bmi < bmiMin)
            return "您過輕了！請注意";
        else
            return "恭喜正常！";
    }

    private String getBmi(Double height, Double weight) {
        double bmi = weight /(height*height);
        return "您的 BMI 結果為"+format(bmi);
    }

}
