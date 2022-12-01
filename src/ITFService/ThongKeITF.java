package ITFService;

import DomainModel.Thongke_Model;
import java.util.ArrayList;


/**
 *
 * @author Enmazr
 */
public interface ThongKeITF {

   ArrayList<Thongke_Model>getall();
    
    //Thống kê tất cả
    ArrayList<Thongke_Model> tongTatCa();
    ArrayList<Thongke_Model> HoaDonTatCa();
    ArrayList<Thongke_Model> SanPhamTatCa();
    ArrayList<Thongke_Model> KhachHangTatCa();
    
    //Thống kê ngày hôm nay
    ArrayList<Thongke_Model> tongNgay();
    ArrayList<Thongke_Model> HoaDonNgay();
    ArrayList<Thongke_Model> SanPhamNgay();
    ArrayList<Thongke_Model> KhachHangNgay();
    
    //thống kê tháng
    ArrayList<Thongke_Model> tongThang();
    ArrayList<Thongke_Model> HoaDonThang();
    ArrayList<Thongke_Model> SanPhamThang();
    ArrayList<Thongke_Model> KhachHangThang();
    
    //thống kê năm
    ArrayList<Thongke_Model> tongNam();
    ArrayList<Thongke_Model> HoaDonNam();
    ArrayList<Thongke_Model> SanPhamNam();
    ArrayList<Thongke_Model> KhachHangNam();

    //thống kê nhân viên
    ArrayList<Thongke_Model>NhanVienXS();
    ArrayList<Thongke_Model>NhanVienXSThang();
    ArrayList<Thongke_Model>NhanVienXSNam();
    
}
