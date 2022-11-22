/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceIML;

import DomainModel.SanPham_SanPhamModel;
import ITFService.SanPhamITF;
import Repositories.SanPhamRepo;
import java.util.ArrayList;

/**
 *
 * @author CQTRUONG
 */
public class SanPhamIML implements SanPhamITF {

    SanPhamRepo Reposame;

    public SanPhamIML() {
        this.Reposame = new SanPhamRepo();
    }

    @Override
    public ArrayList<SanPham_SanPhamModel> All() {
        return this.Reposame.All();
    }

    @Override
    public void insert(SanPham_SanPhamModel sp) {
        this.Reposame.insert(sp);
    }

    @Override
    public void update(String ma, SanPham_SanPhamModel sp) {
        this.Reposame.update(ma, sp);
    }

    @Override
    public void delete(String ma) {
        this.Reposame.delete(ma);
    }

}
