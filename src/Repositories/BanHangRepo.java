/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModel.SanPham_BanhangModel;
import DomainModel.GioHang_BanHangModel;
import DomainModel.HoaDon_BanHangModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class BanHangRepo {

//    đẩy dữ liệu lên view sản phẩm
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

//     tìm kiếm sản phẩm 
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

    public ArrayList<GioHang_BanHangModel> getAllGioHang(String ten, String barcode) {
        ArrayList list = new ArrayList<SanPham_BanhangModel>();
        try {
            Connection conn = Connections.jdbcUtils.getConnection();
            String sql = "select b.TenSP,c.TenTL,a.GiaBan from ChiTietSP a "
                    + "join SanPham b on a.IdSanPham=b.Id "
                    + "join TheLoai c on a.IdLoaiSP=c.Id where TenSP=? or a.BarCode=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ten);
            ps.setString(2, barcode);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String tenSp = rs.getString("TenSP");
                String tenTL = rs.getString("TenTL");
                String giaBan = rs.getString("GiaBan");
                GioHang_BanHangModel ghbhm = new GioHang_BanHangModel(tenSp, tenTL, 0, giaBan, null);
                list.add(ghbhm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    //Thêm sản phẩm vào hóa đơn
    public ArrayList<HoaDon_BanHangModel> getAllHoaDon() {
        ArrayList list = new ArrayList<HoaDon_BanHangModel>();
        try {
            Connection conn = Connections.jdbcUtils.getConnection();
            String sql = "select a.MaHD,b.TenNV,a.TrangThai,a.NgayTao from HoaDon a join NhanVien b on a.IdNV=b.Id order by a.MaHD asc";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String mahd = rs.getString("MaHD");
                String tennv = rs.getString("TenNV");
                int trangthai = rs.getInt("TrangThai");
                String ngaytao = rs.getString("NgayTao");
                HoaDon_BanHangModel hdbhm = new HoaDon_BanHangModel(mahd, tennv, trangthai, ngaytao);
                list.add(hdbhm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //Lọc hóa đơn thanh toán
    public ArrayList<HoaDon_BanHangModel> getHoaDonThanhToan() {
        ArrayList list = new ArrayList<HoaDon_BanHangModel>();
        try {
            Connection conn = Connections.jdbcUtils.getConnection();
            String sql = "select a.MaHD,b.TenNV,a.TrangThai,a.NgayTao from HoaDon a join NhanVien b on a.IdNV=b.Id where a.TrangThai=0 order by a.MaHD asc ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String mahd = rs.getString("MaHD");
                String tennv = rs.getString("TenNV");
                int trangthai = rs.getInt("TrangThai");
                String ngaytao = rs.getString("NgayTao");
                HoaDon_BanHangModel hdbhm = new HoaDon_BanHangModel(mahd, tennv, trangthai, ngaytao);
                list.add(hdbhm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
// Lọc hóa đơn đang chờ
    public ArrayList<HoaDon_BanHangModel> getHoaDonDangCho() {
        ArrayList list = new ArrayList<HoaDon_BanHangModel>();
        try {
            Connection conn = Connections.jdbcUtils.getConnection();
            String sql = "select a.MaHD,b.TenNV,a.TrangThai,a.NgayTao from HoaDon a join NhanVien b on a.IdNV=b.Id where a.TrangThai=1 order by a.MaHD asc ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String mahd = rs.getString("MaHD");
                String tennv = rs.getString("TenNV");
                int trangthai = rs.getInt("TrangThai");
                String ngaytao = rs.getString("NgayTao");
                HoaDon_BanHangModel hdbhm = new HoaDon_BanHangModel(mahd, tennv, trangthai, ngaytao);
                list.add(hdbhm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
