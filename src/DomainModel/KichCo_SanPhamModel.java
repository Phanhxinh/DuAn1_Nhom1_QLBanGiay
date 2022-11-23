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
    private String id;

    public KichCo_SanPhamModel() {
    }

    public KichCo_SanPhamModel(String MaKC, String tenKC, String id) {
        this.MaKC = MaKC;
        this.tenKC = tenKC;
        this.id = id;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String toString(){
        return tenKC;
    }
    
}
