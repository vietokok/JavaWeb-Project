package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Login</title>        \n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"framework/bootstrap/css/bootstrap.css\">\n");
      out.write("        <link href=\"framework/FontAwesome/css/all.css\" rel=\"stylesheet\"> \t       \n");
      out.write("        ");

            String status = (String) request.getAttribute("fail");
        
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body style=\"background-size:100%; background-repeat: no-repeat; background-image: url(bg.jpg);\">\n");
      out.write("        <nav class=\"navbar navbar-expand-lg navbar-light\" style=\"background-color: #6db60ea6\">\t\t\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <a class=\"navbar-brand\" style=\"color: #faf7fd;\"><span class=\"badge badge-light\" data-toggle=\"tooltip\" data-spy=\"scroll\" data-target=\"#my-menu\" id=\"album\" style=\"color: #bf1e2d; font-size: 1.2rem\">Phần mềm quản lý dạy học</span></a>\t\n");
      out.write("            </div>\t\t\t\t\t\n");
      out.write("        </nav>\t\n");
      out.write("        <div style=\"margin-top: 10rem\">\n");
      out.write("            <form action=\"login\" method=\"post\">\n");
      out.write("                <div class=\"container-fluid\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-md-3\"></div>\n");
      out.write("                        <div class=\"col-md-4\"></div>\t\t\t\t\t\t\n");
      out.write("                        <div class=\"col-md-5\">                           \n");
      out.write("                            <div class=\"form-group\" style=\"width: 50%; margin-left: 5rem\">\t\t\t\t\t\t\t\t\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <label for=\"exampleInputPassword1\">Tài khoản</label>\n");
      out.write("                                    <input name=\"user\" type=\"text\" class=\"form-control\" placeholder=\"Username\">\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <label for=\"exampleInputPassword1\">Mật khẩu</label>\n");
      out.write("                                    <input name=\"pass\" type=\"password\" class=\"form-control\" placeholder=\"Password\">\n");
      out.write("                                </div>                               \n");
      out.write("                                <br>\n");
      out.write("                                <button type=\"submit\" class=\"btn btn-danger\" style=\"margin-left: 5rem\">Đăng nhập</button>\n");
      out.write("                                <br>                               \n");
      out.write("                            </div> \n");
      out.write("                            ");

                                if (request.getAttribute("fail") != null) {
      out.write("\n");
      out.write("                            <div style=\"margin-left: 6rem\">");
      out.print(status);
      out.write("</div>  \n");
      out.write("                            ");
}
                            
      out.write("                            \n");
      out.write("                        </div>\t\t\t\t\t\t\t\t\t\t\t\n");
      out.write("                    </div>\t\t\n");
      out.write("                </div>\t\t\t\t\t\n");
      out.write("            </form>\n");
      out.write("        </div>\t            \n");
      out.write("        <script src=\"framework/jquery-3.4.1.min.js\"></script>\n");
      out.write("        <script src=\"framework/popper.min.js\"></script>\n");
      out.write("        <script src=\"framework/bootstrap/js/bootstrap.min.js\"></script>\t\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
