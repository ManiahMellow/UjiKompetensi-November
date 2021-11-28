package com.hilow.searchcar.Model;

public class HistoryAdminModel {
    private String namapenyewa;
    private String alamatpenyewa;
    private String tglsewa;
    private String tglkembali;
    private String jenismobil;
    private String merkmobil;
    private String hargatotal;

    public HistoryAdminModel(String namapenyewa, String alamatpenyewa, String tglsewa, String tglkembali, String jenismobil, String merkmobil, String hargatotal) {
        this.namapenyewa = namapenyewa;
        this.alamatpenyewa = alamatpenyewa;
        this.tglsewa = tglsewa;
        this.tglkembali = tglkembali;
        this.jenismobil = jenismobil;
        this.merkmobil = merkmobil;
        this.hargatotal = hargatotal;
    }

    public String getNamapenyewa() {
        return namapenyewa;
    }

    public void setNamapenyewa(String namapenyewa) {
        this.namapenyewa = namapenyewa;
    }

    public String getAlamatpenyewa() {
        return alamatpenyewa;
    }

    public void setAlamatpenyewa(String alamatpenyewa) {
        this.alamatpenyewa = alamatpenyewa;
    }

    public String getTglsewa() {
        return tglsewa;
    }

    public void setTglsewa(String tglsewa) {
        this.tglsewa = tglsewa;
    }

    public String getTglkembali() {
        return tglkembali;
    }

    public void setTglkembali(String tglkembali) {
        this.tglkembali = tglkembali;
    }

    public String getJenismobil() {
        return jenismobil;
    }

    public void setJenismobil(String jenismobil) {
        this.jenismobil = jenismobil;
    }

    public String getMerkmobil() {
        return merkmobil;
    }

    public void setMerkmobil(String merkmobil) {
        this.merkmobil = merkmobil;
    }

    public String getHargatotal() {
        return hargatotal;
    }

    public void setHargatotal(String hargatotal) {
        this.hargatotal = hargatotal;
    }
}
