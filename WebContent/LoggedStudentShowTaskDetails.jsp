<%@page import="com.cdac.dto.Students_Tasks"%>
<%@page import="com.cdac.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@  include file="MaintainSessionStudent.jsp"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<meta name="Description" content="Enter your description here" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.0/css/all.min.css">
<link rel="stylesheet" href="assets/css/style.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css">
<title>Student Task Info</title>
</head>

<body class="bg-light">

	<!-- NavBar -->
	<jsp:include page="navbar.jsp" />
	<br>
	<br>
	<!-- Student home -->
	<!-- Teacher Login Form -->
	<div class="container-fluid my-2">
		<div class="row justify-content-around">

			<%
				Students_Tasks st = (Students_Tasks) request.getAttribute("LoggedStudentShowTaskDetails");
			%>

			<!--Student Page -->
			<div class="col-md-10 bg-light shadow px-4 pt-4">
				<h1 class="text-center my-1">Task Details</h1>
				<hr>
				<div class="row ">
					<div class="col-md-4 justify-content-center">
						<h2 class="text-center">
							<i class="fa fa-list"></i>
							<%=st.getTask().getTaskName()%>
						</h2>
						<p class="text-secondary text-center">
							<span class="text-danger"><b>Due Date:</b> <%=st.getTask().getDueDate()%>
								<%=st.getTask().getDueTime()%></span>
						</p>
						<p class="text-secondary text-center">
							<b>Task type:</b>
							<%=st.getTask().getTaskType().getTaskTypeName()%>
						</p>

						<p class="text-secondary text-center">
							<b>Course:</b>

							<%=st.getTask().getModule().getModuleName()%>
						</p>

						<p class="text-secondary text-center">

							<b>Course Type:</b>
							<%=st.getTask().getModule().getModuleType()%>
						</p>

					</div>
					<div class="col-md-4 justify-content-center">
						<h2 class="text-center mb-4">
							<i class="fa fa-sync"></i> Status
						</h2>
						<h2 class="text-center text-success  p-2 mt-2">

							<%=(st.getTaskStatus() == 0) ? "Assigned!!!"
					: ((st.getTaskStatus() == 1) ? "Complete"
							: ((st.getTaskStatus() == 2) ? "Pass:-)!!!" : "Fail:-()"))%>
						</h2>
						<%
							if (st.getTaskStatus() == 0) {
						%>
						<a
							href="LoggedStudentShowTaskDetailsSubmit?taskID=<%=st.getTask().getTaskID()%>&Students_Tasks_ID=<%=st.getStudents_Tasks_ID()%>"
							role="button" class="btn btn-outline-success btn-block">Mark
							as Complete </a>
						<%
							}
						%>
					</div>
					<div class="col-md-4 justify-content-center">


						<h2 class="text-center">
							<i class="fa fa-thumbtack"></i> Score
						</h2>

						<h2 class="text-center text-danger">
							<%=(st.getTaskStatus() == 0 || st.getTaskStatus() == 1) ? "Evaluation Not Complete"
					: ("*" + st.getMarks() + "/" + ((double) st.getTask().getTaskType().getTaskMaxMarks()))%>
						</h2>
					</div>
				</div>
				<hr>

				<h2 class="text-center">
					<i class="fa fa-user-graduate "></i>
					<%=st.getStudent().getStudentName()%>
					(Roll no.
					<%=st.getStudent().getStudentRollNo() + ")"%>
				</h2>
				<p class="text-secondary text-center">
					<b>Email:</b>
					<%=st.getStudent().getStudentEmail()%>
					<b>Phone:</b>
					<%=st.getStudent().getStudentPhone()%>
				</p>
				<hr>

				<h3 class="text-center">Task Info</h3>

				<div
					class="table-responsive text-center justify-content-center align-items-center">
					<table class="table table-hover">

						<tr>
							<th class="table-primary">Task ID:</th>
							<td><%=st.getTask().getTaskID()%></td>
						</tr>

						<tr>
							<th class="table-primary">Task Name:</th>
							<td><%=st.getTask().getTaskName()%></td>
						</tr>
						<tr>
							<th class="table-primary">Due Date & Time:</th>
							<td><%=st.getTask().getDueDate()%> <%=st.getTask().getDueTime()%></td>
						</tr>
						<tr>
							<th class="table-primary">Status:</th>
							<td><%=(st.getTaskStatus() == 0) ? "Assigned"
					: ((st.getTaskStatus() == 1) ? "Complete" : ((st.getTaskStatus() == 2) ? "Passed" : "Failed"))%></td>
						</tr>
						<tr>
							<th class="table-primary">Type:</th>
							<td><%=st.getTask().getTaskType().getTaskTypeName()%></td>
						</tr>
						<tr>
							<th class="table-primary">Link:</th>
							<td><%=st.getTask().getTaskLink()%></td>
						</tr>
						<tr>
							<th class="table-primary">Instructions:</th>
							<td><%=st.getTask().getTaskInstruction()%></td>
						</tr>
					</table>
				</div>
				<h3 class="text-center">Module & Teacher Info</h3>
				<div
					class="table-responsive text-center justify-content-center align-items-center">
					<table class="table table-hover">

						<tr>
							<th class="table-success">Module Name:</th>
							<td><%=st.getTask().getModule().getModuleName()%></td>
						</tr>

						<tr>
							<th class="table-success">Module Type:</th>
							<td><%=st.getTask().getModule().getModuleType()%></td>
						</tr>
						<tr>
							<th class="table-success">Module Start Date:</th>
							<td><%=st.getTask().getModule().getStartDate()%></td>
						</tr>
						<tr>
							<th class="table-success">Module End Date:</th>
							<td><%=st.getTask().getModule().getEndDate()%></td>
						</tr>
						<tr>
							<th class="table-success">Teacher:</th>
							<td><%=st.getTask().getModule().getTeacher().getTeacherName()%></td>
						</tr>
						<tr>
							<th class="table-success">Teacher Email:</th>
							<td><%=st.getTask().getModule().getTeacher().getTeacherEmail()%></td>
						</tr>
						<tr>
							<th class="table-success">Teacher Contact No.:</th>
							<td><%=st.getTask().getModule().getTeacher().getTeacherPhone()%></td>
						</tr>
					</table>
				</div>

			</div>
		</div>
	</div>

	<br>
	<br>

	<!-- Footer -->
	<%@ include file="footer.htm"%>

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.1/umd/popper.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>

</html>