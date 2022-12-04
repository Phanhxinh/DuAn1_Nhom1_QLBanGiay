/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ITFService;

import DomainModel.HoaDonView;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface HoadonITF {

    ArrayList<HoaDonView> getall();

    ArrayList<HoaDonView> FindMaNV(String ten);

    ArrayList<HoaDonView> LocNgay(String ngayBD, String ngayKT);

    ArrayList<HoaDonView> TrangThaiTT();

    ArrayList<HoaDonView> TrangThaiHuy();
}
