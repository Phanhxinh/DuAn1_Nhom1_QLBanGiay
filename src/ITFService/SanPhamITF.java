/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ITFService;

import DomainModel.SanPham_SanPhamModel;

import java.util.ArrayList;

/**
 *
 * @author CQTRUONG
 */
public interface SanPhamITF {
         public ArrayList<SanPham_SanPhamModel> All();
    public void insert(SanPham_SanPhamModel sp);
    public void update(String ma,SanPham_SanPhamModel sp);
    public void delete(String ma);
}
