package com.yoga.workshop20161112;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText ed1;
    private Button btn;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = (EditText) findViewById(R.id.ed1);
        btn = (Button) findViewById(R.id.button);
        tv1 = (TextView) findViewById(R.id.textReview);
        btn.setOnClickListener(btnViewText);
    }

    private  Button.OnClickListener btnViewText = new Button.OnClickListener(){
        @Override
        public void onClick(View view) {
            tv1.setText(ed1.getText());
        }
    };
}
