<%-- <%
response.setHeader("Cache-Control","no-cache"); 
response.setHeader("Cache-Control","no-store"); 
response.setDateHeader("Expires", 0); 

%> --%>
<!-- <script type = "text/javascript" >
   function preventBack(){window.history.forward();}
    setTimeout("preventBack()", 0);
    window.onunload=function(){null};
</script> -->

<nav
	class="navbar navbar-expand-sm navbar-dark bg-primary  shadow sticky-top p-3">
	<a class="navbar-brand" href="#"><i class="fa fa-chart-line"></i>
		CDAC-Trac</a>
	<button class="navbar-toggler d-lg-none" type="button"
		data-toggle="collapse" data-target="#collapsibleNavId"
		aria-controls="collapsibleNavId" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<%
		String s = (String) session.getAttribute("teacher_login");
		String s1 = (String) session.getAttribute("student_login");
		String s3 = (String) session.getAttribute("teacher_type");
	%>
	<div class="collapse navbar-collapse justify-content-between"
		id="collapsibleNavId">
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link" href="./">Home</a></li>
			<li class="nav-item"><a class="nav-link" href="Features">Features</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="About">About</a>
			</li>
			<%
				if (s != null && s3.equals("Admin")) {
			%>
			<li class="nav-item"><a class="nav-link" href="TeacherHome">Teacher
					Home</a></li>
			<%
				}else if((s != null && s3.equals("Module_Teacher"))){
			%>
			<li class="nav-item"><a class="nav-link" href="TeacherHomeNonAdmin">Teacher
					Home</a></li>
			<%
				}else if (s1 != null) {
			%>
			<li class="nav-item"><a class="nav-link" href="StudentHome">Student
					Home</a></li>
			<%
				}
			%>
		</ul>

		<ul class="navbar-nav">


			<%
				if (s == null && s1 == null) {
			%>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle mr-4" href="#" id="dropdownId"
				data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Sign-in
					here!!! </a>
				<div class="dropdown-menu" aria-labelledby="dropdownId">
					<a class="dropdown-item" href="TeacherLogin">Teacher</a> <a
						class="dropdown-item" href="StudentLogin">Student</a>
				</div></li>
			<%
				} else if (s != null || s1 != null) {
			%>

			<li class="nav-item "><a class="btn btn-outline-light mx-2"
				href="Logout" role="button">Logout</a></li>
			<%
				}
			%>
		</ul>
	</div>
</nav>