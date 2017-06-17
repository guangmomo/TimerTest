package com.xlw.test.fragmenttest.fragmentbackstack;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.xlw.test.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {


    public FirstFragment() {
        // Required empty public constructor
    }

    private FFirBtnClickListener fFirBtnClickListener;

    public interface FFirBtnClickListener{
        void onFFirBtnClick();
    }

    public void setfFirBtnClickListener(FFirBtnClickListener fFirBtnClickListener){
        this.fFirBtnClickListener=fFirBtnClickListener;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_first, container, false);
        view.findViewById(R.id.btn_to_second_fragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              fFirBtnClickListener.onFFirBtnClick();
            }
        });
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.id_menu_fra_test:
                Toast.makeText(getActivity(), "FragmentMenuItem1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_settings:
                Toast.makeText(getActivity(), "Setting", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}
