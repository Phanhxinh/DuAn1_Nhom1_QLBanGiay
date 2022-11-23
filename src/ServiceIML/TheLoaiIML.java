/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceIML;

import DomainModel.TheLoai_SanPhamModel;
import ITFService.TheLoaiITF;
import Repositories.TheLoaiRepo;
import java.util.ArrayList;

/**
 *
 * @author CQTRUONG
 */
public class TheLoaiIML implements TheLoaiITF{
 public TheLoaiRepo Reposame;
 public TheLoaiIML() {
        this.Reposame = new TheLoaiRepo();
    }
    @Override
    public ArrayList<TheLoai_SanPhamModel> All() {
  return this.Reposame.All();
    }

    @Override
    public void insert(TheLoai_SanPhamModel tl) {
        this.Reposame.insert(tl);
    }

    @Override
    public void update(String ma, TheLoai_SanPhamModel tl) {
      this.Reposame.update(ma, tl);
    }

    @Override
    public void delete(String ma) {
        this.Reposame.delete(ma);
    }
    
}
