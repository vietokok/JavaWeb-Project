/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Center;

/**
 *
 * @author vietvkhe130358
 */
public class CenterDAO extends DBContext {

    public ArrayList<Center> getCenter() {
        ArrayList<Center> list = new ArrayList<>();
        String sql = "SELECT [id]\n"
                + "      ,[center_name]\n"
                + "      ,[center_address]\n"
                + "      ,[phone]\n"
                + "  FROM [dbo].[center]";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Center c = new Center();
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("center_name"));
                c.setAddress(rs.getString("center_address"));
                c.setPhone(rs.getString("phone"));
                list.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CenterDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
