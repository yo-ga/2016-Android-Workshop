package com.yoga.example3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private TextView tv;
    private TextView choice;
    private String[] types = {"請選擇：", "HTC 10", "Samsung Galaxy S7", "Sony Xperia Z5", "OPPO Z5", "ASUS ZenFone3", "HUA WEI P9", "LG Zero" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner= (Spinner) findViewById(R.id.spinner);
        tv = (TextView) findViewById(R.id.text_spinner);
        choice = (TextView) findViewById(R.id.text);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner,types);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 0){
                    choice.setText(R.string.no_choice);
                }
                else{
                    choice.setText((String) getResources().getText(R.string.no_choice)+types[i]);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
