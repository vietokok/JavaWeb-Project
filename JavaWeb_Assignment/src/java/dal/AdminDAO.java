package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;

/**
 *
 * @author sonnt
 */
public class AdminDAO extends DBContext {

    public Account getAccount() {
        Account a = new Account();
        String sql = "SELECT [username]\n"
                + "      ,[password]\n"
                + "  FROM [dbo].[admintrator]";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                a.setUsername(rs.getString("username"));
                a.setPassword(rs.getString("password"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }
}
