<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel ="stylesheet" href = "/PE2I/css/main.css"/>
<link rel ="stylesheet" href = "/PE2I/css/moncompte.css"/>	
<title>PE2I - Mon compte</title>
</head>

<body>


<header>
	<img src="/PE2I/images/general/logo.png" alt="banniere" class="banniere">
</header>

<nav>
	<c:import url="/WEB-INF/jsp/restreint/menu.jsp" />
</nav>

<div class="general">
	
	<div class="divinfoscompte">
		<ul class="infos">
			<c:forEach items="${ listeUtilisateur }" var="utilisateur">
			<li><c:out value="Identifiant : ${ utilisateur.id_Utilisateur }"/></li>
			<li><c:out value="Nom : ${ utilisateur.nom }"/></li>
			<li><c:out value="Prenom : ${ utilisateur.prenom }"/></li>
			<li><c:out value="Groupe ${ utilisateur.groupe} Semestre ${ utilisateur.semestre}"/></li>
			<li><c:out value="Date de naissance : ${ utilisateur.datenaissance }"/></li>
			<li><c:out value="Adresse : ${ utilisateur.adresse }"/></li>
			<li><c:out value="Code postal : ${ utilisateur.codepostal }"/></li>
			<li><c:out value="Ville : ${ utilisateur.ville }"/></li>
			<li><c:out value="Telephone : 0${ utilisateur.telephone }"/></li>
			<li><c:out value="Adresse mail : ${ utilisateur.adressemail}"/></li>
			</c:forEach>
		</ul>
		<a href="/PE2I/restreint/modifiercompte">Modifier les informations</a>
	</div>
	
</div>


</body>
</html>