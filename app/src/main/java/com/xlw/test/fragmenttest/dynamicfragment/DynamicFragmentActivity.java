package com.xlw.test.fragmenttest.dynamicfragment;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.xlw.test.R;

public class DynamicFragmentActivity extends Activity {

    FrameLayout frameLayout;

    int tag=1;//j1 表示当前展示的是DynamicTitleFragment， 2 表示当前展示的是DynamicContentFragment，默认展示DynamicTitleFragment
    boolean isShow=true;
    boolean isAttach=true;
    FragmentManager fm;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_fragment);
        frameLayout= (FrameLayout) findViewById(R.id.fl_dynamic_fragment);
        setDefaultFragment();
    }


    private void setDefaultFragment(){
        fm= getFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        DynamicTitleFragment dynamicTitleFragment = null;
        dynamicTitleFragment=new DynamicTitleFragment();
        ft.replace(R.id.fl_dynamic_fragment,dynamicTitleFragment);
        ft.commit();
    }


    public void handoverFragment(View view) {
        DynamicContentFragment dynamicContentFragment = null;
        DynamicTitleFragment dynamicTitleFragment = null;
          isShow=true;
          isAttach=true;
          if(tag==2){
              FragmentTransaction ft=fm.beginTransaction();
              if(dynamicContentFragment!=null){
                  ft.remove(dynamicContentFragment);
              }
              if(dynamicTitleFragment==null){
                  dynamicTitleFragment=new DynamicTitleFragment();
              }
              ft.replace(R.id.fl_dynamic_fragment,dynamicTitleFragment);
              ft.commit();
              tag=1;
          }else if(tag==1){
              FragmentTransaction ft=fm.beginTransaction();
              if(dynamicTitleFragment!=null){
                  ft.remove(dynamicTitleFragment);
              }
              if(dynamicContentFragment==null){
                  dynamicContentFragment=new DynamicContentFragment();
              }
              ft.replace(R.id.fl_dynamic_fragment,dynamicContentFragment);
              ft.commit();
              tag=2;
          }
    }

    public void hideOrShowFragment(View view) {
      /*  FragmentTransaction ft=fm.beginTransaction();
        if(tag==j1){
            if(isAttach){
                ft.detach(dynamicTitleFragment);
            }else{
                ft.attach(dynamicTitleFragment);
            }
        }else if(tag==2){
            if(isAttach){
                ft.detach(dynamicContentFragment);
            }else{
                ft.attach(dynamicContentFragment);
            }
        }
        ft.commit();
        isAttach=!isAttach;*/
    }

    public void attachOrDetachFragment(View view) {
       /* FragmentTransaction ft=fm.beginTransaction();
        if(tag==j1){
            if(isShow){
                ft.hide(dynamicTitleFragment);
            }else{
                ft.show(dynamicTitleFragment);
            }
        }else if(tag==2){
            if(isShow){
                ft.hide(dynamicContentFragment);
            }else{
                ft.show(dynamicContentFragment);
            }
        }
        ft.commit();
        isShow=!isShow;*/
    }
}
