package DomainModel;

/**
 *
 * @author Enmazr
 */
public class DoiMatKhauModel {
    private String email;
    private String mk;
    private String MKmoi;
    private String XNMKmoi;

    public DoiMatKhauModel() {
    }

    public DoiMatKhauModel(String email, String mk, String MKmoi, String XNMKmoi) {
        this.email = email;
        this.mk = mk;
        this.MKmoi = MKmoi;
        this.XNMKmoi = XNMKmoi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMk() {
        return mk;
    }

    public void setMk(String mk) {
        this.mk = mk;
    }

    public String getMKmoi() {
        return MKmoi;
    }

    public void setMKmoi(String MKmoi) {
        this.MKmoi = MKmoi;
    }

    public String getXNMKmoi() {
        return XNMKmoi;
    }

    public void setXNMKmoi(String XNMKmoi) {
        this.XNMKmoi = XNMKmoi;
    }
    
    
}
