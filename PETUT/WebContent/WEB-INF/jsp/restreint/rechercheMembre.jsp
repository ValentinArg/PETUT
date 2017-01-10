<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel ="stylesheet" href = "/PE2I/css/rechercheMembre.css"/>
<link rel ="stylesheet" href = "/PE2I/css/main.css"/>	
<title>PE2I - Recherche membre</title>
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
	
	<div class="searchform">
		<form method="post" action="rechercheMembre">
			<label><c:out value="${resultat}"/>  &nbsp</label><input type="text" name="nom" required/>
			<input type="submit" value="Rechercher" class="button"/>	
		</form>
	</div>

	
	<c:if test="${utilisateur != null }">
	<div class="infomembre">
		<ul class="infos">
			<li>Identifiant... <b><c:out value="${ utilisateur.id_Utilisateur }"/></b></li>
			<li>Nom... <b><c:out value="${ utilisateur.nom }"/></b></li>
			<li>Prénom... <b><c:out value="${ utilisateur.prenom }"/></b></li>
			<li>Groupe... <b><c:out value="${ utilisateur.groupe}"/></b>  &nbsp Semestre... <b><c:out value="${ utilisateur.semestre}"/></b></li>
			<li>Date de naissance... <b><c:out value=" ${ utilisateur.datenaissance }"/></b></li>
			<li>Ville... <b><c:out value=" ${ utilisateur.ville }"/></b></li>
			<li>Téléphone... <b><c:out value="0${ utilisateur.telephone }"/></b></li>
			<li>Adresse mail... <b><c:out value="${ utilisateur.adressemail}"/></b></li>
		</ul>
	</div></c:if>
	
	
<footer>
	<c:import url="/WEB-INF/jsp/restreint/footer.jsp" />
</footer>
</div>


</body>
</html>