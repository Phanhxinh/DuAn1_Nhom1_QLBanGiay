/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ITFService;

import DomainModel.GioHang_BanHangModel;
import DomainModel.HoaDonModel;
import DomainModel.HoaDon_BanHangModel;
import DomainModel.KhuyenMai_BanHangModel;
import DomainModel.SanPham_BanhangModel;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface BanHangITF {

    ArrayList<SanPham_BanhangModel> getall();

    ArrayList<SanPham_BanhangModel> FindTen(String ten);

    ArrayList<GioHang_BanHangModel> getAllGioHang(String ten, String barcode);

    ArrayList<HoaDon_BanHangModel> getAllHoaDon();

    ArrayList<HoaDon_BanHangModel> getHoaDonThanhToan();

    ArrayList<HoaDon_BanHangModel> getHoaDonDangCho();

    ArrayList<HoaDon_BanHangModel> getHoaDonDangChoThanhToan();

    void insertHoaDon(String IdKH, String IdNV, String IdKM, String MaHD, int TrangThai);

    void insertHoaDonChiTiet(String IdHoaDon, String IdChiTietSP, String IdKM, int SoLuong, String DoGia);

    ArrayList<SanPham_BanhangModel> TenSPToId(String TenSP);

    ArrayList<HoaDonModel> MaHDToIdHD(String MaHD);

    void updateSoLuongSanPham(int soluong, String id);

    void updateTrangThaiHoaDon(int TrangThai, String MaHD);

    ArrayList<KhuyenMai_BanHangModel> getCbbTenKM(String NgayBD, String NgayKT);

    ArrayList<KhuyenMai_BanHangModel> TenKMtoIdKM(String TenKM);

    ArrayList<KhuyenMai_BanHangModel> getKhuyenMai(String TenKM);
    
    ArrayList<GioHang_BanHangModel> MouesClickTableHoaDon(String MaHD);
    
    ArrayList<HoaDonModel> MouseClickKM() ;
    
    void updateIdKm(String Idkm, String mahd);
}
