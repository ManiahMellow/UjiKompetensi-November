package com.hilow.searchcar.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class History {

    @SerializedName("idorder")
    @Expose
    private Integer idorder;
    @SerializedName("idpelanggan")
    @Expose
    private Integer idpelanggan;
    @SerializedName("iduser")
    @Expose
    private Integer iduser;
    @SerializedName("penyewa")
    @Expose
    private String penyewa;
    @SerializedName("alamat")
    @Expose
    private String alamat;
    @SerializedName("jenismobil")
    @Expose
    private String jenismobil;
    @SerializedName("merkmobil")
    @Expose
    private String merkmobil;
    @SerializedName("tglorder")
    @Expose
    private String tglorder;
    @SerializedName("tglkembali")
    @Expose
    private String tglkembali;
    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("bayar")
    @Expose
    private Integer bayar;
    @SerializedName("kembali")
    @Expose
    private Integer kembali;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("created_at")
    @Expose
    private Object createdAt;
    @SerializedName("updated_at")
    @Expose
    private Object updatedAt;

    public Integer getIdorder() {
        return idorder;
    }

    public void setIdorder(Integer idorder) {
        this.idorder = idorder;
    }

    public Integer getIdpelanggan() {
        return idpelanggan;
    }

    public void setIdpelanggan(Integer idpelanggan) {
        this.idpelanggan = idpelanggan;
    }

    public Integer getIduser() {
        return iduser;
    }

    public void setIduser(Integer iduser) {
        this.iduser = iduser;}

    public String getPenyewa() {
        return penyewa;
    }

    public void setPenyewa(String penyewa) {
        this.penyewa = penyewa;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
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

    public String getTglorder() {
        return tglorder;
    }

    public void setTglorder(String tglorder) {
        this.tglorder = tglorder;
    }

    public String getTglkembali() {
        return tglkembali;
    }

    public void setTglkembali(String tglkembali) {
        this.tglkembali = tglkembali;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getBayar() {
        return bayar;
    }

    public void setBayar(Integer bayar) {
        this.bayar = bayar;
    }

    public Integer getKembali() {
        return kembali;
    }

    public void setKembali(Integer kembali) {
        this.kembali = kembali;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Object getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Object createdAt) {
        this.createdAt = createdAt;
    }

    public Object getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Object updatedAt) {
        this.updatedAt = updatedAt;
    }
}
