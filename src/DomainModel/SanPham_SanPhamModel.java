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
    private String Ma,ten;
    private String id;

    public SanPham_SanPhamModel() {
    }

    public SanPham_SanPhamModel(String Ma, String ten, String id) {
        this.Ma = Ma;
        this.ten = ten;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
    
    public String toString(){
        return ten;
    }

   
}
