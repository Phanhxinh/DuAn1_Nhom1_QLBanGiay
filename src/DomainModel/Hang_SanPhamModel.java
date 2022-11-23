/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

/**
 *
 * @author PC- ASUS
 */
public class Hang_SanPhamModel {
       
       private String ma;
       private String ten;
       private String id;

    public Hang_SanPhamModel() {
    }

    public Hang_SanPhamModel(String ma, String ten, String id) {
        this.ma = ma;
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
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
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
