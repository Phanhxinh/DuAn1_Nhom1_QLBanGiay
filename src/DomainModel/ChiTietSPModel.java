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
public class ChiTietSPModel {
    private String id;
    private String idSP;
    private String idSize;
    private String idMau;
    private String idLoaiSP;
    private String idChatLieu;
    private String idHang;
    private String idDE;
    private int giaBan;
    private int giaNhap;
    private int soLuong;
    private String barCode;
    private String moTa;
    private String anh;
    private int trangThai;

    public ChiTietSPModel() {
    }

    public ChiTietSPModel(String id, String idSP, String idSize, String idMau, String idLoaiSP, String idChatLieu, String idHang, String idDE, int giaBan, int giaNhap, int soLuong, String barCode, String moTa, String anh, int trangThai) {
        this.id = id;
        this.idSP = idSP;
        this.idSize = idSize;
        this.idMau = idMau;
        this.idLoaiSP = idLoaiSP;
        this.idChatLieu = idChatLieu;
        this.idHang = idHang;
        this.idDE = idDE;
        this.giaBan = giaBan;
        this.giaNhap = giaNhap;
        this.soLuong = soLuong;
        this.barCode = barCode;
        this.moTa = moTa;
        this.anh = anh;
        this.trangThai = trangThai;
    }

    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdSP() {
        return idSP;
    }

    public void setIdSP(String idSP) {
        this.idSP = idSP;
    }

    public String getIdSize() {
        return idSize;
    }

    public void setIdSize(String idSize) {
        this.idSize = idSize;
    }

    public String getIdMau() {
        return idMau;
    }

    public void setIdMau(String idMau) {
        this.idMau = idMau;
    }

    public String getIdLoaiSP() {
        return idLoaiSP;
    }

    public void setIdLoaiSP(String idLoaiSP) {
        this.idLoaiSP = idLoaiSP;
    }

    public String getIdChatLieu() {
        return idChatLieu;
    }

    public void setIdChatLieu(String idChatLieu) {
        this.idChatLieu = idChatLieu;
    }

    public String getIdHang() {
        return idHang;
    }

    public void setIdHang(String idHang) {
        this.idHang = idHang;
    }

    public String getIdDE() {
        return idDE;
    }

    public void setIdDE(String idDE) {
        this.idDE = idDE;
    }

    public int getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(int giaBan) {
        this.giaBan = giaBan;
    }

    public int getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(int giaNhap) {
        this.giaNhap = giaNhap;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "ChiTietSPModel{" + "id=" + id + ", idSP=" + idSP + ", idSize=" + idSize + ", idMau=" + idMau + ", idLoaiSP=" + idLoaiSP + ", idChatLieu=" + idChatLieu + ", idHang=" + idHang + ", idDE=" + idDE + ", giaBan=" + giaBan + ", giaNhap=" + giaNhap + ", soLuong=" + soLuong + ", barCode=" + barCode + ", moTa=" + moTa + ", anh=" + anh + ", trangThai=" + trangThai + '}';
    }
}
