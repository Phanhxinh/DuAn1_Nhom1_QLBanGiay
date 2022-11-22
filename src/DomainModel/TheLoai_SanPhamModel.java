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

    public TheLoai_SanPhamModel() {
    }

    public TheLoai_SanPhamModel(String MaTL, String tenTL) {
        this.MaTL = MaTL;
        this.tenTL = tenTL;
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

    
}
