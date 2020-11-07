<%@page import="com.cdac.dto.Student"%>
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
    <title>Show All Students</title>
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
                    <i class="fa fa-user-graduate"></i> Student List</h4>
                <h4 class="text-secondary">List of all students.</h4>
                <hr>
                <br>
                <div class="table-responsive text-center justify-content-center align-items-center">
                    <table class="table table-hover">
                        <thead class="thead-dark">
                            <tr>
                                <th>Roll No.</th>
                                <th>Name</th>
                                <th>Email</th>
                                <th>Contact No.</th>
                             </tr>
                        </thead>
                        <tbody>
		<% 
			List <Student> li = (List<Student>) request.getAttribute("All_Student_List");
			
			for(Student student : li){
		%>     
                            <tr> 
                                <td><%=student.getStudentRollNo() %></td>
                                <td><%=student.getStudentName() %></td>
                                <td><%=student.getStudentEmail() %></td>
                                <td><%=student.getStudentPhone() %></td>
         <% } %>
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