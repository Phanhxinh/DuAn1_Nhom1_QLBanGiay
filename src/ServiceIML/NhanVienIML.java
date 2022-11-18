/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceIML;

import DomainModel.NhanVien;
import ITFService.NhanVienITF;
import Repositories.NhanVienRepo;
import ViewModel.NhanVienViewModel;
import java.util.List;

/**
 *
 * @author BachTN
 */
public class NhanVienIML implements NhanVienITF{
    private final NhanVienRepo nvrepo=new NhanVienRepo();

    @Override
    public List<NhanVienViewModel> getListNV() {
        return nvrepo.getListNV();
    }

    @Override
    public void Add(NhanVien nv) {
        nvrepo.Add(nv);
    }

    @Override
    public void Update(String ma,NhanVien nv) {
        nvrepo.Update(ma,nv);
    }
    
}
