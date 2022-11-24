/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

/**
 *
 * @author Hong Phong
 */
public class KhachHangViewModel {
    private String id;
    private String maKh ;
    private String tenKh ;
    private String ngaySinh;
    private String sdt ;
    private String Email ;
    private String diachi ;

    public KhachHangViewModel() {
    }

    public KhachHangViewModel(String id, String maKh, String tenKh, String ngaySinh, String sdt, String Email, String diachi) {
        this.id = id;
        this.maKh = maKh;
        this.tenKh = tenKh;
        this.ngaySinh = ngaySinh;
        this.sdt = sdt;
        this.Email = Email;
        this.diachi = diachi;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaKh() {
        return maKh;
    }

    public void setMaKh(String maKh) {
        this.maKh = maKh;
    }

    public String getTenKh() {
        return tenKh;
    }

    public void setTenKh(String tenKh) {
        this.tenKh = tenKh;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

 
    
     @Override
    public String toString() {
        return "KhachHangViewModel("  +  ", MaKH=" + maKh + ", TenKh = " + tenKh + ", NgaySinh = " + ngaySinh + ", SDT=" + sdt + ", email=" + Email + ",DiaChi=" +diachi + ')' ;  
    }
}
