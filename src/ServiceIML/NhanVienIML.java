/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceIML;

import Connections.ValidateForm;
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
        boolean isExists = nvrepo.isExists(nv.getMaNv());
        boolean isValidEmail = ValidateForm.validateEmail(nv.getEmail());
        boolean isValidPhoneNumber = ValidateForm.validatePhoneNumber(nv.getSdt());
        boolean isValidatePass = ValidateForm.validatePass(nv.getMatKhau());
        if (!nv.getMaNv().startsWith("NV")) {
            throw new RuntimeException("Mã sinh viên phải bắt đầu bằng NV");
        } else if (isExists) {
            throw new RuntimeException("Mã sinh viên đã tồn tại");
        } else if (nv.getHoTen().isEmpty()) {
            throw new RuntimeException("Tên sinh viên không được bỏ trống");
        } else if (nv.getGioiTinh().isEmpty()) {
            throw new RuntimeException("Bạn chưa chọn giới tinh");
        } else if (nv.getNgaySinh().isEmpty()) {
            throw new RuntimeException("Bạn chưa nhập ngày sinh"); 
        } else if (nv.getEmail().isEmpty()) {
            throw new RuntimeException("Bạn chưa nhập email"); 
        } else if (!isValidEmail) {
            throw new RuntimeException("Địa chỉ email có dạng abc@fpt.edu.vn");
        } else if (nv.getSdt().isEmpty()) {
            throw new RuntimeException("Bạn chưa nhập số điện thoại");     
        } else if (!isValidPhoneNumber) {
            throw new RuntimeException("Số điện thoại phải gồm 10 số");
        } else if (nv.getMatKhau().isEmpty()) {
            throw new RuntimeException("Mật khẩu không được để trống");
            // Validate số điện thoại phải là số    \
        }else if (!isValidatePass) {
            throw new RuntimeException("Mật khẩu phải gồm ít nhất 1 chữ in hoa, 1 kí tự đặc biệt, số và chữ thường");
        } else if (nv.getDiaChi().isEmpty()) {
            throw new RuntimeException("Bạn chưa nhập địa chỉ");
        }
        nvrepo.Add(nv);
    }

    @Override
    public void Update(String ma,NhanVien nv) {
        nvrepo.Update(ma,nv);
    }

    @Override
    public List<NhanVienViewModel> FindNhanVien(String manv) {
        return nvrepo.FindNhanVien(manv);
    }

   
    
}
