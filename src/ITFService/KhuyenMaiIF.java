/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ITFService;

import DomainModel.KhuyenMaiModel;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public interface KhuyenMaiIF {

    ArrayList<KhuyenMaiModel> all();

    public void insert(KhuyenMaiModel khuyenMai);

    public void update(String id, KhuyenMaiModel khuyenMai);

    ArrayList<KhuyenMaiModel> Find(String ten);

    ArrayList<KhuyenMaiModel> Findtt(String ngaybd, String ngaykt);

    ArrayList<KhuyenMaiModel> Findttkt(String ngaybd, String ngaykt);
}
