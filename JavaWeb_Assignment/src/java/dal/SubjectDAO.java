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
import model.Subject;

/**
 *
 * @author vietvkhe130358
 */
public class SubjectDAO extends DBContext {

    public ArrayList<Subject> getSubject() {
        ArrayList<Subject> list = new ArrayList<>();
        String sql = "SELECT [id]\n"
                + "      ,[subject_name]\n"
                + "  FROM [dbo].[subject]";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Subject s = new Subject();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("subject_name"));
                list.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static void main(String[] args) {
        SubjectDAO db = new SubjectDAO();
        ArrayList<Subject> list = db.getSubject();
        for (Subject list1 : list) {
            System.out.println(list1.getName());
        }
    }
}
