package com.xlw.test.imagetest;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.widget.ImageView;
import android.widget.Toast;

import com.xlw.test.R;

import java.io.File;

public class BitmapActivity extends Activity {

    ImageView imageView;
    File file= new File(Environment.getExternalStorageDirectory().toString()+File.separator+"徐立文.jpg");
     ImageUtil imageUtil=ImageUtil.getImageInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitmap);
        imageView= (ImageView) findViewById(R.id.iv_bitmap_test);
        imageView.post(new Runnable() {
            @Override
            public void run() {
                if(!imageUtil.isImageExists(file)){
                    Toast.makeText(BitmapActivity.this,"file不存在",Toast.LENGTH_SHORT).show();
                    return;
                }
                int with=imageView.getMeasuredWidth();
                int high=imageView.getMeasuredHeight();
                imageUtil.setImage(imageView,file,high,with);
            }
        });
    }
}
