/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import Connections.jdbcUtils;
import DomainModel.KhachHang;
import ViewModel.KhachHangViewModel;
import ViewModel.NhanVienViewModel;
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
            String sql = "select MaKH,TenKH, NgaySinh,SDT,Email,DiaChi  from KhachHang";
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
            String sql = "select MaKH,TenKH, NgaySinh,SDT,Email,DiaChi  from KhachHang where MaKh = '"+makh+"'";
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