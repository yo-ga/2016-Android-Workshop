package com.yoga.example10;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvShow;
    private Button btBuild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvShow = (TextView) findViewById(R.id.tvShow);
        btBuild = (Button) findViewById(R.id.btBuild);

        btBuild.setOnClickListener(btListener);
    }

    private Button.OnClickListener btListener = new Button.OnClickListener() {
        @Override
        public void onClick(View view) {
            SQLiteDatabase db = openOrCreateDatabase("test.db",MODE_PRIVATE,null);

            tvShow.setText("資料庫路徑："+db.getPath()+"\n資料庫分頁大小："+db.getPageSize()
                    +"\n資料量上限："+db.getMaximumSize());
            db.close();
        }
    };
}
