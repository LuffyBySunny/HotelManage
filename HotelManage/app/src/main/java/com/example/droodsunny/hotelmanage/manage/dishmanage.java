package com.example.droodsunny.hotelmanage.manage;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.CyberTime.biz.DishMgrCT;
import com.CyberTime.entity.DishesCT;
import com.example.droodsunny.hotelmanage.R;
import com.example.droodsunny.hotelmanage.dishMgr.adddishes;
import com.example.droodsunny.hotelmanage.dishMgr.deletedishes;
import com.example.droodsunny.hotelmanage.dishMgr.updatedishes;
import com.example.droodsunny.hotelmanage.login;

import java.util.ArrayList;
import java.util.function.DoubleBinaryOperator;

public class dishmanage extends AppCompatActivity {
    public Button button2;
    public ListView listView;
    SQLiteDatabase db= login.db;
    public ArrayList<String> st;
    ArrayList<DishesCT> dishesCTs;
    private ArrayAdapter<String> arrayAdapter;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dishmanage);

        Button button1=(Button)findViewById(R.id.button1);
        button2=(Button)findViewById(R.id.button2);
        Button button3=(Button)findViewById(R.id.button3);
        Button button4=(Button)findViewById(R.id.button4);
        textView =(TextView)findViewById(R.id.text);
        listView=(ListView)findViewById(R.id.list);

        st = new ArrayList<String>();
        try {
            dishesCTs= DishMgrCT.query(db);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Cursor cursor=db.rawQuery("select * from dishes",null);
        for(DishesCT dishes:dishesCTs){
            cursor.moveToNext();
            int i=cursor.getInt(0);
            String string=i+"     "+dishes.getName()+"    "+dishes.getPrice().toString();
            st.add(string);
        }
        /*
查询菜品
* */
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("    "+"序号"+"    "+"菜名"+"    "+"价格");
                arrayAdapter=new ArrayAdapter<String>(dishmanage.this,android.R.layout.simple_expandable_list_item_1,st);
                listView.setAdapter(arrayAdapter);
            }
        });
        /*
        * 添加菜品
        * */
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(dishmanage.this,adddishes.class);
                startActivity(intent);

            }
        });
/*
* 删除菜品
* */
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(dishmanage.this,deletedishes.class);
                startActivity(intent);

            }
        });
        /*
        * 更新菜品
        * */
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(dishmanage.this,updatedishes.class);
                startActivity(intent);
            }
        });



    }

}
