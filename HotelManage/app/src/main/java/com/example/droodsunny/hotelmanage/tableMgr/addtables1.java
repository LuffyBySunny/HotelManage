package com.example.droodsunny.hotelmanage.tableMgr;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.CyberTime.biz.TableMgrCT;
import com.example.droodsunny.hotelmanage.R;
import com.example.droodsunny.hotelmanage.login;

public class addtables1 extends AppCompatActivity {
    public Button button1;
    public Button button2;
    private EditText seat;
    private EditText location;

    SQLiteDatabase db= login.db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addtables1);


        button1=(Button)findViewById(R.id.add);
        button2=(Button)findViewById(R.id.back);

        seat=(EditText)findViewById(R.id.seats);
        location=(EditText)findViewById(R.id.locations);

        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                    Integer se = Integer.parseInt(seat.getText().toString());
                    Integer lo = Integer.parseInt(location.getText().toString());
                    String ty = "大厅";
                        TableMgrCT.addTable1(se, "unused", lo, ty, db);
                        Toast.makeText(addtables1.this, "添加成功", Toast.LENGTH_SHORT).show();

                }catch (Exception e){
                    Toast.makeText(addtables1.this, "输入有误", Toast.LENGTH_SHORT).show();
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
