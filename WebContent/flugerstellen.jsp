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
<form action="FlugErstellen" method="post">
  
   <div class="form-group">
    <label for="source">Abflugort:</label>
    <input type="text" class="form-control" id="abflug" name="abflug" placeholder="abflug" data-validation="alphanumeric" data-validation-error-msg="Bitte geben Sie eine gültige Flugsource ein!">
  </div>
  <div class="form-group">
    <label for="destination">Destination:</label>
    <input type="text" class="form-control" id="ankunft" name="ankunft" placeholder="ankunft" data-validation="alphanumeric" data-validation-error-msg="Bitte geben Sie eine gültige Flugdestination ein!">
  </div>
  
  <div class="form-group">
    <label for="preis">Preis:</label>
    <input type="text" class="form-control" id="preis" name="preis" placeholder="preis" data-validation="number" data-validation-decimal-separator="." data-validation-allowing="range[1;100000],float" data-validation-error-msg="Bitte geben Sie eine gültige Flugpreis ein!">
  </div>
 
  <div class="form-group">
    <label for="anzahlPl">Anzahl Plätze:</label>
    <input type="text" class="form-control" id="sitzAnzahl" name="sitzAnzahl" placeholder="Anzahl Plätze" data-validation="number" data-validation-allowing="range[1;100000]" data-validation-error-msg="Bitte geben Sie eine gültige Flugcapacity ein!">
  </div>
  
  
  <button type="submit" class="btn btn-default">Speichern</button>
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