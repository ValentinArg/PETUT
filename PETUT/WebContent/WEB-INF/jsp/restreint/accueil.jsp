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


<body>

<header>
	<img src="/PE2I/images/general/logo.png" alt="banniere" class="banniere">
	<img style="float:right" src="/PE2I/images/general/logoiut.jpg" alt="logoiut" class="logoiut">
</header>

<nav>
	<c:import url="/WEB-INF/jsp/restreint/menu.jsp" />
</nav>

<div class="general">

	<div class="news">
		<div class="newsSujets">
			 <table class="tabNewsSujets">
			 		<caption>Derniers sujets ouverts</caption>
	                <c:forEach items="${ listeSujets }" var="sujets">
	                <tr>
	                    <td>
	                    <c:choose>
	                    	<c:when test="${ sujets.type == 'Travaux Pratiques'}"><c:out value="TP"/></c:when>
	                    	<c:when test="${ sujets.type == 'Cours'}"><c:out value="CM"/></c:when>
	                    	<c:when test="${ sujets.type == 'Travaux Dirigés'}"><c:out value="TD"/></c:when>
	                    </c:choose>
	                    </td>
	                    <td><c:out value="${ sujets.module } : ${sujets.numero}) ${ sujets.nom }"/></td>
	                    <td><c:out value="Le ${ sujets.date }"/></td>
	                </tr>
	                </c:forEach>
	         </table>
	    </div>
	    <div class="newsModifs">
			 <table class="tabNewsModifs">
					<caption>Dernières modifications du site</caption>
					 <c:forEach items="${ listeModifications }" var="modifs">
	                <tr>
	                    <td>
	                    <c:choose>
	                    	<c:when test="${ modifs.type == 'nouveaute'}"><c:out value="NEW"/></c:when>
	                    	<c:when test="${ modifs.type == 'maintenance'}"><c:out value="REPARE"/></c:when>
	                    </c:choose>
	                    </td>
	                    <td><c:out value="${modifs.libelle }"/></td>
	                    <td><c:out value="Le ${ modifs.date }"/></td>
	                </tr>
	                </c:forEach>
	         </table>
	    </div>
	</div>
	
	<footer>
	<c:import url="/WEB-INF/jsp/restreint/footer.jsp" />
</footer>	
	
</div>
	

	
</body>
</html>