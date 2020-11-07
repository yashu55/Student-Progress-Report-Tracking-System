<%@page import="com.cdac.dto.Module"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@  include file="MaintainSessionTeacherNonAdmin.jsp"%>

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
<title>Module Info</title>
</head>

<body class="bg-light">

	<!-- NavBar -->
	<jsp:include page="navbar.jsp" />




	<%
		List<Module> moduleList = (List<Module>) request.getAttribute("module_list");
	
	%>

	<!-- Student Login Form -->
	<div class="container-fluid my-2">
		<div class="row justify-content-around">


			<div class="col-md-7 bg-light shadow px-4 pt-4">
				<h4 class="display-4 ">
					<i class="fa fa-book-open"></i> Module Info
				</h4>
				<p class="text-secondary">These are module details.</p>
				<hr>

				<%
				int i = 1;	
				for (Module m : moduleList) {
				%>

				<div
					class="table-responsive my-2 text-center justify-content-center align-items-center">
					<h3 class="text-center">Module <%=i %>:</h3>
					<table class="table table-hover">

						<tr>
							<th class="table-success">Module ID:</th>
							<td><%=m.getModuleID()%></td>
						</tr>

						<tr>
							<th class="table-success">Module Name:</th>
							<td><%=m.getModuleName()%></td>
						</tr>
						<tr>
							<th class="table-success">Module Type:</th>
							<td><%=m.getModuleType()%></td>

						</tr>
						<tr>
							<th class="table-success">Module Start Date:</th>
							<td><%=m.getStartDate()%></td>

						</tr>
						<tr>
							<th class="table-success">Module End Date:</th>
							<td><%=m.getEndDate()%></td>

						</tr>
						
					</table>
				</div>


				<%
					i++;}
				%>

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