/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

/**
 *
 * @author CQTRUONG
 */
public class SanPham_SanPhamModel {
      private String Id,Ma,ten;

    public SanPham_SanPhamModel() {
    }

    public SanPham_SanPhamModel(String Id, String Ma, String ten) {
        this.Id = Id;
        this.Ma = Ma;
        this.ten = ten;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getMa() {
        return Ma;
    }

    public void setMa(String Ma) {
        this.Ma = Ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
      
}
