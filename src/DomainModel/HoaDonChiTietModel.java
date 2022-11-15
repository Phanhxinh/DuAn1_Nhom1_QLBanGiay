/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

/**
 *
 * @author Admin
 */
public class HoaDonChiTietModel {

    private String IdHoaDon;
    private String IdChiTietSP;
    private String IdKM;
    private String SoLuong;
    private String DonGia;

    public HoaDonChiTietModel() {
    }

    public HoaDonChiTietModel(String IdHoaDon, String IdChiTietSP, String IdKM, String SoLuong, String DonGia) {
        this.IdHoaDon = IdHoaDon;
        this.IdChiTietSP = IdChiTietSP;
        this.IdKM = IdKM;
        this.SoLuong = SoLuong;
        this.DonGia = DonGia;
    }

    public String getIdHoaDon() {
        return IdHoaDon;
    }

    public void setIdHoaDon(String IdHoaDon) {
        this.IdHoaDon = IdHoaDon;
    }

    public String getIdChiTietSP() {
        return IdChiTietSP;
    }

    public void setIdChiTietSP(String IdChiTietSP) {
        this.IdChiTietSP = IdChiTietSP;
    }

    public String getIdKM() {
        return IdKM;
    }

    public void setIdKM(String IdKM) {
        this.IdKM = IdKM;
    }

    public String getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(String SoLuong) {
        this.SoLuong = SoLuong;
    }

    public String getDonGia() {
        return DonGia;
    }

    public void setDonGia(String DonGia) {
        this.DonGia = DonGia;
    }

    public String toString(){
        return getIdChiTietSP();
    }
}
