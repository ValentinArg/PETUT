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
			<label>Nom : </label><input type="text" name="nom" required/>
			<input type="submit" value="Rechercher" class="sansLabel"/>	
		</form>
	</div>

	<c:out value="${resultat}"/>
	<c:if test="${utilisateur != null }">
	<div class="infomembre">
		<ul class="infos">
			<li><c:out value="Identifiant : ${ utilisateur.id_Utilisateur }"/></li>
			<li><c:out value="Nom : ${ utilisateur.nom }"/></li>
			<li><c:out value="Prenom : ${ utilisateur.prenom }"/></li>
			<li><c:out value="Groupe ${ utilisateur.groupe } Semestre ${ utilisateur.semestre } "/></li>
			<li><c:out value="Date de naissance : ${ utilisateur.datenaissance }"/></li>
			<li><c:out value="Ville : ${ utilisateur.ville }"/></li>
			<li><c:out value="Telephone : 0${ utilisateur.telephone }"/></li>
			<li><c:out value="Adresse mail : ${ utilisateur.adressemail}"/></li>
		</ul>
	</div></c:if>
	
	
<footer>
	<c:import url="/WEB-INF/jsp/restreint/footer.jsp" />
</footer>
</div>


</body>
</html>