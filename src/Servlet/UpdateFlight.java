package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class UpdateFlight
 */
@WebServlet("/UpdateFlight")
public class UpdateFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		String url = "jdbc:mysql://localhost:3306/easyFlightDB";
		String username="root";
		String password="root";

			
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
			
			try {
				Class.forName(driver);
				
				Connection connection =DriverManager.getConnection(url, username, password);
				
				String reqFlightId=request.getParameter("update");
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
				System.out.println("und nun?");
			}
			else{
				response.getWriter().append("<div class=\"container\"> " + 
					" <form action=\"UpdateFlight\" method=\"post\">" +

					" Flug ID: <input name=\"flightId\" value=\"" + flightId + "\" disabled><br>" + 
					" destination: <input name=\"flightId\" value=\"" + destination + "\"><br>" + 
					" origin: <input name=\"flightId\" value=\"" + origin + "\"><br>" + 
					" departureDateYear: <input name=\"flightId\" value=\"" + departureDateYear + "\"><br>" + 
					" departureDateMonth: <input name=\"flightId\" value=\"" + departureDateMonth + "\"><br>" + 
					" departureDateDay: <input name=\"flightId\" value=\"" + departureDateDay + "\"><br>" + 
					" departureDateHour: <input name=\"flightId\" value=\"" + departureDateHour + "\"><br>" + 
					" departureDateMinute: <input name=\"flightId\" value=\"" + departureDateMinute + "\"><br>" + 
					" arrivalDateYear: <input name=\"flightId\" value=\"" + arrivalDateYear + "\"><br>" + 
					" arrivalDateMonth: <input name=\"flightId\" value=\"" + arrivalDateMonth + "\"><br>" + 
					" arrivalDateDay: <input name=\"flightId\" value=\"" + arrivalDateDay + "\"><br>" + 
					" arrivalDateHour: <input name=\"flightId\" value=\"" + arrivalDateHour + "\"><br>" + 
					" arrivalDateMinute: <input name=\"flightId\" value=\"" + arrivalDateMinute + "\"><br>" + 
					" destination: <input name=\"flightId\" value=\"" + destination + "\"><br>" + 
					" seats: <input name=\"flightId\" value=\"" + seats + "\"><br>" + 
					" price: <input name=\"flightId\" value=\"" + price + "\"><br>" + 
					
					" <br><br> "+
					"<input type=\"hidden\" name=\"hid\" value=\"true\">"+
					"<input type=\"submit\" value=\"bearbeiten\"><br>" +
					"<a href=\"index.jsp\">zurueck zur Hauptseite </a> <br>" +
					"</form>" +
					"</div>");
			}
	}
}

		
	
		

