<!DOCTYPE html>
<html lang="en">

<%
@SuppressWarnings("unchecked")
String infoText = (String) request.getAttribute("infoText");
%>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>easyReisen</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    
  
  </head>
  <body>
  
<div class="container">
<div class="col col-sm-1"></div>
<div class="col col-sm-8">
<div class="col col-md-2"></div>
<div class="col col-md-6">
<div class="panel panel-danger">
  
  <div class="panel-footer">  
   <br />
  </div>
  </div>
  
</div>
<form action="NachrichtSenden" method="post">
  
   <div class="form-group">
    <label for="source">Absender :</label>
    <input type="text" class="form-control" id="von" name="von" placeholder="absender">
  </div>
  <div class="form-group">
    <label for="destination">An:</label>
    <input type="text" class="form-control" id="zu" name="zu" placeholder="an">
  </div>
  
  <div class="form-group">
    <label for="anzahlPl">Nachricht:</label>
   <TEXTAREA class="form-control" id="nachricht" name="nachricht" placeholder="nachricht"  COLS=40 ROWS=6>
   </TEXTAREA>
  </div>
  
  
  <button type="submit" class="btn btn-default">sennden</button>
</form>
	
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-form-validator/2.2.8/jquery.form-validator.min.js"></script>
<script> $.validate(); </script>
</div>
</div>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>