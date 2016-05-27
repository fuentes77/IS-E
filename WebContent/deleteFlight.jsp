<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Flight</title>
</head>
<body>

	<h2>DeliteFlight.jsp</h2><<br><br>
	<div class="container">
		<form action="DeleteFlight" method="post">
	
	<%
	String driver  = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/easyFlightDB";
	String username="root";
	String password="root";
	Class.forName(driver);
	Connection connection =DriverManager.getConnection(url, username, password);
	
	Statement create = (Statement) connection.createStatement();
	
	ResultSet rs=create.executeQuery("SELECT * FROM flug");
	
	int i=0;
	while(rs.next()){
		i++;
		String reqId=rs.getString("FlugId");
		System.out.println("in der while Schleife" + reqId);
		%>
		Vorhandene Flüge <br><center><input type=submit value="<%=reqId %>" name="loeschen" ></center> 
		<%
	}
	
	
	%>
	
		
		</form>
	<a href="index.jsp">Zurueck</a>
	</div>
	

</body>
</html>