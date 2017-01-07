<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel ="stylesheet" href = "/PE2I/css/main.css"/>
<link rel ="stylesheet" href = "/PE2I/css/accueil.css"/>	
<title>PE2I - Accueil</title>
</head>

	<div class="baniere">
		<img  src="/PE2I/images/general/logo.png">
	</div>
<body>

<div class="general">

	<div class="divmenu">
	
		<ul class="nav">
			<li><a href="/PE2I/restreint/forum">Forum</a></li>
			<li>Espace etudiant/prof</li>
			<li><a href="/PE2I/restreint/rechercheMembre">Rechercher membre</li>
			<li><a href="/PE2I/restreint/moncompte">Mon compte</li>
			<li><a href="/PE2I/deconnexion">Se deconnecter</a></li>
		</ul>
	</div>

	<div class="news">
		<div class="newsSujets">
			 <table class="tabNewsSujets">
			 		<caption>Derniers sujets ouverts</caption>
	                <c:forEach items="${ listeSujets }" var="sujets">
	                <tr>
	                    <td>
	                    <c:choose>
	                    	<c:when test="${ sujets.forum == 'Travaux Pratiques'}"><c:out value="TP"/></c:when>
	                    	<c:when test="${ sujets.forum == 'Cours'}"><c:out value="CM"/></c:when>
	                    	<c:when test="${ sujets.forum == 'Travaux Dirigés'}"><c:out value="TD"/></c:when>
	                    </c:choose>
	                    </td>
	                    <td><c:out value="N°${ sujets.numero } : ${ sujets.nom }"/></td>
	                    <td>Date</td>
	                </tr>
	                </c:forEach>
	         </table>
	    </div>
	    <div class="newsModifs">
			 <table class="tabNewsModifs">
					<caption>Dernières modifications du site</caption>
	                <c:forEach items="${ listeSujets }" var="sujets">
	                <tr>
	                    <td>
	                    <c:choose>
	                    	<c:when test="${ sujets.forum == 'Travaux Pratiques'}"><c:out value="TP"/></c:when>
	                    	<c:when test="${ sujets.forum == 'Cours'}"><c:out value="CM"/></c:when>
	                    	<c:when test="${ sujets.forum == 'Travaux Dirigés'}"><c:out value="TD"/></c:when>
	                    </c:choose>
	                    </td>
	                    <td><c:out value="N°${ sujets.numero } : ${ sujets.nom }"/></td>
	                    <td>Date</td>
	                </tr>
	                </c:forEach>
	         </table>
	    </div>
	</div>

</div>
	
</body>

</html>