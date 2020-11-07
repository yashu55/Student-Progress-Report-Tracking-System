<%@page import="com.cdac.dto.TaskType"%>
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
    <title>Add Task</title>
</head>

<body class="bg-light">

<!-- NavBar -->
<jsp:include page="navbar.jsp" />  

  

    <!--Add Task--------->
    <div class="container-fluid my-2">
        <div class="row justify-content-around">
            <div class="col-md-7 bg-light shadow px-4 py-4">
                <h4 class="display-4 ">
                    <i class="fa fa-tasks"></i> Add Task</h4>
                <p class="text-secondary">Enter Task details.</p>
                <hr>
                <form class="was-validated" method="post" action="AddTaskSubmit">
                    <div class="form-group">
                        <label for="name"> Task Name</label>
                        <input type="text" class="form-control" name="taskName" id="name" aria-describedby="nameHelpId"
                            placeholder="Ex. Communication Challenge" maxlength="50" required>
                        <small id="nameHelpId" class="form-text text-muted">*Required</small>
                    </div>
                    <div class="form-group">
                        <label for="taskType">Task Type</label>
                        <select class="form-control" id="taskTypeID" name="taskTypeID" required>
                           <% List<TaskType> taskTypeList = (List<TaskType>)request.getAttribute("TaskType_List"); 
					     	for(TaskType taskType: taskTypeList){
				 %>
					      <option value="<%=taskType.getTaskTypeID()%>" ><%=taskType.getTaskTypeName()%> (Max Marks: <%=taskType.getTaskMaxMarks()%>)</option>
				<% } %>  
                           
                        </select>
                        <small id="taskHelpId" class="form-text text-muted">*Required</small>
                    </div>
                 
                
                    <div class="form-group">      
                        <label for="moduleID">Module</label>
                        <select class="form-control" id="moduleID" name="moduleID" required>
 				<% List<Module> moduleList = (List<Module>)request.getAttribute("Module_List"); 
					     	for(Module module: moduleList){
				 %>
					      <option value="<%=module.getModuleID()%>" ><%=module.getModuleName()%></option>
				<% } %>                        
						</select>
                        <small id="moduleHelpId" class="form-text text-muted">*Required</small>
                    </div>
                    
                    <div class="form-group">
                        <label for="instruction">Task Instructions</label>
                        <textarea class="form-control" name="taskInstruction" id="instruction"
                            aria-describedby="instructionsHelpId" placeholder="Type instructions here..." rows="4"
                            required></textarea>
                        <small id="instructionsHelpId" class="form-text text-muted">*Required</small>
                    </div>
                    <div class="form-group">
                        <label for="link">Task Link</label>
                        <input type="text" class="form-control" name="taskLink" id="link" aria-describedby="linkHelpId"
                            placeholder="https://www.quizz.com/quiz1234" maxlength="50" required>
                        <small id="linkHelpId" class="form-text text-muted">*Required</small>
                    </div>
                    <div class="form-group">
                        <label for="dueDate">Due Date</label>
                        <input class="form-control" type="date" name="dueDate" id="dueDate" required>
                        <small id="dueDateHelpId" class="form-text text-muted">*Required</small>
                    </div>
                    <div class="form-group">
                        <label for="dueTime">Due Time</label>
                        <input class="form-control" type="time" name="dueTime" id="dueTime" required>
                        <small id="dueTimeHelpId" class="form-text text-muted">*Required</small>
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-primary">Add Task</button>
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