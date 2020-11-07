<%@page import="com.cdac.dto.Task"%>
<%@page import="com.cdac.dto.TaskType"%>
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
    <title>Show All Task Types</title>
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
                    <i class="fa fa-book"></i> Task Type List</h4>
                <h4 class="text-secondary">List of all task types.</h4>
                <hr>
                <br>
                <div class="table-responsive text-center justify-content-center align-items-center">
                    <table class="table table-hover">
                        <thead class="thead-dark">
                            <tr>
                                <th>ID</th>
                                <th>Task Name</th>
                                <th>Type</th>
                                <th>Max Marks</th>
                                <th>Module Name</th>
                                <th>Module Type</th>
                                <th>Link</th>
                                <th>Date & Time</th>                        
                             </tr>
                        </thead>
                        <tbody>
		<% 
			List <Task> li = (List<Task>) request.getAttribute("All_Task_List");
			
			for(Task task : li){
		%>     
                            <tr> 
                                <td><%=task.getTaskID() %></td>
                                <td><%=task.getTaskName() %></td>
                                <td><%=task.getTaskType().getTaskTypeName() %></td>
                                <td><%=task.getTaskType().getTaskMaxMarks() %></td>
                                <td><%=task.getModule().getModuleName() %></td>
                                <td><%=task.getModule().getModuleType() %></td>
                                <td><%=task.getTaskLink() %></td>
                                <td><%=task.getDueDate() %> <%=task.getDueTime() %></td>
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