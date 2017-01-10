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

	<div class="accueil">
		<p><b>Bienvenue <i><c:out value="${utilisateur.prenom} ${utilisateur.nom } "/></i>!</b></br> Vous êtes sur le site PE2I: Plateforme d'Echange Intra IUT.</p>
	</div>
	
	<div class="news">
		<div class="newsSujets">
			 <table class="tabNewsSujets">
			 		<caption><img src="/PE2I/images/iconenews.png" alt="iconenews" class="iconenews">Derniers sujets ouverts</caption>
	                <c:forEach items="${ listeSujets }" var="sujets" varStatus="boucle">
	                <tr class="${boucle.index % 2 == 0 ? 'pair' : 'impair'}">
	                    <td class="icone">
	                    <c:choose>
	                    	<c:when test="${ sujets.type == 'Travaux Pratiques'}"><img src="/PE2I/images/iconetp.png" alt="iconetp" title="Travaux Pratiques"/></c:when>
	                    	<c:when test="${ sujets.type == 'Cours'}"><img src="/PE2I/images/iconecm.jpg" alt="iconecm"  title="Cours Magistraux"/></c:when>
	                    	<c:when test="${ sujets.type == 'Travaux Dirigés'}"><img src="/PE2I/images/iconetd.png" alt="iconetd"  title="Travaux Dirigés"/></c:when>
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
					<caption><img src="/PE2I/images/inconemaint.png" alt="iconemaint" class="iconenews">Dernières modifications du site</caption>
					 <c:forEach items="${ listeModifications }" var="modifs" varStatus="boucle">
	                <tr class="${boucle.index % 2 == 0 ? 'pair' : 'impair'}">
	                    <td class="icone">
	                    <c:choose>
	                    	<c:when test="${ modifs.type == 'nouveaute'}"><img src="/PE2I/images/nouveau.jpg" alt="nouveau" title="Nouveauté"/></c:when>
	                    	<c:when test="${ modifs.type == 'maintenance'}"><img src="/PE2I/images/repare.png" alt="repare" title="Correction"/></c:when>
	                    </c:choose>
	                    </td>
	                    <td><c:out value="${modifs.libelle }"/></td>
	                    <td><c:out value="Le ${ modifs.date }"/></td>
	                </tr>
	                </c:forEach>
	         </table>
	    </div>
	</div>
</div>

<footer>
	<c:import url="/WEB-INF/jsp/restreint/footer.jsp" />
</footer>	
		
</body>
</html>