package com.example.droodsunny.hotelmanage.server;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.CyberTime.biz.DishMgrCT;
import com.CyberTime.biz.TableMgrCT;
import com.CyberTime.dao.impl.TabDisCTDaoImpl;
import com.CyberTime.entity.DishesCT;
import com.CyberTime.entity.TabDisCT;
import com.example.droodsunny.hotelmanage.R;
import com.example.droodsunny.hotelmanage.login;

import java.util.ArrayList;

public class order extends AppCompatActivity {

    private Spinner spinner;
    private EditText editText;
    private EditText editText2;
    private Button button1;
    private Button button2;
    private float price;
    private int num;
    private String tID;
    private String dId;
 private float numprice;
    SQLiteDatabase db= login.db;
    public ArrayList<String> st;
    ArrayList<DishesCT> dishesCTs;
    private ArrayAdapter<String> arrayAdapter;
    private String result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        spinner=(Spinner)findViewById(R.id.spinder);
        editText=(EditText)findViewById(R.id.num);
        editText2=(EditText)findViewById(R.id.editText2);
        button1=(Button)findViewById(R.id.ok);
        button2=(Button)findViewById(R.id.back);
        spinner.getSelectedItem();
        st = new ArrayList<String>();
        try {
            dishesCTs= DishMgrCT.query(db);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for(DishesCT d:dishesCTs){
            String string=d.getName();
            st.add(string);
        }
       arrayAdapter=new ArrayAdapter<String>(order.this,R.layout.support_simple_spinner_dropdown_item,st);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
              result= parent.getItemAtPosition(position).toString();
                Cursor cursor=db.rawQuery("select * from dishes",null);
                while (cursor.moveToNext()){
                    if(result.equals(cursor.getString(1))){
                        break;
                    }
                }
                 price=cursor.getFloat(2);
                dId=cursor.getString(0);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    TabDisCT tabDisCT = new TabDisCT();
                    num = Integer.parseInt(editText.getText().toString());
                    tID = editText2.getText().toString();
                    Cursor cursor = db.rawQuery("select * from tables ", null);
                    while (cursor.moveToNext()) {
                        if (tID.equals(cursor.getString(0))) {
                            break;
                        }
                    }
                    if ("used".equals(cursor.getString(2))) {
                        Toast.makeText(order.this, "该桌台正在被使用", Toast.LENGTH_SHORT).show();
                        return;
                    } else {
                        numprice = price * num;
                        int tid = Integer.parseInt(tID);
                        int did = Integer.parseInt(dId);
                        tabDisCT.setNum(num);
                        tabDisCT.setName(result);
                        tabDisCT.setDisID(did);
                        tabDisCT.setTabID(tid);
                        TabDisCTDaoImpl.add(tabDisCT, db);
                        TableMgrCT.updateTable(tID, cursor.getInt(1), "used", cursor.getInt(3), cursor.getString(4), numprice, db);
                        Toast.makeText(order.this, "点菜成功", Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception e){
                    Toast.makeText(order.this, "点菜失败", Toast.LENGTH_SHORT).show();
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
