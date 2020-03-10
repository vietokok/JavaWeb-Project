package controller;

import dal.StudentDAO;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vietvkhe130358
 */
public class EditStudentController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getSession().getAttribute("account") != null) {
            String raw_id = request.getParameter("id");
            int id = Integer.parseInt(raw_id);
            StudentDAO dao = new StudentDAO();
            request.setAttribute("selectedStu", dao.getStudentById(id));
            request.getRequestDispatcher("adminUI.jsp").forward(request, response);
        } else {
            response.sendRedirect("login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        Date date = Date.valueOf(request.getParameter("date"));
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        int id = Integer.parseInt(request.getParameter("id"));
        StudentDAO dao = new StudentDAO();
        dao.updateStuById(name, date, address, phone, id);
        response.sendRedirect("ListStudentByClassController");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
