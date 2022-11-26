/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

/**
 *
 * @author Admin
 */
public class GioHang_BanHangModel {

    private String TenSP;
    private String LoaiSP;
    private String size;
    private String MauSac;
    private int SoLuong;
    private String DonGia;
    private String ThanhTien;
    private String Barcode;

    public GioHang_BanHangModel() {
    }

    public GioHang_BanHangModel(String TenSP, String LoaiSP, String size, String MauSac, int SoLuong, String DonGia, String ThanhTien, String Barcode) {
        this.TenSP = TenSP;
        this.LoaiSP = LoaiSP;
        this.size = size;
        this.MauSac = MauSac;
        this.SoLuong = SoLuong;
        this.DonGia = DonGia;
        this.ThanhTien = ThanhTien;
        this.Barcode = Barcode;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public String getLoaiSP() {
        return LoaiSP;
    }

    public void setLoaiSP(String LoaiSP) {
        this.LoaiSP = LoaiSP;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getMauSac() {
        return MauSac;
    }

    public void setMauSac(String MauSac) {
        this.MauSac = MauSac;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public String getDonGia() {
        return DonGia;
    }

    public void setDonGia(String DonGia) {
        this.DonGia = DonGia;
    }

    public String getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(String ThanhTien) {
        this.ThanhTien = ThanhTien;
    }

    public String getBarcode() {
        return Barcode;
    }

    public void setBarcode(String Barcode) {
        this.Barcode = Barcode;
    }

}
