package com.xlw.test;

import android.app.Application;
import android.content.Context;

/**
 * Created by xlw on 2019/10/18.
 */

public class App extends Application {

    private static Context context;

    public static volatile String  currentName="xuliwen";

    @Override
    public void onCreate() {
        super.onCreate();
        context=this.getApplicationContext();
    }

    public static Context getContext(){
        return context;
    }


}
