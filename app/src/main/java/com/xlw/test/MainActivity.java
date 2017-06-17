package com.xlw.test;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;

public class MainActivity extends ActionBarActivity {


        private Uri imageUri = Uri.fromFile(new File(Environment.getExternalStorageDirectory(), IMAGE_FILE_NAME));//The Uri to store the big bitmap

    /* 头像文件 */
    private static  String IMAGE_FILE_NAME = App.currentName+".jpg";

    /* 请求识别码 */
    private static final int CODE_GALLERY_REQUEST = 0xa0;
    private static final int CODE_CAMERA_REQUEST = 0xa1;
    private static final int CODE_RESULT_REQUEST = 0xa2;


    // 裁剪后图片的宽(X)和高(Y),480 X 480的正方形。
    private static int output_X = 480;
    private static int output_Y = 480;

    private ImageView headImage = null;

    private Button btnDataImage;
    private Button btnRename;
    private Button btnExists;
    private Button btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btnDataImage= (Button) findViewById(R.id.btn_database_image);
        btnDataImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 MainActivity.this.startActivity(new Intent(MainActivity.this,DataBaseImageActivity.class));
            }
        });

        btnRename= (Button) findViewById(R.id.btn_rename);
        btnRename.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                App.currentName="change";
                if(ImageUtil.getImageInstance().changeImageName(new File(Environment.getExternalStorageDirectory(), App.currentName+".jpg"),App.currentName)){
                    Toast.makeText(App.getContext(),"修改名字成功",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(App.getContext(),"修改名字失败",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnExists = (Button) findViewById(R.id.btn_image_exists);
        btnExists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( ImageUtil.getImageInstance().isImageExists(new File(Environment.getExternalStorageDirectory(), App.currentName+".jpg"))){
                    Toast.makeText(App.getContext(),App.currentName+".jpg"+"存在",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(App.getContext(),App.currentName+".jpg"+"不存在",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnDelete = (Button) findViewById(R.id.btn_delete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File file=new File(Environment.getExternalStorageDirectory(), App.currentName+".jpg");
                if(ImageUtil.getImageInstance().deleteImage(file)){
                    Toast.makeText(App.getContext(),App.currentName+".jpg"+"删除成功",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(App.getContext(),App.currentName+".jpg"+"删除失败",Toast.LENGTH_SHORT).show();
                }
            }
        });

        headImage = (ImageView) findViewById(R.id.imageView);
        Button buttonLocal = (Button) findViewById(R.id.buttonLocal);
        buttonLocal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(hasSdcard()){
                    choseHeadImageFromGallery();
                }else {
                    Toast.makeText(getApplication(), "没有SDCard!", Toast.LENGTH_LONG)
                            .show();
                }
            }
        });
        Button buttonCamera = (Button) findViewById(R.id.buttonCamera);
        buttonCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(hasSdcard()){
                    choseHeadImageFromCameraCapture();
                }else {
                    Toast.makeText(getApplication(), "没有SDCard!", Toast.LENGTH_LONG)
                            .show();
                }

            }
        });
    }

    // 从本地相册选取图片作为头像
    private void choseHeadImageFromGallery() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT, null);
        intent.setType("image/*");
        intent.putExtra("crop", "true");
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        intent.putExtra("outputX", 480);
        intent.putExtra("outputY", 480);
        intent.putExtra("scale", true);
        intent.putExtra("return-data", false);
        Uri imageUri = Uri.fromFile(new File(Environment.getExternalStorageDirectory(), App.currentName+".jpg"));//The Uri to store the big bitmap
        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
        intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
        intent.putExtra("noFaceDetection", true); // no face detection
        startActivityForResult(intent, CODE_GALLERY_REQUEST);
    }

    // 启动手机相机拍摄照片作为头像
    private void choseHeadImageFromCameraCapture() {
        Intent intentFromCapture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        Uri imageUri = Uri.fromFile(new File(Environment.getExternalStorageDirectory(), App.currentName+".jpg"));//The Uri to store the big bitmap
        intentFromCapture.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
        startActivityForResult(intentFromCapture, CODE_CAMERA_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent intent) {

        // 用户没有进行有效的设置操作，返回
        if (resultCode == RESULT_CANCELED) {
            Toast.makeText(getApplication(), "取消", Toast.LENGTH_LONG).show();
            return;
        }

        switch (requestCode) {
            case CODE_GALLERY_REQUEST:
                Uri imageUri = Uri.fromFile(new File(Environment.getExternalStorageDirectory(), App.currentName+".jpg"));//The Uri to store the big bitmap
                if (imageUri != null) {
                    Bitmap bitmap = decodeUriAsBitmap(imageUri);//decode bitmap

                    headImage.setImageBitmap(bitmap);
                }
                break;
            case CODE_CAMERA_REQUEST:
                Log.e("test","camera222");
                if (hasSdcard()) {
                    File tempFile = new File(
                            Environment.getExternalStorageDirectory(),
                            App.currentName+".jpg");
                    cropRawPhoto(Uri.fromFile(tempFile));
                } else {
                    Toast.makeText(getApplication(), "没有SDCard!", Toast.LENGTH_LONG)
                            .show();
                }
                break;
            case CODE_RESULT_REQUEST:
                if (intent != null) {
                    setImageToHeadView(intent);
                }
                break;
        }

        super.onActivityResult(requestCode, resultCode, intent);
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


    /**
     * 裁剪原始的图片
     */
    public void cropRawPhoto(Uri uri) {

        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");

        // 设置裁剪
        intent.putExtra("crop", "true");

        // aspectX , aspectY :宽高的比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);

        // outputX , outputY : 裁剪图片宽高
        intent.putExtra("outputX", output_X);
        intent.putExtra("outputY", output_Y);
        intent.putExtra("return-data", true);

        startActivityForResult(intent, CODE_RESULT_REQUEST);
    }

    /**
     * 提取保存裁剪之后的图片数据，并设置头像部分的View
     */
    private void setImageToHeadView(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            Bitmap photo = extras.getParcelable("data");
            headImage.setImageBitmap(photo);
        }
    }

    /**
     * 检查设备是否存在SDCard的工具方法
     */
    public static boolean hasSdcard() {
        String state = Environment.getExternalStorageState();
        if (state.equals(Environment.MEDIA_MOUNTED)) {
            // 有存储的SDCard
            return true;
        } else {
            return false;
        }
    }
}
