package com.xlw.test.fragmenttest.dynamicfragment;


import android.app.Fragment;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xlw.test.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DynamicContentFragment extends Fragment {


    public DynamicContentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_static_content, container, false);
    }

}
