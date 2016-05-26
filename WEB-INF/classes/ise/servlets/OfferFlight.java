package ise.servlets;


        import java.io.IOException;
        import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.PreparedStatement;
        import java.sql.SQLException;
        import java.util.Calendar;
        import java.util.GregorianCalendar;

        import javax.servlet.ServletException;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OfferFlight
 */

public class OfferFlight extends HttpServlet {
    private static final long serialVersionUID = 2244732469487419265L;


    /**
     * @see HttpServlet#HttpServlet()
     */
    public OfferFlight() {
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
        response.getWriter().append("Offer Flight Servlet");


        try{
            Integer.parseInt(request.getParameter("departureDateYear"));
            Integer.parseInt(request.getParameter("departureDateMonth"));
            Integer.parseInt(request.getParameter("departureDateDay"));
            Integer.parseInt(request.getParameter("departureDateHour"));
            Integer.parseInt(request.getParameter("departureDateMinute"));
            Integer.parseInt(request.getParameter("arrivalDateMonth"));
            Integer.parseInt(request.getParameter("arrivalDateDay"));
            Integer.parseInt(request.getParameter("arrivalDateHour"));
            Integer.parseInt(request.getParameter("arrivalDateMinute"));
        }catch (NumberFormatException e) {
            response.getWriter().append("Bitte eine Zahl für das Datum eingeben");
            return;
        }

        Calendar dateDeparture=new GregorianCalendar(Integer.parseInt(request.getParameter("departureDateYear")),
                Integer.parseInt(request.getParameter("departureDateMonth")),
                Integer.parseInt(request.getParameter("departureDateDay")),
                Integer.parseInt(request.getParameter("departureDateHour")),
                Integer.parseInt(request.getParameter("departureDateMinute")));
        Calendar dateArrival=new GregorianCalendar(Integer.parseInt(request.getParameter("arrivalDateYear")),
                Integer.parseInt(request.getParameter("arrivalDateMonth")),
                Integer.parseInt(request.getParameter("arrivalDateDay")),
                Integer.parseInt(request.getParameter("arrivalDateHour")),
                Integer.parseInt(request.getParameter("arrivalDateMinute")));


        //Die FlugId wird eine Kombination aus UserId uns FlugId sein
        // Wird natürlich dementsprechen noch angepasst

        //	String flightId=userId + request.getParameter("flightId");
        //	String userId = (String)session.getAttribute("user_id");

        String flightId=request.getParameter("flightId");
        String origin=request.getParameter("origin");
        String destination=request.getParameter("destination");

        int seats=Integer.parseInt(request.getParameter("seats"));
        double price=Double.parseDouble(request.getParameter("price"));

        String query = "insert into Flug(FlugId, destination, origin, departureDateYear, departureDateMonth"
                + ", departureDateDay, departureDateHour, departureDateMinute, "
                + "arrivalDateYear, arrivalDateMonth, arrivalDateDay, arrivalDateHour, "
                + "arrivalDateMinute, seats, price) values( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try{


            String driver  = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/easyFlightDB";
            String username="root";
            String password="root";
            Class.forName(driver);


            Connection connection =DriverManager.getConnection(url, username, password);


            PreparedStatement create = connection.prepareStatement
                    ("CREATE TABLE IF NOT EXISTS Flug(FlugId VARCHAR(225)  NOT NULL, destination VARCHAR(225), origin VARCHAR(225), departureDateYear int, departureDateMonth"
                            + " int, departureDateDay int, departureDateHour int, departureDateMinute int,"
                            + "arrivalDateYear int, arrivalDateMonth int, arrivalDateDay int,"
                            + " arrivalDateHour int, "
                            + "arrivalDateMinute int, seats int, price double, PRIMARY KEY (FlugId))");

            create.executeUpdate();

            PreparedStatement newFlight=connection.prepareStatement(query);
            newFlight.setString(1, flightId);
            newFlight.setString(2, request.getParameter("destination"));
            newFlight.setString(3, request.getParameter("origin"));
            newFlight.setInt(4, Integer.parseInt(request.getParameter("departureDateYear")));
            newFlight.setInt(5, Integer.parseInt(request.getParameter("departureDateMonth")));
            newFlight.setInt(6, Integer.parseInt(request.getParameter("departureDateDay")));
            newFlight.setInt(7, Integer.parseInt(request.getParameter("departureDateHour")));
            newFlight.setInt(8, Integer.parseInt(request.getParameter("departureDateMinute")));

            newFlight.setInt(9, Integer.parseInt(request.getParameter("arrivalDateYear")));
            newFlight.setInt(10, Integer.parseInt(request.getParameter("arrivalDateMonth")));
            newFlight.setInt(11, Integer.parseInt(request.getParameter("arrivalDateDay")));
            newFlight.setInt(12, Integer.parseInt(request.getParameter("arrivalDateHour")));
            newFlight.setInt(13, Integer.parseInt(request.getParameter("arrivalDateMinute")));

            newFlight.setInt(14, seats);
            newFlight.setDouble(15, price);
            newFlight.executeUpdate();


            response.getWriter().append("Flug erfolgreich erstellt"
                    + "<br><br> Flug Id: " + flightId +
                    "<br>Origin " + origin +
                    "<br>Destination: " + destination +
                    "<br>Anzahl der Sitzplatze: " + seats +
                    "<br>Preis: " + price +

                    "<br><br>\nDepartureTimeYear: " + dateDeparture.get(Calendar.YEAR) +
                    "<br>\n DepartureTimeMonth: " + (dateDeparture.get(Calendar.MONTH)+1) +
                    "<br>\n DepartureDateDay: " + dateDeparture.get(Calendar.DAY_OF_MONTH) +
                    "<br>\n DepartureHour: " + dateDeparture.get(Calendar.HOUR_OF_DAY) +
                    "<br>\n DepartureDateMinute: " + dateDeparture.get(Calendar.MINUTE) +

                    "<br><br>\n ArrivalTimeYear: " + dateArrival.get(Calendar.YEAR) +
                    "<br>\n ArrivalTimeMonth: " + (dateArrival.get(Calendar.MONTH)+1) +
                    "<br>\n ArrivalDateDay " + dateArrival.get(Calendar.DAY_OF_MONTH) +
                    "<br>\n ArrivalDateHour: " + dateArrival.get(Calendar.HOUR_OF_DAY) +
                    "<br>\n ArrivalDateMinute: " + dateArrival.get(Calendar.MINUTE) + "<br><br>");

            response.getWriter().append("<br><b><br><a href=\"index.jsp\">Zurueck zur Hauptseite</a><br>");



        } catch(SQLException e){
            System.out.println("ODER HIER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            if(e.getErrorCode()==1062){
                System.out.println("Bin ich da?!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                response.getWriter().append("Die ID " + flightId + " ist schon vorhanden. Bitte eine neue eingeben");
                response.getWriter().append("<br><b><br><a href=\"offerFlight.jsp\">Zurueck</a><br>");

            }
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}

