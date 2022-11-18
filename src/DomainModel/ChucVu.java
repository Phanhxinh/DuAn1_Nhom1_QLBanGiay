/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainModel;

/**
 *
 * @author BachTN
 */
public class ChucVu {
    private String idCV;
    private String maCV;
    private String tenCV;

    public ChucVu() {
    }

    public ChucVu(String idCV, String maCV, String tenCV) {
        this.idCV = idCV;
        this.maCV = maCV;
        this.tenCV = tenCV;
    }

    public String getIdCV() {
        return idCV;
    }

    public void setIdCV(String idCV) {
        this.idCV = idCV;
    }

    public String getMaCV() {
        return maCV;
    }

    public void setMaCV(String maCV) {
        this.maCV = maCV;
    }

    public String getTenCV() {
        return tenCV;
    }

    public void setTenCV(String tenCV) {
        this.tenCV = tenCV;
    }
    
    public String toString(){
        return tenCV;
    }
    
}
