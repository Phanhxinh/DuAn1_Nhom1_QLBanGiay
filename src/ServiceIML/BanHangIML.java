/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceIML;

import DomainModel.GioHang_BanHangModel;
import DomainModel.HoaDonModel;
import DomainModel.HoaDon_BanHangModel;
import DomainModel.KhuyenMai_BanHangModel;
import DomainModel.SanPham_BanhangModel;
import ITFService.BanHangITF;
import Repositories.BanHangRepo;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class BanHangIML implements BanHangITF {
    
    private BanHangRepo banHangRepo = new BanHangRepo();
    
    @Override
    public ArrayList<SanPham_BanhangModel> getall() {
        return banHangRepo.getall();
    }
    
    @Override
    public ArrayList<SanPham_BanhangModel> FindTen(String ten) {
        return banHangRepo.FindTen(ten);
    }
    
    @Override
    public ArrayList<GioHang_BanHangModel> getAllGioHang(String ten, String barcode) {
        return banHangRepo.getAllGioHang(ten, barcode);
    }
    
    @Override
    public ArrayList<HoaDon_BanHangModel> getAllHoaDon() {
        return banHangRepo.getAllHoaDon();
    }
    
    @Override
    public ArrayList<HoaDon_BanHangModel> getHoaDonThanhToan() {
        return banHangRepo.getHoaDonThanhToan();
    }
    
    @Override
    public ArrayList<HoaDon_BanHangModel> getHoaDonDangCho() {
        return banHangRepo.getHoaDonDangCho();
    }
    
    public void insertHoaDon(String IdKH, String IdNV, String IdKM, String MaHD, int TrangThai) {
        banHangRepo.insertHoaDon(IdKH, IdNV, IdKM, MaHD, TrangThai);
    }
    
    @Override
    public ArrayList<HoaDon_BanHangModel> getHoaDonDangChoThanhToan() {
        return banHangRepo.getHoaDonDangChoThanhToan();
    }
    
    @Override
    public void insertHoaDonChiTiet(String IdHoaDon, String IdChiTietSP, String IdKM, int SoLuong, String DoGia) {
        banHangRepo.insertHoaDonChiTiet(IdHoaDon, IdChiTietSP, IdKM, SoLuong, DoGia);
    }
    
    @Override
    public ArrayList<SanPham_BanhangModel> TenSPToId(String TenSP) {
        return banHangRepo.TenSPToId(TenSP);
    }
    
    @Override
    public ArrayList<HoaDonModel> MaHDToIdHD(String MaHD) {
        return banHangRepo.MaHDToIdHD(MaHD);
    }
    
    @Override
    public void updateSoLuongSanPham(int soluong, String id) {
        banHangRepo.updateSoLuongSanPham(soluong, id);
    }
    
    @Override
    public void updateTrangThaiHoaDon(int TrangThai, String MaHD) {
        banHangRepo.updateTrangThaiHoaDon(TrangThai, MaHD);
    }
    
    @Override
    public ArrayList<KhuyenMai_BanHangModel> getCbbTenKM(String NgayBD, String NgayKT) {
        return banHangRepo.getCbbTenKM(NgayBD, NgayKT);
    }
    
    @Override
    public ArrayList<KhuyenMai_BanHangModel> TenKMtoIdKM(String TenKM) {
        return banHangRepo.TenKMtoIdKM(TenKM);
    }
    
    @Override
    public ArrayList<KhuyenMai_BanHangModel> getKhuyenMai(String TenKM) {
        return banHangRepo.getKhuyenMai(TenKM);
    }
    
    @Override
    public ArrayList<GioHang_BanHangModel> MouesClickTableHoaDon(String MaHD) {
        return banHangRepo.MouesClickTableHoaDon(MaHD);
    }
    
    @Override
    public ArrayList<HoaDonModel> MouseClickKM() {
        return banHangRepo.MouseClickKM();
    }
    
    @Override
    public void updateIdKm(String Idkm, String mahd) {
        banHangRepo.updateIdKm(Idkm, mahd);
    }
    
}
