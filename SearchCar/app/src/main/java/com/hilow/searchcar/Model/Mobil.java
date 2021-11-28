package com.hilow.searchcar.Model;

import androidx.cardview.widget.CardView;

public class Mobil {

  private String jenislist, merkmobil, hargasewa;
  private Integer gambarmobil;

    public Mobil(String jenislist, String merkmobil, String hargasewa, Integer gambarmobil) {
        this.jenislist = jenislist;
        this.merkmobil = merkmobil;
        this.hargasewa = hargasewa;
        this.gambarmobil = gambarmobil;
    }

    public String getJenislist() {
        return jenislist;
    }

    public void setJenislist(String jenislist) {
        this.jenislist = jenislist;
    }

    public String getMerkmobil() {
        return merkmobil;
    }

    public void setMerkmobil(String merkmobil) {
        this.merkmobil = merkmobil;
    }

    public String getHargasewa() {
        return hargasewa;
    }

    public void setHargasewa(String hargasewa) {
        this.hargasewa = hargasewa;
    }

    public Integer getGambarmobil() {
        return gambarmobil;
    }

    public void setGambarmobil(Integer gambarmobil) {
        this.gambarmobil = gambarmobil;
    }
}
