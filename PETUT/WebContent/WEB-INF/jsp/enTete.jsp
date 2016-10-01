<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	<link rel ="stylesheet" href = "/PETUT/css/main.css"/>
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  	
</head>
<body>
	<div class="conteneurEnTete">
		<img  id="derouleur" class= "derouleur" src = "/PETUT/images/menu.png"/>
		<ul class="nav" id="nav">
			<li class="partie"><a>Accueil</a></li>
			<li class="partie"><a>Première Année</a></li>
			<li class="partie"><a>Deuxième Année</a></li>
		</ul>
	</div>
	
	 <script>
		 var left = true;
		 $( "#nav" ).animate({left: "-500px"});
		 // run the currently selected effect
		 function runEffect() {
		 	if(left){
		 		$( "#nav" ).animate({left: "0px"},1000);
		 		left=false;
		 	}
		 	else{
		 		$( "#nav" ).animate({left: "-500px"},1000);
		 		left=true;
		 	}
		 }

	 </script>

</body>
</html>