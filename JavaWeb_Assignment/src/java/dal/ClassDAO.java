/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Category;
import model.Center;
import model.Classroom;
import model.Course;
import model.Subject;
import model.Teacher;

/**
 *
 * @author vietvkhe130358
 */
public class ClassDAO extends DBContext {

    public void addClass(String className, Date sdate, Date edate, String price, int teacher_id, int course_id, int center_id) {
        String sql = "INSERT INTO [dbo].[class]\n"
                + "           ([class_name]\n"
                + "           ,[start_date]\n"
                + "           ,[end_date]\n"
                + "           ,[price]\n"
                + "           ,[teacher_id]\n"
                + "           ,[course_id]\n"
                + "           ,[center_id])\n"
                + "     VALUES\n"
                + "           (?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setNString(1, className);
            ps.setDate(2, sdate);
            ps.setDate(3, edate);
            ps.setString(4, price);
            ps.setInt(5, teacher_id);
            ps.setInt(6, course_id);
            ps.setInt(7, center_id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClassDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Classroom> getClassroom() {
        ArrayList<Classroom> list = new ArrayList<>();
        String sql = "SELECT class.id AS class_id, class.class_name, class.start_date, class.end_date, class.price, class.teacher_id, class.course_id, class.center_id, teacher.name_name, teacher.id, subject.subject_name, category.category_name, center.id AS Expr3, center.center_name, \n"
                + "                  center.center_address, center.phone, course.id AS Expr4, course.subject_id, course.category_id, course.lesson, course.description_course, course.term\n"
                + "FROM     class INNER JOIN\n"
                + "                  center ON class.center_id = center.id INNER JOIN\n"
                + "                  course ON class.course_id = course.id INNER JOIN\n"
                + "                  [subject] ON class.course_id = course.id AND course.subject_id = [subject].id INNER JOIN\n"
                + "                  category ON class.course_id = course.id AND course.category_id = category.id INNER JOIN\n"
                + "                  teacher ON class.teacher_id = teacher.id";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Classroom cr = new Classroom();
                cr.setId(rs.getInt("class_id"));
                cr.setName(rs.getString("class_name"));
                cr.setStart_date(rs.getDate("start_date"));
                cr.setEnd_date(rs.getDate("end_date"));
                cr.setPrice(rs.getString("price"));
                Teacher t = new Teacher();
                t.setId(rs.getInt("teacher_id"));
                t.setName(rs.getString("name_name"));
                Category c = new Category();
                c.setId(rs.getInt("category_id"));
                c.setName(rs.getString("category_name"));
                Subject s = new Subject();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("subject_name"));
                Course course = new Course();
                course.setId(rs.getInt("Expr4"));
                course.getListCate().add(c);
                course.getListSub().add(s);
                course.setLesson(rs.getString("lesson"));
                course.setDescription(rs.getString("description_course"));
                course.setTerm(rs.getString("term"));
                Center cen = new Center();
                cen.setId(rs.getInt("Expr3"));
                cen.setName(rs.getString("center_name"));
                cen.setAddress(rs.getString("center_address"));
                cen.setPhone(rs.getString("phone"));
                cr.getListCourse().add(course);
                cr.getListTeach().add(t);
                cr.getListCenter().add(cen);
                list.add(cr);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TeacherDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public ArrayList<Classroom> getClassroombyId(int id) {
        ArrayList<Classroom> list = new ArrayList<>();
        String sql = "SELECT class.id AS class_id, class.class_name, class.start_date, class.end_date, class.price, class.teacher_id, class.course_id, class.center_id, teacher.name_name, teacher.id, subject.subject_name, category.category_name, center.id AS Expr3, center.center_name,\n"
                + "                 center.center_address, center.phone, course.id AS Expr4, course.subject_id, course.category_id, course.lesson, course.description_course, course.term\n"
                + "                FROM     class INNER JOIN\n"
                + "                          center ON class.center_id = center.id INNER JOIN\n"
                + "                             course ON class.course_id = course.id INNER JOIN\n"
                + "                              [subject] ON class.course_id = course.id AND course.subject_id = [subject].id INNER JOIN\n"
                + "                               category ON class.course_id = course.id AND course.category_id = category.id INNER JOIN\n"
                + "                               teacher ON class.teacher_id = teacher.id\n"
                + "							   Where class.id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Classroom cr = new Classroom();
                cr.setId(rs.getInt("class_id"));
                cr.setName(rs.getString("class_name"));
                cr.setStart_date(rs.getDate("start_date"));
                cr.setEnd_date(rs.getDate("end_date"));
                cr.setPrice(rs.getString("price"));
                Teacher t = new Teacher();
                t.setId(rs.getInt("teacher_id"));
                t.setName(rs.getString("name_name"));
                Category c = new Category();
                c.setId(rs.getInt("category_id"));
                c.setName(rs.getString("category_name"));
                Subject s = new Subject();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("subject_name"));
                Course course = new Course();
                course.setId(rs.getInt("Expr4"));
                course.getListCate().add(c);
                course.getListSub().add(s);
                course.setLesson(rs.getString("lesson"));
                course.setDescription(rs.getString("description_course"));
                course.setTerm(rs.getString("term"));
                Center cen = new Center();
                cen.setId(rs.getInt("Expr3"));
                cen.setName(rs.getString("center_name"));
                cen.setAddress(rs.getString("center_address"));
                cen.setPhone(rs.getString("phone"));
                cr.getListCourse().add(course);
                cr.getListTeach().add(t);
                cr.getListCenter().add(cen);
                list.add(cr);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TeacherDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void updateClass(String className, Date sdate, Date edate, String price, int teacher_id, int course_id, int center_id, int id) {
        String sql = "UPDATE [dbo].[class]\n"
                + "   SET [class_name] = ?\n"
                + "      ,[start_date] = ?\n"
                + "      ,[end_date] = ?\n"
                + "      ,[price] = ?\n"
                + "      ,[teacher_id] = ?\n"
                + "      ,[course_id] = ?\n"
                + "      ,[center_id] = ?\n"
                + " WHERE class.id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setNString(1, className);
            ps.setDate(2, sdate);
            ps.setDate(3, edate);
            ps.setString(4, price);
            ps.setInt(5, teacher_id);
            ps.setInt(6, course_id);
            ps.setInt(7, center_id);
            ps.setInt(8, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClassDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteClass(int id) {
        String sql = "DELETE FROM [dbo].[class]\n"
                + "      WHERE class.id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClassDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int countStuInClass(int cid) {
        int count = 0;
        String sql = "SELECT COUNT (student_id) as countStu\n"
                + "FROM     class_student\n"
                + "WHERE class_student.class_id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, cid);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt("countStu");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClassDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }

    public static void main(String[] args) {
        ClassDAO dao = new ClassDAO();
        int count = dao.countStuInClass(17);
        System.out.println(count);
    }
}
