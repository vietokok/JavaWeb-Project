/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.CategoryDAO;
import dal.CenterDAO;
import dal.ClassDAO;
import dal.SubjectDAO;
import dal.TeacherDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vietvkhe130358
 */
public class AdminGUIController extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        if (request.getSession().getAttribute("account") != null) {
            String raw_option = request.getParameter("option");
            int option = Integer.parseInt(raw_option);
            if (option == 1) {
                SubjectDAO dao = new SubjectDAO();
                TeacherDAO db = new TeacherDAO();
                CenterDAO cdao = new CenterDAO();
                CategoryDAO cateDao = new CategoryDAO();
                request.setAttribute("createForm", "Tạo lớp học");
                request.setAttribute("listTeach", db.getTeacher());
                request.setAttribute("listCate", cateDao.getCategory());
                request.setAttribute("listCenter", cdao.getCenter());
                request.setAttribute("listSub", dao.getSubject());
                request.getRequestDispatcher("adminUI.jsp").forward(request, response);
            } else if (option == 2) {
                ClassDAO classDAO = new ClassDAO();
                request.setAttribute("listClass", classDAO.getClassroom());
                request.setAttribute("content", "Danh sách lớp đã tạo");
                request.getRequestDispatcher("adminUI.jsp").forward(request, response);
            } else if (option == 3) {
                response.sendRedirect("ListStudentByClassController");
            } else if (option == 4) {
                request.setAttribute("register", "Đăng kí học");
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
