/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import Connections.jdbcUtils;
import DomainModel.KichCo_SanPhamModel;

import ITFService.KichCoITF;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author CQTRUONG
 */
public class KichCoRepo implements KichCoITF {

    @Override
    public ArrayList<KichCo_SanPhamModel> All() {
        ArrayList<KichCo_SanPhamModel> listMS = new ArrayList<KichCo_SanPhamModel>();
        try {
            Connection conn = jdbcUtils.getConnection();
            String puery = "SELECT * FROM KichCo";

            PreparedStatement ps = conn.prepareStatement(puery);
            ps.execute();

            ResultSet rs = ps.getResultSet();

            while (rs.next() == true) {

                String ma = rs.getString("MaKC");
                String ten = rs.getString("TenKC");

                KichCo_SanPhamModel kc = new KichCo_SanPhamModel(ma, ten,null);
                listMS.add(kc);
            }
        } catch (Exception ex) {

        }
        return listMS;

    }

    @Override
    public void insert(KichCo_SanPhamModel kc) {
        try {
            Connection conn = jdbcUtils.getConnection();
            String sql = "insert into KichCo "
                    + "(MaKC,TenKC)"
                    + "VALUES(?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, kc.getMaKC());
            ps.setString(2, kc.getTenKC());

            ps.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(String ma, KichCo_SanPhamModel kc) {
        try {
            Connection conn = jdbcUtils.getConnection();
            String sql = "UPDATE KichCo set "
                    + "TenKC = ? WHERE MaKC = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, kc.getTenKC());
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
            String sql = "DELETE KichCo "
                    + "  WHERE MaKC = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, ma);

            ps.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<KichCo_SanPhamModel> CbxKichCo() {
        ArrayList<KichCo_SanPhamModel> list = new ArrayList<>();
        try {
            Connection con = jdbcUtils.getConnection();
            String sql = "select id,tenkc from KichCo";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KichCo_SanPhamModel kc = new KichCo_SanPhamModel();
                kc.setId(rs.getString("id"));
                kc.setTenKC(rs.getString("tenkc"));
                list.add(kc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
