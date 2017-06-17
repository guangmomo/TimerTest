package com.xlw.test.fragmenttest.bp.samAc;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.xlw.test.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment {
    private String mArgument;
    public static final String ARGUMENT = "argument";
    public static final String RESPONSE = "response";
    public static final String EVALUATE_DIALOG = "evaluate_dialog";
    public static final int REQUEST_EVALUATE = 0X110;
    TextView textView;


    public Fragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_fragment1, container, false);
        textView= (TextView) view.findViewById(R.id.tv_mes_fragment2);
        Button btnToFragment2= (Button) view.findViewById(R.id.btn_to_fragment2);
        btnToFragment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment2 fragment2=new Fragment2();
                fragment2.setTargetFragment(Fragment1.this,REQUEST_EVALUATE);
                FragmentManager fm= getFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.addToBackStack(null);
                ft.hide(Fragment1.this);
                ft.add(R.id.ll_same_activity,fragment2,"Second");
                ft.commit();

            }
        });
        return view;
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_EVALUATE && data!=null){
            textView.setText(data.getStringExtra(Fragment2.RESPONSE_EVALUATE));
        }
    }
}
