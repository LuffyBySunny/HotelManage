package com.example.droodsunny.hotelmanage.tableMgr;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.CyberTime.biz.TableMgrCT;
import com.example.droodsunny.hotelmanage.R;
import com.example.droodsunny.hotelmanage.login;

public class upgradetables extends AppCompatActivity {

    SQLiteDatabase db= login.db;
    private Button ok;
    private Button back;
    private EditText Id;
    private EditText location;
    private EditText seats;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upgradetables);

        ok=(Button)findViewById(R.id.update);
        back=(Button)findViewById(R.id.back);
        Id=(EditText)findViewById(R.id.seats);
        location=(EditText)findViewById(R.id.locations);
        seats=(EditText)findViewById(R.id.location1);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String id=Id.getText().toString();
                    Integer loc=Integer .parseInt(location.getText().toString());
                    Integer seat=Integer.parseInt(seats.getText().toString());
                    String use="unsed";
                    Cursor cursor = db.rawQuery("select * from tables", null);
                    while (cursor.moveToNext()) {
                        if (id.equals(cursor.getString(0))) {
                            String ty = "包间";
                            try {
                                TableMgrCT.updateTable(id, seat, use, loc, ty,0, db);
                                Toast.makeText(upgradetables.this, "更新成功", Toast.LENGTH_SHORT).show();
                            } catch (SQLiteException s) {
                                s.printStackTrace();
                            }
                            return;
                        }
                    }
                    Toast.makeText(upgradetables.this, "更新失败", Toast.LENGTH_SHORT).show();
                }catch (Exception s){
                    Toast.makeText(upgradetables.this, "输入有误", Toast.LENGTH_SHORT).show();
                }

            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });




    }
}
