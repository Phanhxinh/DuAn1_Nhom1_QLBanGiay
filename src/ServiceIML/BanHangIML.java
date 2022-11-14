/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceIML;

import DomainModel.GioHang_BanHangModel;
import DomainModel.SanPham_BanhangModel;
import ITFService.BanHangITF;
import Repositories.BanHangRepo;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class BanHangIML implements BanHangITF {

    private BanHangRepo banHangRepo = new BanHangRepo();

    @Override
    public ArrayList<SanPham_BanhangModel> getall() {
        return banHangRepo.getall();
    }

    @Override
    public ArrayList<SanPham_BanhangModel> FindTen(String ten) {
        return banHangRepo.FindTen(ten);
    }

    @Override
    public ArrayList<GioHang_BanHangModel> getAllGioHang(String ten, String barcode) {
        return banHangRepo.getAllGioHang(ten, barcode);
    }

}
