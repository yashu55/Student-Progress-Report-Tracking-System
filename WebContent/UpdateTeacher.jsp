
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
    <title>Update Teacher</title>
</head>

<body class="bg-light">

<!-- NavBar -->
<jsp:include page="navbar.jsp" />  

  <!--Add Teacher--------->
    <div class="container-fluid my-2">
        <div class="row justify-content-around">

            <div class="col-md-7 bg-light shadow px-4 py-4">
                <h4 class="display-4 ">
                    <i class="fa fa-edit"></i> Update Teacher</h4>
                <p class="text-secondary">Update teacher details.</p>
                <hr>
                <form class="was-validated" method="Post" action="UpdateTeacherSubmit">
					
					<div class="form-group">
                        <label for="ID">TeacherID</label>
                        <input value="<%= ( (Teacher) request.getAttribute("Update_Teacher") ).getTeacherID()%>" type="text" class="form-control" name="teacherID" id="ID"
                            aria-describedby="IDHelpId" readonly>
                        <small id="IDHelpId" class="form-text text-muted">*Required</small>
                    </div>
					
                    <div class="form-group">
                        <label for="name">Name</label>
                        <input value="<%= ( (Teacher) request.getAttribute("Update_Teacher") ).getTeacherName()%>" type="text" class="form-control" name="teacherName" id="name"
                            aria-describedby="nameHelpId" placeholder="Ex. Santosh Mondal" maxlength="20" required>
                        <small id="nameHelpId" class="form-text text-muted">*Required</small>
                    </div>

                    <div class="form-group">
                        <label for="email">Email</label>
                        <input value="<%= ( (Teacher) request.getAttribute("Update_Teacher") ).getTeacherEmail() %>" type="email" class="form-control" name="teacherEmail" id="email"
                            aria-describedby="emailHelpId" placeholder="abc@example.com" pattern="[^\s]+" minlength="3"
                            required>
                        <small id="emailHelpId" class="form-text text-muted">*Required</small>
                    </div>

                    <div class="form-group">
                        <label for="phone">Contact No.</label>
                        <input value="<%= ( (Teacher) request.getAttribute("Update_Teacher") ).getTeacherPhone() %>" type="text" class="form-control" name="teacherPhone" id="phone"
                            aria-describedby="phoneHelpId" placeholder="91XXXXXXXX" pattern="[0-9]{10}" minlength="10"
                            maxlength="10" required>
                        <small id="phoneHelpId" class="form-text text-muted">*Required</small>
                    </div>
                    
         
                    
                    <div class="form-group">
                        <button type="submit" class="btn btn-primary">Update</button>
                        <button type="reset" class="btn btn-danger">Reset</button>
                    </div>
                </form>
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