/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import Connections.jdbcUtils;
import DomainModel.HoaDonView;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class HoaDonRepo {
    
    public ArrayList<HoaDonView> getall() {
        ArrayList<HoaDonView> list = new ArrayList<>();
        try {
            Connection conn = jdbcUtils.getConnection();
            String sql = "select a.MaHD,b.TenNV,c.TenKH,a.NgayTao,a.TrangThai from HoaDon a join NhanVien b on a.IdNV=b.Id join KhachHang c on a.IdKH=c.Id order by a.MaHD asc";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next() == true) {
                String maHD = rs.getString("MaHD");
                String tenNV = rs.getString("TenNV");
                String tenKH = rs.getString("TenKH");
                String ngayTao = rs.getString("NgayTao");
                int trangThai = rs.getInt("TrangThai");
                list.add(new HoaDonView(maHD, tenNV, tenKH, ngayTao, trangThai));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public ArrayList<HoaDonView> FindMaNV(String ten) {
        ArrayList<HoaDonView> list = new ArrayList<>();
        try {
            Connection conn = jdbcUtils.getConnection();
            String sql = "select a.MaHD,b.TenNV,c.TenKH,a.NgayTao,a.TrangThai from HoaDon a join NhanVien b on a.IdNV=b.Id join KhachHang c on a.IdKH=c.Id where a.MaHD like N'%" + ten + "%'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next() == true) {
                String maHD = rs.getString("MaHD");
                String tenNV = rs.getString("TenNV");
                String tenKH = rs.getString("TenKH");
                String ngayTao = rs.getString("NgayTao");
                int trangThai = rs.getInt("TrangThai");
                list.add(new HoaDonView(maHD, tenNV, tenKH, ngayTao, trangThai));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
