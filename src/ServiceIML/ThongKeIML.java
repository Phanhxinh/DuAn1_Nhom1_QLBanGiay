package ServiceIML;

import DomainModel.Thongke_Model;
import ITFService.ThongKeITF;
import Repositories.ThongKeRepo;
import java.util.ArrayList;

/**
 *
 * @author Enmazr
 */
public class ThongKeIML implements ThongKeITF{
    private ThongKeRepo tkrp = new ThongKeRepo();
     @Override
    public ArrayList<Thongke_Model> getall() {
        return tkrp.getall();
    }

    @Override
    public ArrayList<Thongke_Model> tongTatCa() {
        
        return tkrp.tongTatCa();
        
    }

    @Override
    public ArrayList<Thongke_Model> HoaDonTatCa() {
        return tkrp.HoaDonTatCa();
    }

    @Override
    public ArrayList<Thongke_Model> SanPhamTatCa() {
        return tkrp.SanPhamTatCa();
    }

    @Override
    public ArrayList<Thongke_Model> KhachHangTatCa() {
        return tkrp.KhachHangTatCa();
    }

    @Override
    public ArrayList<Thongke_Model> tongNgay() {
        return tkrp.tongNgay();
    }

    @Override
    public ArrayList<Thongke_Model> HoaDonNgay() {
        return tkrp.HoaDonNgay();
    }

    @Override
    public ArrayList<Thongke_Model> SanPhamNgay() {
        return tkrp.SanPhamNgay();
    }

    @Override
    public ArrayList<Thongke_Model> KhachHangNgay() {
        return tkrp.KhachHangNgay();
    }

    @Override
    public ArrayList<Thongke_Model> tongThang() {
        return tkrp.tongThang();
    }

    @Override
    public ArrayList<Thongke_Model> HoaDonThang() {
        return tkrp.HoaDonThang();
    }

    @Override
    public ArrayList<Thongke_Model> SanPhamThang() {
        return tkrp.SanPhamThang();
    }

    @Override
    public ArrayList<Thongke_Model> KhachHangThang() {
        return tkrp.KhachHangThang();
    }

    @Override
    public ArrayList<Thongke_Model> tongNam() {
        return tkrp.tongNam();
    }

    @Override
    public ArrayList<Thongke_Model> HoaDonNam() {
        return tkrp.HoaDonNam();
    }

    @Override
    public ArrayList<Thongke_Model> SanPhamNam() {
        return tkrp.SanPhamNam();
    }

    @Override
    public ArrayList<Thongke_Model> KhachHangNam() {
        return tkrp.KhachHangNam();
    }
}
