/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import Connections.jdbcUtils;
import DomainModel.KhachHang;
import ViewModel.KhachHangViewModel;
import ViewModel.NhanVienViewModel;
import ViewModel.LsugdViewModel;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KhachHangRepo {

    public List<KhachHangViewModel> getListKh() {
        List<KhachHangViewModel> listkh = new ArrayList<>();
        try {
            Connection conn = jdbcUtils.getConnection();
            String sql = "select Id,MaKH,TenKH, NgaySinh,SDT,Email,DiaChi  from KhachHang";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHangViewModel khvm = new KhachHangViewModel();
                khvm.setId(rs.getString(1));
                khvm.setMaKh(rs.getString(2));
                khvm.setTenKh(rs.getString(3));
                khvm.setNgaySinh(rs.getString(4));
                khvm.setSdt(rs.getString(5));
                khvm.setEmail(rs.getString(6));
                khvm.setDiachi(rs.getString(7));
                listkh.add(khvm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listkh;
    }
  
    public List<LsugdViewModel> Getlsu(String sdt){
        List<LsugdViewModel> listlsu = new ArrayList<>();
        try {
             Connection conn = jdbcUtils.getConnection();
             String sql = "select * from [history] where SDT = ? order by NgayThanhToan desc";
             PreparedStatement ps = conn.prepareStatement(sql);
             ps.setString(1, sdt);
             ResultSet rs = ps.executeQuery();
             while(rs.next()){
               LsugdViewModel lsgd = new LsugdViewModel();
               lsgd.setTenkh(rs.getString(1));
               lsgd.setSDT(rs.getString(2));
               lsgd.setNgayTT(rs.getString(3));
               lsgd.setTenSP(rs.getString(4));
               lsgd.setSluong(rs.getString(5));
               lsgd.setGIaBan(rs.getString(6));
               lsgd.setThanhtien(rs.getString(7));
               lsgd.setTrangthai(rs.getString(8));
              
               listlsu.add(lsgd);
             }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listlsu;
    }
    public List<KhachHangViewModel> GetId(String ma) {
        List<KhachHangViewModel> listkh = new ArrayList<>();
        try {
            Connection conn = jdbcUtils.getConnection();
            String sql = "select Id,MaKH,TenKH,NgaySinh,SDT,Email,DiaChi  from KhachHang where MaKH=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString("Id");
                String makh = rs.getString("MaKH");
                String tenkh = rs.getString("TenKH");
                String sdt = rs.getString("SDT");
                listkh.add(new KhachHangViewModel(id, makh, tenkh, null, sdt, null, null));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listkh;
    }

    public void Add(KhachHang kh) {
        try {
            Connection conn = jdbcUtils.getConnection();
            String sql = "Insert into KhachHang (MaKH,TenKH, NgaySinh,SDT,Email,DiaChi) values (?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, kh.getMaKh());
            ps.setString(2, kh.getTenKh());
            ps.setString(3, kh.getNgaySinh());
            ps.setString(4, kh.getSdt());
            ps.setString(5, kh.getEmail());
            ps.setString(6, kh.getDiachi());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void Update(String ma, KhachHang kh) {
        try {
            Connection conn = jdbcUtils.getConnection();
            String sql = "update KhachHang set TenKH = ? , NgaySinh = ? , SDT = ? , Email = ? , DiaChi = ? where MaKH = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, kh.getTenKh());
            ps.setString(2, kh.getNgaySinh());
            ps.setString(3, kh.getSdt());
            ps.setString(4, kh.getEmail());
            ps.setString(5, kh.getDiachi());
            ps.setString(6, ma);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isExits(String MaKh) {
        boolean isExist = false;
        try {
            Connection conn = jdbcUtils.getConnection();

            String query = "select MaKH,TenKH, NgaySinh,SDT,Email,DiaChi  from KhachHang where MaKh = ' " + MaKh + "'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                isExist = true;

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return isExist;
    }

        public List<KhachHangViewModel> FindKh(String makh) {
        List<KhachHangViewModel> listkh = new ArrayList<>();

        try {
            Connection conn = jdbcUtils.getConnection();
            String sql = "select MaKH,TenKH, NgaySinh,SDT,Email,DiaChi  from KhachHang where TenKH like N'%"+makh+"%'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHangViewModel khvm = new KhachHangViewModel();
                khvm.setMaKh(rs.getString(1));
                khvm.setTenKh(rs.getString(2));
                khvm.setNgaySinh(rs.getString(3));
                khvm.setSdt(rs.getString(4));
                khvm.setEmail(rs.getString(5));
                khvm.setDiachi(rs.getString(6));
                listkh.add(khvm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listkh;
    }

}
