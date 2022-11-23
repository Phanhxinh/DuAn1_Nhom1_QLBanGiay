/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

/**
 *
 * @author Admin
 */
public class HoaDon_BanHangModel {

    private String MaHD;
    private String TenNV;
    private int TrangThai;
    private String NgayTao;

    public HoaDon_BanHangModel() {
    }

    public HoaDon_BanHangModel(String MaHD, String TenNV, int TrangThai, String NgayTao) {
        this.MaHD = MaHD;
        this.TenNV = TenNV;
        this.TrangThai = TrangThai;
        this.NgayTao = NgayTao;
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

    public String getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(String NgayTao) {
        this.NgayTao = NgayTao;
    }

    public String trangThai() {
        if (TrangThai == 1) {
            return "Đang chờ";
        } else if (TrangThai == 0) {
            return "Đã thanh toán";
        } else if (TrangThai == 2) {
            return "Chờ thanh toán";
        }
        return null;
    }
}
