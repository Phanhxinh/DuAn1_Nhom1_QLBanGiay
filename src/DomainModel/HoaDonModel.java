/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

/**
 *
 * @author Admin
 */
public class HoaDonModel {

    private String IdHD;
    private String IdKH;
    private String IdNV;
    private String IdKM;
    private String MaHD;
    private String TrangThai;

    public HoaDonModel() {
    }

    public HoaDonModel(String IdHD, String IdKH, String IdNV, String IdKM, String MaHD, String TrangThai) {
        this.IdHD = IdHD;
        this.IdKH = IdKH;
        this.IdNV = IdNV;
        this.IdKM = IdKM;
        this.MaHD = MaHD;
        this.TrangThai = TrangThai;
    }

    public String getIdHD() {
        return IdHD;
    }

    public void setIdHD(String IdHD) {
        this.IdHD = IdHD;
    }

    public String getIdKH() {
        return IdKH;
    }

    public void setIdKH(String IdKH) {
        this.IdKH = IdKH;
    }

    public String getIdNV() {
        return IdNV;
    }

    public void setIdNV(String IdNV) {
        this.IdNV = IdNV;
    }

    public String getIdKM() {
        return IdKM;
    }

    public void setIdKM(String IdKM) {
        this.IdKM = IdKM;
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    public String toString(){
        return IdHD;
    }
}
