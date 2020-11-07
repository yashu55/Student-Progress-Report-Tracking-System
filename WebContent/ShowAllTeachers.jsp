<%@page import="java.util.List"%>
<%@page import="com.cdac.dto.Teacher"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  include file="MaintainSessionTeacher.jsp" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="Description" content="Enter your description here" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.0/css/all.min.css">
    <link rel="stylesheet" href="assets/css/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css">
    <title>Show All Teachers</title>
</head>

<body class="bg-light">

<!-- NavBar -->
<jsp:include page="navbar.jsp" />  


  <!-- Teacher List-->
    <div class="container-fluid my-4">
        <div class="row justify-content-around">

            <!--List -->
            <div class="col-md-10 bg-light shadow px-4 pt-4">
                <h4 class="display-4">
                    <i class="fa fa-chalkboard-teacher"></i> Teacher List</h4>
                <h4 class="text-secondary">List of all teachers.</h4>
                <hr>
                <br>
                <div class="table-responsive text-center justify-content-center align-items-center">
                    <table class="table table-hover">
                        <thead class="thead-dark">
                            <tr>
                                <th>#</th>
                                <th>Name</th>
                                <th>Email</th>
                                <th>Contact No.</th>
                                <th>Update</th>
                                 <th>Remove</th>
                             </tr>
                        </thead>
                        <tbody>
		<% 
			List <Teacher> li = (List<Teacher>) request.getAttribute("All_Teacher_List");
			int i = 1;
			for(Teacher teacher : li){
		%>     
                            <tr> 
                                <td><%=i %></td>
                                <td><%=teacher.getTeacherName() %></td>
                                <td><%=teacher.getTeacherEmail() %></td>
                                <td><%=teacher.getTeacherPhone() %></td>
                                <td><a href="UpdateTeacher?TeacherId=<%=teacher.getTeacherID()%>" role="button" class="btn btn-outline-info btn-block">Update</a></td>
                               <td><a href="DeleteTeacher?TeacherId=<%=teacher.getTeacherID()%>" role="button" class="btn btn-outline-danger btn-block">Remove</a></td>                            </tr>
         <% i++;} %>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>



<!-- Footer -->
<%@ include file="footer.htm"%>   

 <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.1/umd/popper.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>

</html>