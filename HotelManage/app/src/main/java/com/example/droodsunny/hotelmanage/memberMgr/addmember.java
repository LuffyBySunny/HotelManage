package com.example.droodsunny.hotelmanage.memberMgr;

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

public class addmember extends AppCompatActivity {

    SQLiteDatabase db= login.db;
    private Button button1;
    private Button button2;
    private EditText editTxet1;
    private EditText editTxet2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addmember);

        button1=(Button)findViewById(R.id.add);
        button2=(Button)findViewById(R.id.back);
        editTxet1=(EditText)findViewById(R.id.name);
        editTxet2=(EditText)findViewById(R.id.points);



        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                String name=editTxet1.getText().toString();

                    int points = Integer.parseInt(editTxet2.getText().toString());
                    try {
                        MembersMgrCT.addUser(db, name, points);
                        Toast.makeText(addmember.this, "添加成功", Toast.LENGTH_SHORT).show();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }catch (Exception e){
                    Toast.makeText(addmember.this, "请输入完整", Toast.LENGTH_SHORT).show();
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
