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
    private ThongKeRepo tkrp= new ThongKeRepo();

    @Override
    public ArrayList<Thongke_Model> getall() {
        return tkrp.getall();
    }

    @Override
    public ArrayList<Thongke_Model> tong() {
        
        return tkrp.tong();
        
    }

    @Override
    public ArrayList<Thongke_Model> tongNgay() {
        return tkrp.tongNgay();
    }

    @Override
    public ArrayList<Thongke_Model> tongThang() {
        return tkrp.tongThang();
    }

    @Override
    public ArrayList<Thongke_Model> tongTuyChon() {
        return tkrp.tongTuyChon();
    }

    @Override
    public ArrayList<Thongke_Model> ban() {
        return tkrp.ban();
    }

    @Override
    public ArrayList<Thongke_Model> banNgay() {
        return tkrp.banNgay();
    }

    @Override
    public ArrayList<Thongke_Model> banThang() {
        return tkrp.banThang();
    }

    @Override
    public ArrayList<Thongke_Model> banTuyChon() {
        return tkrp.banTuyChon();
    }
    
    
}
