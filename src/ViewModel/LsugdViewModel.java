/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

/**
 *
 * @author Admin
 */
public class LsugdViewModel {
    private String tenkh;
    private String SDT;
    private String NgayTT ;
    private String TenSP;
    private String sluong;
    private String GIaBan;
    private String thanhtien;
    private String trangthai;

    public LsugdViewModel() {
    }

    public LsugdViewModel(String tenkh, String SDT, String NgayTT, String TenSP, String sluong, String GIaBan, String thanhtien, String trangthai) {
        this.tenkh = tenkh;
        this.SDT = SDT;
        this.NgayTT = NgayTT;
        this.TenSP = TenSP;
        this.sluong = sluong;
        this.GIaBan = GIaBan;
        this.thanhtien = thanhtien;
        this.trangthai = trangthai;
    }

    public String getTenkh() {
        return tenkh;
    }

    public void setTenkh(String tenkh) {
        this.tenkh = tenkh;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getNgayTT() {
        return NgayTT;
    }

    public void setNgayTT(String NgayTT) {
        this.NgayTT = NgayTT;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public String getSluong() {
        return sluong;
    }

    public void setSluong(String sluong) {
        this.sluong = sluong;
    }

    public String getGIaBan() {
        return GIaBan;
    }

    public void setGIaBan(String GIaBan) {
        this.GIaBan = GIaBan;
    }

    public String getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(String thanhtien) {
        this.thanhtien = thanhtien;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

   
    
        
}
