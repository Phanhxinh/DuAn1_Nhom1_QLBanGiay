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
    private String MaCL,tenCL;
    private String id;
    public ChatLieu_SanPhamModel() {
        
    }

    public ChatLieu_SanPhamModel(String MaCL, String tenCL, String id) {
        this.MaCL = MaCL;
        this.tenCL = tenCL;
        this.id = id;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String toString(){
        return tenCL;
    }
}
   