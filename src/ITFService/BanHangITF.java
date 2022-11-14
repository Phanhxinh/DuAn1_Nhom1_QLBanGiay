/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ITFService;

import DomainModel.GioHang_BanHangModel;
import DomainModel.SanPham_BanhangModel;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface BanHangITF {

    ArrayList<SanPham_BanhangModel> getall();

    ArrayList<SanPham_BanhangModel> FindTen(String ten);
    
    ArrayList<GioHang_BanHangModel>getAllGioHang(String ten,String barcode);
}
