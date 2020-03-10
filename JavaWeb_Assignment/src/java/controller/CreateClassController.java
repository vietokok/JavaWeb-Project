/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.ClassDAO;
import dal.CourseDAO;
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
public class CreateClassController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        if (request.getSession().getAttribute("account") != null) {
            int subject_id = Integer.parseInt(request.getParameter("subject"));
            int category_id = Integer.parseInt(request.getParameter("category"));
            String className = request.getParameter("className");
            Date sdate = Date.valueOf(request.getParameter("sdate"));
            Date edate = Date.valueOf(request.getParameter("edate"));
            String price = (request.getParameter("price") + " " + "vnd");
            int teacher_id = Integer.parseInt(request.getParameter("teacher"));
            CourseDAO dao = new CourseDAO();
            int course_id = dao.getCourseIDbyCateIDandSubjectID(category_id, subject_id);
            int center_id = Integer.parseInt(request.getParameter("center"));
            ClassDAO cdao = new ClassDAO();
            cdao.addClass(className, sdate, edate, price, teacher_id, course_id, center_id);
            ClassDAO classDAO = new ClassDAO();
            request.setAttribute("listClass", classDAO.getClassroom());
            request.setAttribute("content", "Danh sách lớp đã tạo");
            request.getRequestDispatcher("adminUI.jsp").forward(request, response);
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
