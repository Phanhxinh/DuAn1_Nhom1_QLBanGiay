/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

/**
 *
 * @author CQTRUONG
 */
public class De_SanPhamModel {
    private String Id,MaDe,tenDe,ChatLieu,DoCao;

    public De_SanPhamModel() {
    }

    public De_SanPhamModel(String Id, String MaDe, String tenDe, String ChatLieu, String DoCao) {
        this.Id = Id;
        this.MaDe = MaDe;
        this.tenDe = tenDe;
        this.ChatLieu = ChatLieu;
        this.DoCao = DoCao;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getMaDe() {
        return MaDe;
    }

    public void setMaDe(String MaDe) {
        this.MaDe = MaDe;
    }

    public String getTenDe() {
        return tenDe;
    }

    public void setTenDe(String tenDe) {
        this.tenDe = tenDe;
    }

    public String getChatLieu() {
        return ChatLieu;
    }

    public void setChatLieu(String ChatLieu) {
        this.ChatLieu = ChatLieu;
    }

    public String getDoCao() {
        return DoCao;
    }

    public void setDoCao(String DoCao) {
        this.DoCao = DoCao;
    }
    
}
