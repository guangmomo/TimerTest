package com.xlw.test.fragmenttest.viewpager;


import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xlw.test.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BaseFragment extends Fragment {




    @Override
    public void onAttach(Context context) {
        //当fragment 第一次与 Activity 产生关联时调用，以后不再调用
        super.onAttach(context);
        this.hashCode();
        Log.e("demoinfo",  this.getClass().getSimpleName()+"-->"+this.hashCode()+" onAttach() 方法执行！");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        //在 onAttach 执行完后会立刻调用此方法，通常被用于读取保存的状态值，获取或者初始化一些数据，
        // 但是该方法不执行，窗口是不会显示的，因此如果获取的数据需要访问网络，最好新开线程。
        super.onCreate(savedInstanceState);
        Log.e("demoinfo",  this.getClass().getSimpleName()+"-->"+this.hashCode()+" onCreate() 方法执行！");
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //创建 Fragment 中显示的 view, 其中 inflater 用来装载布局文件， container 表示 <fragment> 标签的父标签对应的 ViewGroup 对象，
        // savedInstanceState 可以获取 Fragment 保存的状态

        TextView textView = new TextView(getActivity());
        textView.setText(R.string.hello_blank_fragment);


        Log.e("demoinfo",  this.getClass().getSimpleName()+"-->"+this.hashCode()+" onCreateView() 方法执行！");

        if(null != savedInstanceState){
            Log.e("demoinfo", "保存了的数据： "+ savedInstanceState.getString("myinfo"));
        }else {
            Log.e("demoinfo", "没有保存的数据！");
        }
        return textView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        //在 Activity.onCreate() 方法调用后会立刻调用此方法，表示窗口已经初始化完毕，此时可以调用控件了

        super.onActivityCreated(savedInstanceState);
        Log.e("demoinfo",  this.getClass().getSimpleName()+"-->"+this.hashCode()+" onActivityCreated() 方法执行！");
    }

    @Override
    public void onStart() {
        //开始执行与控件相关的逻辑代码，如按键点击
        super.onStart();
        Log.e("demoinfo",  this.getClass().getSimpleName()+"-->"+this.hashCode()+" onStart() 方法执行！");
    }

    @Override
    public void onResume() {
        //这是 Fragment 从创建到显示的最后一个回调的方法
        super.onResume();
        Log.e("demoinfo",  this.getClass().getSimpleName()+"-->"+this.hashCode()+" onResume() 方法执行！");
    }

    @Override
    public void onPause() {
        //当发生界面跳转时，临时暂停，暂停时间是 500ms,0.5s后直接进入下面的 onStop 方法
        super.onPause();
        Log.e("demoinfo",  this.getClass().getSimpleName()+"-->"+this.hashCode()+" onPause() 方法执行！");
    }

    @Override
    public void onStop() {
        //当该方法返回时， Fragment 将从屏幕上消失
        super.onStop();
        Log.e("demoinfo",  this.getClass().getSimpleName()+"-->"+this.hashCode()+" onStop() 方法执行！");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e("demoinfo",  this.getClass().getSimpleName()+"-->"+this.hashCode()+" onSaveInstanceState() 方法执行！");
        outState.putString("myinfo", "haha");
    }

    @Override
    public void onDestroyView() {
        //当 fragment 状态被保存，或者从回退栈弹出，该方法被调用
        super.onDestroyView();
        Log.e("demoinfo",  this.getClass().getSimpleName()+"-->"+this.hashCode()+" onDestroyView() 方法执行！");
    }

    @Override
    public void onDestroy() {
        //当 Fragment 不再被使用时，如按返回键，就会调用此方法
        super.onDestroy();
        Log.e("demoinfo",  this.getClass().getSimpleName()+"-->"+this.hashCode()+" onDestroy() 方法执行！");
    }

    @Override
    public void onDetach() {
        //Fragment 生命周期的最后一个方法，执行完后将不再与 Activity 关联，将释放所有 fragment 对象和资源
        super.onDetach();
        Log.e("demoinfo",  this.getClass().getSimpleName()+"-->"+this.hashCode()+" onDetach() 方法执行！");
    }

    public BaseFragment() {
        // Required empty public constructor
    }


}
