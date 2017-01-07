<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel ="stylesheet" href = "/PE2I/css/main.css"/>
<link rel ="stylesheet" href = "/PE2I/css/accueil.css"/>	
<title>PE2I - Recherche membre</title>
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
			<li>Rechercher membre</li>
			<li><a href="/PE2I/restreint/moncompte">Mon compte</a></li>
			<li><a href="/PE2I/deconnexion">Se deconnecter</a></li>
		</ul>
	</div>
	
	<div class="searchform">
		<form method="post" action="rechercheMembre">
			<label>Nom : </label><input type="text" name="nom"/>
			<input type="submit" value="Rechercher" class="sansLabel"/>	
		</form>
	</div>

	<c:if test="${param.resultat == 'entree'}"><c:out value="Entrez un nom"/></c:if>
	<c:if test="${param.resultat == 'vide'}"><c:out value="Pas de membre"/></c:if>
	<div class="infomembre">
		<ul class="infos">
			<c:forEach items="${ listeUtilisateurs }" var="utilisateurs">
			<li><c:out value="Identifiant : ${ utilisateurs.id_Utilisateur }"/></li>
			<li><c:out value="Nom : ${ utilisateurs.nom }"/></li>
			<li><c:out value="Prenom : ${ utilisateurs.prenom }"/></li>
			<li><c:out value="Date de naissance : ${ utilisateurs.datenaissance }"/></li>
			<li><c:out value="Adresse : ${ utilisateurs.adresse }"/></li>
			<li><c:out value="Code postal : ${ utilisateurs.codepostal }"/></li>
			<li><c:out value="Ville : ${ utilisateurs.ville }"/></li>
			<li><c:out value="Telephone : 0${ utilisateurs.telephone }"/></li>
			<li><c:out value="Adresse mail : ${ utilisateurs.adressemail}"/></li>
			</c:forEach>
		</ul>
	</div>
</div>

</body>
</html>