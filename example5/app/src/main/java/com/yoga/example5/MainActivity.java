package com.yoga.example5;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private EditText edName;
    private RadioButton rbMan;
    private RadioButton rbWoman;
    private CheckBox cbEat;
    private CheckBox cbSleep;
    private CheckBox cbPlay;
    private CheckBox cbSurf;
    private Button btSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edName = (EditText) findViewById(R.id.et_name);
        rbMan = (RadioButton) findViewById(R.id.bt_man);
        rbWoman = (RadioButton) findViewById(R.id.bt_woman);
        cbEat = (CheckBox) findViewById(R.id.cb_eat);
        cbSleep = (CheckBox) findViewById(R.id.cb_sleep);
        cbPlay = (CheckBox) findViewById(R.id.cb_play);
        cbSurf = (CheckBox) findViewById(R.id.cb_surf);
        btSend = (Button) findViewById(R.id.bt_result);

        btSend.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mName = "";
                if (!edName.getText().toString().equals("")){
                    mName += "用戶：" + edName.getText().toString() + "\n";
                }
                else {
                    mName += "您未填寫姓名\n";
                }

                if (rbMan.isChecked())
                    mName += "您是帥哥！\n";
                else if(rbWoman.isChecked())
                    mName += "您是美女！\n";
                else
                    mName += "未選擇性別！\n";

                mName += "您的興趣有";

                int count = 0;
                if(cbEat.isChecked()){
                    count++;
                    mName += "，" + cbEat.getText().toString();
                }
                if(cbSleep.isChecked()){
                    count++;
                    mName += "，" + cbSleep.getText().toString() ;
                }
                if(cbSurf.isChecked()){
                    count++;
                    mName += "，" + cbSurf.getText().toString() ;
                }
                if(cbPlay.isChecked()){
                    count++;
                    mName += "，" + cbPlay.getText().toString() ;
                }
                if(count==0)
                    mName += "，沒有勾選";
                mName += "。";

                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("興趣調查結果")
                        .setMessage(mName)
                        .setPositiveButton("離開", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .show();
                FirebaseDatabase database = FirebaseDatabase.getInstance() ;
                DatabaseReference myRef = database.getReference("message");

                myRef.setValue("Test");
            }
        });

    }
}
