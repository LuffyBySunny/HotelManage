package com.example.droodsunny.hotelmanage.tableMgr;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.droodsunny.hotelmanage.R;
import com.example.droodsunny.hotelmanage.login;

public class opentables extends AppCompatActivity {
    private Button ok;
    private Button back;
    private EditText ID;
    private EditText bill;
    SQLiteDatabase db= login.db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opentables);


        ok=(Button)findViewById(R.id.ok);
        back=(Button)findViewById(R.id.back);

        ID=(EditText)findViewById(R.id.ID);
        bill=(EditText)findViewById(R.id.status);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Cursor cursor = db.rawQuery("select * from tables", null);
                    String id = ID.getText().toString();
                    float price = Float.parseFloat(bill.getText().toString());
                    while (cursor.moveToNext()) {
                        if (id.equals(cursor.getString(0))) {
                            if ("used".equals(cursor.getString(2))) {
                                Toast.makeText(opentables.this, "桌台已占用,请重新输入", Toast.LENGTH_SHORT).show();
                                return;
                            } else {
                                db.execSQL("update tables set bill = ? where _id = ? ", new Object[]{price, id});
                                db.execSQL("update tables set isUsed = ? where _id = ? ", new Object[]{"used", id});
                                Toast.makeText(opentables.this, "开台成功", Toast.LENGTH_SHORT).show();
                                return;
                            }
                        }
                    }
                    Toast.makeText(opentables.this, "开台失败", Toast.LENGTH_SHORT).show();
                }catch (Exception s){
                    Toast.makeText(opentables.this, "请输入完整", Toast.LENGTH_SHORT).show();
                }


            }
        });


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
