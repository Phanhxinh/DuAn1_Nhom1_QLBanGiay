/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

/**
 *
 * @author CQTRUONG
 */
public class ChatLieu_SanPhamModel {
    private String Id,MaCL,tenCL;

    public ChatLieu_SanPhamModel() {
    }

    public ChatLieu_SanPhamModel(String Id, String MaCL, String tenCL) {
        this.Id = Id;
        this.MaCL = MaCL;
        this.tenCL = tenCL;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getMaCL() {
        return MaCL;
    }

    public void setMaCL(String MaCL) {
        this.MaCL = MaCL;
    }

    public String getTenCL() {
        return tenCL;
    }

    public void setTenCL(String tenCL) {
        this.tenCL = tenCL;
    }
    
}
