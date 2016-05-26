package ise.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class UpdateFlight
 */

public class UpdateFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	String flightId=null;
	String destination=null;
	String origin=null;
	int departureDateYear=0;
	int departureDateMonth=0;
	int departureDateDay=0;
	int departureDateHour=0;
	int departureDateMinute=0;
	
	int arrivalDateYear=0;
	int arrivalDateMonth=0;
	int arrivalDateDay=0;
	int arrivalDateHour=0;
	int arrivalDateMinute=0;
	
	int seats=0;
	double price=0;
	
	String reqFlightId=null;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateFlight() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.getWriter().append("UpdateFligt Servlet");
		
		String driver  = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/ise";
		String username="root";
		String password="root";

		
			
			
			try {
				
				reqFlightId=request.getParameter("update");
				Class.forName(driver);
				
				Connection connection =DriverManager.getConnection(url, username, password);
				

				System.out.println(reqFlightId);
				
				Statement update = (Statement) connection.createStatement();
				ResultSet rs=update.executeQuery("SELECT * FROM flug WHERE FlugId=\"" + reqFlightId + "\"");
				if(rs.next()){
					flightId=rs.getString("FlugId");
					destination=rs.getString("destination");
					origin=rs.getString("origin");
					departureDateYear=rs.getInt("departureDateYear");
					departureDateMonth=rs.getInt("departureDateMonth");
					departureDateDay=rs.getInt("departureDateDay");
					departureDateHour=rs.getInt("departureDateHour");
					departureDateMinute=rs.getInt("departureDateMinute");
					
					arrivalDateYear=rs.getInt("arrivalDateYear");
					arrivalDateMonth=rs.getInt("arrivalDateMonth");
					arrivalDateDay=rs.getInt("arrivalDateDay");
					arrivalDateHour=rs.getInt("arrivalDateHour");
					arrivalDateMinute=rs.getInt("arrivalDateMinute");
					
					seats=rs.getInt("seats");
					price=rs.getInt("price");
					
				}
			}catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

			
			if(request.getParameter("hid").equals("true")){
				origin=request.getParameter("origin");
				destination=request.getParameter("destination");
				departureDateYear= Integer.parseInt(request.getParameter("departureDateYear"));	
				departureDateMonth=	Integer.parseInt(request.getParameter("departureDateMonth"));
				departureDateDay=Integer.parseInt(request.getParameter("departureDateDay"));
				departureDateHour=Integer.parseInt(request.getParameter("departureDateHour"));
				departureDateMinute= Integer.parseInt(request.getParameter("departureDateMinute"));


				arrivalDateYear=Integer.parseInt(request.getParameter("arrivalDateYear"));	
				arrivalDateMonth=Integer.parseInt(request.getParameter("arrivalDateMonth"));
				arrivalDateDay=Integer.parseInt(request.getParameter("arrivalDateDay"));
				arrivalDateHour=Integer.parseInt(request.getParameter("arrivalDateHour"));
				arrivalDateMinute=Integer.parseInt(request.getParameter("arrivalDateMinute"));
				
				seats=Integer.parseInt(request.getParameter("seats"));
				price=Double.parseDouble(request.getParameter("price"));
				try {
					Class.forName(driver);
					Connection connection =DriverManager.getConnection(url, username, password);
					System.out.println(reqFlightId);
					String sql= "UPDATE flug SET destination=\"" + destination + "\", origin=\"" + origin + "\""
							+ ", departureDateYear=" + departureDateYear
							+ ", departureDateMonth=" + departureDateMonth
							+ ", departureDateDay=" + departureDateDay
							+ ", departureDateHour=" + departureDateHour
							+ ", departureDateMinute=" + departureDateMinute
							+ ", arrivalDateYear=" + arrivalDateYear
							+ ", arrivalDateMonth=" + arrivalDateMonth
							+ ", arrivalDateDay=" + arrivalDateDay
							+ ", arrivalDateHour=" + arrivalDateHour
							+ ", arrivalDateMinute=" + arrivalDateMinute
							+ ", seats=" + seats
							+ ", price=" + price
							+ " WHERE FlugID=\"" + reqFlightId + "\"";
					System.out.println(sql);
					PreparedStatement update =  (PreparedStatement) connection.prepareStatement(sql);
					update.executeUpdate();
					response.sendRedirect("updateFlightSuccess.jsp");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
			}

			else{
				response.getWriter().append("<div class=\"container\"> " + 
					" <form action=\"UpdateFlight\" method=\"post\">" +

					" Flug ID: <input name=\"flightId\" value=\"" + flightId + "\" disabled><br>" + 
					" destination: <input name=\"destination\" value=\"" + destination + "\"><br>" + 
					" origin: <input name=\"origin\" value=\"" + origin + "\"><br>" + 
					" departureDateYear: <input name=\"departureDateYear\" value=\"" + departureDateYear + "\"><br>" + 
					" departureDateMonth: <input name=\"departureDateMonth\" value=\"" + departureDateMonth + "\"><br>" + 
					" departureDateDay: <input name=\"departureDateDay\" value=\"" + departureDateDay + "\"><br>" + 
					" departureDateHour: <input name=\"departureDateHour\" value=\"" + departureDateHour + "\"><br>" + 
					" departureDateMinute: <input name=\"departureDateMinute\" value=\"" + departureDateMinute + "\"><br>" + 
					" arrivalDateYear: <input name=\"arrivalDateYear\" value=\"" + arrivalDateYear + "\"><br>" + 
					" arrivalDateMonth: <input name=\"arrivalDateMonth\" value=\"" + arrivalDateMonth + "\"><br>" + 
					" arrivalDateDay: <input name=\"arrivalDateDay\" value=\"" + arrivalDateDay + "\"><br>" + 
					" arrivalDateHour: <input name=\"arrivalDateHour\" value=\"" + arrivalDateHour + "\"><br>" + 
					" arrivalDateMinute: <input name=\"arrivalDateMinute\" value=\"" + arrivalDateMinute + "\"><br>" + 
					" seats: <input name=\"seats\" value=\"" + seats + "\"><br>" + 
					" price: <input name=\"price\" value=\"" + price + "\"><br>" + 
					
					" <br><br> "+
					"<input type=\"hidden\" name=\"update\" value=\"" + reqFlightId + "\">" + 
					"<input type=\"hidden\" name=\"hid\" value=\"true\">"+
					"<input type=\"submit\" value=\"bearbeiten\"><br>" +
					"<a href=\"index.jsp\">zurueck zur Hauptseite </a> <br>" +
					"</form>" +
					"</div>");
			}
	}
}

		
	
		

