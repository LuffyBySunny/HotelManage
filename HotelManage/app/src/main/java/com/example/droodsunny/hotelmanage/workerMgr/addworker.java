package com.example.droodsunny.hotelmanage.workerMgr;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.CyberTime.biz.WorkerMgrCT;
import com.example.droodsunny.hotelmanage.R;
import com.example.droodsunny.hotelmanage.login;

public class addworker extends AppCompatActivity {
    SQLiteDatabase db= login.db;
    private Button button1;
    private Button button2;
    private EditText editText1;
    private EditText editText2;
    private EditText editText3;
    private EditText editText4;
    private EditText editText5;
    private EditText editText6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addworker);
        button1=(Button)findViewById(R.id.update);
        button2=(Button)findViewById(R.id.back);
        editText1=(EditText)findViewById(R.id.name);
        editText2=(EditText)findViewById(R.id.age);
        editText3=(EditText)findViewById(R.id.sex);
        editText4=(EditText)findViewById(R.id.tel);
        editText5=(EditText)findViewById(R.id.pwd);
        editText6=(EditText)findViewById(R.id.power);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String name = editText1.getText().toString();
                    int age = Integer.parseInt(editText2.getText().toString());
                    String sex = editText3.getText().toString();
                    String tel = editText4.getText().toString();
                    String pwd = editText5.getText().toString();
                    String power = editText6.getText().toString();
                    WorkerMgrCT.addUser(db, name, age, tel, pwd, sex, power);
                    Toast.makeText(addworker.this, "添加成功", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Toast.makeText(addworker.this, "添加失败，请输入完整", Toast.LENGTH_SHORT).show();
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
