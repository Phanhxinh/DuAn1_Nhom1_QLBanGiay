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
    
    
}
