package com.CyberTime.dao.impl;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.CyberTime.entity.ReserveCT;

import java.util.ArrayList;

/**
 * Created by DroodSunny on 2017/7/17.
 */

public class ReserveCTDaoImpl {
    public static void addUser(ReserveCT m, SQLiteDatabase db) throws SQLException {
        db.execSQL("insert into reserve (tableID,name,userID,date) values (?,?,?,?)",new Object[]{m.getTableID(),m.getName(),m.getUserID(),m.getDate()});
    }

    public static void updateUser(ReserveCT m,SQLiteDatabase db) throws SQLException{

        db.execSQL("update reserve set name = ? where tableID = ?",new Object[]{m.getName(),m.getTableID()});
        db.execSQL("update reserve set userID = ? where tableID = ?",new Object[]{m.getUserID(),m.getTableID()});
        db.execSQL("update reserve set date = ? where tableID = ?",new Object[]{m.getDate(),m.getTableID()});
    }

    public static void delUser(Integer id,SQLiteDatabase db) throws SQLException{
        db.execSQL("delete from reserve where tableID = ?",new Integer[]{id});

    }

    public static ArrayList<ReserveCT> query(SQLiteDatabase db) throws Exception{

        Cursor cursor=db.rawQuery("select * from reserve",null);
        ArrayList<ReserveCT> mem=new ArrayList<ReserveCT>();
        ReserveCT m=null;
        while (cursor.moveToNext()){
            m=new ReserveCT();
            m.setTableID(cursor.getInt(1));
            m.setName(cursor.getString(2));
            m.setUserID(cursor.getInt(3));
            m.setDate(cursor.getString(4));
            mem.add(m);
        }
        return mem;
    }
    public ReserveCT get(int id,SQLiteDatabase db) throws SQLException{
        ReserveCT d=null;
        Cursor cursor=db.rawQuery("select * from reserve",null);
        while (cursor.moveToNext()){
            d=new ReserveCT();
            if(id==cursor.getInt(1)){
                d.setTableID(cursor.getInt(1));
                d.setName(cursor.getString(2));
                d.setUserID(cursor.getInt(3));
                d.setDate(cursor.getString(4));
                return d;
            }
        }
        return null;
    }
}
