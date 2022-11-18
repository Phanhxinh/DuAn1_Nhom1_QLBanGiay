/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceIML;

import DomainModel.ChucVu;
import ITFService.ChucVuITF;
import Repositories.ChucVuRepo;
import ViewModel.ChucVuViewModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BachTN
 */
public class ChucVuIML implements ChucVuITF {
    private final ChucVuRepo cvrepository=new ChucVuRepo();

    @Override
    public List<ChucVuViewModel> getListCV() {
       return cvrepository.getListCV();
    }

    @Override
    public ArrayList<ChucVu> CbxChucVu() {
        return cvrepository.CbxChucVu();
    }

    @Override
    public void Add(ChucVu cv) {
        cvrepository.Add(cv);
    }

    @Override
    public void Update(ChucVu cv) {
        cvrepository.Update(cv);
    }
    
}
