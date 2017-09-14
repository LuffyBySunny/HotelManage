package com.example.droodsunny.hotelmanage.memberMgr;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.CyberTime.biz.MembersMgrCT;
import com.example.droodsunny.hotelmanage.R;
import com.example.droodsunny.hotelmanage.login;

import java.sql.SQLException;

public class deletemember extends AppCompatActivity {

    SQLiteDatabase db= login.db;
    private Button button1;
    private Button button2;
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deletemember);

        button1=(Button)findViewById(R.id.ok);
        button2=(Button)findViewById(R.id.back);
        editText=(EditText)findViewById(R.id.editText);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String id=editText.getText().toString();
                    Cursor cursor = db.rawQuery("select * from usertest", null);
                    while (cursor.moveToNext()) {
                        if (id.equals(cursor.getString(0))) {
                            try {
                                MembersMgrCT.delUser(id, db);
                                Toast.makeText(deletemember.this, "删除成功", Toast.LENGTH_SHORT).show();
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                            return;
                        }
                    }
                    Toast.makeText(deletemember.this,"无此会员",Toast.LENGTH_SHORT).show();
                }catch (Exception s){
                    Toast.makeText(deletemember.this,"请输入会员ID",Toast.LENGTH_SHORT).show();
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
