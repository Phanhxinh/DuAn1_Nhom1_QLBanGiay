/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ITFService;

import DomainModel.MauSac_SanphamModel;
import java.util.ArrayList;

/**
 *
 * @author CQTRUONG
 */
public interface MauSacITF {
      public ArrayList<MauSac_SanphamModel> All();
    public void insert(MauSac_SanphamModel ms);
    public void update(String ma,MauSac_SanphamModel ms);
    public void delete(String ma);
}
