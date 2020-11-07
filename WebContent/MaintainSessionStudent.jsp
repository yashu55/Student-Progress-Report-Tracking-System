<%
String a = (String) session.getAttribute("student_login");
		if(a == null) {
			response.sendRedirect("./");	
		}
%>  