package controller;

import dal.ClassDAO;
import dal.StudentDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Student;

/**
 *
 * @author vietvkhe130358
 */
public class RegisterOldStudentController extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getSession().getAttribute("account") != null) {
            String raw_id = request.getParameter("id");
            int id = Integer.parseInt(raw_id);
            StudentDAO db = new StudentDAO();
            Student s = db.getStudentById(id);
            ClassDAO classDAO = new ClassDAO();
            request.setAttribute("listClassOld", classDAO.getClassroom());
            request.setAttribute("thisStudent", s);
            request.getRequestDispatcher("adminUI.jsp").forward(request, response);
        } else {
           response.sendRedirect("login");
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String raw_stu_id = request.getParameter("stuId");
        String raw_class_id = request.getParameter("classId");
        int stu_id = Integer.parseInt(raw_stu_id);
        int class_id = Integer.parseInt(raw_class_id);
        StudentDAO db = new StudentDAO();
        db.addStudentInClass(stu_id, class_id);
        Student s = db.getStudentById(stu_id);
        ClassDAO classDAO = new ClassDAO();
        request.setAttribute("listClassOld", classDAO.getClassroom());
        request.setAttribute("thisStudent", s);
        request.getRequestDispatcher("adminUI.jsp").forward(request, response);
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
