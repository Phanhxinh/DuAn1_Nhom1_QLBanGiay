/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ITFService;

import java.util.ArrayList;
import DomainModel.De_SanPhamModel;
/**
 *
 * @author CQTRUONG
 */
public interface DeITF {
      public ArrayList<De_SanPhamModel> All();
    public void insert(De_SanPhamModel de);
    public void update(String ma,De_SanPhamModel de);
    public void delete(String ma);
}
