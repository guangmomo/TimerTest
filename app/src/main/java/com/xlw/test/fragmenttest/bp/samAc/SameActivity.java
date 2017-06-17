package com.xlw.test.fragmenttest.bp.samAc;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.xlw.test.R;

public class SameActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_same);
        setFragment();
    }
    private void setFragment(){
        FragmentManager fm=getFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        Fragment1 fragment1=new Fragment1();
        ft.replace(R.id.ll_same_activity,fragment1,"One");
        ft.commit();

    }
}
