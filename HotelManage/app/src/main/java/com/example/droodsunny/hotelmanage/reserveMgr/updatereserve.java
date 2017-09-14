package com.example.droodsunny.hotelmanage.reserveMgr;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.CyberTime.dao.impl.ReserveCTDaoImpl;
import com.CyberTime.entity.ReserveCT;
import com.example.droodsunny.hotelmanage.R;
import com.example.droodsunny.hotelmanage.login;

public class updatereserve extends AppCompatActivity {

    SQLiteDatabase db= login.db;
    private Button button1;
    private Button button2;
    private EditText editText1;
    private EditText editText2;
    private EditText editText3;
    private EditText editText4;
    private ReserveCT r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatereserve);

        button1=(Button)findViewById(R.id.ok);
        button2=(Button)findViewById(R.id.back);

        editText1=(EditText)findViewById(R.id.tID);
        editText2=(EditText)findViewById(R.id.name);
        editText3=(EditText)findViewById(R.id.pID);
        editText4=(EditText)findViewById(R.id.date);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    r=new ReserveCT();
                    int id=Integer.parseInt(editText1.getText().toString());
                    String name =editText2.getText().toString();
                    int pId=Integer.parseInt(editText3.getText().toString());
                    String date=editText4.getText().toString();
                    Cursor cursor = db.rawQuery("select * from reserve", null);
                    while (cursor.moveToNext()) {
                        if (id == cursor.getInt(1)) {
                            r.setTableID(id);
                            r.setName(name);
                            r.setUserID(pId);
                            r.setDate(date);
                            ReserveCTDaoImpl.updateUser(r, db);
                            Toast.makeText(updatereserve.this, "更新成功", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }
                    Toast.makeText(updatereserve.this,"无此预定",Toast.LENGTH_SHORT).show();

                }catch (Exception s){
                    Toast.makeText(updatereserve.this,"请输入完整",Toast.LENGTH_SHORT).show();
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
