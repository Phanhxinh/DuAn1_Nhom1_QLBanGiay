/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import Connections.jdbcUtils;

import DomainModel.TheLoai_SanPhamModel;
import ITFService.TheLoaiITF;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author CQTRUONG
 */
public class TheLoaiRepo implements TheLoaiITF {

    ArrayList<TheLoai_SanPhamModel> listsame = new ArrayList<TheLoai_SanPhamModel>();

    @Override
    public ArrayList<TheLoai_SanPhamModel> All() {
        try {
            Connection conn = jdbcUtils.getConnection();
            String puery = "SELECT * FROM TheLoai";

            PreparedStatement ps = conn.prepareStatement(puery);
            ps.execute();

            ResultSet rs = ps.getResultSet();

            while (rs.next() == true) {
                String id = rs.getString("Id");
                String ma = rs.getString("MaTL");
                String ten = rs.getString("TenTL");

                TheLoai_SanPhamModel same = new TheLoai_SanPhamModel(id, ma, ten);
                listsame.add(same);
            }
        } catch (Exception ex) {

        }
        return listsame;
    }

    @Override
    public void insert(TheLoai_SanPhamModel tl) {
        try {
            Connection conn = jdbcUtils.getConnection();
            String sql = "insert into TheLoai "
                    + "(MaTL,TenTL)"
                    + "VALUES(?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tl.getMaTL());
            ps.setString(2, tl.getTenTL());

            ps.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(String ma, TheLoai_SanPhamModel tl) {
        try {
            Connection conn = jdbcUtils.getConnection();
            String sql = "UPDATE TheLoai set "
                    + "TenTL = ? WHERE MaTL = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, tl.getTenTL());
            ps.setString(2, ma);

            ps.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(String ma) {
        try {
            Connection conn = jdbcUtils.getConnection();
            String sql = "DELETE TheLoai "
                    + "  WHERE MaTL = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, ma);

            ps.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
