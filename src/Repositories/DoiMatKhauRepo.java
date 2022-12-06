package Repositories;

import Connections.jdbcUtils;
import DomainModel.DoiMatKhauModel;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.*;

/**
 *
 * @author Enmazr
 */
public class DoiMatKhauRepo {
    public void Update(String Email, DoiMatKhauModel nv ){
        try {
            Connection con = Connections.jdbcUtils.getConnection();
            String sql="update NhanVien set MatKhau  = ?"
                + " where Email =?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(2,nv.getEmail());
            ps.setString(1,nv.getMKmoi());
            ps.executeUpdate();
            
        } catch (Exception ex) {
        }
    }
}
