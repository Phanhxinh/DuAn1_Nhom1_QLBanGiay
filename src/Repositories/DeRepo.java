/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import Connections.jdbcUtils;
import DomainModel.ChatLieu_SanPhamModel;
import DomainModel.De_SanPhamModel;
import ITFService.DeITF;
import java.util.ArrayList;
import DomainModel.De_SanPhamModel;
       
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DeRepo implements DeITF {

    ArrayList<De_SanPhamModel> listsame = new ArrayList<De_SanPhamModel>();

    @Override
    public ArrayList<De_SanPhamModel> All() {
        try {
            Connection conn = jdbcUtils.getConnection();
            String puery = "SELECT * FROM De";

            PreparedStatement ps = conn.prepareStatement(puery);
            ps.execute();

            ResultSet rs = ps.getResultSet();

            while (rs.next() == true) {
                String id = rs.getString("Id");
                String ma = rs.getString("MaDe");
                String ten = rs.getString("TenDe");
                String chatlieu = rs.getString("ChatLieu");
                String docao = rs.getString("DoCao");

                De_SanPhamModel same = new De_SanPhamModel(id, ma, ten, chatlieu, docao);
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

}

