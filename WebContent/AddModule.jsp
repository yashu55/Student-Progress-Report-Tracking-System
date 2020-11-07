<%@page import="com.cdac.dto.Teacher"%>
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
    <title>Add Module</title>
</head>

<body class="bg-light">

<!-- NavBar -->
<jsp:include page="navbar.jsp" />  

     <!--Add Module--------->
    <div class="container-fluid my-2">
        <div class="row justify-content-around">

            <div class="col-md-7 bg-light shadow px-4 py-4">
                <h4 class="display-4 ">
                    <i class="fa fa-book"></i> Add Module</h4>
                <p class="text-secondary">Enter Module details.</p>
                <hr>
                <form class="was-validated" method="post" action="AddModuleSubmit">

                    <div class="form-group">
                        <label for="name"> Module Name</label>
                        <input type="text" class="form-control" name="moduleName" id="name"
                            aria-describedby="nameHelpId" placeholder="Ex. Advanced-Java" maxlength="20" required>
                        <small id="nameHelpId" class="form-text text-muted">*Required</small>
                    </div>

                    <div class="form-group">
                        <label for="moduleType">Module Type</label>
                        <select class="form-control" id="moduleType" name="moduleType" required>
                            <option value="Technical">Technical</option>
                            <option value="Communication">Communication</option>
                            <option value="Aptitude">Aptitude</option>
                            <option value="Personality Development">Personality Development</option>
                        </select>
                        <small id="moduleHelpId" class="form-text text-muted">*Required</small>

                    </div>

                    <div class="form-group">
					    <label for="assignTeacher">Assign Teacher</label>
					    <select class="form-control" id="assignteacher" name="teacherID" required>
					     <% List<Teacher> li = (List<Teacher>)request.getAttribute("All_Teachers"); 
					     	for(Teacher teacher: li){
					     %>
					      <option value="<%=teacher.getTeacherID()%>" ><%=teacher.getTeacherName()%></option>
					     <% } %>
					    </select>
					   	<small id="assignTeacherHelpId" class="form-text text-muted">*Required</small>
					</div>

                    <div class="form-group">
                        <label for="startDate">Start Date</label>
                        <input class="form-control" type="date" name="startDate" id="startDate" required>
                        <small id="startDateHelpId" class="form-text text-muted">*Required</small>

                    </div>

                    <div class="form-group">
                        <label for="endDate">End Date</label>
                        <input class="form-control" type="date" name="endDate" id="endDate" required>
                        <small id="endDateHelpId" class="form-text text-muted">*Required</small>

                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-primary">Add Module</button>
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