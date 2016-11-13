package com.yoga.example2;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button entry;
    private TextView result;
    private String[] menu = {"豬肉總匯", "牛肉堡", "蘿蔔糕", "蛋沙拉", "薯餅"};
    private boolean[] check = {false, false, false, false, false};

    private  void cleanChoice(boolean[] change){
        for(int i =0 ;i<change.length;i++){
            change[i]=false;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        entry = (Button) findViewById(R.id.entry);
        result = (TextView) findViewById(R.id.result);

        entry.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                final boolean[] c = check;
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle(R.string.result)
                        .setMultiChoiceItems(menu,check, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isCheck) {
                                c[which]=isCheck;
                            }
                        })
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                check = c;
                                boolean all = false;
                                String temp = "";
                                for (int i=0;i<c.length;i++){
                                    if (c[i]) {
                                        temp += menu[i] + "\n";
                                        all = true;
                                    }
                                }
                                if (all)
                                    result.setText("您的餐點是：\n" + temp);
                                else
                                    result.setText("您沒有點餐");
                                cleanChoice(check);
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                result.setText("您取消了");
                                cleanChoice(check);
                            }
                        })
                        .show();
            }
        });
    }
}
