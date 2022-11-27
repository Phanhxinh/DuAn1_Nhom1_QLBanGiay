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
    
    public ArrayList<Thongke_Model> tong(){
        ArrayList<Thongke_Model> list = new ArrayList<>();
        try {
            Connection conn = Connections.jdbcUtils.getConnection();
            String sql="select sum(SoLuong*DonGia) as Tong from HoaDonChiTiet a "
                    + "join HoaDon b on a.idHoaDon = b.id "
                    + "where b.NgayThanhToan = convert(Date,getdate(),103)" ;
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
    public ArrayList<Thongke_Model> tongNgay(){
        ArrayList<Thongke_Model> list = new ArrayList<>();
        try {
            Connection conn = Connections.jdbcUtils.getConnection();
            String sql="select sum(SoLuong*DonGia) as Tong from HoaDonChiTiet a "
                    + "join HoaDon b on a.idHoaDon = b.id "
                    + "where DatePart (\"ww\", b.NgayThanhToan) = DatePart (\"ww\", getdate())";
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
    public ArrayList<Thongke_Model> tongThang(){
        ArrayList<Thongke_Model> list = new ArrayList<>();
        try {
            Connection conn = Connections.jdbcUtils.getConnection();
            String sql="select sum(SoLuong*DonGia) as Tong from HoaDonChiTiet a "
                    + "join HoaDon b on a.idHoaDon = b.id "
                    + "where  MONTH(b.NgayThanhToan) = MONTH(GETDATE())";
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
    public ArrayList<Thongke_Model> tongTuyChon(){
        ArrayList<Thongke_Model> list = new ArrayList<>();
        try {
            Connection conn = Connections.jdbcUtils.getConnection();
            String sql="select sum(SoLuong*DonGia) as Tong from HoaDonChiTiet a "
                    + "join HoaDon b on a.idHoaDon = b.id "
                    + "where  Year(b.NgayThanhToan) = Year(GETDATE()) ";
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
    
    
    public ArrayList<Thongke_Model> ban(){
        ArrayList<Thongke_Model> list = new ArrayList<>();
        try {
            Connection conn = Connections.jdbcUtils.getConnection();
            String sql="select sum(SoLuong) as Tong from HoaDonChiTiet a "
                    + "join HoaDon b on a.idHoaDon = b.id "
                    + "where b.NgayThanhToan = convert(Date,getdate(),103) ";
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
    public ArrayList<Thongke_Model> banNgay(){
        ArrayList<Thongke_Model> list = new ArrayList<>();
        try {
            Connection conn = Connections.jdbcUtils.getConnection();
            String sql="select sum(SoLuong) as Tong from HoaDonChiTiet a "
                    + "join HoaDon b on a.idHoaDon = b.id "
                    + "where DatePart (\"ww\", b.NgayThanhToan) = DatePart (\"ww\", getdate())";
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
    public ArrayList<Thongke_Model> banThang(){
        ArrayList<Thongke_Model> list = new ArrayList<>();
        try {
            Connection conn = Connections.jdbcUtils.getConnection();
            String sql="select sum(SoLuong) as Tong from HoaDonChiTiet a "
                    + "join HoaDon b on a.idHoaDon = b.id "
                    + "where  MONTH(b.NgayThanhToan) = MONTH(GETDATE())";
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
    public ArrayList<Thongke_Model> banTuyChon(){
        ArrayList<Thongke_Model> list = new ArrayList<>();
        try {
            Connection conn = Connections.jdbcUtils.getConnection();
            String sql="select sum(SoLuong) as Tong from HoaDonChiTiet a "
                    + "join HoaDon b on a.idHoaDon = b.id "
                    + "where  Year(b.NgayThanhToan) = Year(GETDATE()) ";
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
    public ArrayList<Thongke_Model> LocNgay(String ngayBD, String ngayKT) {
        ArrayList<Thongke_Model> list = new ArrayList<>();
        try {
            Connection conn = Connections.jdbcUtils.getConnection();
            String sql = "select  s.MaSP,s.TenSP, h.SoLuong,d.NgayTao,d.trangThai from HoaDonChiTiet h "
                    + "join ChiTietSP c on h.IdChiTietSP = c.Id "
                    + "join SanPham s on s.Id = c.IdSanPham "
                    + "join HoaDon d on h.IdHoaDon =d.Id "
                    + "where a.NgayTao>=? and a.NgayTao<=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ngayBD);
            ps.setString(2, ngayKT);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next() == true) {
                String ma = rs.getString("MaSP");
                String ten = rs.getString("TenSP");
                int soLuong = rs.getInt("SoLuong");
                String NT = rs.getString("NgayTao");
                int tt = rs.getInt("trangThai");
                list.add(new Thongke_Model(ma, ten, soLuong, ngayKT, tt, null));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
