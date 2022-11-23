/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceIML;

import DomainModel.KichCo_SanPhamModel;
import ITFService.KichCoITF;
import Repositories.KichCoRepo;
import java.util.ArrayList;

/**
 *
 * @author CQTRUONG
 */
public class KichCoIML implements KichCoITF{
 public KichCoRepo kcRepo;
    
    public KichCoIML() {
        this.kcRepo = new KichCoRepo();
    }
    @Override
    public ArrayList<KichCo_SanPhamModel> All() {
        return this.kcRepo.All();
    }

    @Override
    public void insert(KichCo_SanPhamModel kc) {
        this.kcRepo.insert(kc);
    }

    @Override
    public void update(String ma, KichCo_SanPhamModel kc) {
        this.kcRepo.update(ma, kc);
    }

    @Override
    public void delete(String ma) {
        this.kcRepo.delete(ma);
    }
    
}
