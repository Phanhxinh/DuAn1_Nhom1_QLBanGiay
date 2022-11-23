/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositories;
import Connections.jdbcUtils;
import DomainModel.ChiTietSPModel;
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
public class ChiTietSPRepo {

    public List<ChiTietSPModel> getListCTSP() {
        List<ChiTietSPModel> listSP = new ArrayList<>();
        try {
            Connection con = jdbcUtils.getConnection();
            String sql = "select ChiTietSP.Id, SanPham.TenSP,KichCo.TenKc,MauSac.TenMS,TheLoai.TenTL,ChatLieu.TenCL,Hang.TenHang,De.TenDe,GiaNhap,GiaBan,SoLuong,BarCode,MoTa,Anh,TrangThai \n"
                    + "from ChiTietSP \n"
                    + "inner join SanPham on SanPham.id=ChiTietSP.IdSanPham\n"
                    + "inner join KichCo on KichCo.id=ChiTietSP.IdKichCo\n"
                    + "inner join MauSac on MauSac.id=ChiTietSP.IdMauSac\n"
                    + "inner join TheLoai on TheLoai.id=ChiTietSP.IdLoaiSP\n"
                    + "inner join ChatLieu on ChatLieu.id=ChiTietSP.IdChatLieu\n"
                    + "inner join Hang on Hang.id=ChiTietSP.IdHang\n"
                    + "inner join De on De.id=ChiTietSP.IdDe";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChiTietSPModel ctsp = new ChiTietSPModel();
                ctsp.setId(rs.getString(1));
                ctsp.setIdSP(rs.getString(2));
                ctsp.setIdSize(rs.getString(3));
                ctsp.setIdMau(rs.getString(4));
                ctsp.setIdLoaiSP(rs.getString(5));
                ctsp.setIdChatLieu(rs.getString(6));
                ctsp.setIdHang(rs.getString(7));
                ctsp.setIdDE(rs.getString(8));
                ctsp.setGiaNhap(rs.getInt(9));
                ctsp.setGiaBan(rs.getInt(10));
                ctsp.setSoLuong(rs.getInt(11));
                ctsp.setBarCode(rs.getString(12));
                ctsp.setMoTa(rs.getString(13));
                ctsp.setAnh(rs.getString(14));
                ctsp.setTrangThai(rs.getInt(15));
                listSP.add(ctsp);
            }
        } catch (Exception ex) {
            Logger.getLogger(NhanVienRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listSP;
    }

    public void Add(ChiTietSPModel ctsp) {
        try {
            Connection con = jdbcUtils.getConnection();
            String sql = "INSERT INTO [dbo].[ChiTietSP]\n"
                    + "           ([IdSanPham]\n"
                    + "           ,[IdKichCo]\n"
                    + "           ,[IdMauSac]\n"
                    + "           ,[IdLoaiSP]\n"
                    + "           ,[IdChatLieu]\n"
                    + "           ,[IdHang]\n"
                    + "           ,[IdDe]\n"
                    + "           ,[GiaNhap]\n"
                    + "           ,[GiaBan]\n"
                    + "           ,[SoLuong]\n"
                    + "           ,[BarCode]\n"
                    + "           ,[MoTa]\n"
                    + "           ,[Anh]\n"
                    + "           ,[TrangThai])\n"
                    + "           VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ctsp.getIdSP());
            ps.setString(2, ctsp.getIdSize());
            ps.setString(3, ctsp.getIdMau());
            ps.setString(4, ctsp.getIdLoaiSP());
            ps.setString(5, ctsp.getIdChatLieu());
            ps.setString(6, ctsp.getIdHang());
            ps.setString(7, ctsp.getIdDE());
            ps.setInt(8, ctsp.getGiaNhap());
            ps.setInt(9, ctsp.getGiaBan());
            ps.setInt(10, ctsp.getSoLuong());
            ps.setString(11, ctsp.getBarCode());
            ps.setString(12, ctsp.getMoTa());
            ps.setString(13, ctsp.getAnh());
            ps.setInt(14, ctsp.getTrangThai());
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(NhanVienRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Update(String id,ChiTietSPModel ctsp) {
        try {
            Connection con = jdbcUtils.getConnection();
            String sql = "update [ChiTietSP] "
                    + "set [IdKichCo]=?,"
                    + "[IdMauSac]=?"
                    + ",[IdLoaiSP]=?"
                    + ",[IdChatLieu]=?"
                    + ",[IdHang]=?"
                    + ",[IdDe]=?"
                    + ",[GiaNhap]=?"
                    + ",[GiaBan]=?"
                    + ",[SoLuong]=?"
                    + ",[BarCode]=?"
                    + ",[MoTa]=?"
                    + ",[Anh]=?"
                    + ",[TrangThai]=?"
                    + " where [Id] =?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, ctsp.getIdSize());
            ps.setString(2, ctsp.getIdMau());
            ps.setString(3, ctsp.getIdLoaiSP());
            ps.setString(4, ctsp.getIdChatLieu());
            ps.setString(5, ctsp.getIdHang());
            ps.setString(6, ctsp.getIdDE());
            ps.setInt(7, ctsp.getGiaNhap());
            ps.setInt(8, ctsp.getGiaBan());
            ps.setInt(9, ctsp.getSoLuong());
            ps.setString(10, ctsp.getBarCode());
            ps.setString(11, ctsp.getMoTa());
            ps.setString(12, ctsp.getAnh());
            ps.setInt(13, ctsp.getTrangThai());
            ps.setString(14, id);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(NhanVienRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
