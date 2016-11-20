package com.yoga.example6;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etATM;
    private Button btOne, btTwo, btThree;
    private Button btFour, btFive, btSix,
                    btSeven, btEight, btNine,
                    btOk, btZero, btBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etATM = (EditText) findViewById(R.id.etATM);
        btOne = (Button) findViewById(R.id.btOne);
        btTwo = (Button) findViewById(R.id.btTwo);
        btThree = (Button) findViewById(R.id.btThree);
        btFour = (Button) findViewById(R.id.btFour);
        btFive = (Button) findViewById(R.id.btFive);
        btSix = (Button) findViewById(R.id.btSix);
        btSeven = (Button) findViewById(R.id.btSeven);
        btEight = (Button) findViewById(R.id.btEight);
        btNine = (Button) findViewById(R.id.btNine);
        btOk = (Button) findViewById(R.id.btOk);
        btZero = (Button) findViewById(R.id.btZero);
        btBack = (Button) findViewById(R.id.btBack);

        btOne.setOnClickListener(kbListener);
        btTwo.setOnClickListener(kbListener);
        btThree.setOnClickListener(kbListener);
        btFour.setOnClickListener(kbListener);
        btFive.setOnClickListener(kbListener);
        btSix.setOnClickListener(kbListener);
        btSeven.setOnClickListener(kbListener);
        btEight.setOnClickListener(kbListener);
        btNine.setOnClickListener(kbListener);
        btOk.setOnClickListener(kbListener);
        btZero.setOnClickListener(kbListener);
        btBack.setOnClickListener(kbListener);
    }

    private Button.OnClickListener kbListener = new Button.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btOne:
                    display("1");
                    break;
                case R.id.btTwo:
                    display("2");
                    break;
                case R.id.btThree:
                    display("3");
                    break;
                case R.id.btFour:
                    display("4");
                    break;
                case R.id.btFive:
                    display("5");
                    break;
                case R.id.btSix:
                    display("6");
                    break;
                case R.id.btSeven:
                    display("7");
                    break;
                case R.id.btEight:
                    display("8");
                    break;
                case R.id.btNine:
                    display("9");
                    break;
                case R.id.btZero:
                    display("0");
                    break;
                case R.id.btBack:
                    String str = etATM.getText().toString();
                    if (str.length()>0){
                        str = str.substring(0, str.length()-1);
                        etATM.setText(str);
                    }
                    break;
                case R.id.btOk:
                    str = etATM.getText().toString();
                    if (str.equals("465465")){
                        Toast toast = Toast.makeText(MainActivity.this, "Good!"+str.hashCode() ,Toast.LENGTH_LONG);
                        toast.show();
                    }
                    else{
                        Toast toast = Toast.makeText(MainActivity.this, "Wrong",Toast.LENGTH_LONG);
                        toast.show();
                        etATM.setText("");
                    }
                    break;
            }
        }
    };

    private void display(String s){
        String str = etATM.getText().toString();
        etATM.setText(str+s);
    }


}
