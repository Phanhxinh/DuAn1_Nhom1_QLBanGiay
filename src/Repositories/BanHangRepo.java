/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModel.SanPham_BanhangModel;
import DomainModel.GioHang_BanHangModel;
import DomainModel.HoaDonModel;
import DomainModel.HoaDon_BanHangModel;
import DomainModel.KhuyenMai_BanHangModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class BanHangRepo {

//    đẩy dữ liệu lên view sản phẩm
    public ArrayList<SanPham_BanhangModel> getall() {
        ArrayList list = new ArrayList<SanPham_BanhangModel>();
        try {
            Connection conn = Connections.jdbcUtils.getConnection();
            String sql = "select b.TenSP,c.TenTL,d.TenHang,e.TenCL,f.TenKC,g.TenMS,h.TenDe,a.SoLuong,a.GiaBan,a.BarCode "
                    + "from ChiTietSP a "
                    + "join SanPham b on a.IdSanPham=b.Id "
                    + "join TheLoai c on a.IdLoaiSP = c.Id "
                    + "join Hang d on a.IdHang=d.Id "
                    + "join ChatLieu e on a.IdChatLieu=e.Id "
                    + "join KichCo f on a.IdKichCo=f.Id "
                    + "join MauSac g on a.IdMauSac=g.Id"
                    + " join De h on a.IdDe=h.Id";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String tenSP = rs.getString("TenSP");
                String tenTL = rs.getString("TenTL");
                String tenHang = rs.getString("TenHang");
                String tenCL = rs.getString("TenCL");
                String tenKC = rs.getString("TenKC");
                String tenMS = rs.getString("TenMS");
                String tenDe = rs.getString("TenDe");
                String soLuong = rs.getString("SoLuong");
                String giaBan = rs.getString("GiaBan");
                String barcode = rs.getString("BarCode");
                SanPham_BanhangModel spbm = new SanPham_BanhangModel(null, tenSP, tenTL, tenHang, tenCL, tenKC, tenMS, tenDe, soLuong, giaBan, barcode);
                list.add(spbm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

//     tìm kiếm sản phẩm 
    public ArrayList<SanPham_BanhangModel> FindTen(String ten) {
        ArrayList list = new ArrayList<SanPham_BanhangModel>();
        try {
            Connection conn = Connections.jdbcUtils.getConnection();
            String sql = "select b.TenSP,c.TenTL,d.TenHang,e.TenCL,f.TenKC,g.TenMS,h.TenDe,a.SoLuong,a.GiaBan,a.BarCode "
                    + "from ChiTietSP a "
                    + "join SanPham b on a.IdSanPham=b.Id "
                    + "join TheLoai c on a.IdLoaiSP = c.Id "
                    + "join Hang d on a.IdHang=d.Id "
                    + "join ChatLieu e on a.IdChatLieu=e.Id "
                    + "join KichCo f on a.IdKichCo=f.Id "
                    + "join MauSac g on a.IdMauSac=g.Id"
                    + " join De h on a.IdDe=h.Id "
                    + "where b.TenSP like N'%" + ten + "%'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String tenSP = rs.getString("TenSP");
                String tenTL = rs.getString("TenTL");
                String tenHang = rs.getString("TenHang");
                String tenCL = rs.getString("TenCL");
                String tenKC = rs.getString("TenKC");
                String tenMS = rs.getString("TenMS");
                String tenDe = rs.getString("TenDe");
                String soLuong = rs.getString("SoLuong");
                String giaBan = rs.getString("GiaBan");
                String barcode = rs.getString("BarCode");
                SanPham_BanhangModel spbm = new SanPham_BanhangModel(null, tenSP, tenTL, tenHang, tenCL, tenKC, tenMS, tenDe, soLuong, giaBan, barcode);
                list.add(spbm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<GioHang_BanHangModel> getAllGioHang(String ten, String barcode) {
        ArrayList list = new ArrayList<SanPham_BanhangModel>();
        try {
            Connection conn = Connections.jdbcUtils.getConnection();
            String sql = "select b.TenSP,c.TenTL,a.GiaBan from ChiTietSP a "
                    + "join SanPham b on a.IdSanPham=b.Id "
                    + "join TheLoai c on a.IdLoaiSP=c.Id where TenSP=? or a.BarCode=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ten);
            ps.setString(2, barcode);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String tenSp = rs.getString("TenSP");
                String tenTL = rs.getString("TenTL");
                String giaBan = rs.getString("GiaBan");
                GioHang_BanHangModel ghbhm = new GioHang_BanHangModel(tenSp, tenTL, 0, giaBan, null);
                list.add(ghbhm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //Thêm sản phẩm vào hóa đơn
    public ArrayList<HoaDon_BanHangModel> getAllHoaDon() {
        ArrayList list = new ArrayList<HoaDon_BanHangModel>();
        try {
            Connection conn = Connections.jdbcUtils.getConnection();
            String sql = "select a.MaHD,b.TenNV,a.TrangThai,a.NgayTao from HoaDon a join NhanVien b on a.IdNV=b.Id order by a.MaHD asc";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String mahd = rs.getString("MaHD");
                String tennv = rs.getString("TenNV");
                int trangthai = rs.getInt("TrangThai");
                String ngaytao = rs.getString("NgayTao");
                HoaDon_BanHangModel hdbhm = new HoaDon_BanHangModel(mahd, tennv, trangthai, ngaytao);
                list.add(hdbhm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //Lọc hóa đơn thanh toán
    public ArrayList<HoaDon_BanHangModel> getHoaDonThanhToan() {
        ArrayList list = new ArrayList<HoaDon_BanHangModel>();
        try {
            Connection conn = Connections.jdbcUtils.getConnection();
            String sql = "select a.MaHD,b.TenNV,a.TrangThai,a.NgayTao from HoaDon a join NhanVien b on a.IdNV=b.Id where a.TrangThai=0 order by a.MaHD asc ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String mahd = rs.getString("MaHD");
                String tennv = rs.getString("TenNV");
                int trangthai = rs.getInt("TrangThai");
                String ngaytao = rs.getString("NgayTao");
                HoaDon_BanHangModel hdbhm = new HoaDon_BanHangModel(mahd, tennv, trangthai, ngaytao);
                list.add(hdbhm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
// Lọc hóa đơn đang chờ

    public ArrayList<HoaDon_BanHangModel> getHoaDonDangCho() {
        ArrayList list = new ArrayList<HoaDon_BanHangModel>();
        try {
            Connection conn = Connections.jdbcUtils.getConnection();
            String sql = "select a.MaHD,b.TenNV,a.TrangThai,a.NgayTao from HoaDon a join NhanVien b on a.IdNV=b.Id where a.TrangThai=1 order by a.MaHD asc ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String mahd = rs.getString("MaHD");
                String tennv = rs.getString("TenNV");
                int trangthai = rs.getInt("TrangThai");
                String ngaytao = rs.getString("NgayTao");
                HoaDon_BanHangModel hdbhm = new HoaDon_BanHangModel(mahd, tennv, trangthai, ngaytao);
                list.add(hdbhm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //Lọc hóa đơn đang chờ thanh toán
    public ArrayList<HoaDon_BanHangModel> getHoaDonDangChoThanhToan() {
        ArrayList list = new ArrayList<HoaDon_BanHangModel>();
        try {
            Connection conn = Connections.jdbcUtils.getConnection();
            String sql = "select a.MaHD,b.TenNV,a.TrangThai,a.NgayTao from HoaDon a join NhanVien b on a.IdNV=b.Id where a.TrangThai=2 order by a.MaHD asc ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String mahd = rs.getString("MaHD");
                String tennv = rs.getString("TenNV");
                int trangthai = rs.getInt("TrangThai");
                String ngaytao = rs.getString("NgayTao");
                HoaDon_BanHangModel hdbhm = new HoaDon_BanHangModel(mahd, tennv, trangthai, ngaytao);
                list.add(hdbhm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //Tạo hóa đơn
    public void insertHoaDon(String IdKH, String IdNV, String IdKM, String MaHD, int TrangThai) {
        try {
            Connection conn = Connections.jdbcUtils.getConnection();
            String sql = "insert into HoaDon(IdKH,IdNV,IdKM,MaHD,NgayTao,NgayThanhToan,TrangThai)"
                    + " values(?,?,?,?,convert(DATE,getdate(),103),convert(DATE,getdate(),103),?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, IdKH);
            ps.setString(2, IdNV);
            ps.setString(3, IdKM);
            ps.setString(4, MaHD);
            ps.setInt(5, TrangThai);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Tạo hóa đơn chi tiết
    public void insertHoaDonChiTiet(String IdHoaDon, String IdChiTietSP, String IdKM, int SoLuong, String DoGia) {
        try {
            Connection conn = Connections.jdbcUtils.getConnection();
            String sql = "insert into HoaDonChiTiet(IdHoaDon,IdChiTietSP,IdKM,SoLuong,DonGia) values(?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, IdHoaDon);
            ps.setString(2, IdChiTietSP);
            ps.setString(3, IdKM);
            ps.setInt(4, SoLuong);
            ps.setString(5, DoGia);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Chuyển tên sản phẩm thành idSanPhamChiTiet
    public ArrayList<SanPham_BanhangModel> TenSPToId(String TenSP) {
        ArrayList list = new ArrayList<HoaDon_BanHangModel>();
        try {
            Connection conn = Connections.jdbcUtils.getConnection();
            String sql = "select a.Id,b.TenSP from ChiTietSP a join SanPham b on a.IdSanPham=b.Id where TenSP=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, TenSP);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString("Id");
                String tenSP = rs.getString("TenSP");
                SanPham_BanhangModel sanPham_BanhangModel = new SanPham_BanhangModel(id, tenSP, null, null, null, null, null, null, null, null, null);
                list.add(sanPham_BanhangModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //Chuyển Mã hóa đơn thành id hóa đơn
    public ArrayList<HoaDonModel> MaHDToIdHD(String MaHD) {
        ArrayList list = new ArrayList<HoaDonModel>();
        try {
            Connection conn = Connections.jdbcUtils.getConnection();
            String sql = "select * from HoaDon where MaHD=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, MaHD);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String idHoaDon = rs.getString("Id");
                String maHd = rs.getString("MaHD");
                HoaDonModel hoaDonModel = new HoaDonModel(idHoaDon, null, null, null, maHd, null);
                list.add(hoaDonModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //cập nhập số lượng sản phẩm trong kho
    public void updateSoLuongSanPham(int soluong, String id) {
        try {
            Connection conn = Connections.jdbcUtils.getConnection();
            String sql = "update ChiTietSP set SoLuong-=? where Id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, soluong);
            ps.setString(2, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // cập nhập trạng thái hóa đơn
    public void updateTrangThaiHoaDon(int TrangThai, String MaHD) {
        try {
            Connection conn = Connections.jdbcUtils.getConnection();
            String sql = "update HoaDon set TrangThai=? where MaHD=?	";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, TrangThai);
            ps.setString(2, MaHD);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<KhuyenMai_BanHangModel> getCbbTenKM(String NgayBD, String NgayKT) {
        ArrayList list = new ArrayList<HoaDonModel>();
        try {
            Connection conn = Connections.jdbcUtils.getConnection();
            String sql = "select * from KhuyenMai where NgayBD<=? and NgayKT>=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, NgayBD);
            ps.setString(2, NgayKT);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String idKM = rs.getString("Id");
                String tenKM = rs.getString("TenKM");
                KhuyenMai_BanHangModel khuyenMai_BanHangModel = new KhuyenMai_BanHangModel(idKM, tenKM, null, null, null);
                list.add(khuyenMai_BanHangModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //Chuyển TenKM thành IdKM
    public ArrayList<KhuyenMai_BanHangModel> TenKMtoIdKM(String TenKM) {
        ArrayList list = new ArrayList<HoaDonModel>();
        try {
            Connection conn = Connections.jdbcUtils.getConnection();
            String sql = "select * from KhuyenMai where TenKM=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, TenKM);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String idKM = rs.getString("Id");
                String tenKM = rs.getString("TenKM");
                KhuyenMai_BanHangModel khuyenMai_BanHangModel = new KhuyenMai_BanHangModel(idKM, tenKM, null, null, null);
                list.add(khuyenMai_BanHangModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // Lấy % khuyến mại
    public ArrayList<KhuyenMai_BanHangModel> getKhuyenMai(String TenKM) {
        ArrayList list = new ArrayList<HoaDonModel>();
        try {
            Connection conn = Connections.jdbcUtils.getConnection();
            String sql = "select * from KhuyenMai where TenKM=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, TenKM);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String ngayBD = rs.getString("NgayBD");
                String ngayKT = rs.getString("NgayKT");
                String giamGia = rs.getString("GiamGia");
                KhuyenMai_BanHangModel khuyenMai_BanHangModel = new KhuyenMai_BanHangModel(null, null, ngayBD, ngayKT, giamGia);
                list.add(khuyenMai_BanHangModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //Mouclick tableHoaDon
    public ArrayList<GioHang_BanHangModel> MouesClickTableHoaDon(String MaHD) {
        ArrayList list = new ArrayList<SanPham_BanhangModel>();
        try {
            Connection conn = Connections.jdbcUtils.getConnection();
            String sql = "select b.TenSP,c.TenTL,a.GiaBan,c.TenTL,d.SoLuong,a.GiaBan,d.DonGia from ChiTietSP a "
                    + "join SanPham b on a.IdSanPham=b.Id"
                    + " join TheLoai c on a.IdLoaiSP=c.Id "
                    + "join HoaDonChiTiet d on a.Id=d.IdChiTietSP "
                    + "where d.IdHoaDon=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, MaHD);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String tenSp = rs.getString("TenSP");
                String tenTL = rs.getString("TenTL");
                String giaBan = rs.getString("GiaBan");
                int soLuong = rs.getInt("SoLuong");
                String donGia = rs.getString("DonGia");
                GioHang_BanHangModel ghbhm = new GioHang_BanHangModel(tenSp, tenTL, soLuong, giaBan, donGia);
                list.add(ghbhm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //MouesClickKM
    public ArrayList<HoaDonModel> MouseClickKM() {
        ArrayList list = new ArrayList<HoaDonModel>();
        try {
            Connection conn = Connections.jdbcUtils.getConnection();
            String sql = "select b.MaHD,a.TenKM from KhuyenMai a join HoaDon b on a.Id=b.IdKM";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String mahd = rs.getString("MaHD");
                String idkm = rs.getString("TenKM");
                HoaDonModel hdm = new HoaDonModel(null, null, null, idkm, mahd, null);
                list.add(hdm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //cập nhật id khuyến mại vào hóa đơn
    public void updateIdKm(String Idkm, String mahd) {
        try {
            Connection conn = Connections.jdbcUtils.getConnection();
            String sql = "update HoaDon set IdKM=? where MaHD=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, Idkm);
            ps.setString(2, mahd);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
// xóa khỏi giỏ hàng
    
}
