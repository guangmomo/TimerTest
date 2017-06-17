package com.xlw.test.fragmenttest.dialogfragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import com.xlw.test.R;



public class DialogFragmentActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_fragment);
    }

    public void toAlertDialog(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // Get the layout inflater
        View viewDialog = getLayoutInflater().inflate(R.layout.fragment_dialog_login, null);
        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(viewDialog)
                // Add action buttons
                .setPositiveButton("Sign in",
                        new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialog, int id)
                            {
                            }
                        }).setNegativeButton("Cancel", null).show();
        builder.create();
    }

    public void toDialogFragment(View view) {
        new DialogLoginFragment().show(getFragmentManager(),"DialogLoginFragment");
    }
}
