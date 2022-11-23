/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ITFService;

import DomainModel.TheLoai_SanPhamModel;
import java.util.ArrayList;

/**
 *
 * @author CQTRUONG
 */
public interface TheLoaiITF {
        public ArrayList<TheLoai_SanPhamModel> All();
    public void insert(TheLoai_SanPhamModel tl);
    public void update(String ma,TheLoai_SanPhamModel tl);
    public void delete(String ma);
}
