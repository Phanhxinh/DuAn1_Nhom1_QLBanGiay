/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

/**
 *
 * @author CQTRUONG
 */
public class KichCo_SanPhamModel {
    private String MaKC,tenKC;

    public KichCo_SanPhamModel() {
    }

    public KichCo_SanPhamModel(String MaKC, String tenKC) {
        this.MaKC = MaKC;
        this.tenKC = tenKC;
    }

    public String getMaKC() {
        return MaKC;
    }

    public void setMaKC(String MaKC) {
        this.MaKC = MaKC;
    }

    public String getTenKC() {
        return tenKC;
    }

    public void setTenKC(String tenKC) {
        this.tenKC = tenKC;
    }

    
    
}
