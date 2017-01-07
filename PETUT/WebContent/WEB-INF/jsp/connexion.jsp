<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel ="stylesheet" href = "/PE2I/css/connexion.css"/>	
<title>PE2I - Connexion</title>
</head>

<header>
<h1>PE2I - Connexion</h1>
</header>

<body>
	<div class="connexion">
		<form method="post" action="connexion">
		   	<fieldset> 
		   		<h2>Connexion</h2>               
				<label for="identifiant" class="id"></label>
		           <input type="text" name="identifiant" size="30" maxlength="60" placeholder="Identifiant ..."/>
		           <span class="erreur">${traitement.erreurs['identifiant']}</span>
		        <br />            
		        <label for="motdepasse" class="pw"></label>
		           <input type="password" name="motdepasse" value="" size="30" maxlength="20" placeholder="Mot de passe ..."/>
		           <span class="erreur">${traitement.erreurs['motdepasse']}</span>
		        <br />    
		        <input type="checkbox" id="souvenir" name="souvenir" class="check">Se souvenir de moi</br>
		                
		           <input type="submit" value="" class="sansLabel"/>
		        <br />		                
		     </fieldset>
		</form>
	</div>
	
</body>
</html>