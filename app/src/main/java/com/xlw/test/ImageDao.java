package com.xlw.test;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by xlw on 2017/3/31.
 */

public class ImageDao {

    private DBHelper dbHelper;


    public ImageDao() {
        dbHelper = new DBHelper(App.getContext());
    }

    public void addImageName(String imageName){
        ContentValues values=new ContentValues();
        values.put("name",imageName);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        if (db.isOpen()) {
            db.insert("image",null,values);
            db.close();
        }
    }

    public String getImageName(String nameTemp){
        String name=null;
        String password=null;
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        if (db.isOpen()) {
            Cursor cursor = db.rawQuery("select * from user where name = ? ", new String[]{nameTemp});
            if(cursor.moveToFirst()){
                name=cursor.getString(cursor.getColumnIndex("name"));
            }else{
                Log.e("test","数据库中没有找到图片名字");
                return null;
            }
            cursor.close();
            db.close();
        }
        return name;
    }
}
