package controller;

import dal.AdminDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;

/**
 *
 * @author vietvkhe130358
 */
public class LoginController extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        AdminDAO dao = new AdminDAO();
        Account a = dao.getAccount();
        if (user.equals(a.getUsername()) && pass.equals(a.getPassword())) {
            a = new Account();
            a.setUsername(user);
            a.setPassword(pass);
            request.getSession().setAttribute("account", a);
            request.setAttribute("welcome", "Xin chào");
            request.getRequestDispatcher("adminUI.jsp").forward(request, response);
        } else {
            request.setAttribute("fail", "Sai tên đăng nhập hoặc mật khẩu");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
