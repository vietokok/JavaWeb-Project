<%-- 
    Document   : index
    Created on : Oct 15, 2019, 11:23:25 AM
    Author     : vietvkhe130358
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>        
        <link rel="stylesheet" type="text/css" href="framework/bootstrap/css/bootstrap.css">
        <link href="framework/FontAwesome/css/all.css" rel="stylesheet"> 	       
        <%
            String status = (String) request.getAttribute("fail");
        %>
    </head>
    <body style="background-size:100%; background-repeat: no-repeat; background-image: url(bg.jpg);">
        <nav class="navbar navbar-expand-lg navbar-light" style="background-color: #6db60ea6">		
            <div class="container">
                <a class="navbar-brand" style="color: #faf7fd;"><span class="badge badge-light" data-toggle="tooltip" data-spy="scroll" data-target="#my-menu" id="album" style="color: #bf1e2d; font-size: 1.2rem">Phần mềm quản lý dạy học</span></a>	
            </div>					
        </nav>	
        <div style="margin-top: 10rem">
            <form action="login" method="post">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-md-3"></div>
                        <div class="col-md-4"></div>						
                        <div class="col-md-5">                           
                            <div class="form-group" style="width: 50%; margin-left: 5rem">								
                                <div class="form-group">
                                    <label for="exampleInputPassword1">Tài khoản</label>
                                    <input name="user" type="text" class="form-control" placeholder="Username">
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputPassword1">Mật khẩu</label>
                                    <input name="pass" type="password" class="form-control" placeholder="Password">
                                </div>                               
                                <br>
                                <button type="submit" class="btn btn-danger" style="margin-left: 5rem">Đăng nhập</button>
                                <br>                               
                            </div> 
                            <%
                                if (request.getAttribute("fail") != null) {%>
                            <div style="margin-left: 6rem"><%=status%></div>  
                            <%}
                            %>                            
                        </div>											
                    </div>		
                </div>					
            </form>
        </div>	            
        <script src="framework/jquery-3.4.1.min.js"></script>
        <script src="framework/popper.min.js"></script>
        <script src="framework/bootstrap/js/bootstrap.min.js"></script>	
    </body>
</html>
