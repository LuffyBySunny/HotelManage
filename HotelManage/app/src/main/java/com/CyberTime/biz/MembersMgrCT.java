package com.CyberTime.biz;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.CyberTime.entity.MembersCT;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by DroodSunny on 2017/7/11.
 */

public class MembersMgrCT {
    public static void addUser(SQLiteDatabase db,String name,Integer points) throws SQLException {
        db.execSQL("insert into usertest(name,points) values (?,?)",new Object[]{name,points});
    }

    public static void updateUser(SQLiteDatabase db,String name,int points,String id) throws SQLException{
        db.execSQL("update usertest set name = ? where _id = ?",new Object[]{name,id});
        db.execSQL("update usertest set points = ? where _id = ?",new Object[]{name,id});

    }

    public static void delUser(String id,SQLiteDatabase db) throws SQLException{

        db.execSQL("delete from usertest where _id = ?",new String[]{id});
    }

    public static ArrayList<MembersCT> query(SQLiteDatabase db) throws Exception{
        ArrayList<MembersCT> mem=new ArrayList<MembersCT>();
        MembersCT m=null;
        Cursor cursor = db.rawQuery("select * from usertest",null);
        while (cursor.moveToNext()){
            m=new MembersCT();
            m.setName(cursor.getString(1));
            m.setPoints(cursor.getInt(2));
            mem.add(m);
        }
        return mem;
    }

    public MembersCT get(){
        return null;
    }


}
