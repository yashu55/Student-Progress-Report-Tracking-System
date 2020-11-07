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
<title>Student Info</title>
</head>

<body class="bg-light">

	<!-- NavBar -->
	<jsp:include page="navbar.jsp" />
	<br>
	<br>
	<br>
	<%
		Student student = (Student) request.getAttribute("Logged_Student_Details");
	%>
	<!-- Student home -->
	<div class="container-fluid my-2">
		<div class="row justify-content-around">

			<!--Student Page -->
			<div class="col-md-10 bg-light shadow px-4 pt-4">
				<h5 class="display-4 ">
					<i class="fa fa-user-graduate"></i> Hello,
					<%=student.getStudentName()%>!</h5>
				<p class="text-secondary">These are your details.</p>
				<hr>

				<br>
				<div
					class="table-responsive text-center justify-content-center align-items-center">
					<table class="table table-hover">
						<thead class="thead-dark">
							<tr>
								<th>Roll No.</th>
								<th>Name</th>
								<th>Email</th>
								<th>Contact No.</th>
							</tr>
						</thead>
						<tbody>

							<tr>
								<td><%=student.getStudentRollNo()%></td>
								<td><%=student.getStudentName()%></td>
								<td><%=student.getStudentEmail()%></td>
								<td><%=student.getStudentPhone()%></td>
						</tbody>
					</table>
				</div>


				<hr>
				<h2 class="text-center ">
					 Update Details
				</h2>
				<!--Update form -->
				<form class="was-validated" method="post"
					action="LoggedStudentUpdateSubmit">
					<div class="form-group">
                        <label for="ID">Roll No.</label>
                        <input value="<%=student.getStudentRollNo()%>" type="text" class="form-control" name="studentRollNo" id="ID"
                            aria-describedby="IDHelpId" readonly>
                        <small id="IDHelpId" class="form-text text-muted">*Required</small>
                    </div>
					<div class="form-group">
						<label for="email">Update Email</label> <input type="email"
							class="form-control" name="studentEmail" id="email"
							aria-describedby="emailHelpId" placeholder="abc@example.com"
							pattern="[^\s]+" minlength="3" 
							value="<%=student.getStudentEmail()%>"required> <small
							id="emailHelpId" class="form-text text-muted">*Required</small>
					</div>
					<div class="form-group">
						<label for="pwd">New Password</label> <input type="password"
							class="form-control" name="studentPass" id="pwd"
							placeholder="Password" minlength="4" maxlength="20" required>
						<small id="passwordHelpId" class="form-text text-muted">*Required</small>
					</div>

					<div class="form-group">
						<label for="phone"> Update Contact No.</label> <input type="text"
							class="form-control" name="studentPhone" id="phone"
							aria-describedby="phoneHelpId" placeholder="91XXXXXXXX"
							pattern="[0-9]{10}" minlength="10" maxlength="10" 
							value="<%=student.getStudentPhone()%>" required>
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