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
    private String NgayTao;
    private String tong;

    public Thongke_Model() {
    }

    public Thongke_Model(String ma, String ten, int soLuong,String NgayTao, int TrangTha, String tong) {
        this.ma = ma;
        this.ten = ten;
        this.soLuong = soLuong;
        this.NgayTao = NgayTao;
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

    public String getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(String NgayTao) {
        this.NgayTao = NgayTao;
    }


    public String getTong() {
        return tong;
    }

    public void setTong(String tong) {
        this.tong = tong;
    }

    
    

    public String getTT(){
        if (TrangThai == 1) {
            return "Đang chờ";
        } else if (TrangThai == 0) {
            return "Đã thanh toán";
        } else if (TrangThai == 2) {
            return "Chờ thanh toán";
        } else if (TrangThai == 3) {
            return "Đã hủy";
        }
        return null;
    }
    
}
