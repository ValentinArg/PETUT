<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	<link rel ="stylesheet" href = "/PE2I/css/main.css"/>
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  	
</head>
<body>
	<div class=enTete>
		<p class="boutonHautBas" id="boutonHautBas">Module</p>
		<ul class="nav" id="nav">
			<c:forEach var="forum" items="${listeForum}">
				<li class=" partie"><a class="forum" id="${forum.id}"><c:out value="${forum.nom}"/></a></li>
			</c:forEach>
			<!-- <li class="partie" id="banniere"><a>PETUT</a></li>-
			<li class=" partie"><a class="forum" id="1">Cours</a></li>
			<li class="partie"><a class="forum" id="2">Travaux Dirigées</a></li>
			<li class="partie"><a class="forum" id="3">Travaux Pratiques</a></li>
			<li class="partie"><a class="forum" id="4">Partiels</a></li>
			<li class="partie"><a>Mon Compte</a></li>-->
		</ul>
	</div>
	
</body>
</html>