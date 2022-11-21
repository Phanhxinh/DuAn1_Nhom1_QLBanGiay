/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewModel;

/**
 *
 * @author BachTN
 */
public class ChucVuViewModel {
    private String maCv;
    private String tenCV;

    public ChucVuViewModel() {
    }

    public ChucVuViewModel(String maCv, String tenCV) {
        this.maCv = maCv;
        this.tenCV = tenCV;
    }

    public String getMaCv() {
        return maCv;
    }

    public void setMaCv(String maCv) {
        this.maCv = maCv;
    }

    public String getTenCV() {
        return tenCV;
    }

    public void setTenCV(String tenCV) {
        this.tenCV = tenCV;
    }

    @Override
    public String toString() {
        return "ChucVuViewModel{" + "maCv=" + maCv + ", tenCV=" + tenCV + '}';
    }
    
}
