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
import android.widget.TextView;

import com.CyberTime.biz.DishMgrCT;
import com.CyberTime.biz.TableMgrCT;
import com.CyberTime.dao.impl.TabDisCTDaoImpl;
import com.CyberTime.entity.DishesCT;
import com.CyberTime.entity.TabDisCT;
import com.CyberTime.entity.TablesCT;
import com.example.droodsunny.hotelmanage.R;
import com.example.droodsunny.hotelmanage.login;

import java.util.ArrayList;

public class dishesmanage extends AppCompatActivity {
    public Button button2;
    public ListView listView;
    SQLiteDatabase db= login.db;
    public ArrayList<String> st;
    public ArrayList<String> tst;
    public ArrayList<String> tsst;
    ArrayList<DishesCT> dishesCTs;
    ArrayList<TablesCT> tablesCTs;
    ArrayList<TabDisCT> tabDisCTs;
    private ArrayAdapter<String> arrayAdapter;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dishesmanage);

        Button button1=(Button)findViewById(R.id.button1);
        button2=(Button)findViewById(R.id.button2);
        Button button3=(Button)findViewById(R.id.button3);
        Button button4=(Button)findViewById(R.id.button4);
        textView =(TextView)findViewById(R.id.text);
        listView=(ListView)findViewById(R.id.list);
        st = new ArrayList<String>();
        tst = new ArrayList<String>();
        tsst = new ArrayList<String>();
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
        tablesCTs= TableMgrCT.query(db);
        Cursor cursor1=db.rawQuery("select * from tables",null);
        for(TablesCT dt:tablesCTs){
            cursor1.moveToNext();
            int i=cursor1.getInt(0);
                String string=i+"  "+dt.getSeats().toString()+"  "+dt.getIsUsed()+"  "+dt.getLocation().toString()+"  "+dt.getType()+"  "+dt.getBill();
                tst.add(string);
        }
        try {
            tabDisCTs= TabDisCTDaoImpl.query(db);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for(TabDisCT ta:tabDisCTs){
           String string="    "+ta.getTabID()+"    "+ta.getName()+"    "+ta.getNum();
           tsst.add(string);
       }
/*
查询菜品
* */
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("    "+"序号"+"    "+"菜名"+"    "+"价格");
                arrayAdapter=new ArrayAdapter<String>(dishesmanage.this,android.R.layout.simple_expandable_list_item_1,st);
                listView.setAdapter(arrayAdapter);
            }
        });
        /*
       点菜
        * */
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent();
                intent.setClass(dishesmanage.this,order.class);
                startActivity(intent);
            }
        });
        /*
        * 查看桌台
        * */
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("    "+"序号"+"    "+"座位数"+"    "+"状态"+"    "+"位置"+"    "+"类型"+"    "+"费用");
                arrayAdapter=new ArrayAdapter<String>(dishesmanage.this,android.R.layout.simple_expandable_list_item_1,tst);
                listView.setAdapter(arrayAdapter);
            }
        });
        /*
        * 查询订单
        * */
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("    "+"桌台ID"+"    "+"菜名"+"    "+"菜品份数");
                arrayAdapter=new ArrayAdapter<String>(dishesmanage.this,android.R.layout.simple_expandable_list_item_1,tsst);
                listView.setAdapter(arrayAdapter);
                arrayAdapter.notifyDataSetChanged();
            }
        });
    }
   /* public void refresh(ArrayAdapter<String> Adapter) {

        Handler handler = new Handler();
        handler.postDelayed(add, 3000);//延迟3秒执行

        Runnable add = new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub

                Adapter.notifyDataSetChanged();
            }
        };
        class editItem extends AsyncTask<String, Integer, String> {
            @Override
            protected String doInBackground(String... params) {
                arr.set(Integer.parseInt(params[0]), params[1]);
                //params得到的是一个数组，params[0]在这里是"0",params[1]是"第1项"
                //Adapter.notifyDataSetChanged();
                //执行添加后不能调用 Adapter.notifyDataSetChanged()更新UI，因为与UI不是同线程
                //下面的onPostExecute方法会在doBackground执行后由UI线程调用
                return null;
            }

            @Override
            protected void onPostExecute(String result) {
                // TODO Auto-generated method stub
                super.onPostExecute(result);
                Adapter.notifyDataSetChanged();
                //执行完毕，更新UI
            }

        }
    }*/

}
