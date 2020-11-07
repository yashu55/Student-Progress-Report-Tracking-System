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
    <title>Student Menu</title>
</head>

<body class="bg-light">

<!-- NavBar -->
<jsp:include page="navbar.jsp" />  

    <br>
    <br>
    <br>
    <div class="container-fluid my-4 justify-content-center align-items-center">
        <div class="row justify-content-around my-4">
            <div class="col-md-5 bg-light shadow px-4 py-4">
                <h1 class=" display-1 text-success text-center"><i class="fa fa-user-plus"></i></h1>
                <a class="btn btn-outline-success btn-block" href="AddStudent" role="button">Add Student</a>
            </div>
            <div class="col-md-5 bg-light shadow px-4 py-4">
                <h1 class=" display-1 text-warning text-center"><i class="fa fa-list-alt"></i></h1>
                <a class="btn btn-outline-warning btn-block" href="ShowAllStudents" role="button">Show All Students</a>
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