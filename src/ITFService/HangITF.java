/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ITFService;


import DomainModel.Hang_SanPhamModel;
import java.util.ArrayList;

/**
 *
 * @author CQTRUONG
 */
public interface HangITF {
         public ArrayList<Hang_SanPhamModel> All();
    public void insert(Hang_SanPhamModel hang);
    public void update(String ma,Hang_SanPhamModel hang);
    public void delete(String ma);
}
