package controller;

import dal.ClassDAO;
import dal.StudentDAO;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Student;

/**
 *
 * @author vietvkhe130358
 */
public class StudentController extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        if (request.getSession().getAttribute("account") != null) {
            String name = request.getParameter("name");
            Date date = Date.valueOf(request.getParameter("dob"));
            String address = request.getParameter("address");
            String phone = request.getParameter("phone");
            StudentDAO dao = new StudentDAO();
            ClassDAO classDAO = new ClassDAO();
            dao.addStudent(name, date, address, phone);
            request.setAttribute("namestudent", dao.getLastStudent());
            request.setAttribute("listClassFix", classDAO.getClassroom());
            request.getRequestDispatcher("adminUI.jsp").forward(request, response);
        } else {
           response.sendRedirect("login");
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String raw_class_id = request.getParameter("classId");
        StudentDAO db = new StudentDAO();
        Student s = db.getLastStudent();
        int stu_id = s.getId();
        int class_id = Integer.parseInt(raw_class_id);
        db.addStudentInClass(stu_id, class_id);
        StudentDAO dao = new StudentDAO();
        ClassDAO classDAO = new ClassDAO();
        request.setAttribute("namestudent", dao.getLastStudent());
        request.setAttribute("listClassFix", classDAO.getClassroom());
        request.getRequestDispatcher("adminUI.jsp").forward(request, response);
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
