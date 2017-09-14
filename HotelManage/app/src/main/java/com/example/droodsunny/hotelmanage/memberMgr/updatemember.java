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

public class updatemember extends AppCompatActivity {
    SQLiteDatabase db= login.db;
    private Button button1;
    private Button button2;
    private EditText Idtext;
    private EditText nametext;
    private EditText pointstext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatemember);

        button1=(Button)findViewById(R.id.update);
        button2=(Button)findViewById(R.id.back);

        Idtext=(EditText)findViewById(R.id.seats);
        nametext=(EditText)findViewById(R.id.locations);
        pointstext=(EditText)findViewById(R.id.location1);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    String id=Idtext.getText().toString();
                    String name=nametext.getText().toString();
                    Integer points=Integer.parseInt(pointstext.getText().toString());
                    Cursor cursor = db.rawQuery("select * from usertest", null);
                    while (cursor.moveToNext()) {
                        if (id.equals(cursor.getString(0))) {
                            try {
                                MembersMgrCT.updateUser(db, name, points, id);
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                            Toast.makeText(updatemember.this, "更新成功", Toast.LENGTH_SHORT).show();
                            return;
                        }

                    }
                    Toast.makeText(updatemember.this,"更新失败",Toast.LENGTH_SHORT).show();
                }catch (Exception s){
                    Toast.makeText(updatemember.this,"无此会员",Toast.LENGTH_SHORT).show();
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
