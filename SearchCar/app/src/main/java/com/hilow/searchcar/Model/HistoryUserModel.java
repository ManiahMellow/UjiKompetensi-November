package com.hilow.searchcar.Model;

public class HistoryUserModel {

    private String jenisuser;
    private String merkuser;
    private String sewauser;
    private String kembaliuser;
    private String totaluser;

    public HistoryUserModel(String jenisuser, String merkuser, String sewauser, String kembaliuser, String totaluser) {
        this.jenisuser = jenisuser;
        this.merkuser = merkuser;
        this.sewauser = sewauser;
        this.kembaliuser = kembaliuser;
        this.totaluser = totaluser;
    }

    public String getJenisuser() {
        return jenisuser;
    }

    public void setJenisuser(String jenisuser) {
        this.jenisuser = jenisuser;
    }

    public String getMerkuser() {
        return merkuser;
    }

    public void setMerkuser(String merkuser) {
        this.merkuser = merkuser;
    }

    public String getSewauser() {
        return sewauser;
    }

    public void setSewauser(String sewauser) {
        this.sewauser = sewauser;
    }

    public String getKembaliuser() {
        return kembaliuser;
    }

    public void setKembaliuser(String kembaliuser) {
        this.kembaliuser = kembaliuser;
    }

    public String getTotaluser() {
        return totaluser;
    }

    public void setTotaluser(String totaluser) {
        this.totaluser = totaluser;
    }
}
