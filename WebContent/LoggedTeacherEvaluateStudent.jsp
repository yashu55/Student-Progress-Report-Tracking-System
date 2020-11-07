<%@page import="java.util.List"%>
<%@page import="com.cdac.dto.Students_Tasks"%>
<%@page import="com.cdac.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@  include file="MaintainSessionTeacherNonAdmin.jsp"%>



<%
	List<Students_Tasks> li = (List<Students_Tasks>) request.getAttribute("stuTasksAll");
	Student student = (Student) request.getAttribute("student");
%>

<%
	int totalTasks = 0;
	int taskComplete = 0;
	int taskIncomplete = 0;
	int tasksubmitted = 0;
	int tasksPassed = 0;
	int tasksFailed = 0;
	for (Students_Tasks st : li) {
		if (st.getTaskStatus() == 0)
			tasksubmitted++;
		else if (st.getTaskStatus() == 1 )
			taskComplete++;
		else if (st.getTaskStatus() == 2)
			tasksPassed++;
		else if (st.getTaskStatus() == 3)
			tasksFailed++;

		totalTasks++;
	}
	taskIncomplete = totalTasks - taskComplete;
%>


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
<title>Teacher Home</title>




<!--Load the AJAX API-->
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
	// Load the Visualization API and the corechart package.
	google.charts.load('current', {
		'packages' : [ 'corechart' ]
	});

	// Set a callback to run when the Google Visualization API is loaded.
	google.charts.setOnLoadCallback(drawChart);

	// Callback that creates and populates a data table,
	// instantiates the pie chart, passes in the data and
	// draws it.
	function drawChart() {

		// Create the data table.
		var data = new google.visualization.DataTable();
		data.addColumn('string', 'Task Status');
		data.addColumn('number', 'tasks');
		data
				.addRows([ [ 'Assigned',
<%=tasksubmitted%>
	],
						[ 'Completed',
<%=taskComplete%>
	],
						[ 'Passed',
<%=tasksPassed%>
	],
						[ 'Failed',
<%=tasksFailed%>
	] ]);

		// Set chart options
		var options = {
			'title' : 'Task Status',
		};

		// Instantiate and draw our chart, passing in some options.
		var chart = new google.visualization.PieChart(document
				.getElementById('chart_div'));
		chart.draw(data, options);
		var chart2 = new google.visualization.BarChart(document
				.getElementById('chart_div_bar'));
		chart2.draw(data, options);

	}
</script>
















</head>

<body class="bg-light">

	<!-- NavBar -->
	<jsp:include page="navbar.jsp" />



	<div
		class="container-fluid my-3 justify-content-center align-items-center">
		<div class="row justify-content-center align-items-center">
			<div class="col-md-11 text-dark ">
				<h1 class="text-center">PROGRESS REPORT</h1>
				<div class="row justify-content-center align-items-center">
					<div class="col-md-6 text-dark text-center">
						<h2 class="py-2">
							<i class="fa fa-user-graduate "></i>
							<%=student.getStudentName()%>
							(Roll no.
							<%=student.getStudentRollNo() + ")"%>
						</h2>
						<p class="text-secondary ">
							<b>Email:</b>
							<%=student.getStudentEmail()%>
							<b>Phone:</b>
							<%=student.getStudentPhone()%>
						</p>
						<button type="button" onclick="window.print()"
							class="btn btn-lg btn-primary">
							<i class="fa fa-print "></i> Print Report
						</button>

					</div>
					<div class="col-md-6 text-dark text-center">
						<h2 class="py-2">Total Tasks</h2>
						<div class="container-fluid">
							<div class="row">
								<div class="col-md-4 ">
									<p class="text-secondary text-info">
										<b>Tasks completed:</b>
										<%=taskComplete%>

									</p>
									<p class="text-secondary text-warning">
										<b>Tasks incomplete:</b>
										<%=taskIncomplete%>
									</p>
								</div>
								<div class="col-md-4 ">
									<p class="text-secondary text-success">
										<b>Tasks passed:</b>
										<%=tasksPassed%>
									</p>
									<p class="text-secondary text-danger">
										<b>Tasks failed:</b>
										<%=tasksFailed%>
									</p>
								</div>
								<div class="col-md-4">

									<p class="text-secondary text-info">
										<b>Tasks assigned:</b>
										<%=tasksubmitted%>

									</p>
									<p class="text-secondary text-warning">
										<b>Total Tasks:</b>
										<%=totalTasks%>
									</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<hr>

		<div class="container-fluid">
			<div class="row" >
				<div class="col-md-6">
					<div id="chart_div" style="height: 400px;"></div>
				</div>
				<div class="col-md-6">
					<div id="chart_div_bar" style="height: 400px;"></div>

				</div>
			</div>
		</div>


		<hr>
		<h4 class="text-center text-success">
			Tasks Submitted <span class="text-danger">
				<h6>*(Yet to be evaluated)</h6>
			</span>
		</h4>
		<!-- 1111111111111111111111111111111111 -->

		<div
			class="table-responsive text-center mt-2 justify-content-center align-items-center">
			<table class="table table-hover">
				<thead class="bg-success">
					<tr>
						<th>ID</th>
						<th>Task Name</th>
						<th>Task Type</th>
						<th>Module Name</th>
						<th>Module Type</th>
						<th>Due Date & Time</th>
						<th>Max Score</th>
						<th>Enter Score</th>
						<th>More Info</th>
					</tr>
				</thead>
				<tbody>
					<%
						for (Students_Tasks st : li) {
							if (st.getTaskStatus() == 1) {
					%>
					<tr>
						<td><%=st.getTask().getTaskID()%></td>
						<td><%=st.getTask().getTaskName()%></td>
						<td><%=st.getTask().getTaskType().getTaskTypeName()%></td>
						<td><%=st.getTask().getModule().getModuleName()%></td>
						<td><%=st.getTask().getModule().getModuleType()%></td>
						<td><%=st.getTask().getDueDate()%> <%=st.getTask().getDueTime()%></td>
						<td><%=st.getTask().getTaskType().getTaskMaxMarks()%></td>
						<td>

							<form class="form-inline"
								action="LoggedTeacherEvaluateStudentSubmit">
								<div class="form-group">

									<input type="number" class="form-control" id="marks"
										name="marks" required min="0"
										max="<%=st.getTask().getTaskType().getTaskMaxMarks()%>">
								</div>
								<div class="form-group">

									<input type="text" class="form-control" id="studentRollNo"
										name="studentRollNo" required
										value="<%=student.getStudentRollNo()%>" hidden>
								</div>

								<div class="form-group">

									<input type="text" class="form-control" id="Students_Tasks_ID"
										name="Students_Tasks_ID" required
										value="<%=st.getStudents_Tasks_ID()%>" hidden>
								</div>

								<button type="submit" class="btn  btn-success">Submit</button>
							</form>
						</td>
						<td><a
							href="LoggedTeacherShowTaskDetails?taskID=<%=st.getTask().getTaskID()%>&Students_Tasks_ID=<%=st.getStudents_Tasks_ID()%>"
							role="button" class="btn btn-outline-success ">Details</a></td>
					</tr>

					<%
						}
						}
					%>
				</tbody>
			</table>
		</div>


		<h4 class="text-center text-info">Tasks Assigned:</h4>
		<!-- 222222222222222222222222222222222222222 -->



		<div
			class="table-responsive text-center mt-2 justify-content-center align-items-center">
			<table class="table table-hover">
				<thead class="bg-info">
					<tr>
						<th>ID</th>
						<th>Task Name</th>
						<th>Task Type</th>
						<th>Module Name</th>
						<th>Module Type</th>
						<th>Due Date & Time</th>
						<th>Max Score</th>
						<th>Score/Status</th>
						<th>More Info</th>
					</tr>
				</thead>
				<tbody>
					<%
						for (Students_Tasks st : li) {
							if (st.getTaskStatus() == 0) {
					%>
					<tr>
						<td><%=st.getTask().getTaskID()%></td>
						<td><%=st.getTask().getTaskName()%></td>
						<td><%=st.getTask().getTaskType().getTaskTypeName()%></td>
						<td><%=st.getTask().getModule().getModuleName()%></td>
						<td><%=st.getTask().getModule().getModuleType()%></td>
						<td><%=st.getTask().getDueDate()%> <%=st.getTask().getDueTime()%></td>
						<td><%=st.getTask().getTaskType().getTaskMaxMarks()%></td>
						<td><%=(st.getTaskStatus() == 0 || st.getTaskStatus() == 1)
							? "<span class='bg-info'>Evaluation not complete</span>"
							: (st.getMarks() + "/" + ((double) st.getTask().getTaskType().getTaskMaxMarks()))%></td>



						<td><a
							href="LoggedTeacherShowTaskDetails?taskID=<%=st.getTask().getTaskID()%>&Students_Tasks_ID=<%=st.getStudents_Tasks_ID()%>"
							role="button" class="btn btn-outline-info ">Details</a></td>
					</tr>

					<%
						}
						}
					%>
				</tbody>
			</table>
		</div>





		<h4 class="text-center text-warning">Task Completed:</h4>
		<!-- 333333333333333333333333333333333333 -->


		<div
			class="table-responsive text-center mt-2 justify-content-center align-items-center">
			<table class="table table-hover">
				<thead class="bg-warning">
					<tr>
						<th>ID</th>
						<th>Task Name</th>
						<th>Task Type</th>
						<th>Module Name</th>
						<th>Module Type</th>
						<th>Due Date & Time</th>
						<th>Max Score</th>
						<th>Score</th>
						<th>Status</th>
						<th>More Info</th>
					</tr>
				</thead>
				<tbody>
					<%
						for (Students_Tasks st : li) {
							if (st.getTaskStatus() == 2 || st.getTaskStatus() == 3) {
					%>
					<tr>
						<td><%=st.getTask().getTaskID()%></td>
						<td><%=st.getTask().getTaskName()%></td>
						<td><%=st.getTask().getTaskType().getTaskTypeName()%></td>
						<td><%=st.getTask().getModule().getModuleName()%></td>
						<td><%=st.getTask().getModule().getModuleType()%></td>
						<td><%=st.getTask().getDueDate()%> <%=st.getTask().getDueTime()%></td>
						<td><%=st.getTask().getTaskType().getTaskMaxMarks()%></td>
						<td><%=(st.getTaskStatus() == 0 || st.getTaskStatus() == 1)
							? "<span class='bg-info'>Evaluation not complete</span>"
							: (st.getMarks() + "/" + ((double) st.getTask().getTaskType().getTaskMaxMarks()))%></td>

						<td><%=(st.getTaskStatus() == 0) ? "Assigned"
							: ((st.getTaskStatus() == 1) ? "Complete"
									: ((st.getTaskStatus() == 2) ? "<span class='bg-success'>Pass</span>"
											: "<span class='bg-danger'>Fail</span>"))%></td>

						<td><a
							href="LoggedTeacherShowTaskDetails?taskID=<%=st.getTask().getTaskID()%>&Students_Tasks_ID=<%=st.getStudents_Tasks_ID()%>"
							role="button" class="btn btn-outline-warning ">Details</a></td>
					</tr>

					<%
						}
						}
					%>
				</tbody>
			</table>
		</div>









	</div>
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