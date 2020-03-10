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
import model.Teacher;

/**
 *
 * @author vietvkhe130358
 */
public class TeacherDAO extends DBContext {

    public ArrayList<Teacher> getTeacher() {
        ArrayList<Teacher> list = new ArrayList<>();
        String sql = "SELECT [id]\n"
                + "      ,[name_name]     \n"
                + "  FROM [dbo].[teacher]";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Teacher t = new Teacher();
                t.setId(rs.getInt("id"));
                t.setName(rs.getString("name_name"));
                list.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TeacherDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
