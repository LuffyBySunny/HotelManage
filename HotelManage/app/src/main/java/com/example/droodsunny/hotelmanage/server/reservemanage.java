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

import com.CyberTime.dao.impl.ReserveCTDaoImpl;
import com.CyberTime.entity.ReserveCT;
import com.example.droodsunny.hotelmanage.R;
import com.example.droodsunny.hotelmanage.login;
import com.example.droodsunny.hotelmanage.reserveMgr.addreserve;
import com.example.droodsunny.hotelmanage.reserveMgr.deletereserve;
import com.example.droodsunny.hotelmanage.reserveMgr.updatereserve;

import java.util.ArrayList;

public class reservemanage extends AppCompatActivity {

    SQLiteDatabase db= login.db;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private ListView listView;


    public ArrayList<String> st;
    private ArrayAdapter<String> arrayAdapter;
    private ArrayList<ReserveCT> reserveCTs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservemanage);

        button1=(Button)findViewById(R.id.look);
        button2=(Button)findViewById(R.id.add);
        button3=(Button)findViewById(R.id.delete);
        button4=(Button)findViewById(R.id.update);
        listView=(ListView)findViewById(R.id.listv);

        st=new ArrayList<>();
        try {
            reserveCTs= ReserveCTDaoImpl.query(db);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Cursor cursor=db.rawQuery("select * from reserve",null);

        for(ReserveCT re:reserveCTs){
            cursor.moveToNext();
            String str=re.getTableID()+"       "+re.getName()+"        "+re.getUserID()+"       "+re.getDate();
            st.add(str);
        }
        arrayAdapter=new ArrayAdapter<String>(reservemanage.this,android.R.layout.simple_expandable_list_item_1,st);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                listView.setAdapter(arrayAdapter);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent();
                intent.setClass(reservemanage.this,addreserve.class);
                startActivity(intent);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(reservemanage.this,deletereserve.class);
                startActivity(intent);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(reservemanage.this,updatereserve.class);
                startActivity(intent);
            }
        });

    }

}
