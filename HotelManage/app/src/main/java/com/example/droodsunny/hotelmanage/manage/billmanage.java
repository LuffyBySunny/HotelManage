package com.example.droodsunny.hotelmanage.manage;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.droodsunny.hotelmanage.R;
import com.example.droodsunny.hotelmanage.login;

public class billmanage extends AppCompatActivity {

    private SQLiteDatabase db= login.db;
    private Button button1;
    private Button button2;
    private TextView text1;
    private TextView text2;
    private TextView text3;
    float lobbysum=0;
    float privatesum=0;
    float total=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_billmanage);

        button1=(Button)findViewById(R.id.ok);
        button2=(Button)findViewById(R.id.back);

        text1=(TextView)findViewById(R.id.dating);
        text2=(TextView)findViewById(R.id.baojian);
        text3=(TextView)findViewById(R.id.total);

        try{
        Cursor cursor=db.rawQuery("select * from tables",null);
        String type1="包间";
        String type2="大厅";
        while (cursor.moveToNext()){
            if(type1.equals(cursor.getString(4))){
                float bill=0;
                bill=cursor.getFloat(6);
                lobbysum+=bill;
            }
            else {
                float bill=0;
                bill=cursor.getFloat(6);
                privatesum+=bill;
            }
        }}catch (Exception e){
            Toast.makeText(billmanage.this,"无消费信息",Toast.LENGTH_SHORT).show();
        }
        total=privatesum+lobbysum;
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence charSequence=String.valueOf(lobbysum);
                text1.setText(charSequence);
                charSequence=String.valueOf(privatesum);
                text2.setText(charSequence);
                charSequence=String.valueOf(total);
                text3.setText(charSequence);
                Toast.makeText(billmanage.this,"请查看账单",Toast.LENGTH_SHORT).show();
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
