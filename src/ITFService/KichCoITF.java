/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ITFService;

import DomainModel.KichCo_SanPhamModel;
import java.util.ArrayList;

/**
 *
 * @author CQTRUONG
 */
public interface KichCoITF {
      public ArrayList<KichCo_SanPhamModel> All();
    public void insert(KichCo_SanPhamModel kc);
    public void update(String ma,KichCo_SanPhamModel kc);
    public void delete(String ma);
}
