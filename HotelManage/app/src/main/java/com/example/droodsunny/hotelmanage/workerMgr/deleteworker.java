package com.example.droodsunny.hotelmanage.workerMgr;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.CyberTime.biz.WorkerMgrCT;
import com.example.droodsunny.hotelmanage.R;
import com.example.droodsunny.hotelmanage.login;

public class deleteworker extends AppCompatActivity {

    SQLiteDatabase db= login.db;
    private Button button1;
    private Button button2;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deleteworker);

        button1=(Button)findViewById(R.id.ok);
        button2=(Button)findViewById(R.id.back);
        editText=(EditText)findViewById(R.id.name);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    String name=editText.getText().toString();
                    Cursor cursor = db.rawQuery("select * from worker", null);
                    while (cursor.moveToNext()) {
                        if (name.equals(cursor.getString(1))) {
                            WorkerMgrCT.delUser(name, db);
                            Toast.makeText(deleteworker.this, "删除成功", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }
                    Toast.makeText(deleteworker.this,"输入名字有误",Toast.LENGTH_SHORT).show();
                }catch (Exception s){
                    Toast.makeText(deleteworker.this,"暂无人员",Toast.LENGTH_SHORT).show();
                }


            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}
