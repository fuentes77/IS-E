<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>offerFlightjsp</title>
</head>
<body>

	<h2>Offer Flight Servlet</h2>

	<div class="container">
		<form action="OfferFlight" method="post">

			Flug ID: <input name="flightId" value="flugID"><br>
			Destination <input name="destination" value="Salzburg"><br>
			Origin: <input name="origin" value="Wien"><br>
			Anzahl der sitzplätze <input name="seats" value="10"><br>
			Preis <input name="price" value="150"><br>
		
			<br> Departure Year: <input type="text" name="departureDateYear" placeholder="YYYY" value="2017" maxlength="4">
	Departure Month: <select name="departureDateMonth">
			<option value="0">January</option>
			<option value="1">February</option>
			<option value="2">March</option>
			<option value="3">April</option>
			<option value="4">May</option>
			<option value="5">June</option>
			<option value="6">July</option>
			<option value="7">August</option>
			<option value="8">September</option>
			<option value="9">October</option>
			<option value="10">November</option>
			<option value="11">December</option>
		</select>
		Departure Day: <input type="text" name="departureDateDay" placeholder="DD" value="09" maxlength="2"><br>
		             Departure Stunde: <input type="text" name="departureDateHour" placeholder="HH" value="20" maxlength="2">
		Departure Minute: <input type="text" name="departureDateMinute" placeholder="MM" value="10" maxlength="2">
		<br><br>
			Arrival Year:<input type="text" name="arrivalDateYear" placeholder="YYYY" value="2017" maxlength="4" >
		Arrival Month: <select name="arrivalDateMonth">
			<option value="0">January</option>
			<option value="1">February</option>
			<option value="2">March</option>
			<option value="3">April</option>
			<option value="4">May</option>
			<option value="5">June</option>
			<option value="6">July</option>
			<option value="7">August</option>
			<option value="8">September</option>
			<option value="9">October</option>
			<option value="10">November</option>
			<option value="11">December</option>
		</select>
		Arrival Day: <input type="text" name="arrivalDateDay" placeholder="DD" value="10" maxlength="2"><br>
		Arrival Stunde: <input type="text" name="arrivalDateHour" placeholder="HH" value="21" maxlength="2">
		Arrival Minute: <input type="text" name="arrivalDateMinute" placeholder="MM" value="11" maxlength="2"> <br>
		
		<br><br>
		
		<input type="submit" value="anbieten"><br>
		</form>
		<a href="index.jsp">Zurueck</a>
	</div>
</body>
</html>