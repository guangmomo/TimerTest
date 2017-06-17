package com.xlw.test.fragmenttest.viewpager;




import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by xlw on 2017/4/2.
 */

public class FragAdapter extends FragmentPagerAdapter {

    private List<Fragment> list;

    public FragAdapter(FragmentManager fm,List<Fragment> listFragment) {
        super(fm);
        list=listFragment;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
