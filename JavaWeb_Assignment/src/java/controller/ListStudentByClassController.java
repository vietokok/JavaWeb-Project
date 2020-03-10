package controller;

import dal.ClassDAO;
import dal.StudentDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Student;

/**
 *
 * @author vietvkhe130358
 */
public class ListStudentByClassController extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        if (request.getSession().getAttribute("account") != null) {
            String raw_id = request.getParameter("id");
            if (raw_id == null || raw_id.equals("")) {
                raw_id = "0";
            }
            int id = Integer.parseInt(raw_id);
            if (id != -1) {
                ClassDAO cdao = new ClassDAO();
                request.setAttribute("option3listClass", cdao.getClassroom());
                request.setAttribute("listCreatedStu", "Danh sách học sinh");
                StudentDAO dao = new StudentDAO();
                ArrayList<Student> listS = dao.getStudentByClass(id);
                request.setAttribute("listStudentByCid", listS);
                request.setAttribute("cid", id);
                request.getRequestDispatcher("adminUI.jsp").forward(request, response);
            } else {
                ClassDAO cdao = new ClassDAO();
                request.setAttribute("option3listClass", cdao.getClassroom());
                request.setAttribute("listCreatedStu", "Danh sách học sinh");
                StudentDAO dao = new StudentDAO();
                ArrayList<Student> listS = dao.getStuNotBelongAClass();
                request.setAttribute("listStudentByCid", listS);
                request.setAttribute("cid", id);
                request.getRequestDispatcher("adminUI.jsp").forward(request, response);
            }
        } else {
            response.sendRedirect("login");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
