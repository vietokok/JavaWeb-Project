package controller;

import dal.CategoryDAO;
import dal.CenterDAO;
import dal.ClassDAO;
import dal.CourseDAO;
import dal.SubjectDAO;
import dal.TeacherDAO;
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
public class EditClassController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        if (request.getSession().getAttribute("account") != null) {
            String raw_id = request.getParameter("id");
            int id = Integer.parseInt(raw_id);
            ClassDAO dao = new ClassDAO();
            request.setAttribute("edit", dao.getClassroombyId(id));
            SubjectDAO sdao = new SubjectDAO();
            TeacherDAO db = new TeacherDAO();
            CenterDAO cdao = new CenterDAO();
            CategoryDAO cateDao = new CategoryDAO();
            request.setAttribute("listTeach", db.getTeacher());
            request.setAttribute("listCate", cateDao.getCategory());
            request.setAttribute("listCenter", cdao.getCenter());
            request.setAttribute("listSub", sdao.getSubject());
            request.getRequestDispatcher("adminUI.jsp").forward(request, response);
        } else {
            response.sendRedirect("login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
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
        int id = Integer.parseInt(request.getParameter("id"));
        ClassDAO cdao = new ClassDAO();
        cdao.updateClass(className, sdate, edate, price, teacher_id, course_id, center_id, id);
        request.setAttribute("listClass", cdao.getClassroom());
        request.setAttribute("content", "Danh sách lớp đã tạo");
        request.setAttribute("success", "Sửa dữ liệu thành công");
        request.getRequestDispatcher("adminUI.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
