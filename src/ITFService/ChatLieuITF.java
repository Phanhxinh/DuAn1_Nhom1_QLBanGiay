/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ITFService;

import DomainModel.ChatLieu_SanPhamModel;
import java.util.ArrayList;

/**
 *
 * @author CQTRUONG
 */
public interface ChatLieuITF {
      public ArrayList<ChatLieu_SanPhamModel> All();
    public void insert(ChatLieu_SanPhamModel cl);
    public void update(String ma,ChatLieu_SanPhamModel cl);
    public void delete(String ma);
}
