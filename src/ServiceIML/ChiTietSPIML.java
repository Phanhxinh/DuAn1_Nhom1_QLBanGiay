/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceIML;

import DomainModel.ChiTietSPModel;
import ITFService.ChiTietSpITF;
import Repositories.ChiTietSPRepo;
import java.util.List;

/**
 *
 * @author BachTN
 */
public class ChiTietSPIML implements ChiTietSpITF{
    private final ChiTietSPRepo ctspRepo=new ChiTietSPRepo();
    @Override
    public List<ChiTietSPModel> getListCTSP() {
        return ctspRepo.getListCTSP();
    }

    @Override
    public void Add(ChiTietSPModel ctsp) {
        ctspRepo.Add(ctsp);
    }

    @Override
    public void Update(String id,ChiTietSPModel ctsp) {
        ctspRepo.Update(id,ctsp);
    }
}
