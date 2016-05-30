package ise.servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import java.util.ArrayList;
import java.util.Date;
import java.text.*;
import ise.*;



public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = -2244732469487419265L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("nachricht.jsp");
		view.forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		ServiceManagement service=new ServiceManagement();
		HttpSession session=request.getSession();
		String submitValue=request.getParameter("submit");
		String username = session.getAttribute("session_username");
		if(!username.isEmpty){			
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
		else{
			RequestDispatcher view = request.getRequestDispatcher("Info.jsp");
			view.forward(request, response);
			
		}



	}

}