package com.example.droodsunny.hotelmanage.server;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.CyberTime.biz.MembersMgrCT;
import com.CyberTime.entity.MembersCT;
import com.example.droodsunny.hotelmanage.R;
import com.example.droodsunny.hotelmanage.login;
import com.example.droodsunny.hotelmanage.memberMgr.addmember;
import com.example.droodsunny.hotelmanage.memberMgr.deletemember;
import com.example.droodsunny.hotelmanage.memberMgr.updatemember;

import java.util.ArrayList;

public class employeemanage extends AppCompatActivity {

    public Button button2;
    public ListView listView;
    SQLiteDatabase db= login.db;
    public ArrayList<String> st;
    private ArrayAdapter<String> arrayAdapter;
    private ArrayList<MembersCT> membersCTs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employeemanage);

        Button button1=(Button)findViewById(R.id.button1);
        button2=(Button)findViewById(R.id.button2);
        Button button3=(Button)findViewById(R.id.button3);
        Button button4=(Button)findViewById(R.id.button4);
        listView=(ListView)findViewById(R.id.list);
        st = new ArrayList<String>();
        try {
            membersCTs= MembersMgrCT.query(db);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Cursor cursor=db.rawQuery("select * from usertest",null);
        for(MembersCT mm:membersCTs){
            cursor.moveToNext();
            String id=cursor.getString(0);
            String str=id+"     "+mm.getName()+"     "+mm.getPoints().toString();
            st.add(str);
        }
         arrayAdapter=new ArrayAdapter<String>(employeemanage.this,android.R.layout.simple_expandable_list_item_1,st);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listView.setAdapter(arrayAdapter);
            }
        });

        /*
        * 添加会员*/
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(employeemanage.this,addmember.class);
                startActivity(intent);

            }
        });
        /*删除会员*/
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(employeemanage.this,deletemember.class);
                startActivity(intent);
            }
        });
        /*
        * 更新会员*/
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(employeemanage.this,updatemember.class);
                startActivity(intent);
            }
        });

    }
}
