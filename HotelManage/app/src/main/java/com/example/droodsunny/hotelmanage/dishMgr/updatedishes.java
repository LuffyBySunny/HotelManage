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

public class updatedishes extends AppCompatActivity {

    SQLiteDatabase db= login.db;
    private Button button1;
    private Button button2;
    private EditText editText1;
    private EditText editText2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatedishes);

        button1=(Button)findViewById(R.id.update);
        button2=(Button)findViewById(R.id.back);
        editText1=(EditText)findViewById(R.id.name);
        editText2=(EditText)findViewById(R.id.price);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=editText1.getText().toString();
                try {
                    Cursor cursor = db.rawQuery("select * from dishes", null);
                    while (cursor.moveToNext()) {
                        if (name.equals(cursor.getString(1))) {
                            Integer price = Integer.parseInt(editText2.getText().toString());

                                DishMgrCT.updateDish(db, name, price);
                                Toast.makeText(updatedishes.this, "更新成功", Toast.LENGTH_SHORT).show();

                            return;
                        }

                    }
                }catch (Exception e) {
                    e.printStackTrace();
                }
                Toast.makeText(updatedishes.this,"请输入完整",Toast.LENGTH_SHORT).show();
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
