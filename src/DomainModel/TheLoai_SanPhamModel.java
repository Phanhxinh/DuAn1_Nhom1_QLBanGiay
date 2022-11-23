/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

/**
 *
 * @author CQTRUONG
 */
public class TheLoai_SanPhamModel {
    private String MaTL,tenTL;
    private String id;

    public TheLoai_SanPhamModel() {
    }

    public TheLoai_SanPhamModel(String MaTL, String tenTL, String id) {
        this.MaTL = MaTL;
        this.tenTL = tenTL;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getMaTL() {
        return MaTL;
    }

    public void setMaTL(String MaTL) {
        this.MaTL = MaTL;
    }

    public String getTenTL() {
        return tenTL;
    }

    public void setTenTL(String tenTL) {
        this.tenTL = tenTL;
    }
    
    public String toString(){
        return tenTL;
    }

    
}
