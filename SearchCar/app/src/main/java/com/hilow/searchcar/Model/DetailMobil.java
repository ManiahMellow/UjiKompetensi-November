package com.hilow.searchcar.Model;

public class DetailMobil {

    private String detailjenis ,detailmerk, detailharga;
    private Integer detailgambar;

    public DetailMobil(String detailjenis, String detailmerk, String detailharga, Integer detailgambar) {
        this.detailjenis = detailjenis;
        this.detailmerk = detailmerk;
        this.detailharga = detailharga;
        this.detailgambar = detailgambar;
    }

    public String getDetailjenis() {
        return detailjenis;
    }

    public void setDetailjenis(String detailjenis) {
        this.detailjenis = detailjenis;
    }

    public String getDetailmerk() {
        return detailmerk;
    }

    public void setDetailmerk(String detailmerk) {
        this.detailmerk = detailmerk;
    }

    public String getDetailharga() {
        return detailharga;
    }

    public void setDetailharga(String detailharga) {
        this.detailharga = detailharga;
    }

    public Integer getDetailgambar() {
        return detailgambar;
    }

    public void setDetailgambar(Integer detailgambar) {
        this.detailgambar = detailgambar;
    }
}
