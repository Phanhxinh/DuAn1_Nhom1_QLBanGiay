package ServiceIML;

import DomainModel.DoiMatKhauModel;
import ITFService.DoiMatKhau;
import Repositories.DoiMatKhauRepo;

/**
 *
 * @author Enmazr
 */
public class DoiMatKhauIML implements DoiMatKhau{
    private DoiMatKhauRepo dmkrp= new DoiMatKhauRepo();
    @Override
    public void update(String Email, DoiMatKhauModel dmk) {
        dmkrp.Update(Email, dmk);
    }
    
}
