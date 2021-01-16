package com.h5190048.rabia_kose_final.network;


import com.h5190048.rabia_kose_final.model.AgacModel;


import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ServiceApi {

    //base url
    //
    @GET("agaclar.json")
    Observable<List<AgacModel>> agaclariGetir();
}
