package DomainModel;

/**
 *
 * @author Enmazr
 */
public class Thongke_Model {
    private String ma;
    private String ten;
    private int soLuong;
    private int TrangThai;
    private int soBan;
    private float gia;
    private float tong = soLuong* gia;

    public Thongke_Model() {
    }

    public Thongke_Model(String ma, String ten, int soLuong, int TrangThai) {
        this.ma = ma;
        this.ten = ten;
        this.soLuong = soLuong;
        this.TrangThai = TrangThai;
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

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

    public int getSoBan() {
        return soBan;
    }

    public void setSoBan(int soBan) {
        this.soBan = soBan;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public float getTong() {
        return tong;
    }

    public void setTong(float tong) {
        this.tong = tong;
    }

    
    

    public String getTT(){
        if (TrangThai == 0) {
            return "Hết";
        }else{
            return "Đang bán";
        }
    }
    
}
