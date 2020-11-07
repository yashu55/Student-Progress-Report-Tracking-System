<%@page import="com.cdac.dto.Students_Tasks"%>
<%@page import="java.util.List"%>
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
<title>Student Task List</title>
</head>

<body class="bg-light">

	<!-- NavBar -->
	<jsp:include page="navbar.jsp" />



	<% Student stu = (Student) request.getAttribute("Logged_Student_Details"); %>
	<br>
	<!-- Teacher Login Form -->
	<div class="container-fluid my-1">
		<div class="row justify-content-around">

			<!--Student Page -->
			<div class="col-md-10 bg-light shadow px-4 py-2">
			
				<h2 class="py-2">
					<i class="fa fa-user-graduate "></i>
					<%=stu.getStudentName()%>
					(Roll no.
					<%=stu.getStudentRollNo() + ")"%>
				</h2>
				<p class="text-secondary ">
					<b>Email:</b>
					<%=stu.getStudentEmail()%>
					<b>Phone:</b>
					<%=stu.getStudentPhone()%>
				</p>
				<hr>
				<br>
				<h2 class="text-center">
					<i class="fa fa-list"></i> Task List
				</h2>
				<br>
				<div
					class="table-responsive text-center justify-content-center align-items-center">
					<table class="table table-hover">
						<thead class="thead-dark">
							<tr>
								<th>ID</th>
								<th>Task Name</th>
								<th>Due Date & Time</th>
								<th>Link</th>
								<th>Status</th>
								<th>Score</th>
								<th>More Info</th>
							</tr>
						</thead>
						<tbody>
							<%
								List<Students_Tasks> li = (List<Students_Tasks>) request.getAttribute("All_Task_list");
								for (Students_Tasks st : li) {
							%>
							<tr>
								<td><%=st.getTask().getTaskID()%></td>
								<td><%=st.getTask().getTaskName()%></td>
								<td><%=st.getTask().getDueDate()%> <%=st.getTask().getDueTime()%></td>
								<td><%=st.getTask().getTaskLink()%></td>
								<td><%=(st.getTaskStatus() == 0) ? "Assigned"
						: ((st.getTaskStatus() == 1) ? "Complete" : 
							((st.getTaskStatus() == 2) ? "Passed" : "Failed"))%></td>
								
								
								<td><%=(st.getTaskStatus() == 0 || st.getTaskStatus() == 1) ? "Evaluation not complete"
						: (st.getMarks() + "/" + ((double) st.getTask().getTaskType().getTaskMaxMarks()))%></td>
								
								
								<td><a
									href="LoggedStudentShowTaskDetails?taskID=<%=st.getTask().getTaskID()%>&Students_Tasks_ID=<%=st.getStudents_Tasks_ID()%>"
									role="button" class="btn btn-outline-success btn-block">Show
										Details</a></td>
							</tr>
							<%
								}
							%>
						</tbody>
					</table>
				</div>

			</div>
		</div>
	</div>


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