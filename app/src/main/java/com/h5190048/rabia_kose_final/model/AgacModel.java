package com.h5190048.rabia_kose_final.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AgacModel {

    @SerializedName("Adi")
    @Expose
    private String adi;
    @SerializedName("BilimselAdi")
    @Expose
    private String bilimselAdi;
    @SerializedName("UstSinifi")
    @Expose
    private String ustSinifi;
    @SerializedName("OrtalamaBoyu")
    @Expose
    private String ortalamaBoyu;
    @SerializedName("Ailesi")
    @Expose
    private String ailesi;
    @SerializedName("BuyukFotoUrl")
    @Expose
    private String buyukFotoUrl;
    @SerializedName("KucukFotoUrl")
    @Expose
    private String kucukFotoUrl;
    @SerializedName("Aciklama")
    @Expose
    private String aciklama;

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getBilimselAdi() {
        return bilimselAdi;
    }

    public void setBilimselAdi(String bilimselAdi) {
        this.bilimselAdi = bilimselAdi;
    }

    public String getUstSinifi() {
        return ustSinifi;
    }

    public void setUstSinifi(String ustSinifi) {
        this.ustSinifi = ustSinifi;
    }

    public String getOrtalamaBoyu() {
        return ortalamaBoyu;
    }

    public void setOrtalamaBoyu(String ortalamaBoyu) {
        this.ortalamaBoyu = ortalamaBoyu;
    }

    public String getAilesi() {
        return ailesi;
    }

    public void setAilesi(String ailesi) {
        this.ailesi = ailesi;
    }

    public String getBuyukFotoUrl() {
        return buyukFotoUrl;
    }

    public void setBuyukFotoUrl(String buyukFotoUrl) {
        this.buyukFotoUrl = buyukFotoUrl;
    }

    public String getKucukFotoUrl() {
        return kucukFotoUrl;
    }

    public void setKucukFotoUrl(String kucukFotoUrl) {
        this.kucukFotoUrl = kucukFotoUrl;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

}
