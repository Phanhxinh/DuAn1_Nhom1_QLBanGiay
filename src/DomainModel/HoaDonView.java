/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

/**
 *
 * @author Admin
 */
public class HoaDonView {

    private String MaHD;
    private String TenNV;
    private String TenKH;
    private String NgayTao;
    private int TrangThai;

    public HoaDonView() {
    }

    public HoaDonView(String MaHD, String TenNV, String TenKH, String NgayTao, int TrangThai) {
        this.MaHD = MaHD;
        this.TenNV = TenNV;
        this.TenKH = TenKH;
        this.NgayTao = NgayTao;
        this.TrangThai = TrangThai;
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

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public String getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(String NgayTao) {
        this.NgayTao = NgayTao;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

    public String trangThai() {
        if (TrangThai == 1) {
            return "Đang chờ";
        } else if (TrangThai == 0) {
            return "Đã thanh toán";
        } else if (TrangThai == 2) {
            return "Chờ thanh toán";
        } else if (TrangThai == 3) {
            return "Đã hủy";
        }
        return null;
    }
}
