package com.xlw.test.fragmenttest.bp.difAc;


import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.xlw.test.R;

public class Activity2 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        setFragment();
    }

    private void setFragment(){
        FragmentManager fm=getFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        GetAcMesFragment getAcMesFragment= GetAcMesFragment.newInstance(getIntent().getStringExtra("frag_mes"));
        ft.replace(R.id.fl_gam_fragment,getAcMesFragment);
        ft.commit();

    }

}
