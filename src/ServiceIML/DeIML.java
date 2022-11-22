/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceIML;

import DomainModel.De_SanPhamModel;
import ITFService.DeITF;
import Repositories.ChatLieuRepo;
import Repositories.DeRepo;

import java.util.ArrayList;

/**
 *
 * @author CQTRUONG
 */
public class DeIML implements DeITF{
 public DeRepo Reposame;
    
    public DeIML() {
        this.Reposame = new DeRepo();
    }
    @Override
    public ArrayList<De_SanPhamModel> All() {
        return this.Reposame.All();
    }

    @Override
    public void insert(De_SanPhamModel de) {
        this.Reposame.insert(de);
    }

    @Override
    public void update(String ma, De_SanPhamModel de) {
        this.Reposame.update(ma, de);
    }

    @Override
    public void delete(String ma) {
        this.Reposame.delete(ma);
    }
    
}
