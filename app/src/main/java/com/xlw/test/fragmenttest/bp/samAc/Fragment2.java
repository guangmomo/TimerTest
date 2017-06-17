package com.xlw.test.fragmenttest.bp.samAc;


import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.xlw.test.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment2 extends Fragment {

    EditText editText;
    public static final String RESPONSE_EVALUATE = "response_evaluate";

    public Fragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_fragment2, container, false);
        editText= (EditText) view.findViewById(R.id.et_fragment2);
        setResult();
        return view;

    }


    private void setResult(){
        if(getTargetFragment()==null){
            return;
        }
        Intent intent=new Intent();
        intent.putExtra(RESPONSE_EVALUATE,"response_evaluate");
        getTargetFragment().onActivityResult(Fragment1.REQUEST_EVALUATE, Activity.RESULT_OK,intent);
    }

}
