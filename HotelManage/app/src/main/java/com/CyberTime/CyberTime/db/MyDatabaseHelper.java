package com.CyberTime.CyberTime.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by DroodSunny on 2017/7/13.
 */

public class MyDatabaseHelper extends SQLiteOpenHelper {
    //指定了数据库名称和版本
    private static final String DB_NAME="mydb.db";
    private static  final int DB_VERSION=1;
    private String sqldishs="CREATE TABLE dishes (_id INTEGER PRIMARY KEY AUTOINCREMENT,name,price)";
    private String sqltables="CREATE TABLE tables (_id INTEGER PRIMARY KEY AUTOINCREMENT,seats,isUsed,location,type,date,bill)";
    private String sqlusertest="CREATE TABLE usertest (_id INTEGER PRIMARY KEY AUTOINCREMENT,name,points)";
    private String sqlworker="CREATE TABLE worker (_id INTEGER PRIMARY KEY AUTOINCREMENT,name,age,tel,pwd,sex,power)";
    private String sqlreserve="CREATE TABLE reserve (_id INTEGER PRIMARY KEY AUTOINCREMENT,tableID,name,userID,date)";
    private String sqltd="CREATE TABLE td (_id INTEGER PRIMARY KEY AUTOINCREMENT,tableID,dishID,dishNum)";
    public MyDatabaseHelper(Context context){
        super(context,DB_NAME,null,DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        //调用SQLiteDatabase中的execSQL（）执行建表语句。
        db.execSQL(sqldishs);
        db.execSQL(sqltables);
        db.execSQL(sqlusertest);
        db.execSQL(sqlworker);
        db.execSQL(sqlreserve);
        db.execSQL(sqltd);
        inti(db);
    }
    //升级的方法
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void inti(SQLiteDatabase db){
        ContentValues values1 = new ContentValues();
        values1.put("name","红烧鱼");
        values1.put("price",50);
        db.insert("dishes",null,values1);
        values1.clear();
        values1.put("name","包子");
        values1.put("price",2);
        db.insert("dishes",null,values1);
        values1.clear();
        values1.put("name","葡萄酒");
        values1.put("price",60);
        db.insert("dishes",null,values1);
        values1.clear();
        values1.put("name","海带");
        values1.put("price",10);
        db.insert("dishes",null,values1);
        values1.clear();
        values1.put("seats",8);
        values1.put("isUsed","unused");
        values1.put("location",1);
        values1.put("type","大厅");
        db.insert("tables",null,values1);
        values1.clear();
        values1.put("seats",4);
        values1.put("isUsed","unused");
        values1.put("location",2);
        values1.put("type","包间");
        db.insert("tables",null,values1);
        values1.clear();
        values1.put("seats",4);
        values1.put("isUsed","used");
        values1.put("location",3);
        values1.put("type","包间");
        values1.put("bill",3000);
        db.insert("tables",null,values1);
        values1.clear();
        values1.put("seats",8);
        values1.put("isUsed","unused");
        values1.put("location",3);
        values1.put("type","大厅");
        db.insert("tables",null,values1);
        values1.clear();
        values1.put("name","lala");
        values1.put("points",120);
        db.insert("usertest",null,values1);
        values1.clear();
        values1.put("name","joke");
        values1.put("points",10);
        db.insert("usertest",null,values1);
        values1.clear();
        values1.put("name","danne");
        values1.put("points",30);
        db.insert("usertest",null,values1);
        values1.clear();
        values1.put("name","mike");
        values1.put("age",21);
        values1.put("pwd",123);
        values1.put("tel","13354009976");
        values1.put("sex","male");
        values1.put("power","manager");
        db.insert("worker",null,values1);
        values1.clear();
        values1.put("name","jack");
        values1.put("age",20);
        values1.put("pwd",123);
        values1.put("tel","13766666111");
        values1.put("sex","male");
        values1.put("power","waiter");
        db.insert("worker",null,values1);
        values1.clear();
        values1.put("name","anna");
        values1.put("age",19);
        values1.put("pwd",123);
        values1.put("tel","13355555555");
        values1.put("sex","female");
        values1.put("power","manager");
        db.insert("worker",null,values1);
        values1.clear();
        values1.put("tableID",1);
        values1.put("name","Tom");
        values1.put("userID",1);
        values1.put("date","2017-07-20");
        db.insert("reserve",null,values1);

    }
}
