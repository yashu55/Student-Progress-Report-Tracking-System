<%@page import="com.cdac.dto.Teacher"%>
<%@page import="com.cdac.dto.Student"%>
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
<title>Teacher Info</title>
</head>

<body class="bg-light">

	<!-- NavBar -->
	<jsp:include page="navbar.jsp" />
	<br>
	<br>
	<br>
	<%
		Teacher teacher = (Teacher) request.getAttribute("teacher_details");
	%>
	<!-- Student home -->
	<div class="container-fluid my-2">
		<div class="row justify-content-around">

			<!--Student Page -->
			<div class="col-md-10 bg-light shadow px-4 pt-4">
				<h5 class="display-4 ">
					<i class="fa fa-chalkboard-teacher"></i> Hello,
					<%=teacher.getTeacherName()%>!</h5>
				<p class="text-secondary">These are your details.</p>
				<hr>

				<br>
				<div
					class="table-responsive text-center justify-content-center align-items-center">
					<table class="table table-hover">
						<thead class="thead-dark">
							<tr>
								<th>Teacher ID</th>
								<th>Name</th>
								<th>Email</th>
								<th>Contact No.</th>
								<th>Teacher Type</th>
							</tr>
						</thead>
						<tbody>

							<tr>
								<td><%=teacher.getTeacherID()%></td>
								<td><%=teacher.getTeacherName()%></td>
								<td><%=teacher.getTeacherEmail()%></td>
								<td><%=teacher.getTeacherPhone()%></td>
								<td><%=teacher.getTeacherType()%></td>
						</tbody>
					</table>
				</div>


				<hr>
				<h2 class="text-center ">
					 Update Details
				</h2>
				<!--Update form -->
				<form class="was-validated" method="post"
					action="LoggedTeacherTeacherInfoSubmit">
					<div class="form-group">
                        <label for="ID">Teacher ID</label>
                        <input value="<%=teacher.getTeacherID()%>" type="text" class="form-control" name="teacherID" id="ID"
                            aria-describedby="IDHelpId" readonly>
                        <small id="IDHelpId" class="form-text text-muted">*Required</small>
                    </div>
                    <div class="form-group">
                        <label for="ID">Teacher Type</label>
                        <input value="<%=teacher.getTeacherType()%>" type="text" class="form-control" name="teacherType" id="type"
                            aria-describedby="IDHelpId" readonly>
                        <small id="IDHelpId" class="form-text text-muted">*Required</small>
                    </div>
                    
                    <div class="form-group">
                        <label for="ID">Teacher Name</label>
                        <input value="<%=teacher.getTeacherName()%>" type="text" class="form-control" name="teacherName" id="name"
                            aria-describedby="IDHelpId" required >
                        <small id="IDHelpId" class="form-text text-muted">*Required</small>
                    </div>
                    
					<div class="form-group">
						<label for="email">Update Email</label> <input type="email"
							class="form-control" name="teacherEmail" id="email"
							aria-describedby="emailHelpId" placeholder="abc@example.com"
							pattern="[^\s]+" minlength="3" 
							value="<%=teacher.getTeacherEmail()%>"required> <small
							id="emailHelpId" class="form-text text-muted">*Required</small>
					</div>
					<div class="form-group">
						<label for="pwd">New Password</label> <input type="password"
							class="form-control" name="teacherPass" id="pwd"
							placeholder="Password" minlength="4" maxlength="20" required>
						<small id="passwordHelpId" class="form-text text-muted">*Required</small>
					</div>

					<div class="form-group">
						<label for="phone"> Update Contact No.</label> <input type="text"
							class="form-control" name="teacherPhone" id="phone"
							aria-describedby="phoneHelpId" placeholder="91XXXXXXXX"
							pattern="[0-9]{10}" minlength="10" maxlength="10" 
							value="<%=teacher.getTeacherPhone()%>" required>
						<small id="phoneHelpId" class="form-text text-muted">*Required</small>
					</div>
					<div class="form-group">
						<button type="submit" class="btn btn-primary">Submit</button>
						<button type="reset" class="btn btn-danger">Reset</button>
					</div>
				</form>
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