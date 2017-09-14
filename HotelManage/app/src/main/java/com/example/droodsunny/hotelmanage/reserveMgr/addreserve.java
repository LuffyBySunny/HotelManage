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

public class addreserve extends AppCompatActivity {

    SQLiteDatabase db= login.db;
    private Button button1;
    private Button button2;
    private EditText editText1;
    private EditText editText2;
    private EditText editText3;
    private EditText editText4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addreserve);

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
                    Cursor cursor1 = db.rawQuery("select * from reserve", null);
                    int tID = Integer.parseInt(editText1.getText().toString());
                    int pID = Integer.parseInt(editText3.getText().toString());
                    String username = editText2.getText().toString();
                    String date = editText4.getText().toString();
                    while (cursor1.moveToNext()) {
                        if (tID == cursor1.getInt(1)) {
                            Toast.makeText(addreserve.this, "桌台已预订", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }
                    ReserveCT reserveCT = new ReserveCT();
                    reserveCT.setTableID(tID);
                    reserveCT.setUserID(pID);
                    reserveCT.setName(username);
                    reserveCT.setDate(date);
                    ReserveCTDaoImpl.addUser(reserveCT, db);
                    Toast.makeText(addreserve.this, "预订成功", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Toast.makeText(addreserve.this, "请输入完整", Toast.LENGTH_SHORT).show();
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
