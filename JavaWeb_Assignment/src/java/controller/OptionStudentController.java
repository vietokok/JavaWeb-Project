package controller;

import dal.StudentDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vietvkhe130358
 */
public class OptionStudentController extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getSession().getAttribute("account") != null) {
            String option = request.getParameter("optionStu");
            switch (option) {
                case "1":
                    request.setAttribute("registerNew", "Học sinh mới");
                    request.getRequestDispatcher("adminUI.jsp").forward(request, response);
                    break;
                case "2":
                    StudentDAO db = new StudentDAO();
                    request.setAttribute("listS", db.getStudent());
                    request.setAttribute("registerOld", "Học sinh cũ");
                    request.getRequestDispatcher("adminUI.jsp").forward(request, response);
                    break;
            }
        } else {
            response.sendRedirect("login");
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("searchByName");
        StudentDAO db = new StudentDAO();
        request.setAttribute("listS", db.getStudentByName(name));
        request.setAttribute("registerOld", "Học sinh cũ");
        request.getRequestDispatcher("adminUI.jsp").forward(request, response);
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
