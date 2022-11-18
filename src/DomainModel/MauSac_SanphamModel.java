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
    private String Id,MaMS,tenMS;

    public MauSac_SanphamModel() {
    }

    public MauSac_SanphamModel(String Id, String MaMS, String tenMS) {
        this.Id = Id;
        this.MaMS = MaMS;
        this.tenMS = tenMS;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
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
}

   

   