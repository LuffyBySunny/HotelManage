package com.CyberTime.biz;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.CyberTime.entity.DishesCT;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by DroodSunny on 2017/7/11.
 */

public class DishMgrCT {
    public static void  addDish(SQLiteDatabase db,String name,int price) throws SQLException {
        db.execSQL("insert into dishes(name,price) values (?,?)",new Object[]{name,price});
    }
    public static void updateDish(SQLiteDatabase db,String name,int price) throws SQLException{
        db.execSQL("update dishes set price = ? where name = ?",new Object[]{price,name});
    }

    public static void delDish(String name,SQLiteDatabase db) throws SQLException{
         db.execSQL("delete from dishes where name = ?",new String[]{name});
    }

    public static ArrayList<DishesCT> query(SQLiteDatabase db) throws Exception{
        ArrayList<DishesCT> dis=new ArrayList<DishesCT>();
        DishesCT d=null;
        Cursor cursor = db.rawQuery("select * from dishes",null);
        while(cursor.moveToNext()){
            d=new DishesCT();
            d.setName(cursor.getString(1));
            d.setPrice(cursor.getInt(2));
            dis.add(d);
        }
        cursor.close();
        return dis;
    }
}
