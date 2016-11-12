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

<header>
<h1>PE2I</h1>
</header>

<body>

<div class="general">

	<div class="divmenu">
	
		<ul class="nav">
			<li class="navforum"><a href="/PE2I/restreint/forum">Forum</a></li>
			<li class="navspace">Espace etudiant/prof</li>
			<li class="navsearch">Rechercher membre</li>
			<li class="navcompte">Mon compte</li>
			<li class="navdeco"><a href="/PE2I/deconnexion">Se deconnecter</a></li>
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
	                    	<c:when test="${ sujets.forum == 'Travaux Dirig�s'}"><c:out value="TD"/></c:when>
	                    </c:choose>
	                    </td>
	                    <td><c:out value="N�${ sujets.numero } : ${ sujets.nom }"/></td>
	                    <td>Date</td>
	                </tr>
	                </c:forEach>
	         </table>
	    </div>
	    <div class="newsModifs">
			 <table class="tabNewsModifs">
					<caption>Derni�res modifications du site</caption>
	                <c:forEach items="${ listeSujets }" var="sujets">
	                <tr>
	                    <td>
	                    <c:choose>
	                    	<c:when test="${ sujets.forum == 'Travaux Pratiques'}"><c:out value="TP"/></c:when>
	                    	<c:when test="${ sujets.forum == 'Cours'}"><c:out value="CM"/></c:when>
	                    	<c:when test="${ sujets.forum == 'Travaux Dirig�s'}"><c:out value="TD"/></c:when>
	                    </c:choose>
	                    </td>
	                    <td><c:out value="N�${ sujets.numero } : ${ sujets.nom }"/></td>
	                    <td>Date</td>
	                </tr>
	                </c:forEach>
	         </table>
	    </div>
	</div>

</div>
	
</body>

</html>