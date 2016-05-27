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

import Controller.FlugManagement;
import Modell.Flug;

/**
 * Servlet implementation class FlugSpeichernServlet
 */
@WebServlet("/FlugErstellen")
public class FlugErstellen extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FlugErstellen() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("flugerstellen.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
						
			String abflug = request.getParameter("abflug");
			String ankunft = request.getParameter("ankunft");
			double preis = 0 ;
			int sitzAnzahl = 0 ;
			if(!request.getParameter("preis").equals("")){
				preis = Double.parseDouble(request.getParameter("preis"));
			}
			if(!request.getParameter("sitzAnzahl").equals(""))
				sitzAnzahl = Integer.parseInt(request.getParameter("sitzAnzahl"));
			
				FlugManagement fm = new FlugManagement();
				fm.createFlug(abflug, ankunft, preis, sitzAnzahl);
				request.setAttribute("infoText", "Flug wurde erfolgreich gespeichert");
				RequestDispatcher view = request.getRequestDispatcher("Info.jsp");
			view.forward(request, response);
	}

}
