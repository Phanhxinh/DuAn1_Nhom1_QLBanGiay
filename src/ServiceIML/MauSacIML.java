/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceIML;

import DomainModel.MauSac_SanphamModel;
import ITFService.MauSacITF;
import Repositories.MauSacRepo;
import java.util.ArrayList;

/**
 *
 * @author CQTRUONG
 */
public class MauSacIML implements MauSacITF {

    public MauSacRepo mauSacRepo;
    
    public MauSacIML() {
        this.mauSacRepo = new MauSacRepo();
    }
    
    @Override
    public ArrayList<MauSac_SanphamModel> All() {
        return this.mauSacRepo.All();
    }
    
    @Override
    public void insert(MauSac_SanphamModel ms) {
        this.mauSacRepo.insert(ms);
    }
    
    @Override
    public void update(String ma, MauSac_SanphamModel ms) {
        this.mauSacRepo.update(ma, ms);
    }
    
    @Override
    public void delete(String ma) {
        this.mauSacRepo.delete(ma);
    }
    
}
