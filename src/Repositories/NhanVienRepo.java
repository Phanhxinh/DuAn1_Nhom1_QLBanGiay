/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositories;

import Connections.jdbcUtils;
import DomainModel.NhanVien;
import ViewModel.NhanVienViewModel;
import java.sql.Connection;
import java.sql.Date;
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
public class NhanVienRepo {
    public List<NhanVienViewModel> getListNV() {
        List<NhanVienViewModel> listNv = new ArrayList<>();
        try {
            Connection con = jdbcUtils.getConnection();
            String sql = "select manv,tennv,gioitinh,ngaysinh,email,diachi,matkhau,sdt,ten,trangthai,anh from NhanVien join ChucVu on ChucVu.id=NhanVien.idCV";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhanVienViewModel nvviewmodel = new NhanVienViewModel();
                nvviewmodel.setMaNv(rs.getString(1));
                nvviewmodel.setHoTen(rs.getString(2));
                nvviewmodel.setGioiTinh(rs.getString(3));
                nvviewmodel.setNgaySinh(rs.getString(4));
                nvviewmodel.setEmail(rs.getString(5));
                nvviewmodel.setDiaChi(rs.getString(6));
                nvviewmodel.setMatKhau(rs.getString(7));
                nvviewmodel.setSdt(rs.getString(8));
                nvviewmodel.setChucVu(rs.getString(9));
                nvviewmodel.setTrangThai(rs.getString(10));
                nvviewmodel.setAnh(rs.getString(11));
                listNv.add(nvviewmodel);
            }
        } catch (Exception ex) {
            Logger.getLogger(NhanVienRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listNv;
    }
    
    public void Add(NhanVien nv){
        try {
            Connection con= jdbcUtils.getConnection();
            String sql="insert into NhanVien (manv,tennv,anh,gioitinh,ngaysinh,email,diachi,matkhau,sdt,idcv,trangthai) values (?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps=con.prepareStatement(sql);            
            ps.setString(1,nv.getMaNv());
            ps.setString(2,nv.getHoTen());
            ps.setString(3,nv.getAnhNv());
            ps.setString(4,nv.getGioiTinh());
            ps.setString(5,nv.getNgaySinh());
            ps.setString(6,nv.getEmail());
            ps.setString(7,nv.getDiaChi());
            ps.setString(8,nv.getMatKhau());
            ps.setString(9,nv.getSdt());
            ps.setString(10,nv.getIdCV());
            ps.setString(11,nv.getTrangThai());
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(NhanVienRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Update(String ma, NhanVien nv ){
        try {
            Connection con = jdbcUtils.getConnection();
            String sql="update [NhanVien] set tennv =?"
                + ",anh=?,"
                + "gioitinh=?"
                + ",ngaysinh=?"
                + ",email=?"
                + ",diachi=?"
                + ",matkhau=?"
                + ",sdt=?"
                + ",trangthai=?"
                + ",idcv=?"
                + " where manv =?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,nv.getHoTen());
            ps.setString(2,nv.getAnhNv());
            ps.setString(3,nv.getGioiTinh());
            ps.setString(4,nv.getNgaySinh());
            ps.setString(5,nv.getEmail());
            ps.setString(6,nv.getDiaChi());
            ps.setString(7,nv.getMatKhau());
            ps.setString(8,nv.getSdt());
            ps.setString(9,nv.getTrangThai());
            ps.setString(10,nv.getIdCV());
            ps.setString(11,ma);
            ps.executeUpdate();
            
        } catch (Exception ex) {
            Logger.getLogger(NhanVienRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
            
}
