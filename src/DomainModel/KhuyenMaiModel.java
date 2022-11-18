/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

/**
 *
 * @author DELL
 */
public class KhuyenMaiModel {
    private String ma;
    private String ten;
    private String khuyenmai;
    private String ngaybd;
    private String ngaykt;
    private String mota;

    public KhuyenMaiModel() {
    }

    public KhuyenMaiModel(String ma, String ten, String khuyenmai, String ngaybd, String ngaykt, String mota) {
        this.ma = ma;
        this.ten = ten;
        this.khuyenmai = khuyenmai;
        this.ngaybd = ngaybd;
        this.ngaykt = ngaykt;
        this.mota = mota;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getKhuyenmai() {
        return khuyenmai;
    }

    public void setKhuyenmai(String khuyenmai) {
        this.khuyenmai = khuyenmai;
    }

    public String getNgaybd() {
        return ngaybd;
    }

    public void setNgaybd(String ngaybd) {
        this.ngaybd = ngaybd;
    }

    public String getNgaykt() {
        return ngaykt;
    }

    public void setNgaykt(String ngaykt) {
        this.ngaykt = ngaykt;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
    
    
}
