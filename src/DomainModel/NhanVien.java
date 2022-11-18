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
public class NhanVien {
    private String id;
    private String maNv;
    private String hoTen;
    private String gioiTinh;
    private String diaChi;
    private String ngaySinh;
    private String anhNv;
    private String sdt;
    private String email;
    private String matKhau;
    private String idCV;
    private String trangThai;

    public NhanVien() {
    }

    public NhanVien(String id, String maNv, String hoTen, String gioiTinh, String diaChi, String ngaySinh, String anhNv, String sdt, String email, String matKhau, String idCV, String trangThai) {
        this.id = id;
        this.maNv = maNv;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.ngaySinh = ngaySinh;
        this.anhNv = anhNv;
        this.sdt = sdt;
        this.email = email;
        this.matKhau = matKhau;
        this.idCV = idCV;
        this.trangThai = trangThai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaNv() {
        return maNv;
    }

    public void setMaNv(String maNv) {
        this.maNv = maNv;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getAnhNv() {
        return anhNv;
    }

    public void setAnhNv(String anhNv) {
        this.anhNv = anhNv;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getIdCV() {
        return idCV;
    }

    public void setIdCV(String idCV) {
        this.idCV = idCV;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "NhanVien{" + "id=" + id + ", maNv=" + maNv + ", hoTen=" + hoTen + ", gioiTinh=" + gioiTinh + ", diaChi=" + diaChi + ", ngaySinh=" + ngaySinh + ", anhNv=" + anhNv + ", sdt=" + sdt + ", email=" + email + ", matKhau=" + matKhau + ", idCV=" + idCV + ", trangThai=" + trangThai + '}';
    }

    
}
