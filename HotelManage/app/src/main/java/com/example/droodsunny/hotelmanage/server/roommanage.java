package com.example.droodsunny.hotelmanage.server;
/*
* 包间管理
**/

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
import com.example.droodsunny.hotelmanage.login;
import com.example.droodsunny.hotelmanage.tableMgr.opentables;

import java.util.ArrayList;

public class roommanage extends AppCompatActivity {

    public ListView listView;
    SQLiteDatabase db= login.db;
    public ArrayList<String> st;
    private ArrayAdapter<String> arrayAdapter;
    private Button button1;
    private  Button button2;
    private Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roommanage);
        button1=(Button)findViewById(R.id.button1);
        button2=(Button)findViewById(R.id.button2);
        button3=(Button)findViewById(R.id.button3);

        listView=(ListView)findViewById(R.id.list);
        st = new ArrayList<String>();
       ArrayList<TablesCT> tablesCTs= TableMgrCT.query(db);
        String baojian="包间";
        Cursor cursor=db.rawQuery("select * from tables",null);
            for(TablesCT dt:tablesCTs){
                cursor.moveToNext();
                int i=cursor.getInt(0);
                String type=cursor.getString(4);
                if(baojian.equals(type)){
                    String string=i+"  "+dt.getSeats().toString()+"  "+dt.getIsUsed()+"  "+dt.getLocation().toString()+"  "+dt.getType()+"  "+dt.getBill();
                    st.add(string);
                }
        }
        arrayAdapter=new ArrayAdapter<String>(roommanage.this,android.R.layout.simple_expandable_list_item_1,st);
        /*
        * 查看桌台
        **/
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listView.setAdapter(arrayAdapter);
            }
        });
        /*
        * 开台
        * */
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent();
                intent.setClass(roommanage.this,opentables.class);
                startActivity(intent);

            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
