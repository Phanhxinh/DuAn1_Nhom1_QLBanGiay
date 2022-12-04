/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ITFService;

import DomainModel.ChiTietSPModel;
import java.util.List;

/**
 *
 * @author BachTN
 */
public interface ChiTietSpITF {

    List<ChiTietSPModel> getListCTSP();

    void Add(ChiTietSPModel ctsp);

    void Update(String id, ChiTietSPModel ctsp);

    List<ChiTietSPModel> TimTenSP(String ten);

    List<ChiTietSPModel> TrangThai(int so);
}
