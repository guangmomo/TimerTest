package com.xlw.test;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import java.io.File;
import java.io.FileNotFoundException;

public class DataBaseImageActivity extends AppCompatActivity {

    private ImageView imageView;

    File file=new File(Environment.getExternalStorageDirectory(), IMAGE_FILE_NAME);

    private Uri imageUri = Uri.fromFile(new File(Environment.getExternalStorageDirectory(), IMAGE_FILE_NAME));//The Uri to store the big bitmap

    /* 头像文件 */
    private static  String IMAGE_FILE_NAME = App.currentName+".jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_base_image);
        imageView= (ImageView) findViewById(R.id.iv_data_base);
    //    Bitmap bitmap = decodeUriAsBitmap(imageUri);//decode bitmap
        Bitmap bitmap =ImageUtil.getImageInstance().getImage(file);
        if(bitmap!=null){
            imageView.setImageBitmap(bitmap);
        }else{
            imageView.setImageResource(R.mipmap.ic_launcher);
        }


    }



    private Bitmap decodeUriAsBitmap(Uri uri) {
        Bitmap bitmap = null;
        try {
            bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(uri));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }

        return bitmap;

    }
}
