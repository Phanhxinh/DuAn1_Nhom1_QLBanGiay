/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceIML;

import DomainModel.KhuyenMaiModel;
import ITFService.KhuyenMaiIF;
import Repositories.KhuyenMaiRepo;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class KhuyenMaiIML implements KhuyenMaiIF {
////
    private KhuyenMaiRepo khuyenMaiRepo = new KhuyenMaiRepo();

    public ArrayList<KhuyenMaiModel> all() {
        return khuyenMaiRepo.all();
    }

    public void update(String id, KhuyenMaiModel khuyenMai) {
        khuyenMaiRepo.update(id, khuyenMai);
    }

    public void insert(KhuyenMaiModel khuyenMai) {
        khuyenMaiRepo.intsert(khuyenMai);
    }

    @Override
    public ArrayList<KhuyenMaiModel> Find(String ten) {
        return khuyenMaiRepo.Find(ten);
    }

    @Override
    public ArrayList<KhuyenMaiModel> Findtt(String ngaybd, String ngaykt) {
        return khuyenMaiRepo.Findtt(ngaybd, ngaykt);
    }

    @Override
    public ArrayList<KhuyenMaiModel> Findttkt(String ngaybd, String ngaykt) {
        return khuyenMaiRepo.Findttkt(ngaybd, ngaykt);
    }

}
