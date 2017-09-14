package com.CyberTime.biz;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import com.CyberTime.entity.TablesCT;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DroodSunny on 2017/7/11.
 */

public class TableMgrCT {
    public static void addTable(int seats,String isUsed,int location,String type, SQLiteDatabase db) throws SQLiteException {
        db.execSQL("insert into tables(seats,isUsed,location,type) values (?,?,?,?)",new Object[]{seats
        ,isUsed,location,"包间"});
    }
    public static void addTable1(int seats,String isUsed,int location,String type, SQLiteDatabase db) throws SQLiteException {
        db.execSQL("insert into tables(seats,isUsed,location,type) values (?,?,?,?)",new Object[]{seats
                ,isUsed,location,"大厅"});
    }

    public static void updateTable(String id,int seats,String isUsed,int location,String type,float bill,SQLiteDatabase db)throws SQLiteException{
        db.execSQL("update tables set seats = ? where _id = ?",new Object[]{seats,id});
        db.execSQL("update tables set isUsed = ? where _id = ?",new Object[]{isUsed,id});
        db.execSQL("update tables set location = ? where _id = ?",new Object[]{location,id});
        db.execSQL("update tables set type = ? where _id = ?",new Object[]{type,id});
        db.execSQL("update tables set bill = ? where _id = ?",new Object[]{bill,id});
    }
    public static void updateTable(TablesCT tablesCT,SQLiteDatabase db){

    }
    public static void updateTable1(String id,int seats,String isUsed,int location,String type,SQLiteDatabase db)throws SQLiteException{
        db.execSQL("update tables set seats = ? where _id = ?",new Object[]{seats,id});
        db.execSQL("update tables set isUsed = ? where _id = ?",new Object[]{isUsed,id});
        db.execSQL("update tables set location = ? where _id = ?",new Object[]{location,id});
        db.execSQL("update tables set type = ? where _id = ?",new Object[]{type,id});
    }
    public static void delTable(String id,SQLiteDatabase db) throws SQLiteException{
        db.execSQL("delete from tables where _id = ?",new String[]{id} );
    }
    public static ArrayList<TablesCT> query(SQLiteDatabase db) {
        ArrayList<TablesCT> tab=new ArrayList<TablesCT>();
        Cursor cursor = db.rawQuery("select * from tables",null);
        TablesCT w=null;
        while(cursor.moveToNext()){
            w=new TablesCT();
            w.setSeats(cursor.getInt(1));
            w.setUsed(cursor.getString(2));
            w.setLocation(cursor.getInt(3));
            w.setType(cursor.getString(4));
            w.setBill(cursor.getFloat(6));
            tab.add(w);
        }
        cursor.close();
        return tab;
    }
    public static List<TablesCT> get(String type,SQLiteDatabase db) throws SQLiteException{
        Cursor cursor = db.rawQuery("select * from tables where type = ?",new String[]{type});
        TablesCT w=null;
        List<TablesCT> tab=new ArrayList<TablesCT>();
        while(cursor.moveToNext()){
            w=new TablesCT();
            w.setSeats(cursor.getInt(1));
            w.setUsed(cursor.getString(2));
            w.setLocation(cursor.getInt(3));
            w.setType(cursor.getString(4));
            w.setDate(cursor.getString(5));
            w.setBill(cursor.getFloat(6));
           tab.add(w);
        }
        cursor.close();
        return tab;
    }
    public static void optables(SQLiteDatabase db,String id,String isUsed) throws SQLiteException{
        db.execSQL("update tables set isUsed = ? where _id = ?",new Object[]{isUsed,id});
    }
    public static TablesCT getID(String ID,SQLiteDatabase db){
        Cursor cursor=db.rawQuery("select * from tables where _id = ？",new String[]{ID});
        TablesCT t=new TablesCT();
        t.setSeats(cursor.getInt(1));
        t.setUsed(cursor.getString(2));
        t.setLocation(cursor.getInt(3));
        t.setType(cursor.getString(4));
        t.setDate(cursor.getString(5));
        return t;

    }

}
