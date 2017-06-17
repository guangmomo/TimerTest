package com.xlw.test;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimerTestActivity extends AppCompatActivity {

    private Context mContext;
    TextView textView;
    String test="abbbb";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext=this;
        textView= (TextView) findViewById(R.id.tv_test);
        textView.setText(highLight(test,"^a*"));
    }


    public SpannableStringBuilder highLight(String text, String target) {
        SpannableStringBuilder spannable = new SpannableStringBuilder(text);
        CharacterStyle span ;

        Pattern p = Pattern.compile(target);
        Matcher m = p.matcher(text);
        while (m.find()) {
            span = new ForegroundColorSpan(Color.RED);// 需要重复！
            spannable.setSpan(span, m.start(), m.end(),
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        return spannable;
    }


    public void alarmManager(View view){
        AlarmManager am = (AlarmManager)mContext.getSystemService(Context.ALARM_SERVICE);
// Schedule the alarm!
        Intent intent = new Intent("timer_alarm_manager");
      //  Intent intent = new Intent(this,AlarmManagerActivity.class);
        intent.putExtra("xlw","xlw_alarm_manager");
        int requestCode=1;
        int firstTime=2000;
      //  PendingIntent sender = PendingIntent.getBroadcast(mContext,requestCode, intent, 0);
        PendingIntent sender = PendingIntent.getService(mContext,requestCode, intent, 0);
      //  PendingIntent sender = PendingIntent.getActivity(mContext,requestCode, intent, 0);
        am.setRepeating(AlarmManager.RTC,
                System.currentTimeMillis(), 2000, sender);
    }

    public void handler(View view){
       // handler.sendEmptyMessage(0);
        handler.sendEmptyMessageDelayed(0,4000);
    }

    public void timer(View view){
        Timer timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Log.e("timer","timer_timer");
            }
        },1000,3000);
    }

    private Handler.Callback callback=new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            return false;
        }
    };

    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    Log.e("timer","timer_handler");
                    // 移除所有的msg.what为0等消息，保证只有一个循环消息队列再跑
                    handler.removeMessages(0);
                    // app的功能逻辑处理.......
                    // 再次发出msg，循环更新
                    handler.sendEmptyMessageDelayed(0, 1000);
                    break;
            }
        }
    };


    public void thread(View view){
        //TODO 逻辑简单，不做实现
    }
}
