package com.h5190048.rabia_kose_final.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.h5190048.rabia_kose_final.adaptor.AgacAdaptor;
import com.h5190048.rabia_kose_final.model.AgacModel;
import com.h5190048.rabia_kose_final.util.AlertDialogUtil;
import com.h5190048.rabia_kose_final.util.Constants;
import com.h5190048.rabia_kose_final.util.ObjectUtil;
import com.h5190048.rabia_kose_final.R;
import com.h5190048.rabia_kose_final.network.Service;


import java.util.ArrayList;
import java.util.List;


import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ListeActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste);

        progressDialog = new ProgressDialog(ListeActivity.this);
        progressDialog.setMessage(getResources().getString(R.string.progress_bekleyiniz));
        progressDialog.show();

        init();


    }

    private  void  init()
    {
        agaclariGetir();
    }

    void  agaclariGetir()
    {

        new Service().getServiceApi().agaclariGetir().
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<AgacModel>>() {

                    List<AgacModel> agaclar=new ArrayList<>();

                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("RETROFIT","onSubscribe : ");
                    }

                    @Override
                    public void onNext(List<AgacModel> agacList) {
                        Log.e("RETROFIT","onNext : ");
                        agaclar=agacList;
                    }

                    @Override
                    public void onError(Throwable e) {

                        Log.e("RETROFIT","onError : " + e.getLocalizedMessage());
                        progressDialog.dismiss();
                    }

                    @Override
                    public void onComplete()
                    {
                        Log.e("RETROFIT","onComplete : ");
                        progressDialog.dismiss();

                        if(agaclar.size()>0) {



                            initRecycleView(agaclar);
                        }
                    }
                });
    }

    @Override
    public void onBackPressed() {
        AlertDialogUtil.dialogUtil(ListeActivity.this,
                getResources().getString(R.string.programda_uyari),
                getResources().getString(R.string.programdan_cikma),
                getResources().getString(R.string.programdan_evet),
                getResources().getString(R.string.programdan_hayir),
                getResources().getString(R.string.liste_activity));
     }

    private  void  initRecycleView(List<AgacModel> agacList)
    {
        recyclerView =findViewById(R.id.rcvAgaclar);
        AgacAdaptor agacAdaptor =new AgacAdaptor(agacList, getApplicationContext(), new AgacAdaptor.OnItemClickListener() {
            @Override
            public void onClik(int position) {

                AgacModel tiklananAgac=agacList.get(position);
                Toast.makeText(getApplicationContext(), getResources().getString(R.string.tiklanan_adi) + tiklananAgac.getAdi(), Toast.LENGTH_SHORT).show();
                opennextActivity(tiklananAgac);

            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(agacAdaptor);
    }
    private void opennextActivity(AgacModel tiklananAgac){
        Intent secondActivityIntent=new Intent(getApplicationContext(), AgacDetayActivity.class);
        String tiklananAgacString= ObjectUtil.agacToJsonString(tiklananAgac);
        secondActivityIntent.putExtra(Constants.TIKLANAN_AGAC_TASINANIN_BASLIGI,tiklananAgacString);
        startActivity(secondActivityIntent);
    }

}