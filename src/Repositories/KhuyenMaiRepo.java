/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import Connections.jdbcUtils;
import DomainModel.KhuyenMaiModel;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author DELL
 */
public class KhuyenMaiRepo {

    public ArrayList<KhuyenMaiModel> all() {
        ArrayList<KhuyenMaiModel> list = new ArrayList<>();
        try {
            Connection conn = jdbcUtils.getConnection();
            String query = "SELECT [MaKM]\n"
                    + "      ,[TenKM]\n"
                    + "      ,[GiamGia]\n"
                    + "      ,[NgayBD]\n"
                    + "      ,[NgayKT]\n"
                    + "      ,[MoTa]\n"
                    + "  FROM [dbo].[KhuyenMai]";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String MaKM = rs.getString("MaKM");
                String TenKM = rs.getString("TenKM");
                String GiamGia = rs.getString("GiamGia");
                String NgayBD = rs.getString("NgayBD");
                String NgayKT = rs.getString("NgayKT");
                String MoTa = rs.getString("MoTa");
                KhuyenMaiModel khuyenMai = new KhuyenMaiModel(MaKM, TenKM, GiamGia, NgayBD, NgayKT, MoTa);
                list.add(khuyenMai);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<KhuyenMaiModel> Find(String ten) {
        ArrayList<KhuyenMaiModel> list = new ArrayList<>();
        try {
            Connection conn = jdbcUtils.getConnection();
            String query = "SELECT [MaKM]\n"
                    + "      ,[TenKM]\n"
                    + "      ,[GiamGia]\n"
                    + "      ,[NgayBD]\n"
                    + "      ,[NgayKT]\n"
                    + "      ,[MoTa]\n"
                    + "  FROM [dbo].[KhuyenMai] where TenKM like N'%" + ten + "%'";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String MaKM = rs.getString("MaKM");
                String TenKM = rs.getString("TenKM");
                String GiamGia = rs.getString("GiamGia");
                String NgayBD = rs.getString("NgayBD");
                String NgayKT = rs.getString("NgayKT");
                String MoTa = rs.getString("MoTa");
                KhuyenMaiModel khuyenMai = new KhuyenMaiModel(MaKM, TenKM, GiamGia, NgayBD, NgayKT, MoTa);
                list.add(khuyenMai);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<KhuyenMaiModel> Findtt(String ngaybd, String ngaykt) {
        ArrayList<KhuyenMaiModel> list = new ArrayList<>();
        try {
            Connection conn = jdbcUtils.getConnection();
            String query = "SELECT [MaKM]\n"
                    + "      ,[TenKM]\n"
                    + "      ,[GiamGia]\n"
                    + "      ,[NgayBD]\n"
                    + "      ,[NgayKT]\n"
                    + "      ,[MoTa]\n"
                    + "  FROM [dbo].[KhuyenMai] where NgayBD<=? and NgayKT>=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, ngaybd);
            ps.setString(2, ngaykt);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String MaKM = rs.getString("MaKM");
                String TenKM = rs.getString("TenKM");
                String GiamGia = rs.getString("GiamGia");
                String NgayBD = rs.getString("NgayBD");
                String NgayKT = rs.getString("NgayKT");
                String MoTa = rs.getString("MoTa");
                KhuyenMaiModel khuyenMai = new KhuyenMaiModel(MaKM, TenKM, GiamGia, NgayBD, NgayKT, MoTa);
                list.add(khuyenMai);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
        public ArrayList<KhuyenMaiModel> Findttkt(String ngaybd, String ngaykt) {
        ArrayList<KhuyenMaiModel> list = new ArrayList<>();
        try {
            Connection conn = jdbcUtils.getConnection();
            String query = "SELECT [MaKM]\n"
                    + "      ,[TenKM]\n"
                    + "      ,[GiamGia]\n"
                    + "      ,[NgayBD]\n"
                    + "      ,[NgayKT]\n"
                    + "      ,[MoTa]\n"
                    + "  FROM [dbo].[KhuyenMai] where NgayBD<=? and NgayKT<=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, ngaybd);
            ps.setString(2, ngaykt);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String MaKM = rs.getString("MaKM");
                String TenKM = rs.getString("TenKM");
                String GiamGia = rs.getString("GiamGia");
                String NgayBD = rs.getString("NgayBD");
                String NgayKT = rs.getString("NgayKT");
                String MoTa = rs.getString("MoTa");
                KhuyenMaiModel khuyenMai = new KhuyenMaiModel(MaKM, TenKM, GiamGia, NgayBD, NgayKT, MoTa);
                list.add(khuyenMai);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void intsert(KhuyenMaiModel khuyenMai) {
        try {
            Connection conn = jdbcUtils.getConnection();
            String query = "INSERT INTO [dbo].[KhuyenMai]\n"
                    + "           ([MaKM]\n"
                    + "           ,[TenKM]\n"
                    + "           ,[GiamGia]\n"
                    + "           ,[NgayBD]\n"
                    + "           ,[NgayKT]\n"
                    + "           ,[MoTa])\n"
                    + "     VALUES(?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, khuyenMai.getMa());
            ps.setString(2, khuyenMai.getTen());
            ps.setString(3, khuyenMai.getKhuyenmai());
            ps.setString(4, khuyenMai.getNgaybd());
            ps.setString(5, khuyenMai.getNgaykt());
            ps.setString(6, khuyenMai.getMota());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(String id, KhuyenMaiModel khuyenMai) {
        try {
            Connection conn = jdbcUtils.getConnection();
            String query = "UPDATE [dbo].[KhuyenMai]\n"
                    + "   SET [TenKM] =?\n"
                    + "      ,[GiamGia] =?\n"
                    + "      ,[NgayBD] = ?\n"
                    + "      ,[NgayKT] = ?\n"
                    + "      ,[MoTa] =?\n"
                    + " WHERE [MaKM] =?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, khuyenMai.getTen());
            ps.setString(2, khuyenMai.getKhuyenmai());
            ps.setString(3, khuyenMai.getNgaybd());
            ps.setString(4, khuyenMai.getNgaykt());
            ps.setString(5, khuyenMai.getMota());
            ps.setString(6, id);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
