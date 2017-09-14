package com.CyberTime.biz;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import com.CyberTime.entity.WorkersCT;

import java.util.ArrayList;

/**
 * Created by DroodSunny on 2017/7/11.
 */

public class WorkerMgrCT {
    public static void addUser(SQLiteDatabase db,String name,int age,String tel,String pwd,String sex,String power) throws SQLiteException {
      db.execSQL("insert into worker(name,age,tel,pwd,sex,power) values (?,?,?,?,?,?)",new Object[]{name,age,tel,pwd,sex,power});
    }
    public static void updateUser(SQLiteDatabase db,String name,int age,String tel,String pwd,String sex,String power) throws SQLiteException{
        db.execSQL("update worker set age = ? where name = ?",new Object[]{age,name});
        db.execSQL("update worker set tel = ? where name = ?",new Object[]{tel,name});
        db.execSQL("update worker set pwd = ? where name = ?",new Object[]{pwd,name});
        db.execSQL("update worker set sex = ? where name = ?",new Object[]{sex,name});
        db.execSQL("update worker set power = ? where name = ?",new Object[]{power,name});
    }
    public static void delUser(String name,SQLiteDatabase db) throws SQLiteException{
        db.execSQL("delete from worker where name = ?",new String[]{name});
    }



    public static ArrayList<WorkersCT> query(SQLiteDatabase db) throws Exception{
        Cursor cursor = db.rawQuery("select * from worker",null);
        ArrayList<WorkersCT> wor=new ArrayList<WorkersCT>();
        WorkersCT w=null;
        while(cursor.moveToNext()){
            w=new WorkersCT();
            w.setName(cursor.getString(1));
            w.setAge(cursor.getInt(2));
            w.setTel(cursor.getString(3));
            w.setPwd(cursor.getString(4));
            w.setSex(cursor.getString(5));
            w.setPower(cursor.getString(6));
            wor.add(w);
        }
        cursor.close();
        return wor;
    }

    public WorkersCT get(String name, SQLiteDatabase db) throws SQLiteException{
        WorkersCT w=null;
        Cursor cursor = db.rawQuery("select * from worker",null);
        while(cursor.moveToNext()){
            if(name.equals(cursor.getString(1))){
                w=new WorkersCT();
                w.setName(cursor.getString(1));
                w.setAge(cursor.getInt(2));
                w.setTel(cursor.getString(3));
                w.setPwd(cursor.getString(4));
                w.setSex(cursor.getString(5));
                w.setPower(cursor.getString(6));
                return w;
            }
        }
        cursor.close();
       return null;
    }
}
