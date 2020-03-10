package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Student;

/**
 *
 * @author vietvkhe130358
 */
public class StudentDAO extends DBContext {

    public void addStudent(String name, Date dob, String state, String phone) {
        String sql = "INSERT INTO [dbo].[Student]\n"
                + "           ([name]\n"
                + "           ,[dob]\n"
                + "           ,[state]\n"
                + "           ,[phone])\n"
                + "     VALUES\n"
                + "           (?, ?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setDate(2, dob);
            ps.setString(3, state);
            ps.setString(4, phone);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Student getLastStudent() {
        Student s = new Student();
        String sql = "SELECT [id]\n"
                + "      ,[name]\n"
                + "      ,[dob]\n"
                + "      ,[state]\n"
                + "      ,[phone]\n"
                + "  FROM [dbo].[Student]";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setDob(rs.getDate("dob"));
                s.setAddress(rs.getString("state"));
                s.setPhone(rs.getString("phone"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }

    public Student getStudentById(int id) {
        String sql = "SELECT [id]\n"
                + "      ,[name]\n"
                + "      ,[dob]\n"
                + "      ,[state]\n"
                + "      ,[phone]\n"
                + "  FROM [dbo].[Student]\n"
                + "  WHERE [id] = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setDob(rs.getDate("dob"));
                s.setAddress(rs.getString("state"));
                s.setPhone(rs.getString("phone"));
                return s;
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Student> getStudent() {
        ArrayList<Student> list = new ArrayList<>();
        String sql = "SELECT [id]\n"
                + "      ,[name]\n"
                + "      ,[dob]\n"
                + "      ,[state]\n"
                + "      ,[phone]\n"
                + "  FROM [dbo].[Student]";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setDob(rs.getDate("dob"));
                s.setAddress(rs.getString("state"));
                s.setPhone(rs.getString("phone"));
                list.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public ArrayList<Student> getStudentByName(String name) {
        ArrayList<Student> list = new ArrayList<>();
        String sql = "SELECT [id]\n"
                + "      ,[name]\n"
                + "      ,[dob]\n"
                + "      ,[state]\n"
                + "      ,[phone]\n"
                + "  FROM [dbo].[Student]\n"
                + "  WHERE [name] LIKE '%" + name + "%'";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setDob(rs.getDate("dob"));
                s.setAddress(rs.getString("state"));
                s.setPhone(rs.getString("phone"));
                list.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void addStudentInClass(int stu_id, int class_id) {
        String sql = "INSERT INTO [dbo].[class_student]\n"
                + "           ([student_id]\n"
                + "           ,[class_id])\n"
                + "     VALUES\n"
                + "           (?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, stu_id);
            ps.setInt(2, class_id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Student> getStudentByClass(int id) {
        ArrayList<Student> list = new ArrayList<>();
        String sql = "SELECT DISTINCT Student.id, Student.[name], Student.dob, Student.[state], Student.phone\n"
                + "FROM     class INNER JOIN\n"
                + "                  class_student ON class.id = class_student.class_id INNER JOIN\n"
                + "                  Student ON class_student.student_id = Student.id\n";
        if (id != 0) {
            sql += "WHERE class.id = ?";
        }
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            if (id != 0) {
                ps.setInt(1, id);
            }
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setDob(rs.getDate("dob"));
                s.setAddress(rs.getString("state"));
                s.setPhone(rs.getString("phone"));
                list.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void deleteStuInClass_Stu(int sid) {
        String sql = "DELETE FROM [dbo].[class_student]\n"
                + "      WHERE class_student.student_id = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, sid);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteStuInStudent(int sid) {
        String sql = "DELETE FROM [dbo].[Student]\n"
                + "      WHERE Student.id = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, sid);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Student> getStuNotBelongAClass() {
        ArrayList<Student> list = new ArrayList<>();
        String sql = "SELECT Student.id, Student.name, Student.dob, Student.state, Student.phone\n"
                + "FROM     class_student RIGHT JOIN\n"
                + "                  Student ON class_student.student_id = Student.id\n"
                + "				  WHERE class_student.class_id IS NULL";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setDob(rs.getDate("dob"));
                s.setAddress(rs.getString("state"));
                s.setPhone(rs.getString("phone"));
                list.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void updateStuById(String name, Date date, String address, String phone, int id) {
        String sql = "UPDATE [dbo].[Student]\n"
                + "   SET [name] = ?\n"
                + "      ,[dob] = ?\n"
                + "      ,[state] = ?\n"
                + "      ,[phone] = ?\n"
                + " WHERE [Student].id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setDate(2, date);
            ps.setString(3, address);
            ps.setString(4, phone);
            ps.setInt(5, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
