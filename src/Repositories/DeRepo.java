/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import Connections.jdbcUtils;
import DomainModel.ChatLieu_SanPhamModel;
import DomainModel.De_SanPhamModel;
import java.util.ArrayList;
import DomainModel.De_SanPhamModel;
       
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import ITFService.DEITF;

public class DeRepo implements DEITF {

   

    @Override
    public ArrayList<De_SanPhamModel> All() {
         ArrayList<De_SanPhamModel> listsame = new ArrayList<De_SanPhamModel>();
        try {
            Connection conn = jdbcUtils.getConnection();
            String puery = "SELECT * FROM De";

            PreparedStatement ps = conn.prepareStatement(puery);
            ps.execute();

            ResultSet rs = ps.getResultSet();

            while (rs.next() == true) {
             
                String ma = rs.getString("MaDe");
                String ten = rs.getString("TenDe");
                String chatlieu = rs.getString("ChatLieu");
                String docao = rs.getString("DoCao");

                De_SanPhamModel same = new De_SanPhamModel( ma, ten, chatlieu, docao,null);
                listsame.add(same);
            }
        } catch (Exception ex) {

        }
        return listsame;

    }

    @Override
    public void insert(De_SanPhamModel de) {
try {
            Connection conn = jdbcUtils.getConnection();
            String sql = "insert into De "
                    + "(MaDe,TenDe,ChatLieu,DoCao)"
                    + "VALUES(?,?,?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, de.getMaDe());
            ps.setString(2, de.getTenDe());
             ps.setString(3, de.getChatLieu());
              ps.setString(4, de.getDoCao());
            
            ps.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(String ma, De_SanPhamModel de) {
try {
            Connection conn = jdbcUtils.getConnection();
            String sql = "UPDATE De set "
                    + "TenDe = ? ChatLieu = ? DoCao= ? WHERE MaDe = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
          
            ps.setString(1, de.getTenDe());
            ps.setString(2, de.getChatLieu());
            ps.setString(3, de.getDoCao());
            ps.setString(4, ma);
            
            ps.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }    
    }

    @Override
    public void delete(String ma) {
try {
            Connection conn = jdbcUtils.getConnection();
            String sql = "DELETE De "
                    + "  WHERE MaDe = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
          
            
            ps.setString(1, ma);
            
            ps.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }    } 
    public ArrayList<De_SanPhamModel> CbxDe() {
        ArrayList<De_SanPhamModel> list = new ArrayList<>();
        try {
            Connection con = jdbcUtils.getConnection();
            String sql = "select id,tende from De";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                De_SanPhamModel hang = new De_SanPhamModel();
                hang.setId(rs.getString("id"));
                hang.setTenDe(rs.getString("tende"));
                list.add(hang);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}

