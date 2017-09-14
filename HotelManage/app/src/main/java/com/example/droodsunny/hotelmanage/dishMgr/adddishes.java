package com.example.droodsunny.hotelmanage.dishMgr;

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

public class adddishes extends AppCompatActivity {
    public Button button1;
    public Button button2;
    private EditText name;
    private EditText price;

    SQLiteDatabase db= login.db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adddishes);


        button1=(Button)findViewById(R.id.add);
        button2=(Button)findViewById(R.id.back);

        name=(EditText)findViewById(R.id.names);
        price=(EditText)findViewById(R.id.prices);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String dishname = name.getText().toString();
                    Integer dishprice = Integer.parseInt(price.getText().toString());

                        DishMgrCT.addDish(db, dishname, dishprice);
                        Toast.makeText(adddishes.this, "添加成功", Toast.LENGTH_SHORT).show();

                }catch (Exception e){
                    Toast.makeText(adddishes.this, "请输入完整", Toast.LENGTH_SHORT).show();
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
