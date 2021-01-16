package com.h5190048.rabia_kose_final.util;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

import androidx.appcompat.app.AlertDialog;

import com.h5190048.rabia_kose_final.R;

public class AlertDialogUtil {
    public static void dialogUtil(Context context, String ilkSatir, String ikinciSatir, String evet, String hayir , String sayfa)
    {
        AlertDialog.Builder builder =new AlertDialog.Builder(context);
        builder.setTitle(ilkSatir);
        builder.setMessage(ikinciSatir);
        builder.setPositiveButton(evet, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface window, int i) {
                if(sayfa.toString() == context.getResources().getString(R.string.main_activity)){
                    context.startActivity(new Intent(android.provider.Settings.ACTION_SETTINGS));
                }
                else{
                    ((Activity)context).onBackPressed();
                    ((Activity)context).finish();
                }

            }
        });

        builder.setNegativeButton(hayir, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface window, int i) {
                if(sayfa.toString() == context.getResources().getString(R.string.main_activity)){
                    ((Activity)context).finish();
                }
                else{
                    window.dismiss();
                }

            }
        });
        builder.show();
    }
}
