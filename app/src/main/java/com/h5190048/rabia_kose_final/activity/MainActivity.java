package com.h5190048.rabia_kose_final.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

import com.h5190048.rabia_kose_final.R;
import com.h5190048.rabia_kose_final.util.AlertDialogUtil;
import com.h5190048.rabia_kose_final.util.NetworkUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        zamanlamayiBaslat();
    }
    public void zamanlamayiBaslat(){
        CountDownTimer countDownTimer =new CountDownTimer(3000,1000) {
            @Override
            public void onTick(long l) {
            }
            @Override
            public void onFinish() {

                if(NetworkUtil.InternetKontrol(getApplicationContext()))
                {
                    Intent listeekraninagecis=new Intent(getApplicationContext(),ListeActivity.class);
                    startActivity(listeekraninagecis);
                    finish();
                }
    else
                {
                    InternetiKontrolEtmeMethod();
                }

            }
        };
        countDownTimer.start();
    }
    public void InternetiKontrolEtmeMethod(){
        AlertDialogUtil.dialogUtil(MainActivity.this,
                getResources().getString(R.string.internet_yok),
                getResources().getString(R.string.internet_bagla),
                getResources().getString(R.string.ayarlar_git),
                getResources().getString(R.string.uygulama_kapat),
                getResources().getString(R.string.main_activity));
         }
}