/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceIML;

import DomainModel.Hang_SanPhamModel;
import ITFService.HangITF;
import Repositories.HangRepo;
import java.util.ArrayList;

/**
 *
 * @author CQTRUONG
 */
public class HangIML implements HangITF{
    HangRepo Reposame;
     public HangIML() {
        this.Reposame = new HangRepo();
    }
    @Override
    public ArrayList<Hang_SanPhamModel> All() {
 return this.Reposame.All();    }

    @Override
    public void insert(Hang_SanPhamModel hang) {
  this.Reposame.insert(hang);    }

    @Override
    public void update(String ma, Hang_SanPhamModel hang) {
  this.Reposame.update(ma, hang);    }

    @Override
    public void delete(String ma) {
    this.Reposame.delete(ma);    }
    
}
