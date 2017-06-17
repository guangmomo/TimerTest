package com.xlw.test.fragmenttest.bp.difAc;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xlw.test.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class GetAcMesFragment extends Fragment {


    private String str;

    private static final String ARGUMENT="argument";

    public GetAcMesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_get_ac_mes, container, false);
        TextView textView= (TextView) view.findViewById(R.id.tv_ac_mes);
        Bundle bundle=getArguments();
        if(bundle!=null){
            textView.setText(bundle.getString(ARGUMENT));
        }
        return view;
    }

    public static GetAcMesFragment newInstance(String argument){
        Bundle bundle=new Bundle();
        bundle.putString(ARGUMENT,argument);
        GetAcMesFragment getAcMesFragment=new GetAcMesFragment();
        getAcMesFragment.setArguments(bundle);
        return getAcMesFragment;
    }


}
