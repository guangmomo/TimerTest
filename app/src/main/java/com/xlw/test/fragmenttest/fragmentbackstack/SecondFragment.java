package com.xlw.test.fragmenttest.fragmentbackstack;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xlw.test.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {


    public SecondFragment() {
        // Required empty public constructor
    }

    public interface FSecBtnOnClickListener{
        void onFSecClick();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_second, container, false);
        view.findViewById(R.id.btn_to_third_fragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getActivity() instanceof FSecBtnOnClickListener){
                    ((FSecBtnOnClickListener)getActivity()).onFSecClick();
                }
            }
        });
        return view;
    }

}
