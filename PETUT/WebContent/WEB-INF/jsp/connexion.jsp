<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel ="stylesheet" href = "/PE2I/css/main.css"/>
<link rel ="stylesheet" href = "/PE2I/css/connexion.css"/>	
<title>PE2I - Connexion</title>
</head>


<body>

<header>
	<img src="/PE2I/images/general/logo.png" alt="banniere" class="banniere">
	<img style="float:right" src="/PE2I/images/general/logoiut.jpg" alt="logoiut" class="logoiut">
</header>

<div class="general">
	<div class="divconnexion">
		<form method="post" action="connexion">
		   		<h2>Connexion</h2>               
				<div class="inputspan"><img src="/PE2I/images/iconeid.png" alt="iconeid"/>
		           <input type="text" name="identifiant" size="30" maxlength="60" placeholder="Identifiant ..."/></div>
		           <span class="erreur">${traitement.erreurs['identifiant']}</span>           
		        <div class="inputspan"><img src="/PE2I/images/iconepw.png" alt="iconepw"/>
		           <input type="password" name="motdepasse" value="" size="30" maxlength="20" placeholder="Mot de passe ..."/></div>
		           <span class="erreur">${traitement.erreurs['motdepasse']}</span>   
		           <div class="spancheck">
		        <input type="checkbox" id="souvenir" name="souvenir" class="check"><span>Se souvenir de moi</span></div>
		                
		          <button type="submit" class="button"><span>Connexion</span></button>
	           
		</form>
	</div>
	</div>
	
<footer>
	<div class="divfooter">
	<p style="text-align:center">Plateforme d'Echange Intra IUT réalisée par Florian B, Valentin A, Paul-Emmanuel B et Marc-Antoine G. IUT Informatique Paul-Sabatier 2016/2017.</p>
</footer>

</body>
</html>