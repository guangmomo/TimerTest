package com.xlw.test.fragmenttest.staticfragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.xlw.test.R;

public class StaticFragmentActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_static_fragment);
    }
}
