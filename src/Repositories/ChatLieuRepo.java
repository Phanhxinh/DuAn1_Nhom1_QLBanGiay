/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import Connections.jdbcUtils;
import DomainModel.ChatLieu_SanPhamModel;
import DomainModel.KichCo_SanPhamModel;
import ITFService.ChatLieuITF;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author CQTRUONG
 */
public class ChatLieuRepo implements ChatLieuITF{
     ArrayList<ChatLieu_SanPhamModel> listcl = new ArrayList<ChatLieu_SanPhamModel>();
    @Override
    public ArrayList<ChatLieu_SanPhamModel> All() {
try {
            Connection conn = jdbcUtils.getConnection();
            String puery = "SELECT * FROM ChatLieu";
            
            PreparedStatement ps = conn.prepareStatement(puery);
            ps.execute();
            
            ResultSet rs = ps.getResultSet();
            
            while(rs.next() == true){
                String id = rs.getString("Id");
                String ma = rs.getString("MaCL");
                String ten = rs.getString("TenCL");
                
                ChatLieu_SanPhamModel cl = new ChatLieu_SanPhamModel(id, ma, ten);
                listcl.add(cl);
            }
        } catch (Exception ex) {
            
        }
        return listcl;
        
    }

    @Override
    public void insert(ChatLieu_SanPhamModel cl) {
try {
            Connection conn = jdbcUtils.getConnection();
            String sql = "insert into ChatLieu "
                    + "(MaCL,TenCL)"
                    + "VALUES(?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cl.getMaCL());
            ps.setString(2, cl.getTenCL());
            
            ps.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(String ma, ChatLieu_SanPhamModel cl) {
 try {
            Connection conn = jdbcUtils.getConnection();
            String sql = "UPDATE ChatLieu set "
                    + "TenCL = ? WHERE MaCL = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
          
            ps.setString(1, cl.getTenCL());
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
            String sql = "DELETE ChatLieu "
                    + "  WHERE MaCL = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
          
            
            ps.setString(1, ma);
            
            ps.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }    }
    
}
