package com.xlw.test;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by xlw on 2017/3/31.
 */

public class ImageUtil {

    private volatile static ImageUtil imageInstance;

    private ImageUtil(){}

    public static ImageUtil getImageInstance(){
        if(imageInstance==null){
            synchronized (ImageUtil.class){
                if(imageInstance==null){
                    imageInstance = new ImageUtil();
                }
            }
        }
        return imageInstance;
    }

    //查询图片是否存在
    public boolean isImageExists(File file){
        return file.exists();
    }

    //修改图片的名字
    public boolean changeImageName(File file,String newName){
        String parent=file.getParent();
        File newFile = new File(parent + File.separatorChar+newName+".jpg");
        return file.renameTo(newFile);

    }

    //读取图片
    public Bitmap getImage(File file){
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return BitmapFactory.decodeStream(fis);
    }

    public boolean deleteImage(File file){
        if(file.isFile() &&  file.exists()){
            file.delete();
            Log.e("fff","删除成功");
            return true;
        }else{
            Log.e("fff","删除失败");
            return false;
        }
    }



}
