/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceIML;

import Connections.ValidateForm;
import DomainModel.KhachHang;
import ITFService.KhachHangITF;
import ViewModel.KhachHangViewModel;
import ViewModel.LsugdViewModel;
import java.util.List;
import Repositories.KhachHangRepo;

public class KhachHangIML implements KhachHangITF {

    private final KhachHangRepo khrepo = new KhachHangRepo();

    @Override
    public List<KhachHangViewModel> getListKh() {
        return khrepo.getListKh();
    }
   
    @Override
    public void Add(KhachHang kh) {
        boolean isExists = khrepo.isExits(kh.getMaKh());
        boolean isValidEmail = ValidateForm.validateEmail(kh.getEmail());
        boolean isValidPhone = ValidateForm.validatePhoneNumber(kh.getSdt());

        if (!kh.getMaKh().startsWith("KH") || kh.getMaKh().isBlank()) {
            throw new RuntimeException("Mã khách hàng không được có khoảng trống và phải bắt đầu bằng KH");
        } else if (isExists) {
            throw new RuntimeException("Khách hàng đã tồn tại");

        } else if (kh.getTenKh().isBlank()) {
            throw new RuntimeException("Tên không được để trống");
        } else if (kh.getNgaySinh().isBlank()) {
            throw new RuntimeException("Ngày sinh không được để trống");

        } else if (kh.getSdt().isBlank()) {
            throw new RuntimeException("Số điện thoại không được để trống");

        } else if (!isValidPhone) {
            throw new RuntimeException("số điện thoại phải gồm 10 số");
        } else if (kh.getEmail().isBlank()) {
            throw new RuntimeException("Email không thể có khoảng trắng");
        } //else if (!isValidEmail) {
        //          throw new RuntimeException("Địa chỉ email có dạng abc@fpt.edu.vn");
        //    }
        else if (kh.getDiachi().isBlank()) {
            throw new RuntimeException("Địa chỉ không được để trống");
        }
        khrepo.Add(kh);
    }

    @Override
    public void Update(String ma, KhachHang kh) {
        boolean isExists = khrepo.isExits(kh.getMaKh());
        boolean isValidEmail = ValidateForm.validateEmail(kh.getEmail());
        boolean isValidPhone = ValidateForm.validatePhoneNumber(kh.getSdt());

        if (!kh.getMaKh().startsWith("KH") || kh.getMaKh().isBlank()) {
            throw new RuntimeException("Mã khách hàng không được có khoảng trống và phải bắt đầu bằng KH");
        } else if (isExists) {
            throw new RuntimeException("Khách hàng đã tồn tại");

        } else if (kh.getTenKh().isBlank()) {
            throw new RuntimeException("Tên không được để trống");
        } else if (kh.getNgaySinh().isBlank()) {
            throw new RuntimeException("Ngày sinh không được để trống");

        } else if (kh.getSdt().isBlank()) {
            throw new RuntimeException("Số điện thoại không được để trống");

        } else if (!isValidPhone) {
            throw new RuntimeException("số điện thoại phải gồm 10 số");
        } else if (kh.getEmail().isBlank()) {
            throw new RuntimeException("Email không thể có khoảng trắng");
        }// else if (!isValidEmail) {
        //  throw new RuntimeException("Địa chỉ email có dạng abc@fpt.edu.vn");
        //} 
        else if (kh.getDiachi().isBlank()) {
            throw new RuntimeException("Địa chỉ không được để trống");
        }
        khrepo.Update(ma, kh);
    }

    @Override
    public List<KhachHangViewModel> FindKh(String makh) {
        return khrepo.FindKh(makh);
    }
    
    @Override
    public List<KhachHangViewModel> GetId(String ten) {
        return khrepo.GetId(ten);
    }

    @Override
    public List<LsugdViewModel> GetLsu(String sdt) {
        return khrepo.Getlsu(sdt);
    }

}
