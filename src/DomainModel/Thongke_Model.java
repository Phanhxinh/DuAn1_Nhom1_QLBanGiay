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
    private String tong;

    public Thongke_Model() {
    }

    public Thongke_Model(String ma, String ten, int soLuong, int TrangTha, String tong) {
        this.ma = ma;
        this.ten = ten;
        this.soLuong = soLuong;
        this.TrangThai = TrangThai;
        this.tong = tong;
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

    public String getTong() {
        return tong;
    }

    public void setTong(String tong) {
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
