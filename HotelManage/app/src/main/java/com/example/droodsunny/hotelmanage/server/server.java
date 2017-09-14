package com.example.droodsunny.hotelmanage.server;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.droodsunny.hotelmanage.R;
import com.example.droodsunny.hotelmanage.login;
import com.example.droodsunny.hotelmanage.manage.billmanage;

public class server extends AppCompatActivity {

    private Button button1;
    private Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_server);

        SQLiteDatabase db= login.db;


        button1=(Button)findViewById(R.id.button);
        button2=(Button)findViewById(R.id.button2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup menu = (RadioGroup)findViewById(R.id.radiogroup);
                int ckeckedId= menu.getCheckedRadioButtonId();
                RadioButton rd=(RadioButton)findViewById(ckeckedId);
                try {
                    switch (rd.getId()) {
                        case R.id.radio1:
                            //包间管理
                            Intent intent = new Intent();
                            intent.setClass(server.this, roommanage.class);
                            startActivity(intent);
                            break;
                        case R.id.radio2:
                            //大厅管理
                            Intent intent1 = new Intent();
                            intent1.setClass(server.this, roommanage1.class);
                            startActivity(intent1);
                            break;
                        case R.id.radio3:
                            //菜品管理
                            Intent intent2 = new Intent();
                            intent2.setClass(server.this, dishesmanage.class);
                            startActivity(intent2);
                            break;
                        case R.id.radio4:
                            Intent intent3 = new Intent();
                            intent3.setClass(server.this, employeemanage.class);
                            startActivity(intent3);
                            //人员管理
                            break;
                        case R.id.radio5:
                            Intent intent4 = new Intent();
                            intent4.setClass(server.this, billmanage.class);
                            startActivity(intent4);
                            //费用管理
                            break;
                        case R.id.radio6:
                            //预定管理
                            Intent intent5 = new Intent();
                            intent5.setClass(server.this, reservemanage.class);
                            startActivity(intent5);
                            break;

                    }
                }catch (Exception e){
                    Toast.makeText(server.this,"请选择一个选项",Toast.LENGTH_SHORT).show();
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
