package com.xlw.test.fragmenttest.dialogfragment;


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.os.Bundle;
import android.view.View;

import com.xlw.test.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DialogLoginFragment extends DialogFragment {


    public DialogLoginFragment() {
        // Required empty public constructor
    }


  /*  @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        return inflater.inflate(R.layout.fragment_dialog_login, container, false);
    }*/

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        View view=getActivity().getLayoutInflater().inflate(R.layout.fragment_dialog_login,null);
        builder.setView(view);
        return builder.create();
    }
}
