package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class DeleteClass
 */
@WebServlet("/DeleteFlight")
public class DeleteFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteFlight() {
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
		
		
		
		
		try {
			
			String driver  = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/easyFlightDB";
			String username="root";
			String password="root";
			Class.forName(driver);
			Connection connection =DriverManager.getConnection(url, username, password);
			
			String reqFlightId=request.getParameter("loeschen");
			System.out.println(reqFlightId);
			
			PreparedStatement ps=connection.prepareStatement("DELETE FROM Flug WHERE FlugId = \"" +reqFlightId + "\"");
			ps.execute();
			
			response.getWriter().append("Der Flug mit der Id "  + reqFlightId + " wurde erfolgreich geloescht "
					+ "<br> <br> <a href=\"index.jsp\"> Zurück zur Hauptseite");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
