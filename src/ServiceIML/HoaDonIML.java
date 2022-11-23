/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceIML;

import DomainModel.HoaDonView;
import ITFService.HoadonITF;
import Repositories.HoaDonRepo;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class HoaDonIML implements HoadonITF {

    private HoaDonRepo hoaDonRepo = new HoaDonRepo();

    @Override
    public ArrayList<HoaDonView> getall() {
        return hoaDonRepo.getall();
    }

    @Override
    public ArrayList<HoaDonView> FindMaNV(String ten) {
        return hoaDonRepo.FindMaNV(ten);
    }

}
