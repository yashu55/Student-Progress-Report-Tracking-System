<%
String a = (String) session.getAttribute("teacher_login");
String teacherType = (String) session.getAttribute("teacher_type");

		if(a == null || !teacherType.equals("Admin")) {
			response.sendRedirect("./");	
		}
%>  