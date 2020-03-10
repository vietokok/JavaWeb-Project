<%-- 
    Document   : adminUI
    Created on : Oct 16, 2019, 10:53:39 AM
    Author     : vietvkhe130358
--%>

<%@page import="model.Student"%>
<%@page import="model.Classroom"%>
<%@page import="model.Category"%>
<%@page import="model.Center"%>
<%@page import="model.Teacher"%>
<%@page import="model.Subject"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Teaching Management</title>
        <link href="style.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" type="text/css" href="framework/bootstrap/css/bootstrap.css">
        <link href="framework/FontAwesome/css/all.css" rel="stylesheet"> 
        <%
            String option = (String) request.getAttribute("createForm");
        %>
    </head>
    <body>
        <!--nav-horizon-->
        <nav class="navbar navbar-dark fixed-top bg-dark flex-md-nowrap p-0 shadow">
            <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="#">Quản lý dạy học</a>
            <a class="mr-4" href="logout" style="color: white">Đăng xuất</a>
        </nav>
        <!--end nav-horizon-->
        <div class="container-fluid">
            <div class="row">   
                <!--nav-vertical-->
                <nav class="col-md-2 d-none d-md-block bg-light sidebar">
                    <div class="sidebar-sticky">
                        <h6 class="sidebar-heading d-flex align-items-center px-3 mb-3 text-muted">
                            <i class="fas fa-home mr-1"></i>
                            <span>Tác vụ</span>				
                        </h6>
                        <ul class="nav flex-column">				
                            <li class="nav-item">
                                <form id="frm" action="admin" method="post">
                                    <input type="hidden" value="1" name="option">                   
                                    <i class="far fa-calendar-plus text-muted"></i>
                                    <div class="btn btn-outline-dark" onclick="document.getElementById('frm').submit();">Tạo lớp học</div>                            
                                </form>

                            </li>
                            <li class="nav-item mt-2">
                                <form id="frm1" action="admin" method="post">
                                    <input type="hidden" value="2" name="option">                   
                                    <i class="fas fa-align-center text-muted"></i>
                                    <div class="btn btn-outline-dark" onclick="document.getElementById('frm1').submit();">Danh sách lớp đã tạo</div>                            
                                </form>                       
                            </li>
                            <li class="nav-item mt-2">
                                <form id="frm2" action="admin" method="post">
                                    <input type="hidden" value="3" name="option">                   
                                    <i class="far fa-user text-muted"></i>
                                    <div class="btn btn-outline-dark" onclick="document.getElementById('frm2').submit();">Danh sách học sinh</div>                            
                                </form>                       
                            </li>             
                            <li class="nav-item mt-2">   
                                <form id="frm4" action="admin" method="post">
                                    <input type="hidden" value="4" name="option">                   
                                    <i class="far fa-plus-square text-muted"></i>
                                    <div class="btn btn-outline-dark" onclick="document.getElementById('frm4').submit();">Đăng ký học</div>                            
                                </form>        
                            </li>
                        </ul>              
                    </div>
                </nav>
                <!--end nav-vertical-->
                <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4"><div class="chartjs-size-monitor" style="position: absolute; left: 0px; top: 0px; right: 0px; bottom: 0px; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;"><div class="chartjs-size-monitor-expand" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:1000000px;height:1000000px;left:0;top:0"></div></div><div class="chartjs-size-monitor-shrink" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:200%;height:200%;left:0; top:0"></div></div></div>
                            <%if (request.getAttribute("welcome") != null) {%>                            
                            <%String first = (String) request.getAttribute("welcome");%>
                    <div class="d-flex justify-content-center flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                        <h1 style="font-size: 5rem"><%=first%></h1>
                    </div>
                    <!--create new class-->        
                    <%} else if (request.getAttribute("createForm") != null) {%>
                    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                        <h1 class="h2"><%=option%></h1>
                    </div>
                    <div class="mt-5">
                        <form action="createClass" method="post">
                            <div class="container">						
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <% ArrayList<Subject> list = (ArrayList<Subject>) request.getAttribute("listSub");%>
                                            <label>Môn Học</label>
                                            <select class="form-control" name="subject">
                                                <%for (Subject s : list) {%>
                                                <option value="<%=s.getId()%>"><%=s.getName()%></option>
                                                <%}%>                                                                                    
                                            </select>						
                                        </div>
                                    </div>							
                                </div>
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label>Tên lớp học</label>
                                            <input type="text" class="form-control" placeholder="Class name" name="className" required>						
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <% ArrayList<Category> listCate = (ArrayList<Category>) request.getAttribute("listCate");%>
                                            <label>Lớp</label>
                                            <select class="form-control" name="category">
                                                <%for (Category c : listCate) {%>
                                                <option value="<%=c.getId()%>"><%=c.getName()%></option>
                                                <%}%>                                                                                    
                                            </select>						
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label>Ngày bắt đầu</label>
                                            <input type="date" class="form-control" placeholder="Start Date" name="sdate" required>						
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label>Ngày kết thúc</label>
                                            <input type="date" class="form-control" placeholder="End date" name="edate" required>	
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <% ArrayList<Teacher> listTeach = (ArrayList<Teacher>) request.getAttribute("listTeach");%>
                                            <label>Giáo viên</label>
                                            <select class="form-control" name="teacher">
                                                <%for (Teacher t : listTeach) {%>
                                                <option value="<%=t.getId()%>"><%=t.getName()%></option>
                                                <%}%>                                                                                    
                                            </select>							
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <% ArrayList<Center> listCenter = (ArrayList<Center>) request.getAttribute("listCenter");%>
                                            <label>Trung tâm</label>
                                            <select class="form-control" name="center">
                                                <%for (Center c : listCenter) {%>
                                                <option value="<%=c.getId()%>"><%=c.getName()%></option>
                                                <%}%>                                                                                    
                                            </select>	
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="form-group">                                            
                                            <label>Giá lớp học</label> 
                                            <input type="number" class="form-control" placeholder="Price" name="price" required>                                            
                                        </div>
                                    </div>							
                                </div>
                                <div class="row">
                                    <div class="col-md-12 mt-3">
                                        <button type="submit" class="btn btn-success" style="margin-left: 32rem;">Tạo</button>
                                    </div>							
                                </div>
                            </div>					
                        </form>
                    </div>
                    <!--end create new class-->
                    <!--list created class-->
                    <%} else if (request.getAttribute("listClass") != null) {%>
                    <%ArrayList<Classroom> list = (ArrayList<Classroom>) request.getAttribute("listClass");%>
                    <%String option1 = (String) request.getAttribute("content");%>
                    <%int id = 0;%>
                    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                        <h1 class="h2"><%=option1%></h1>
                    </div>                                       
                    <div class="table-responsive">
                        <table class="table table-striped table-sm table-hover">
                            <thead>
                                <tr>
                                    <th>STT</th>
                                    <th>Tên lớp</th>
                                    <th>Ngày bắt đầu</th>
                                    <th>Ngày kết thúc</th>
                                    <th>Môn học</th>
                                    <th>Lớp</th>
                                    <th>Giáo viên</th>
                                    <th>Giá lớp học</th>
                                    <th>Trung tâm</th>
                                    <th></th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <%for (Classroom c : list) {
                                %>
                                <tr>
                                    <td><%=++id%></td>
                                    <td><%=c.getName()%></td>
                                    <td><%=c.getStart_date()%></td>
                                    <td><%=c.getEnd_date()%></td>
                                    <td><%=c.getListCourse().get(0).getListSub().get(0).getName()%></td>
                                    <td><%=c.getListCourse().get(0).getListCate().get(0).getName()%></td>
                                    <td><%=c.getListTeach().get(0).getName()%></td>
                                    <td><%=c.getPrice()%></td>
                                    <td><%=c.getListCenter().get(0).getName()%></td>
                                    <td><form action="edit" method="get">
                                            <input type="hidden" value="<%=c.getId()%>" name="id">
                                            <input class="btn btn-outline-dark" type="submit" value="Sửa">
                                        </form></td>
                                    <td><form id="<%=c.getId()%>" action="deleteClass" method="post">
                                            <input type="hidden" value="<%=c.getId()%>" name="id">                                            
                                        </form>
                                        <button class="btn btn-outline-dark" onclick="checkDelete(<%=c.getId()%>);">Xóa</button></td>
                                </tr>
                                <%}%>
                            </tbody>
                        </table>
                    </div> 
                    <!--end list created class-->
                    <%} else if (request.getAttribute("existStu") != null) {%>                    
                    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                        <h1 class="h2">Lớp có học sinh, không thể xóa</h1>
                    </div>      
                    <!--edit selected class-->
                    <%} else if (request.getAttribute("edit") != null) {%>
                    <%int id = 0;%>
                    <%ArrayList<Classroom> listEdit = (ArrayList<Classroom>) request.getAttribute("edit");%>                        
                    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                        <h1 class="h2">Sửa</h1>
                    </div>                                       
                    <div class="table-responsive">
                        <table class="table table-striped table-sm table-hover">
                            <thead>
                                <tr>
                                    <th>STT</th>
                                    <th>Tên lớp</th>
                                    <th>Ngày bắt đầu</th>
                                    <th>Ngày kết thúc</th>
                                    <th>Môn học</th>
                                    <th>Lớp</th>
                                    <th>Giáo viên</th>
                                    <th>Giá lớp học</th>
                                    <th>Trung tâm</th>                                       
                                </tr>
                            </thead>
                            <tbody>

                                <%for (Classroom c : listEdit) {
                                %>
                                <tr>
                                    <td><%=++id%></td>
                                    <td><%=c.getName()%></td>
                                    <td><%=c.getStart_date()%></td>
                                    <td><%=c.getEnd_date()%></td>
                                    <td><%=c.getListCourse().get(0).getListSub().get(0).getName()%></td>
                                    <td><%=c.getListCourse().get(0).getListCate().get(0).getName()%></td>
                                    <td><%=c.getListTeach().get(0).getName()%></td>
                                    <td><%=c.getPrice()%></td>
                                    <td><%=c.getListCenter().get(0).getName()%></td>                                        
                                </tr>
                                <%}%>
                            </tbody>
                        </table>
                    </div>                            
                    <div class="mt-1">
                        <form action="edit" method="post">                            
                            <div class="container">						
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <% ArrayList<Subject> list = (ArrayList<Subject>) request.getAttribute("listSub");%>
                                            <label>Môn Học</label>
                                            <select class="form-control" name="subject">
                                                <%for (Subject s : list) {%>
                                                <option value="<%=s.getId()%>"><%=s.getName()%></option>
                                                <%}%>                                                                                    
                                            </select>						
                                        </div>
                                    </div>							
                                </div>
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label>Tên lớp học</label>
                                            <input type="text" class="form-control" placeholder="Class name" name="className" required>						
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <% ArrayList<Category> listCate = (ArrayList<Category>) request.getAttribute("listCate");%>
                                            <label>Lớp</label>
                                            <select class="form-control" name="category">
                                                <%for (Category c : listCate) {%>
                                                <option value="<%=c.getId()%>"><%=c.getName()%></option>
                                                <%}%>                                                                                    
                                            </select>						
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label>Ngày bắt đầu</label>
                                            <input type="date" class="form-control" placeholder="Start date" name="sdate" required>						
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label>Ngày kết thúc</label>
                                            <input type="date" class="form-control" placeholder="End date" name="edate" required>	
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <% ArrayList<Teacher> listTeach = (ArrayList<Teacher>) request.getAttribute("listTeach");%>
                                            <label>Giáo viên</label>
                                            <select class="form-control" name="teacher">
                                                <%for (Teacher t : listTeach) {%>
                                                <option value="<%=t.getId()%>"><%=t.getName()%></option>
                                                <%}%>                                                                                    
                                            </select>							
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <% ArrayList<Center> listCenter = (ArrayList<Center>) request.getAttribute("listCenter");%>
                                            <label>Trung tâm</label>
                                            <select class="form-control" name="center">
                                                <%for (Center c : listCenter) {%>
                                                <option value="<%=c.getId()%>"><%=c.getName()%></option>
                                                <%}%>                                                                                    
                                            </select>	
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="form-group">                                            
                                            <label>Giá lớp học</label> 
                                            <input type="number" class="form-control" placeholder="Price" name="price" required>                                            
                                        </div>
                                    </div>							
                                </div>
                                <input type="hidden" value="<%=listEdit.get(0).getId()%>" name="id">
                                <div class="row">
                                    <div class="col-md-12 mt-3">
                                        <button type="submit" class="btn btn-warning" style="margin-left: 32rem;">Sửa</button>
                                    </div>							
                                </div>
                            </div>					
                        </form>
                    </div>
                    <!--end edit selected class-->
                    <!--student register-->
                    <%} else if (request.getAttribute("register") != null) {%>
                    <%String option3 = (String) request.getAttribute("register");%>
                    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                        <h1 class="h2"><%=option3%></h1>
                    </div>
                    <div class="mt-5">
                        <div class="container">
                            <div class="row">
                                <div class="col-md-6">                                    
                                    <form id="newStudent" action="OptionStudentController" method="get">
                                        <input type="hidden" name="optionStu" value="1">
                                        <div class="btn btn-info" style="font-size: 1.8rem; margin-left: 50%" onclick="document.getElementById('newStudent').submit();">Học sinh mới</div>
                                    </form>                                    
                                </div>
                                <div class="col-md-6">
                                    <form id="oldStudent" action="OptionStudentController" method="get">
                                        <input type="hidden" name="optionStu" value="2">
                                        <div class="btn btn-success" style="font-size: 1.8rem" onclick="document.getElementById('oldStudent').submit();">Học Sinh Cũ</div>
                                    </form>
                                </div>
                            </div>
                        </div>                 
                    </div>     
                    <!--student register-->
                    <!--new student register-->
                    <%} else if (request.getAttribute("registerNew") != null) {%>
                    <%String newStu = (String) request.getAttribute("registerNew");%>
                    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                        <h1 class="h2"><%=newStu%></h1>
                    </div>
                    <div class="mt-5">
                        <form action="student" method="get">
                            <div class="container">		
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label>Tên của bé</label>
                                            <input type="text" class="form-control" placeholder="Your name" name="name" required>						
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label>Ngày sinh</label>
                                            <input type="date" class="form-control" placeholder="Date of birth" name="dob" required>						
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label>Địa chỉ</label>
                                            <input type="text" class="form-control" placeholder="address" name="address" required>						
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label>Số điện thoại</label>
                                            <input type="number" class="form-control" placeholder="Phone" name="phone" required>	
                                        </div>
                                    </div>
                                </div>                              
                                <div class="row">
                                    <div class="col-md-12 mt-3">
                                        <button type="submit" class="btn btn-success" style="margin-left: 33rem;">Tạo</button>
                                    </div>							
                                </div>
                            </div>					
                        </form>
                    </div>
                    <!--end new student register-->
                    <!--old student register-->
                    <%} else if (request.getAttribute("registerOld") != null) {%>
                    <%String oldStu = (String) request.getAttribute("registerOld");%>
                    <%ArrayList<Student> listS = (ArrayList<Student>) request.getAttribute("listS");%>
                    <%int id = 0;%>
                    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                        <h1 class="h2"><%=oldStu%></h1>
                    </div>
                    <div class="mt-2 mb-2">
                        <form id="searchName" action="OptionStudentController" method="post">
                            Tên học sinh: <input type="text" name="searchByName" style="height: 2.2rem">
                            <input type="submit" value="Tìm kiếm">
                        </form>
                    </div>                   
                    <div class="table-responsive">
                        <table class="table table-striped table-sm table-hover">
                            <thead>
                                <tr>
                                    <th>STT</th>
                                    <th>Họ và tên</th>
                                    <th>Ngày sinh</th>
                                    <th>Địa chỉ</th>
                                    <th>Số điện thoại</th>   
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>

                                <%for (Student s : listS) {
                                %>
                                <tr>
                                    <td><%=++id%></td>
                                    <td><%=s.getName()%></td>
                                    <td><%=s.getDob()%></td>
                                    <td><%=s.getAddress()%></td>
                                    <td><%=s.getPhone()%></td>   
                                    <td><form action="RegisterOldStudent" method="get">
                                            <input type="hidden" value="<%=s.getId()%>" name="id">  
                                            <button type="submit" class="btn btn-outline-success">Đăng ký thêm</button>
                                        </form></td>                                            
                                </tr>
                                <%}%>
                            </tbody>
                        </table>
                    </div>          
                    <!--end old student register-->
                    <!--list class-old student register-->
                    <%} else if (request.getAttribute("thisStudent") != null) {
                    %>
                    <%Student s = (Student) request.getAttribute("thisStudent");%>
                    <%ArrayList<Classroom> listC = (ArrayList<Classroom>) request.getAttribute("listClassOld");%>
                    <%int id = 0;%>
                    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                        <h1 class="h2"><%=s.getName()%></h1>
                    </div>
                    <div class="table-responsive">
                        <table class="table table-striped table-sm table-hover">
                            <thead>
                                <tr>
                                    <th>STT</th>
                                    <th>Tên lớp</th>
                                    <th>Ngày bắt đầu</th>
                                    <th>Ngày kết thúc</th>
                                    <th>Môn học</th>
                                    <th>Lớp</th>
                                    <th>Giáo viên</th>
                                    <th>Giá lớp học</th>
                                    <th>Trung tâm</th>
                                    <th></th>                                    
                                </tr>
                            </thead>
                            <tbody>
                                <%for (Classroom c : listC) {
                                %>
                                <tr>
                                    <td><%=++id%></td>
                                    <td><%=c.getName()%></td>
                                    <td><%=c.getStart_date()%></td>
                                    <td><%=c.getEnd_date()%></td>
                                    <td><%=c.getListCourse().get(0).getListSub().get(0).getName()%></td>
                                    <td><%=c.getListCourse().get(0).getListCate().get(0).getName()%></td>
                                    <td><%=c.getListTeach().get(0).getName()%></td>
                                    <td><%=c.getPrice()%></td>
                                    <td><%=c.getListCenter().get(0).getName()%></td>
                                    <td><form action="RegisterOldStudent" method="post">
                                            <input type="hidden" value="<%=c.getId()%>" name="classId">
                                            <input type="hidden" value="<%=s.getId()%>" name="stuId">
                                            <input class="btn btn-outline-dark" type="submit" value="Đăng ký" onclick="alert('Đăng ký thành công');">
                                        </form></td>                                   
                                </tr>
                                <%}%>
                            </tbody>
                        </table>
                    </div>
                    <!--end list class-old student register-->
                    <!--list class-new student register-->
                    <%} else if (request.getAttribute("namestudent") != null) {
                    %>
                    <%Student s = (Student) request.getAttribute("namestudent");%>
                    <%ArrayList<Classroom> listC = (ArrayList<Classroom>) request.getAttribute("listClassFix");%>
                    <%int id = 0;%>
                    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                        <h1 class="h2"><%=s.getName()%></h1>
                    </div>
                    <div class="table-responsive">
                        <table class="table table-striped table-sm table-hover">
                            <thead>
                                <tr>
                                    <th>STT</th>
                                    <th>Tên lớp</th>
                                    <th>Ngày bắt đầu</th>
                                    <th>Ngày kết thúc</th>
                                    <th>Môn học</th>
                                    <th>Lớp</th>
                                    <th>Giáo viên</th>
                                    <th>Giá lớp học</th>
                                    <th>Trung tâm</th>
                                    <th></th>                                    
                                </tr>
                            </thead>
                            <tbody>
                                <%for (Classroom c : listC) {
                                %>
                                <tr>
                                    <td><%=++id%></td>
                                    <td><%=c.getName()%></td>
                                    <td><%=c.getStart_date()%></td>
                                    <td><%=c.getEnd_date()%></td>
                                    <td><%=c.getListCourse().get(0).getListSub().get(0).getName()%></td>
                                    <td><%=c.getListCourse().get(0).getListCate().get(0).getName()%></td>
                                    <td><%=c.getListTeach().get(0).getName()%></td>
                                    <td><%=c.getPrice()%></td>
                                    <td><%=c.getListCenter().get(0).getName()%></td>
                                    <td><form action="student" method="post">
                                            <input type="hidden" value="<%=c.getId()%>" name="classId">
                                            <input class="btn btn-outline-dark" type="submit" value="Đăng ký" onclick="alert('Đăng ký thành công');">
                                        </form></td>                                   
                                </tr>
                                <%}%>
                            </tbody>
                        </table>
                    </div>
                    <!--end list class-new student register-->
                    <!--list student by class id-->
                    <%} else if (request.getAttribute("listCreatedStu") != null) {
                    %>
                    <%String s = (String) request.getAttribute("listCreatedStu");%>
                    <%ArrayList<Classroom> listC = (ArrayList<Classroom>) request.getAttribute("option3listClass");%>
                    <%ArrayList<Student> listS = (ArrayList<Student>) request.getAttribute("listStudentByCid");%>                            
                    <%Integer cid = (Integer) request.getAttribute("cid");%>
                    <%int id = 0;%>
                    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                        <h1 class="h2"><%=s%></h1>
                    </div>
                    <div class="mt-2 mb-2">
                        <form action="ListStudentByClassController" method="post" id="frmName">
                            <select name="id" onchange="document.getElementById('frmName').submit();">
                                <option <%=(0 == cid) ? "selected" : ""%> value="0">Tất cả</option>
                                <option <%=(cid == -1) ? "selected" : ""%> value="-1">Chưa thuộc lớp nào</option>
                                <%for (Classroom c : listC) {
                                %>                        
                                <option <%=(c.getId() == cid) ? "selected" : ""%> value="<%=c.getId()%>"><%=c.getName()%></option>
                                <%}%>                                
                            </select>
                        </form>                     
                    </div>  
                    <div class="table-responsive">
                        <table class="table table-striped table-sm table-hover">
                            <thead>
                                <tr>
                                    <th>STT</th>
                                    <th>Họ và tên</th>
                                    <th>Ngày sinh</th>
                                    <th>Địa chỉ</th>
                                    <th>Số điện thoại</th>   
                                    <th></th>                                    
                                    <th></th>                                    
                                </tr>
                            </thead>
                            <tbody>
                                <%for (Student student : listS) {
                                %>
                                <tr>
                                    <td><%=++id%></td>
                                    <td><%=student.getName()%></td>
                                    <td><%=student.getDob()%></td>
                                    <td><%=student.getAddress()%></td>
                                    <td><%=student.getPhone()%></td>   
                                    <td><form action="EditStudentController" method="get">
                                            <input type="hidden" value="<%=student.getId()%>" name="id">
                                            <input class="btn btn-outline-dark" type="submit" value="Sửa">
                                        </form></td>
                                    <td><form id="<%=student.getId()%>" action="DeleteStudentController" method="post">
                                            <input type="hidden" value="<%=student.getId()%>" name="id">                                            
                                        </form>
                                        <button class="btn btn-outline-dark" onclick="checkDelete(<%=student.getId()%>);">Xóa</button></td>
                                </tr>
                                <%}%>
                            </tbody>
                        </table>
                    </div>
                    <!--end list student by class id-->
                    <!--edit student-->
                    <%} else if (request.getAttribute("selectedStu") != null) {
                    %>
                    <%Student student = (Student) request.getAttribute("selectedStu");%>                    
                    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                        <h1 class="h2">Sửa</h1>
                    </div>                                       
                    <div class="table-responsive">
                        <table class="table table-striped table-sm table-hover">
                            <thead>
                                <tr>
                                    <th>STT</th>
                                    <th>Tên</th>
                                    <th>Ngày sinh</th>
                                    <th>Địa chỉ</th>
                                    <th>Số điện thoại</th>                                                                         
                                </tr>
                            </thead>
                            <tbody>                               
                                <tr>
                                    <td>1</td>
                                    <td><%=student.getName()%></td>
                                    <td><%=student.getDob()%></td>
                                    <td><%=student.getAddress()%></td>
                                    <td><%=student.getPhone()%></td>                                                                           
                                </tr>                                
                            </tbody>
                        </table>
                    </div>                            
                    <div class="mt-1">
                        <form action="EditStudentController" method="post">                            
                            <div class="container">	
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label>Tên học sinh</label>
                                            <input type="text" class="form-control" placeholder="Name" name="name" required>						
                                        </div>
                                    </div>
                                    <div class="col-md-6">                                        
                                        <div class="form-group">
                                            <label>Ngày sinh</label>
                                            <input type="date" class="form-control" placeholder="Date of birth" name="date" required>						
                                        </div>			
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label>Địa chỉ</label>
                                            <input type="text" class="form-control" placeholder="Address" name="address" required>						
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label>Số điện thoại</label>
                                            <input type="number" class="form-control" placeholder="Phone" name="phone" required>	
                                        </div>
                                    </div>
                                </div>                           
                                <input type="hidden" value="<%=student.getId()%>" name="id">
                                <div class="row">
                                    <div class="col-md-12 mt-3">
                                        <button type="submit" class="btn btn-warning" style="margin-left: 32rem;">Sửa</button>
                                    </div>							
                                </div>
                            </div>					
                        </form>
                    </div>
                    <%}%>
                    <!--end edit student-->
                </main>
            </div>
        </div>
        <!--check-delete-->
        <script type="text/javascript">
            function checkDelete(form_id) {
                var result = confirm("Bạn có chắc chắc muốn xóa bản ghi này không");
                if (result) {
                    document.getElementById(form_id).submit();
                } else {
                }
            }
            function displayStatus() {
                alert('Lớp còn học sinh, không thể xóa');
            }
        </script>
        <!--end check-delete-->
        <script src="framework/jquery-3.4.1.min.js"></script>
        <script src="framework/popper.min.js"></script>
        <script src="framework/bootstrap/js/bootstrap.min.js"></script>	
    </body>
</html>
