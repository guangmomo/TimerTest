package com.xlw.test.fragmenttest.viewpager;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.xlw.test.R;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class ViewPagerActivity extends Activity {

    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        viewPager= (ViewPager) findViewById(R.id.view_pager);
        List<WeakReference<Fragment>> listWeak=new ArrayList<>();
        listWeak.add(new WeakReference<Fragment>(new FragmentOne()));
        listWeak.add(new WeakReference<Fragment>(new FragmentTwo()));
        listWeak.add(new WeakReference<Fragment>(new FragmentThree()));
        listWeak.add(new WeakReference<Fragment>(new FragmentFour()));

        List<Fragment> list=new ArrayList<>();
        list.add(new FragmentOne());
        list.add(new FragmentTwo());
        list.add(new FragmentThree());
        list.add(new FragmentFour());
       FragAdapter fragAdapter=new FragAdapter(getFragmentManager(),list);
        FragStateAdapter fragStateAdapter = new FragStateAdapter(getFragmentManager(),list);
        viewPager.setOffscreenPageLimit(1);
        viewPager.setAdapter(fragStateAdapter);
       //viewPager.setAdapter(fragAdapter);

    }
}
