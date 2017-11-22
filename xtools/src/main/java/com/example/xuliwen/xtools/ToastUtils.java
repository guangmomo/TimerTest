package com.example.xuliwen.xtools;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by xuliwen on 2017/11/22.
 */

public class ToastUtils {
	public static void toast(Context context, String content) {
		Toast.makeText(context, content, Toast.LENGTH_SHORT).show();
	}
}
