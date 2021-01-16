package com.h5190048.rabia_kose_final.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.h5190048.rabia_kose_final.model.AgacModel;
import com.h5190048.rabia_kose_final.util.Constants;
import com.h5190048.rabia_kose_final.util.GlideUtil;
import com.h5190048.rabia_kose_final.util.ObjectUtil;
import com.h5190048.rabia_kose_final.R;

public class AgacDetayActivity extends AppCompatActivity {

    ImageView imgKapak;
    TextView txtAdi, txtBilimselAdi, txtUstSinifi, txtOrtalamaBoyu, txtAilesi, txtAciklama;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agac_detay);
        init();



    }
    private void init(){

        String tasinanAgacString=getIntent().getStringExtra(Constants.TIKLANAN_AGAC_TASINANIN_BASLIGI);
        AgacModel agacModel= ObjectUtil.jsonStringToAgac(tasinanAgacString);

        imgKapak=findViewById(R.id.imgKapak);
        txtAdi=findViewById(R.id.txtAdi);
        txtBilimselAdi=findViewById(R.id.txtBilimselAdi);
        txtUstSinifi=findViewById(R.id.txtUstSinifi);
        txtOrtalamaBoyu=findViewById(R.id.txtOrtalamaBoyu);
        txtAilesi=findViewById(R.id.txtAilesi);
        txtAciklama=findViewById(R.id.txtAciklama);


        txtAdi.setText((agacModel.getAdi()));
        txtBilimselAdi.setText(agacModel.getBilimselAdi());
        txtUstSinifi.setText(agacModel.getUstSinifi());
        txtOrtalamaBoyu.setText(agacModel.getOrtalamaBoyu());
        txtAilesi.setText(agacModel.getAilesi());
        txtAciklama.setText(agacModel.getAciklama());


        GlideUtil.resmiIndiripGoster(getApplicationContext(),agacModel.getBuyukFotoUrl(),imgKapak);


    }
}