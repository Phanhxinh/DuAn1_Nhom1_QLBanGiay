/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ITFService;

import DomainModel.KhachHang;
import ViewModel.KhachHangViewModel;
import java.util.List;

public interface KhachHangITF {
     List<KhachHangViewModel>  getListKh();
    void Add(KhachHang kh);
    void Update(String ma , KhachHang kh);
    List<KhachHangViewModel> FindKh(String makh);
}
