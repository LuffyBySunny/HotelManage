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

import com.CyberTime.biz.TableMgrCT;
import com.CyberTime.entity.TablesCT;
import com.example.droodsunny.hotelmanage.R;
import com.example.droodsunny.hotelmanage.tableMgr.addtables;
import com.example.droodsunny.hotelmanage.tableMgr.deletetables;
import com.example.droodsunny.hotelmanage.login;
import com.example.droodsunny.hotelmanage.tableMgr.upgradetables;

import java.util.ArrayList;

public class roomofmanager extends AppCompatActivity {


    public  Button button2;
    public ListView listView;
    SQLiteDatabase db= login.db;
  public   ArrayList<String> st;
  private ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roomofmanager);

        Button button1=(Button)findViewById(R.id.button1);
        button2=(Button)findViewById(R.id.button2);
        Button button3=(Button)findViewById(R.id.button3);
        Button button4=(Button)findViewById(R.id.button4);
        listView=(ListView)findViewById(R.id.list);
        st = new ArrayList<String>();
        final ArrayList<TablesCT> tablesCTs= TableMgrCT.query(db);
        final String baojian="包间";
        Cursor cursor=db.rawQuery("select * from tables",null);
        for(TablesCT dt:tablesCTs){
            cursor.moveToNext();
            int i=cursor.getInt(0);
            String type=cursor.getString(4);
            if(baojian.equals(type)){
                String string=i+"    "+dt.getSeats().toString()+"    "+dt.getIsUsed()+"    "+dt.getLocation().toString()+"    "+dt.getType()+"  "+dt.getBill();
                st.add(string);
            }
        }
        /*
        查询桌台
        */
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayAdapter=new ArrayAdapter<String>(roomofmanager.this,android.R.layout.simple_expandable_list_item_1,st);
                listView.setAdapter(arrayAdapter);
            }
        });
        /*
        * 添加桌台*/
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // listView.removeAllViews();
                Intent intent=new Intent();
                intent.setClass(roomofmanager.this,addtables.class);
                startActivity(intent);
            }
        });
     /*
     * 删除桌台
     * */
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // listView.removeAllViews();
                Intent intent= new Intent();
                intent.setClass(roomofmanager.this,deletetables.class);
                startActivity(intent);

            }
        });
        /*
        * 更新桌台
        * */
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(roomofmanager.this,upgradetables.class);
                startActivity(intent);
            }
        });
    }
}
