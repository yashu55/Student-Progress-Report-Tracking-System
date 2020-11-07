<%@page import="com.cdac.dto.Module"%>
<%@page import="java.util.List"%>
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
    <title>Add Task Type</title>
</head>

<body class="bg-light">

<!-- NavBar -->
<jsp:include page="navbar.jsp" />  

  <!--Add Task Type--------->
    <div class="container-fluid my-2">
        <div class="row justify-content-around">

            <div class="col-md-7 bg-light shadow px-4 py-4">
                <h4 class="display-4 ">
                    <i class="fa fa-list"></i> Add Task Type</h4>
                <p class="text-secondary">Add task type details.</p>
                <hr>
                <form class="was-validated" method="post" action="AddTaskTypeSubmit">

                    <div class="form-group">
                        <label for="name">Task Type Name</label>
                        <input type="text" class="form-control" name="taskTypeName" id="name"
                            aria-describedby="nameHelpId" placeholder="Ex. Quiz" maxlength="20" required>
                        <small id="nameHelpId" class="form-text text-muted">*Required</small>
                    </div>
                    
                    <div class="form-group">
                        <label for="taskMaxMarks">Maximum Marks for the Task</label>
                        <input type="text" class="form-control" name="taskMaxMarks" id="taskMaxMarks"
                            aria-describedby="rollnoHelpId" placeholder="50" pattern="^[1-9][0-9]?$|(^100$)" required>
                        <small id="taskMaxMarksHelpId" class="form-text text-muted">*Required</small>
                    </div>

           
                    <div class="form-group">
                        <button type="submit" class="btn btn-primary">Add Task Type</button>
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








 