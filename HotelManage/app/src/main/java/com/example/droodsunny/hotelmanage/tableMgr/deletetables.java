package com.example.droodsunny.hotelmanage.tableMgr;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.CyberTime.biz.TableMgrCT;
import com.example.droodsunny.hotelmanage.R;
import com.example.droodsunny.hotelmanage.login;

public class deletetables extends AppCompatActivity {

    SQLiteDatabase db= login.db;
    private Button button1;
    private  Button button2;
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deletetables);

        button1=(Button)findViewById(R.id.ok);
        button2=(Button)findViewById(R.id.back);
        editText=(EditText)findViewById(R.id.editText);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    String id=editText.getText().toString();
                    Cursor cursor = db.rawQuery("select * from tables", null);
                    while (cursor.moveToNext()) {
                        if (id.equals(cursor.getString(0))) {
                            try {
                                TableMgrCT.delTable(id, db);
                                Toast.makeText(deletetables.this, "删除成功", Toast.LENGTH_SHORT).show();
                            } catch (SQLiteException s) {
                                s.printStackTrace();
                            }
                            return;
                        }
                    }
                    Toast.makeText(deletetables.this, "输入有误", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Toast.makeText(deletetables.this, "暂无桌台", Toast.LENGTH_SHORT).show();
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
