package com.xlw.test.fragmenttest.viewpager;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by xlw on 2017/4/2.
 */

public class FragStateAdapter extends FragmentStatePagerAdapter {

   /* List<WeakReference<Fragment>> listWeak=new ArrayList<>();

    public FragStateAdapter(FragmentManager fm, List<WeakReference<Fragment>>  listWeak) {
        super(fm);
        this.listWeak=listWeak;
    }

    @Override
    public Fragment getItem(int position) {
        if(listWeak==null){
            Log.e("test","weakReference==null");
        }
        WeakReference<Fragment> weak=listWeak.get(position);
        if(weak==null){
            Log.e("test","weak==null");
        }
        if(weak.get()==null){
            switch (position){
                case 0:
                    listWeak.set(position,new WeakReference<Fragment>(new FragmentOne()));
                    break;
                case 1:
                    listWeak.set(position,new WeakReference<Fragment>(new FragmentTwo()));
                    break;
                case 2:
                    listWeak.set(position,new WeakReference<Fragment>(new FragmentThree()));
                    break;
                case 3:
                    listWeak.set(position,new WeakReference<Fragment>(new FragmentFour()));
                    break;
            }
            weak=listWeak.get(position);
            Log.e("test","fragment-->"+position+"==null");
        }
      return weak.get();
    }

    @Override
    public int getCount() {
        return listWeak.size();
    }
*/
    private List<Fragment> list;

    public FragStateAdapter(FragmentManager fm,List<Fragment> listFragment) {
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
