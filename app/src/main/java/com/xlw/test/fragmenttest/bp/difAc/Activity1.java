package com.xlw.test.fragmenttest.bp.difAc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.xlw.test.R;

public class Activity1 extends Activity {

    EditText etFragMes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
        etFragMes= (EditText) findViewById(R.id.et_frag_mes);
    }

    public void toActivity2Fragment(View view) {
        Intent intent=new Intent(Activity1.this,Activity2.class);
        intent.putExtra("frag_mes",etFragMes.getText().toString());
        startActivity(intent);
    }
}
