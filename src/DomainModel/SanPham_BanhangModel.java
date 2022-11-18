/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

/**
 *
 * @author Admin
 */
public class SanPham_BanhangModel {

    private String IdChiTietSP;
    private String TenSP;
    private String LoaiSP;
    private String Hang;
    private String ChatLieu;
    private String KichCo;
    private String MauSac;
    private String De;
    private String SoLuong;
    private String GiaBan;
    private String Barcode;

    public SanPham_BanhangModel() {
    }

    public SanPham_BanhangModel(String IdChiTietSP, String TenSP, String LoaiSP, String Hang, String ChatLieu, String KichCo, String MauSac, String De, String SoLuong, String GiaBan, String Barcode) {
        this.IdChiTietSP = IdChiTietSP;
        this.TenSP = TenSP;
        this.LoaiSP = LoaiSP;
        this.Hang = Hang;
        this.ChatLieu = ChatLieu;
        this.KichCo = KichCo;
        this.MauSac = MauSac;
        this.De = De;
        this.SoLuong = SoLuong;
        this.GiaBan = GiaBan;
        this.Barcode = Barcode;
    }

    public String getIdChiTietSP() {
        return IdChiTietSP;
    }

    public void setIdChiTietSP(String IdChiTietSP) {
        this.IdChiTietSP = IdChiTietSP;
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

    public String getHang() {
        return Hang;
    }

    public void setHang(String Hang) {
        this.Hang = Hang;
    }

    public String getChatLieu() {
        return ChatLieu;
    }

    public void setChatLieu(String ChatLieu) {
        this.ChatLieu = ChatLieu;
    }

    public String getKichCo() {
        return KichCo;
    }

    public void setKichCo(String KichCo) {
        this.KichCo = KichCo;
    }

    public String getMauSac() {
        return MauSac;
    }

    public void setMauSac(String MauSac) {
        this.MauSac = MauSac;
    }

    public String getDe() {
        return De;
    }

    public void setDe(String De) {
        this.De = De;
    }

    public String getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(String SoLuong) {
        this.SoLuong = SoLuong;
    }

    public String getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(String GiaBan) {
        this.GiaBan = GiaBan;
    }

    public String getBarcode() {
        return Barcode;
    }

    public void setBarcode(String Barcode) {
        this.Barcode = Barcode;
    }

    public String toString(){
        return IdChiTietSP;
    }
}
