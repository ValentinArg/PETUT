<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel ="stylesheet" href = "/PE2I/css/main.css"/>
<link rel ="stylesheet" href = "/PE2I/css/modifierCompte.css"/>	
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
		<form method="post" action="modifiercompte">
		   	<fieldset> 
		   		<h2>Modification des informations de compte</h2>   
		     	<label for="nom">Adresse :  </label>
		           <input type="text" name="adresse" value="<c:out value="${ utilisateur.adresse }"/>"/>
		        <br /> 
		        <label for="nom">Code postal : </label>
		           <input type="text" pattern="^[0-9]{5}$" name="codepostal" value="<c:out value="${ utilisateur.codepostal }"/>"/>
		        <br />
		        <label for="nom">Ville : </label>
		           <input type="text" name="ville" value="<c:out value="${ utilisateur.ville }"/>"/>
		        <br /> 
		        <label for="nom">Téléphone : </label>
		           <input type="tel" pattern="^((\+\d{1,3}(-| )?\(?\d\)?(-| )?\d{1,5})|(\(?\d{2,6}\)?))(-| )?(\d{3,4})(-| )?(\d{4})(( x| ext)\d{1,5}){0,1}$" name="telephone" value="<c:out value="0${ utilisateur.telephone }"/>"/>
		        <br />  
		        <label for="nom">Adresse mail : </label>
		           <input type="email" name="adressemail" value="<c:out value="${ utilisateur.adressemail }"/>"/>
		        <br />       
		           <input type="submit" value="Confirmer" class="sansLabel"/>	                   
		     </fieldset>
		</form>
	</div>
	
	
	<footer>
	<c:import url="/WEB-INF/jsp/restreint/footer.jsp" />
</footer>
</div>

</body>
</html>
