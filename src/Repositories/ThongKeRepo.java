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
    public ArrayList<Thongke_Model>getall(){
        ArrayList<Thongke_Model> list = new ArrayList<>();
        try {
            Connection conn = Connections.jdbcUtils.getConnection();
            String sql="select  s.MaSP,s.TenSP, h.SoLuong,d.NgayTao,d.trangThai from HoaDonChiTiet h"
                    + " join ChiTietSP c on h.IdChiTietSP = c.Id "
                    + "join SanPham s on s.Id = c.IdSanPham "
                    + "join HoaDon d on h.IdHoaDon =d.Id";
            PreparedStatement ps =conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String ma = rs.getString("MaSP");
                String ten = rs.getString("TenSP");
                int soLuong = rs.getInt("SoLuong");
                String NT = rs.getString("NgayTao");
                int tt = rs.getInt("trangThai");
                Thongke_Model tk = new Thongke_Model(ma, ten, soLuong,NT, tt,null );
                list.add(tk);
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    //repo tatca
    public ArrayList<Thongke_Model> tongTatCa(){
        ArrayList<Thongke_Model> list = new ArrayList<>();
        try {
            Connection conn = Connections.jdbcUtils.getConnection();
            String sql="select sum(DonGia) as Tong from HoaDonChiTiet a "
                    + "join HoaDon b on a.idHoaDon = b.id "
                    + "where b.TrangThai =0" ;
            PreparedStatement ps =conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String tong = rs.getString("Tong");

                Thongke_Model tk = new Thongke_Model(null, null, 0,null, 0, tong);
                list.add(tk);
            }
        } catch (Exception e) {
        }
        return list;
    }
    public ArrayList<Thongke_Model> HoaDonTatCa(){
        ArrayList<Thongke_Model> list = new ArrayList<>();
        try {
            Connection conn = Connections.jdbcUtils.getConnection();
            String sql="select COUNT(MaHD) as Tong from HoaDon";
            PreparedStatement ps =conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String tong = rs.getString("Tong");

                Thongke_Model tk = new Thongke_Model(null, null, 0,null, 0, tong);
                list.add(tk);
            }
        } catch (Exception e) {
        }
        return list;
    }
    public ArrayList<Thongke_Model> SanPhamTatCa(){
        ArrayList<Thongke_Model> list = new ArrayList<>();
        try {
            Connection conn = Connections.jdbcUtils.getConnection();
            String sql="select sum(SoLuong) as Tong from HoaDonChiTiet ";
            PreparedStatement ps =conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String tong = rs.getString("Tong");

                Thongke_Model tk = new Thongke_Model(null, null, 0,null, 0, tong);
                list.add(tk);
            }
        } catch (Exception e) {
        }
        return list;
    }
    public ArrayList<Thongke_Model> KhachHangTatCa(){
        ArrayList<Thongke_Model> list = new ArrayList<>();
        try {
            Connection conn = Connections.jdbcUtils.getConnection();
            String sql="select COUNT(IdKH) as Tong from HoaDon ";
            PreparedStatement ps =conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String tong = rs.getString("Tong");

                Thongke_Model tk = new Thongke_Model(null, null, 0,null, 0, tong);
                list.add(tk);
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    //repo ngay
    public ArrayList<Thongke_Model> tongNgay(){
        ArrayList<Thongke_Model> list = new ArrayList<>();
        try {
            Connection conn = Connections.jdbcUtils.getConnection();
            String sql="select sum(DonGia) as Tong from HoaDonChiTiet a "
                    + "join HoaDon b on a.idHoaDon = b.id "
                    + "where b.TrangThai =0"
                    + "and b.NgayThanhToan= convert(Date,getdate(),103) " ;
            PreparedStatement ps =conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String tong = rs.getString("Tong");

                Thongke_Model tk = new Thongke_Model(null, null, 0,null, 0, tong);
                list.add(tk);
            }
        } catch (Exception e) {
        }
        return list;
    }
    public ArrayList<Thongke_Model> HoaDonNgay(){
        ArrayList<Thongke_Model> list = new ArrayList<>();
        try {
            Connection conn = Connections.jdbcUtils.getConnection();
            String sql="select COUNT(MaHD) as Tong from HoaDon "
                    + "where b.NgayThanhToan= convert(Date,getdate(),103)";
            PreparedStatement ps =conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String tong = rs.getString("Tong");

                Thongke_Model tk = new Thongke_Model(null, null, 0,null, 0, tong);
                list.add(tk);
            }
        } catch (Exception e) {
        }
        return list;
    }
    public ArrayList<Thongke_Model> SanPhamNgay(){
        ArrayList<Thongke_Model> list = new ArrayList<>();
        try {
            Connection conn = Connections.jdbcUtils.getConnection();
            String sql="select sum(SoLuong) as Tong from HoaDonChiTiet "
                    + "where b.NgayThanhToan= convert(Date,getdate(),103)";
            PreparedStatement ps =conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String tong = rs.getString("Tong");

                Thongke_Model tk = new Thongke_Model(null, null, 0,null, 0, tong);
                list.add(tk);
            }
        } catch (Exception e) {
        }
        return list;
    }
    public ArrayList<Thongke_Model> KhachHangNgay(){
        ArrayList<Thongke_Model> list = new ArrayList<>();
        try {
            Connection conn = Connections.jdbcUtils.getConnection();
            String sql="select COUNT(IdKH) as Tong from HoaDon "
                    + "where b.NgayThanhToan= convert(Date,getdate(),103)";
            PreparedStatement ps =conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String tong = rs.getString("Tong");

                Thongke_Model tk = new Thongke_Model(null, null, 0,null, 0, tong);
                list.add(tk);
            }
        } catch (Exception e) {
        }
        return list;
    }
    //repo thang
    public ArrayList<Thongke_Model> tongThang(){
        ArrayList<Thongke_Model> list = new ArrayList<>();
        try {
            Connection conn = Connections.jdbcUtils.getConnection();
            String sql="select sum(DonGia) as Tong from HoaDonChiTiet a "
                    + "join HoaDon b on a.idHoaDon = b.id "
                    + "where b.TrangThai =0"
                    + "and  MONTH(NgayThanhToan) = MONTH(GETDATE())" ;
            PreparedStatement ps =conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String tong = rs.getString("Tong");

                Thongke_Model tk = new Thongke_Model(null, null, 0,null, 0, tong);
                list.add(tk);
            }
        } catch (Exception e) {
        }
        return list;
    }
    public ArrayList<Thongke_Model> HoaDonThang(){
        ArrayList<Thongke_Model> list = new ArrayList<>();
        try {
            Connection conn = Connections.jdbcUtils.getConnection();
            String sql="select COUNT(MaHD) as Tong from HoaDon"
                    + "where  MONTH(NgayThanhToan) = MONTH(GETDATE())";
            PreparedStatement ps =conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String tong = rs.getString("Tong");

                Thongke_Model tk = new Thongke_Model(null, null, 0,null, 0, tong);
                list.add(tk);
            }
        } catch (Exception e) {
        }
        return list;
    }
    public ArrayList<Thongke_Model> SanPhamThang(){
        ArrayList<Thongke_Model> list = new ArrayList<>();
        try {
            Connection conn = Connections.jdbcUtils.getConnection();
            String sql="select sum(SoLuong) as Tong from HoaDonChiTiet "
                    + "where  MONTH(NgayThanhToan) = MONTH(GETDATE())";
            PreparedStatement ps =conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String tong = rs.getString("Tong");

                Thongke_Model tk = new Thongke_Model(null, null, 0,null, 0, tong);
                list.add(tk);
            }
        } catch (Exception e) {
        }
        return list;
    }
    public ArrayList<Thongke_Model> KhachHangThang(){
        ArrayList<Thongke_Model> list = new ArrayList<>();
        try {
            Connection conn = Connections.jdbcUtils.getConnection();
            String sql="select COUNT(IdKH) as Tong from HoaDon "
                    + "where  MONTH(NgayThanhToan) = MONTH(GETDATE())";
            PreparedStatement ps =conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String tong = rs.getString("Tong");

                Thongke_Model tk = new Thongke_Model(null, null, 0,null, 0, tong);
                list.add(tk);
            }
        } catch (Exception e) {
        }
        return list;
    }
    //repo nam
    public ArrayList<Thongke_Model> tongNam(){
        ArrayList<Thongke_Model> list = new ArrayList<>();
        try {
            Connection conn = Connections.jdbcUtils.getConnection();
            String sql="select sum(DonGia) as Tong from HoaDonChiTiet a "
                    + "join HoaDon b on a.idHoaDon = b.id "
                    + "where b.TrangThai =0"
                    + "and YEAR(b.NgayThanhToan) = YEAR(GETDATE())" ;
            PreparedStatement ps =conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String tong = rs.getString("Tong");

                Thongke_Model tk = new Thongke_Model(null, null, 0,null, 0, tong);
                list.add(tk);
            }
        } catch (Exception e) {
        }
        return list;
    }
    public ArrayList<Thongke_Model> HoaDonNam(){
        ArrayList<Thongke_Model> list = new ArrayList<>();
        try {
            Connection conn = Connections.jdbcUtils.getConnection();
            String sql="select COUNT(MaHD) as Tong from HoaDon"
                    + "where YEAR(NgayThanhToan) = YEAR(GETDATE())";
            PreparedStatement ps =conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String tong = rs.getString("Tong");

                Thongke_Model tk = new Thongke_Model(null, null, 0,null, 0, tong);
                list.add(tk);
            }
        } catch (Exception e) {
        }
        return list;
    }
    public ArrayList<Thongke_Model> SanPhamNam(){
        ArrayList<Thongke_Model> list = new ArrayList<>();
        try {
            Connection conn = Connections.jdbcUtils.getConnection();
            String sql="select sum(SoLuong) as Tong from HoaDonChiTiet "
                    + "where YEAR(NgayThanhToan) = YEAR(GETDATE())";
            PreparedStatement ps =conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String tong = rs.getString("Tong");

                Thongke_Model tk = new Thongke_Model(null, null, 0,null, 0, tong);
                list.add(tk);
            }
        } catch (Exception e) {
        }
        return list;
    }
    public ArrayList<Thongke_Model> KhachHangNam(){
        ArrayList<Thongke_Model> list = new ArrayList<>();
        try {
            Connection conn = Connections.jdbcUtils.getConnection();
            String sql="select COUNT(IdKH) as Tong from HoaDon "
                    + "where YEAR(NgayThanhToan) = YEAR(GETDATE())";
            PreparedStatement ps =conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String tong = rs.getString("Tong");

                Thongke_Model tk = new Thongke_Model(null, null, 0,null, 0, tong);
                list.add(tk);
            }
        } catch (Exception e) {
        }
        return list;
    }
}
