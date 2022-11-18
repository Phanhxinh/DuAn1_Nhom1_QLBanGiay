/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositories;

import Connections.jdbcUtils;
import DomainModel.ChucVu;
import Repositories.NhanVienRepo;
import Repositories.NhanVienRepo;
import ViewModel.ChucVuViewModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BachTN
 */
public class ChucVuRepo {

    public List<ChucVuViewModel> getListCV() {
        List<ChucVuViewModel> listCv = new ArrayList<>();
        try {
            Connection con = jdbcUtils.getConnection();
            String sql = "select ma,ten from ChucVu";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChucVuViewModel cvview = new ChucVuViewModel();
                cvview.setMaCv(rs.getString(1));
                cvview.setTenCV(rs.getString(2));
                listCv.add(cvview);
            }
        } catch (Exception ex) {
            Logger.getLogger(ChucVuRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listCv;
    }
    
    public ArrayList<ChucVu> CbxChucVu() {
        ArrayList<ChucVu> list = new ArrayList<>();
        try {
            Connection con = jdbcUtils.getConnection();
            String sql = "select id,ten from ChucVu";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChucVu chucVu = new ChucVu();
                chucVu.setIdCV(rs.getString("id"));
                chucVu.setTenCV(rs.getString("ten"));
                list.add(chucVu);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public void Add(ChucVu cv){
        try {
            Connection con= jdbcUtils.getConnection();
            String sql="insert into ChucVu (ma,ten) values (?,?)";
            PreparedStatement ps=con.prepareStatement(sql);            
            ps.setString(1,cv.getMaCV());
            ps.setString(2,cv.getTenCV());
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(NhanVienRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void Update(ChucVu cv){
        try {
            Connection con= jdbcUtils.getConnection();
            String sql="update [ChucVu] set ten=?"
                + "where ma =?";
            PreparedStatement ps=con.prepareStatement(sql);            
            ps.setString(1,cv.getTenCV());
            ps.setString(2,cv.getMaCV());
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(NhanVienRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
