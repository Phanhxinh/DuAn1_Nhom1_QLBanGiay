package Repositories;

import Connections.jdbcUtils;
import DomainModel.Thongke_Model;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Enmazr
 */
public class ThongKeRepo {

    public ArrayList<Thongke_Model> getall() {
        ArrayList<Thongke_Model> list = new ArrayList<>();
        try {
            Connection conn = Connections.jdbcUtils.getConnection();
            String sql = "select  s.MaSP,s.TenSP, h.SoLuong,d.NgayTao,d.trangThai from HoaDonChiTiet h"
                    + " join ChiTietSP c on h.IdChiTietSP = c.Id "
                    + "join SanPham s on s.Id = c.IdSanPham "
                    + "join HoaDon d on h.IdHoaDon =d.Id";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String ma = rs.getString("MaSP");
                String ten = rs.getString("TenSP");
                int soLuong = rs.getInt("SoLuong");
                String NT = rs.getString("NgayTao");
                int tt = rs.getInt("trangThai");
                Thongke_Model tk = new Thongke_Model(ma, ten, soLuong, NT, tt, null);
                list.add(tk);
            }
        } catch (Exception e) {
        }
        return list;
    }

    //repo tatca
    public ArrayList<Thongke_Model> tongTatCa() {
        ArrayList<Thongke_Model> list = new ArrayList<>();
        try {
            Connection conn = Connections.jdbcUtils.getConnection();
            String sql = "select sum(DonGia) as Tong from HoaDonChiTiet a "
                    + "join HoaDon b on a.idHoaDon = b.id "
                    + "where b.TrangThai =0";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String tong = rs.getString("Tong");

                Thongke_Model tk = new Thongke_Model(null, null, 0, null, 0, tong);
                list.add(tk);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public ArrayList<Thongke_Model> HoaDonTatCa() {
        ArrayList<Thongke_Model> list = new ArrayList<>();
        try {
            Connection conn = Connections.jdbcUtils.getConnection();
            String sql = "select COUNT(MaHD) as Tong from HoaDon";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String tong = rs.getString("Tong");

                Thongke_Model tk = new Thongke_Model(null, null, 0, null, 0, tong);
                list.add(tk);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public ArrayList<Thongke_Model> SanPhamTatCa() {
        ArrayList<Thongke_Model> list = new ArrayList<>();
        try {
            Connection conn = Connections.jdbcUtils.getConnection();
            String sql = "select sum(SoLuong) as Tong from HoaDonChiTiet ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String tong = rs.getString("Tong");

                Thongke_Model tk = new Thongke_Model(null, null, 0, null, 0, tong);
                list.add(tk);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public ArrayList<Thongke_Model> KhachHangTatCa() {
        ArrayList<Thongke_Model> list = new ArrayList<>();
        try {
            Connection conn = Connections.jdbcUtils.getConnection();
            String sql = "select COUNT(DISTINCT IdKH) as Tong from HoaDon where TrangThai=0";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String tong = rs.getString("Tong");

                Thongke_Model tk = new Thongke_Model(null, null, 0, null, 0, tong);
                list.add(tk);
            }
        } catch (Exception e) {
        }
        return list;
    }

    //repo ngay
    public ArrayList<Thongke_Model> tongNgay() {
        ArrayList<Thongke_Model> list = new ArrayList<>();
        try {
            Connection conn = Connections.jdbcUtils.getConnection();
            String sql = "select sum(DonGia) as Tong from HoaDonChiTiet a "
                    + "join HoaDon b on a.idHoaDon = b.id "
                    + "where b.TrangThai =0"
                    + "and b.NgayThanhToan= convert(Date,getdate(),103) ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String tong = rs.getString("Tong");

                Thongke_Model tk = new Thongke_Model(null, null, 0, null, 0, tong);
                list.add(tk);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public ArrayList<Thongke_Model> HoaDonNgay() {
        ArrayList<Thongke_Model> list = new ArrayList<>();
        try {
            Connection conn = Connections.jdbcUtils.getConnection();
            String sql = "select COUNT(MaHD) as Tong from HoaDon "
                    + "where NgayThanhToan= convert(Date,getdate(),103) and TrangThai=0";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String tong = rs.getString("Tong");

                Thongke_Model tk = new Thongke_Model(null, null, 0, null, 0, tong);
                list.add(tk);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public ArrayList<Thongke_Model> SanPhamNgay() {
        ArrayList<Thongke_Model> list = new ArrayList<>();
        try {
            Connection conn = Connections.jdbcUtils.getConnection();
            String sql = "select sum(SoLuong) as Tong from HoaDonChiTiet a "
                    + "join HoaDon b on a.idHoaDon = b.id "
                    + "where NgayThanhToan = convert(Date,getdate(),103) and b.TrangThai=0";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String tong = rs.getString("Tong");

                Thongke_Model tk = new Thongke_Model(null, null, 0, null, 0, tong);
                list.add(tk);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public ArrayList<Thongke_Model> KhachHangNgay() {
        ArrayList<Thongke_Model> list = new ArrayList<>();
        try {
            Connection conn = Connections.jdbcUtils.getConnection();
            String sql = "select COUNT(DISTINCT IdKH) as Tong from HoaDon "
                    + "where NgayThanhToan= convert(Date,getdate(),103) where TrangThai=0";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String tong = rs.getString("Tong");

                Thongke_Model tk = new Thongke_Model(null, null, 0, null, 0, tong);
                list.add(tk);
            }
        } catch (Exception e) {
        }
        return list;
    }

    //repo thang
    public ArrayList<Thongke_Model> tongThang() {
        ArrayList<Thongke_Model> list = new ArrayList<>();
        try {
            Connection conn = Connections.jdbcUtils.getConnection();
            String sql = "select sum(DonGia) as Tong from HoaDonChiTiet a "
                    + "join HoaDon b on a.idHoaDon = b.id "
                    + "where b.TrangThai =0"
                    + "and  MONTH(b.NgayThanhToan) = MONTH(GETDATE())";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String tong = rs.getString("Tong");

                Thongke_Model tk = new Thongke_Model(null, null, 0, null, 0, tong);
                list.add(tk);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public ArrayList<Thongke_Model> HoaDonThang() {
        ArrayList<Thongke_Model> list = new ArrayList<>();
        try {
            Connection conn = Connections.jdbcUtils.getConnection();
            String sql = "select COUNT(MaHD) as Tong from HoaDon "
                    + "where  MONTH(NgayThanhToan) = MONTH(GETDATE()) and TrangThai=0";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String tong = rs.getString("Tong");

                Thongke_Model tk = new Thongke_Model(null, null, 0, null, 0, tong);
                list.add(tk);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public ArrayList<Thongke_Model> SanPhamThang() {
        ArrayList<Thongke_Model> list = new ArrayList<>();
        try {
            Connection conn = Connections.jdbcUtils.getConnection();
            String sql = "select sum(SoLuong) as Tong from HoaDonChiTiet a "
                    + "join HoaDon b on a.idHoaDon = b.id "
                    + "where  MONTH(NgayThanhToan) = MONTH(GETDATE()) and b.TrangThai=0";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String tong = rs.getString("Tong");

                Thongke_Model tk = new Thongke_Model(null, null, 0, null, 0, tong);
                list.add(tk);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public ArrayList<Thongke_Model> KhachHangThang() {
        ArrayList<Thongke_Model> list = new ArrayList<>();
        try {
            Connection conn = Connections.jdbcUtils.getConnection();
            String sql = "select COUNT(DISTINCT IdKH) as Tong from HoaDon "
                    + "where  MONTH(NgayThanhToan) = MONTH(GETDATE()) and TrangThai=0";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String tong = rs.getString("Tong");

                Thongke_Model tk = new Thongke_Model(null, null, 0, null, 0, tong);
                list.add(tk);
            }
        } catch (Exception e) {
        }
        return list;
    }

    //repo nam
    public ArrayList<Thongke_Model> tongNam() {
        ArrayList<Thongke_Model> list = new ArrayList<>();
        try {
            Connection conn = Connections.jdbcUtils.getConnection();
            String sql = "select sum(DonGia) as Tong from HoaDonChiTiet a "
                    + "join HoaDon b on a.idHoaDon = b.id "
                    + "where b.TrangThai =0"
                    + "and YEAR(b.NgayThanhToan) = YEAR(GETDATE())";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String tong = rs.getString("Tong");

                Thongke_Model tk = new Thongke_Model(null, null, 0, null, 0, tong);
                list.add(tk);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public ArrayList<Thongke_Model> HoaDonNam() {
        ArrayList<Thongke_Model> list = new ArrayList<>();
        try {
            Connection conn = Connections.jdbcUtils.getConnection();
            String sql = "select COUNT(MaHD) as Tong from HoaDon "
                    + "where YEAR(NgayThanhToan) = YEAR(GETDATE()) and TrangThai=0";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String tong = rs.getString("Tong");

                Thongke_Model tk = new Thongke_Model(null, null, 0, null, 0, tong);
                list.add(tk);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public ArrayList<Thongke_Model> SanPhamNam() {
        ArrayList<Thongke_Model> list = new ArrayList<>();
        try {
            Connection conn = Connections.jdbcUtils.getConnection();
            String sql = "select sum(SoLuong) as Tong from HoaDonChiTiet a "
                    + "join HoaDon b on a.idHoaDon = b.id "
                    + "where YEAR(b.NgayThanhToan) = YEAR(GETDATE()) and b.TrangThai=0";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String tong = rs.getString("Tong");

                Thongke_Model tk = new Thongke_Model(null, null, 0, null, 0, tong);
                list.add(tk);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public ArrayList<Thongke_Model> KhachHangNam() {
        ArrayList<Thongke_Model> list = new ArrayList<>();
        try {
            Connection conn = Connections.jdbcUtils.getConnection();
            String sql = "select COUNT(DISTINCT IdKH) as Tong from HoaDon "
                    + "where YEAR(NgayThanhToan) = YEAR(GETDATE()) and TrangThai=0";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String tong = rs.getString("Tong");

                Thongke_Model tk = new Thongke_Model(null, null, 0, null, 0, tong);
                list.add(tk);
            }
        } catch (Exception e) {
        }
        return list;
    }

    //repo thống kê nhân viên xs
    public ArrayList<Thongke_Model> NhanVienXS() {
        ArrayList<Thongke_Model> list = new ArrayList<>();
        try {
            Connection conn = Connections.jdbcUtils.getConnection();
            String sql = "SELECT MaNV,TenNV , count(c.IdHoaDon) as SoLuong,sum(c.DonGia) as Doanhthu FROM   HoaDon a "
                    + "join NhanVien b on a.IdNV =b.Id "
                    + "join HoaDonChiTiet c on a.id= c.IdHoaDon "
                    + "where DATEPART(\"ww\",a.NgayThanhToan) = DATEPART(\"ww\",GETDATE()) and a.TrangThai=0 "
                    + "GROUP BY  MaNV,TenNV "
                    + "order by Doanhthu desc";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String ma = rs.getString("MaNV");
                String ten = rs.getString("TenNV");
                int soLuong = rs.getInt("SoLuong");
                String gia = rs.getString("Doanhthu");

                Thongke_Model tk = new Thongke_Model(ma, ten, soLuong, null, 0, gia);
                list.add(tk);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public ArrayList<Thongke_Model> NhanVienXSThang() {
        ArrayList<Thongke_Model> list = new ArrayList<>();
        try {
            Connection conn = Connections.jdbcUtils.getConnection();
            String sql = "SELECT MaNV,TenNV , count(c.IdHoaDon) as SoLuong,sum(c.DonGia) as Doanhthu FROM   HoaDon a "
                    + "join NhanVien b on a.IdNV =b.Id "
                    + "join HoaDonChiTiet c on a.id= c.IdHoaDon "
                    + "where MONTH(a.NgayThanhToan) = MONTH(GETDATE()) and a.TrangThai=0 "
                    + "GROUP BY  MaNV,TenNV "
                    + "order by Doanhthu desc";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String ma = rs.getString("MaNV");
                String ten = rs.getString("TenNV");
                int soLuong = rs.getInt("SoLuong");
                String gia = rs.getString("Doanhthu");
                Thongke_Model tk = new Thongke_Model(ma, ten, soLuong, null, 0, gia);
                list.add(tk);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public ArrayList<Thongke_Model> NhanVienXSNam() {
        ArrayList<Thongke_Model> list = new ArrayList<>();
        try {
            Connection conn = Connections.jdbcUtils.getConnection();
            String sql = "SELECT MaNV,TenNV , count(c.IdHoaDon) as SoLuong,sum(c.DonGia) as Doanhthu FROM   HoaDon a "
                    + "join NhanVien b on a.IdNV =b.Id "
                    + "join HoaDonChiTiet c on a.id= c.IdHoaDon "
                    + "where YEAR(a.NgayThanhToan) = YEAR(GETDATE()) and a.TrangThai=0 "
                    + "GROUP BY  MaNV,TenNV "
                    + "order by Doanhthu desc";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String ma = rs.getString("MaNV");
                String ten = rs.getString("TenNV");
                int soLuong = rs.getInt("SoLuong");
                String gia = rs.getString("Doanhthu");
                Thongke_Model tk = new Thongke_Model(ma, ten, soLuong, null, 0, gia);
                list.add(tk);
            }
        } catch (Exception e) {
        }
        return list;
    }

    // Biểu đồ thống kê theo tháng
    public ArrayList<Thongke_Model> getMoneyMonTh(int thang) {
        ArrayList<Thongke_Model> list = new ArrayList<>();
        try {
            Connection conn = Connections.jdbcUtils.getConnection();
            String sql = "select sum(DonGia) as Tong from HoaDonChiTiet a join HoaDon b on a.idHoaDon = b.id where b.TrangThai =0 and  MONTH(NgayThanhToan) = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, thang);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String tong = rs.getString("Tong");
                Thongke_Model tk = new Thongke_Model(null, null, 0, null, 0, tong);
                list.add(tk);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
