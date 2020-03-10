/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Course;

/**
 *
 * @author vietvkhe130358
 */
public class CourseDAO extends DBContext {

    public int getCourseIDbyCateIDandSubjectID(int cateId, int subjectId) {
        int course_id;
        String sql = "SELECT [id]\n"
                + "    \n"
                + "  FROM [dbo].[course]\n"
                + "  Where category_id = ? AND subject_id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, cateId);
            ps.setInt(2, subjectId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                course_id = rs.getInt("id");
                return course_id;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
}
