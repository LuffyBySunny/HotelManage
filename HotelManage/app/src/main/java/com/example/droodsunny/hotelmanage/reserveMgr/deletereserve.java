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
import com.example.droodsunny.hotelmanage.R;
import com.example.droodsunny.hotelmanage.login;

public class deletereserve extends AppCompatActivity {

    SQLiteDatabase db= login.db;
    private Button button1;
    private  Button button2;
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deletereserve);

        button1=(Button)findViewById(R.id.ok);
        button2=(Button)findViewById(R.id.back);
        editText=(EditText)findViewById(R.id.editText);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Integer id=Integer.parseInt(editText.getText().toString());
                    Cursor cursor = db.rawQuery("select * from reserve", null);
                    while (cursor.moveToNext()) {
                        if (id == cursor.getInt(1)) {
                            ReserveCTDaoImpl.delUser(id, db);
                            Toast.makeText(deletereserve.this, "删除预订成功", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }
                    Toast.makeText(deletereserve.this,"无此预订",Toast.LENGTH_SHORT).show();
                }catch (Exception s){
                    Toast.makeText(deletereserve.this,"暂无预订",Toast.LENGTH_SHORT).show();
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
