package DomainModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Admin
 */
public class KhuyenMai_BanHangModel {

    private String IdKM;
    private String TenKM;
    private String NgayBD;
    private String NgayKT;
    private String GiamGia;

    public KhuyenMai_BanHangModel() {
    }

    public KhuyenMai_BanHangModel(String IdKM, String TenKM, String NgayBD, String NgayKT, String GiamGia) {
        this.IdKM = IdKM;
        this.TenKM = TenKM;
        this.NgayBD = NgayBD;
        this.NgayKT = NgayKT;
        this.GiamGia = GiamGia;
    }

    public String getIdKM() {
        return IdKM;
    }

    public void setIdKM(String IdKM) {
        this.IdKM = IdKM;
    }

    public String getTenKM() {
        return TenKM;
    }

    public void setTenKM(String TenKM) {
        this.TenKM = TenKM;
    }

    public String getNgayBD() {
        return NgayBD;
    }

    public void setNgayBD(String NgayBD) {
        this.NgayBD = NgayBD;
    }

    public String getNgayKT() {
        return NgayKT;
    }

    public void setNgayKT(String NgayKT) {
        this.NgayKT = NgayKT;
    }

    public String getGiamGia() {
        return GiamGia;
    }

    public void setGiamGia(String GiamGia) {
        this.GiamGia = GiamGia;
    }

    public String toString() {
        return IdKM;
    }
}
