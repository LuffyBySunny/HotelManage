package com.example.droodsunny.hotelmanage;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.CyberTime.CyberTime.db.MyDatabaseHelper;
import com.CyberTime.biz.WorkerMgrCT;
import com.example.droodsunny.hotelmanage.manage.manager;
import com.example.droodsunny.hotelmanage.server.server;

import static android.widget.Toast.LENGTH_SHORT;

public class login extends AppCompatActivity {

    public static MyDatabaseHelper databaseHelper;
    public static SQLiteDatabase db;
    public EditText editTextUsername;
    public EditText editTextpassWord;
    public Button Login;
    public Button Logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editTextUsername = (EditText) findViewById(R.id.editText3);
        editTextpassWord = (EditText) findViewById(R.id.editText4);
        Login = (Button) findViewById(R.id.login);
        Logout = (Button) findViewById(R.id.logout);
        databaseHelper = new MyDatabaseHelper(this);
        db = databaseHelper.getWritableDatabase();

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    login();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    

    public void login() throws Exception {
        String username = editTextUsername.getText().toString();
        String passWord = editTextpassWord.getText().toString();
        WorkerMgrCT m = new WorkerMgrCT();
    if(m.get(username,db)!=null)
    {
        if (passWord.equals(m.get(username,db).getPwd())) {
            if (m.get(username,db).getPower().equals("manager")) {
                //进入manager界面
                Intent intent = new Intent();
                intent.setClass(login.this, manager.class);
                startActivity(intent);
            } else {
               Intent intent = new Intent();
                intent.setClass(login.this,server.class);
                startActivity(intent);
            }
        }else{
            Toast.makeText(login.this,"输入密码名有误",LENGTH_SHORT).show();
        }
    }
    else
    {
        Toast toast = Toast.makeText(login.this, "请重新输入用户名和密码", LENGTH_SHORT);
        toast.show();
    }
    }

}
