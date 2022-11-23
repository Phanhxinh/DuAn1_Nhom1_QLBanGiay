/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

/**
 *
 * @author PC DUNG
 */
public class MauSac_SanphamModel {
    private String MaMS,tenMS;
    private String id;
    public MauSac_SanphamModel() {
    }

    public MauSac_SanphamModel(String MaMS, String tenMS, String id) {
        this.MaMS = MaMS;
        this.tenMS = tenMS;
        this.id = id;
    }

    

    public String getMaMS() {
        return MaMS;
    }

    public void setMaMS(String MaMS) {
        this.MaMS = MaMS;
    }

    public String getTenMS() {
        return tenMS;
    }

    public void setTenMS(String tenMS) {
        this.tenMS = tenMS;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String toString(){
        return tenMS;
    }
    

    
}

   

   