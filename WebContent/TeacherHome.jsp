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
    <title>Teacher Home</title>
</head>

<body class="bg-light">

<!-- NavBar -->
<jsp:include page="navbar.jsp" />  

<!-- Teacher home -->
 <div class="container-fluid my-4">
        <div class="row justify-content-around my-4">
            <div class="col-md-3 bg-light shadow px-4 py-4">
                <h1 class=" display-1 text-primary text-center"><i class="fa fa-user-graduate"></i></h1>
                <a class="btn btn-outline-primary btn-block" href="StudentMenu" role="button">Student</a>
            </div>
            <div class="col-md-3 bg-light shadow px-4 py-4">
                <h1 class=" display-1 text-secondary text-center"><i class="fa fa-book"></i></h1>
                <a class="btn btn-outline-secondary btn-block" href="ModuleMenu" role="button">Module</a>
            </div>
            <div class="col-md-3 bg-light shadow px-4 py-4">
                <h1 class=" display-1 text-warning text-center"><i class="fa fa-chalkboard-teacher"></i></h1>
                <a class="btn btn-outline-warning btn-block" href="TeacherMenu" role="button">Teacher</a>
            </div>
        </div>
        <div class="row justify-content-around my-4">
            <div class="col-md-3 bg-light shadow px-4 py-4">
                <h1 class=" display-1 text-success text-center"><i class="fa fa-tasks"></i></h1>
                <a class="btn btn-outline-success btn-block" href="TaskMenu" role="button">Task</a>
            </div>

            <div class="col-md-3 bg-light shadow px-4 py-4">
                <h1 class=" display-1 text-info text-center"><i class="fa fa-chart-line"></i></h1>
                <a class="btn btn-outline-info btn-block" href="ProgressReport" role="button">Progress Report</a>
            </div>
			<div class="col-md-3 bg-light shadow px-4 py-4">
                <h1 class=" display-1 text-danger text-center"><i class="fa fa-cogs"></i></h1>
                <a class="btn btn-outline-danger btn-block" href="SettingMenu" role="button">Settings</a>
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