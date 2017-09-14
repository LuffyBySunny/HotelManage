package com.CyberTime.dao.impl;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.CyberTime.entity.TabDisCT;

import java.util.ArrayList;

/**
 * Created by DroodSunny on 2017/7/17.
 */

public class TabDisCTDaoImpl {
    public static void add(TabDisCT m, SQLiteDatabase db) throws SQLException {
        Integer tId=m.getTabID();
       String name=m.getName();
        Integer num=m.getNum();
        db.execSQL("insert into td (tableID,dishID,dishNum) values (?,?,?)",new Object[]{tId,name,num});
    }

    public static ArrayList<TabDisCT>query(SQLiteDatabase db)throws Exception{
        Cursor cursor=db.rawQuery("select * from td",null);
        TabDisCT ct=null;
        ArrayList<TabDisCT> tabDisCTs=new ArrayList<TabDisCT>();
        while (cursor.moveToNext()){
            ct=new TabDisCT();
            int tableid=Integer.parseInt(cursor.getString(1));
            ct.setTabID(tableid);
            ct.setName(cursor.getString(2));
            ct.setNum(cursor.getInt(3));
            tabDisCTs.add(ct);
        }
        return tabDisCTs;
    }
}
