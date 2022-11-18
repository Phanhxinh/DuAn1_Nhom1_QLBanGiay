package ITFService;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import DomainModel.ChucVu;
import DomainModel.NhanVien;
import ViewModel.ChucVuViewModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BachTN
 */
public interface ChucVuITF {
    List<ChucVuViewModel> getListCV();
    ArrayList<ChucVu> CbxChucVu();
    void Add(ChucVu cv);
    void Update(ChucVu cv);
    
}
