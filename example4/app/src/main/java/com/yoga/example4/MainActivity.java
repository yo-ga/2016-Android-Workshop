package com.yoga.example4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Spinner spVolt;
    private EditText etAmp;
    private EditText etHr;
    private EditText etFee;
    private Button btCal;
    private TextView tvResult;

    protected int vol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spVolt = (Spinner) findViewById(R.id.sp_vol);
        etAmp = (EditText) findViewById(R.id.et_amp);
        etHr = (EditText) findViewById(R.id.et_hr);
        etFee = (EditText) findViewById(R.id.et_fee);
        btCal = (Button) findViewById(R.id.bt_cal);
        tvResult = (TextView) findViewById(R.id.tv_result);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(MainActivity.this, R.array.option_voltage, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spVolt.setAdapter(adapter);

        btCal.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                spVolt.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> mAdapter, View mView, int mItem, long mId) {
                        vol = mAdapter.getSelectedItemPosition();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });

                int mVolt ;
                if (vol==0)
                    mVolt=110;
                else
                    mVolt=220;

                double mAmp = Double.parseDouble(etAmp.getText().toString());
                int mHr = Integer.parseInt(etHr.getText().toString());
                int mFee = Integer.parseInt(etFee.getText().toString());

                double mWal = mAmp*mVolt;
                int mResult = (int) Math.round(mWal*mHr*30*mFee/1000);
                tvResult.setText(new Integer(mResult).toString());
            }
        });

        // W = V * A
        // Fee = (W/1000)*(hr/Day * 30)* $/degree
    }
}
