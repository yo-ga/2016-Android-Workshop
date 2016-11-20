package com.yoga.exampe8;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etHeight;
    private EditText etWeight;
    private RadioButton rbMale;
    private RadioButton rbFemale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etHeight = (EditText) findViewById(R.id.etHeight);
        etWeight = (EditText) findViewById(R.id.etWeight);
        rbMale = (RadioButton) findViewById(R.id.rdMale);
        rbFemale = (RadioButton) findViewById(R.id.rdFemale);

        Button btCalcu = (Button) findViewById(R.id.btCalcu);
        btCalcu.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                double height, weight;
                try {
                    height = Double.parseDouble(etHeight.getText().toString());
                    weight = Double.parseDouble(etWeight.getText().toString());
                    String gender = "";
                    if (rbMale.isChecked())
                        gender = "M";
                    else
                        gender = "F";

                    Intent intent = new Intent(MainActivity.this, ShowActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putDouble("height", height);
                    bundle.putDouble("weight", weight);
                    bundle.putString("gender", gender);
                    intent.putExtras(bundle);
                    startActivityForResult(intent, 0);
                } catch (Exception e) {
                    Toast toast = Toast.makeText(MainActivity.this,"Error Input",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (resultCode) {
            case RESULT_OK:
                Bundle bundle = data.getExtras();
                String gender = bundle.getString("gender");
                Double height = bundle.getDouble("height");
                Double weight = bundle.getDouble("weight");
                etHeight.setText("");
                etWeight.setText("");
                rbFemale.setChecked(false);
                rbMale.setChecked(false);
                break;
            default:
                break;
        }
    }
}
