/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModel.SanPham_BanhangModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class BanHangRepo {

    public ArrayList<SanPham_BanhangModel> getall() {
        ArrayList list = new ArrayList<SanPham_BanhangModel>();
        try {
            Connection conn = Connections.jdbcUtils.getConnection();
            String sql = "select b.TenSP,c.TenTL,d.TenHang,e.TenCL,f.TenKC,g.TenMS,h.TenDe,a.SoLuong,a.GiaBan,a.BarCode "
                    + "from ChiTietSP a "
                    + "join SanPham b on a.IdSanPham=b.Id "
                    + "join TheLoai c on a.IdLoaiSP = c.Id "
                    + "join Hang d on a.IdHang=d.Id "
                    + "join ChatLieu e on a.IdChatLieu=e.Id "
                    + "join KichCo f on a.IdKichCo=f.Id "
                    + "join MauSac g on a.IdMauSac=g.Id"
                    + " join De h on a.IdDe=h.Id";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String tenSP = rs.getString("TenSP");
                String tenTL = rs.getString("TenTL");
                String tenHang = rs.getString("TenHang");
                String tenCL = rs.getString("TenCL");
                String tenKC = rs.getString("TenKC");
                String tenMS = rs.getString("TenMS");
                String tenDe = rs.getString("TenDe");
                String soLuong = rs.getString("SoLuong");
                String giaBan = rs.getString("GiaBan");
                String barcode = rs.getString("BarCode");
                SanPham_BanhangModel spbm = new SanPham_BanhangModel(tenSP, tenTL, tenHang, tenCL, tenKC, tenMS, tenDe, soLuong, giaBan, barcode);
                list.add(spbm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<SanPham_BanhangModel> FindTen(String ten) {
        ArrayList list = new ArrayList<SanPham_BanhangModel>();
        try {
            Connection conn = Connections.jdbcUtils.getConnection();
            String sql = "select b.TenSP,c.TenTL,d.TenHang,e.TenCL,f.TenKC,g.TenMS,h.TenDe,a.SoLuong,a.GiaBan,a.BarCode "
                    + "from ChiTietSP a "
                    + "join SanPham b on a.IdSanPham=b.Id "
                    + "join TheLoai c on a.IdLoaiSP = c.Id "
                    + "join Hang d on a.IdHang=d.Id "
                    + "join ChatLieu e on a.IdChatLieu=e.Id "
                    + "join KichCo f on a.IdKichCo=f.Id "
                    + "join MauSac g on a.IdMauSac=g.Id"
                    + " join De h on a.IdDe=h.Id "
                    + "where b.TenSP like N'%" + ten + "%'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String tenSP = rs.getString("TenSP");
                String tenTL = rs.getString("TenTL");
                String tenHang = rs.getString("TenHang");
                String tenCL = rs.getString("TenCL");
                String tenKC = rs.getString("TenKC");
                String tenMS = rs.getString("TenMS");
                String tenDe = rs.getString("TenDe");
                String soLuong = rs.getString("SoLuong");
                String giaBan = rs.getString("GiaBan");
                String barcode = rs.getString("BarCode");
                SanPham_BanhangModel spbm = new SanPham_BanhangModel(tenSP, tenTL, tenHang, tenCL, tenKC, tenMS, tenDe, soLuong, giaBan, barcode);
                list.add(spbm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
