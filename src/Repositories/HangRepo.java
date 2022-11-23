/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import Connections.jdbcUtils;
import DomainModel.Hang_SanPhamModel;

import ITFService.HangITF;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author CQTRUONG
 */
public class HangRepo implements HangITF{
 
    @Override
    public ArrayList<Hang_SanPhamModel> All() {
        ArrayList<Hang_SanPhamModel> listsame = new ArrayList<Hang_SanPhamModel>();
   try {
            Connection conn = jdbcUtils.getConnection();
            String puery = "SELECT * FROM Hang";

            PreparedStatement ps = conn.prepareStatement(puery);
            ps.execute();

            ResultSet rs = ps.getResultSet();

            while (rs.next() == true) {
              
                String ma = rs.getString("MaHang");
                String ten = rs.getString("TenHang");

                Hang_SanPhamModel same = new Hang_SanPhamModel( ma, ten,null);
                listsame.add(same);
            }
        } catch (Exception ex) {

        }
        return listsame;    }

    @Override
    public void insert(Hang_SanPhamModel hang) {
 try {
            Connection conn = jdbcUtils.getConnection();
            String sql = "insert into Hang "
                    + "(MaHang,TenHang)"
                    + "VALUES(?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, hang.getMa());
            ps.setString(2, hang.getTen());

            ps.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }    }

    @Override
    public void update(String ma, Hang_SanPhamModel hang) {
 try {
            Connection conn = jdbcUtils.getConnection();
            String sql = "UPDATE Hang set "
                    + "TenHang = ? WHERE MaHang = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, hang.getTen());
            ps.setString(2, ma);

            ps.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }    }

    @Override
    public void delete(String ma) {
  try {
            Connection conn = jdbcUtils.getConnection();
            String sql = "DELETE Hang "
                    + "  WHERE MaHang = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, ma);

            ps.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    } 
    public ArrayList<Hang_SanPhamModel> CbxHang() {
        ArrayList<Hang_SanPhamModel> list = new ArrayList<>();
        try {
            Connection con = jdbcUtils.getConnection();
            String sql = "select id,tenhang from Hang";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Hang_SanPhamModel hang = new Hang_SanPhamModel();
                hang.setId(rs.getString("id"));
                hang.setTen(rs.getString("tenhang"));
                list.add(hang);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
    

