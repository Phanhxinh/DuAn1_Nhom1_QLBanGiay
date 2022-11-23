/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceIML;

import DomainModel.ChatLieu_SanPhamModel;
import ITFService.ChatLieuITF;
import Repositories.ChatLieuRepo;

import java.util.ArrayList;

/**
 *
 * @author CQTRUONG
 */
public class ChatLieuIML implements ChatLieuITF{
 public ChatLieuRepo Reposame;
    
    public ChatLieuIML() {
        this.Reposame = new ChatLieuRepo();
    }
    @Override
    public ArrayList<ChatLieu_SanPhamModel> All() {
        return this.Reposame.All();
    }

    @Override
    public void insert(ChatLieu_SanPhamModel cl) {
        this.Reposame.insert(cl);
    }

    @Override
    public void update(String ma, ChatLieu_SanPhamModel cl) {
        this.Reposame.update(ma, cl);
    }

    @Override
    public void delete(String ma) {
        this.Reposame.delete(ma);
    }
    
}
