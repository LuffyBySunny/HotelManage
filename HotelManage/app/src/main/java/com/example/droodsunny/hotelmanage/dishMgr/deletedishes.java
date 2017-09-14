package com.example.droodsunny.hotelmanage.dishMgr;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.CyberTime.biz.DishMgrCT;
import com.example.droodsunny.hotelmanage.R;
import com.example.droodsunny.hotelmanage.login;

public class deletedishes extends AppCompatActivity {
    SQLiteDatabase db= login.db;
    private Button button1;
    private  Button button2;
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deletedishes);

        button1=(Button)findViewById(R.id.ok);
        button2=(Button)findViewById(R.id.back);
        editText=(EditText)findViewById(R.id.editText);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=editText.getText().toString();
                try {
                    Cursor cursor = db.rawQuery("select * from dishes", null);
                    while (cursor.moveToNext()) {
                        if (name.equals(cursor.getString(1))) {
                                DishMgrCT.delDish(name, db);
                                Toast.makeText(deletedishes.this, "删除成功", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }
                }catch (Exception s){
                    Toast.makeText(deletedishes.this,"暂无菜品",Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(deletedishes.this,"输入菜名有误",Toast.LENGTH_SHORT).show();
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
