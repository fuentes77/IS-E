package Servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.NachrichtManagement;
import Modell.Nachricht;
import Controller.UserManagement;
import Modell.User;
/**
 * Servlet implementation class FlugSpeichernServlet
 */
@WebServlet("/NachrichtSenden")
public class NachrichtSenden extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NachrichtSenden() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("nachricht.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
						
			String von = request.getParameter("von");
			String zu = request.getParameter("zu");
			String nachricht = request.getParameter("nachricht");
			
			
				NachrichtManagement nm = new NachrichtManagement ();
				// muss ein Methode in UserManagement dass , user bey Username nach suchen und züruckliefert User 
				UserManagement um = new UserManagement();
				nm.nachrichtSenden(um.getUserByName(von), um.getUserByName(zu), nachricht);
				request.setAttribute("infoText", "nachricht wurde erfolgreich gespeichert");
				RequestDispatcher view = request.getRequestDispatcher("Info.jsp");
			view.forward(request, response);
	}

}
