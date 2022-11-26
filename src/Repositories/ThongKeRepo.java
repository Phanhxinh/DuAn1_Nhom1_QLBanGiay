package Repositories;
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
            String sql="select  s.MaSP,s.TenSP, h.SoLuong,d.trangThai from HoaDonChiTiet h"
                    + " join ChiTietSP c on h.IdChiTietSP = c.Id "
                    + "join SanPham s on s.Id = c.IdSanPham "
                    + "join HoaDon d on h.IdHoaDon =d.Id";
            PreparedStatement ps =conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String ma = rs.getString("MaSP");
                String ten = rs.getString("TenSP");
                int soLuong = rs.getInt("SoLuong");
                int tt = rs.getInt("trangThai");
                Thongke_Model tk = new Thongke_Model(ma, ten, soLuong, tt,null );
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
            String sql="select sum(SoLuong*DonGia) as Tong from HoaDonChiTiet ";
            PreparedStatement ps =conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String tong = rs.getString("Tong");

                Thongke_Model tk = new Thongke_Model(null, null, 0, 0, tong);
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
            String sql="select sum(SoLuong*DonGia) as Tong from HoaDonChiTiet ";
            PreparedStatement ps =conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String tong = rs.getString("Tong");

                Thongke_Model tk = new Thongke_Model(null, null, 0, 0, tong);
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
            String sql="select sum(SoLuong*DonGia) as Tong from HoaDonChiTiet ";
            PreparedStatement ps =conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String tong = rs.getString("Tong");

                Thongke_Model tk = new Thongke_Model(null, null, 0, 0, tong);
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
            String sql="select sum(SoLuong*DonGia) as Tong from HoaDonChiTiet ";
            PreparedStatement ps =conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String tong = rs.getString("Tong");

                Thongke_Model tk = new Thongke_Model(null, null, 0, 0, tong);
                list.add(tk);
            }
        } catch (Exception e) {
        }
        return list;
    }
}
