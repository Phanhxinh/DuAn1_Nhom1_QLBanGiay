/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import Connections.jdbcUtils;
import DomainModel.SanPham_SanPhamModel;
import DomainModel.TheLoai_SanPhamModel;

import ITFService.SanPhamITF;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author CQTRUONG
 */
public class SanPhamRepo implements SanPhamITF{

    @Override
    public ArrayList<SanPham_SanPhamModel> All() {
    ArrayList<SanPham_SanPhamModel> listsame = new ArrayList<SanPham_SanPhamModel>();
        try {
            Connection conn = jdbcUtils.getConnection();
            String puery = "SELECT * FROM SanPham";

            PreparedStatement ps = conn.prepareStatement(puery);
            ps.execute();

            ResultSet rs = ps.getResultSet();

            while (rs.next() == true) {
            
                String ma = rs.getString("MaSP");
                String ten = rs.getString("TenSP");

               SanPham_SanPhamModel same = new SanPham_SanPhamModel( ma, ten,null);
                listsame.add(same);
            }
        } catch (Exception ex) {

        }
        return listsame;
    }

    @Override
    public void insert(SanPham_SanPhamModel sp) {
 try {
            Connection conn = jdbcUtils.getConnection();
            String sql = "insert into SanPham "
                    + "(MaSP,TenSP)"
                    + "VALUES(?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sp.getMa());
            ps.setString(2, sp.getTen());

            ps.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }    }

    @Override
    public void update(String ma, SanPham_SanPhamModel sp) {
try {
            Connection conn = jdbcUtils.getConnection();
            String sql = "UPDATE SanPham set "
                    + "TenSP = ? WHERE MaSP = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, sp.getTen());
            ps.setString(2, ma);

            ps.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }    }

    @Override
    public void delete(String ma) {
try {
            Connection conn = jdbcUtils.getConnection();
            String sql = "DELETE SanPham "
                    + "  WHERE MaSP = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, ma);

            ps.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public ArrayList<SanPham_SanPhamModel> CbxSanPham() {
        ArrayList<SanPham_SanPhamModel> list = new ArrayList<>();
        try {
            Connection con = jdbcUtils.getConnection();
            String sql = "select id,tensp from SanPham";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham_SanPhamModel sp = new SanPham_SanPhamModel();
                sp.setId(rs.getString("id"));
                sp.setTen(rs.getString("tensp"));
                list.add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

  
 }
    

