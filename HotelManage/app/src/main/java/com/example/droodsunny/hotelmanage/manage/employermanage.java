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

import com.CyberTime.biz.WorkerMgrCT;
import com.CyberTime.entity.WorkersCT;
import com.example.droodsunny.hotelmanage.R;
import com.example.droodsunny.hotelmanage.login;
import com.example.droodsunny.hotelmanage.workerMgr.addworker;
import com.example.droodsunny.hotelmanage.workerMgr.deleteworker;
import com.example.droodsunny.hotelmanage.workerMgr.updateworker;

import java.util.ArrayList;

public class employermanage extends AppCompatActivity {
    public Button button2;
    Button button3;
    Button button1;
    Button button4;
    public ListView listView;

    public ArrayList<String> st;
    private ArrayAdapter<String> arrayAdapter;
    private ArrayList<WorkersCT> workersCTs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employermanage);

       button1=(Button)findViewById(R.id.button1);
        button2=(Button)findViewById(R.id.button2);
        button3=(Button)findViewById(R.id.button3);
         button4=(Button)findViewById(R.id.button4);
        listView=(ListView)findViewById(R.id.list);
        st = new ArrayList<String>();

    }


    @Override
    protected void onResume() {

        super.onResume();
        SQLiteDatabase db= login.db;
        try {
            workersCTs= WorkerMgrCT.query(db);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Cursor cursor=db.rawQuery("select * from worker",null);
        for(WorkersCT wo:workersCTs){
            cursor.moveToNext();
            int i=cursor.getInt(0);
            String string=i+"     "+wo.getName()+"     "+wo.getAge()+"     "+wo.getSex()+"     "+wo.getTel()+"     "+wo.getPwd()+"     "+wo.getPower();
            st.add(string);

        }
        arrayAdapter=new ArrayAdapter<String>(employermanage.this,android.R.layout.simple_expandable_list_item_1,st);
        arrayAdapter.notifyDataSetChanged();

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listView.setAdapter(arrayAdapter);

            }
        });
        /*
        添加人员
        * */
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(employermanage.this,addworker.class);
                startActivity(intent);
                st.clear();

            }
        });
        /*删除人员
        * */
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(employermanage.this,deleteworker.class);
                startActivity(intent);
            }
        });
        /*
        * 更新人员
        * */
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(employermanage.this,updateworker.class);
                startActivity(intent);
            }
        });

    }
}
