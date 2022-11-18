/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ITFService;

import DomainModel.NhanVien;
import ViewModel.NhanVienViewModel;
import java.util.List;

/**
 *
 * @author BachTN
 */
public interface NhanVienITF {
    List<NhanVienViewModel> getListNV();
    void Add(NhanVien nv);
    void Update(String ma,NhanVien nv);
}
