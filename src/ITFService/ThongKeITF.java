package ITFService;

import DomainModel.Thongke_Model;
import java.util.ArrayList;


/**
 *
 * @author Enmazr
 */
public interface ThongKeITF {
    ArrayList<Thongke_Model>getall();
    
    ArrayList<Thongke_Model> tong();
    
    ArrayList<Thongke_Model> tongNgay();
    ArrayList<Thongke_Model> tongThang();
    ArrayList<Thongke_Model> tongTuyChon();
}
