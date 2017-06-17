package com.xlw.test.fragmenttest.fragmentbackstack;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.xlw.test.R;

public class FragmentBackStackActivity extends Activity implements SecondFragment.FSecBtnOnClickListener {

    private FirstFragment.FFirBtnClickListener fFirBtnClickListener=new FirstFragment.FFirBtnClickListener() {
        @Override
        public void onFFirBtnClick() {
            FragmentManager fm=getFragmentManager();
            FragmentTransaction ft=fm.beginTransaction();
            ft.replace(R.id.fl_fragment_back_stack,new SecondFragment(),"Two");
            ft.addToBackStack(null);
            ft.commit();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_back_stack);
//        if(savedInstanceState==null){//防止屏幕旋转时候，Fragment重建  第1种方法
//            FragmentManager fm=getFragmentManager();
//            FragmentTransaction ft=fm.beginTransaction();
//            FirstFragment firstFragment=new FirstFragment();
//            firstFragment.setfFirBtnClickListener(fFirBtnClickListener);
//            ft.replace(R.id.fl_fragment_back_stack,firstFragment,"One");
//            ft.addToBackStack(null);
//            ft.commit();
//        }else{
//            Log.e("test",savedInstanceState.toString());
//        }

        
        if(getFragmentManager().findFragmentById(R.id.fl_fragment_back_stack)==null){//防止屏幕旋转时候，Fragment重建  第2种方法
            FragmentManager fm=getFragmentManager();
            FragmentTransaction ft=fm.beginTransaction();
            FirstFragment firstFragment=new FirstFragment();
            firstFragment.setfFirBtnClickListener(fFirBtnClickListener);
            ft.replace(R.id.fl_fragment_back_stack,firstFragment,"One");
            ft.addToBackStack(null);
            ft.commit();
        }


    }

    @Override
    public void onFSecClick() {
        FragmentManager fm=getFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        SecondFragment secondFragment= (SecondFragment) fm.findFragmentByTag("Two");
        ft.hide(secondFragment);
        ft.replace(R.id.fl_fragment_back_stack,new ThirdFragment(),"Third");
        ft.addToBackStack(null);
        ft.commit();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item)//menu的点击会先由Activity拦截，然后再传至Fragment
    {
        switch (item.getItemId())
        {
            case R.id.action_settings:
                Toast.makeText(this, "setting_activity", Toast.LENGTH_SHORT).show();
                return true;
            default:
                //如果希望Fragment自己处理MenuItem点击事件，一定不要忘了调用super.xxx
                return super.onOptionsItemSelected(item);
        }
    }
}
