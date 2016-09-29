<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel ="stylesheet" href = "/PETUT/css/main.css"/>
<link rel ="stylesheet" href = "/PETUT/css/inscription.css"/>	
<title>Insert title here</title>
</head>
<body>
	<div class="conteneurGeneral">
		<form method="post" action="connexion">
			<div class="checkbox">
				<input type="checkbox"  id="case1" class="case" name="id" value="enseignant"><p class="textCheckBox"> enseignant</p>
				<input type="checkbox"  id="case2" class="case" name="id" value="eleve"><p class="textCheckBox"> �l�ve</p>
			</div>
			<br/>
	    	<fieldset>
	        	<legend>Connexion</legend>
	            <p>Vous possedez d�j� un compte :</p>
	
	                
				<label for="connexionEmail">Adresse email <span class="requis"></span></label>
	            <input type="email" id="connexionEmail" name="connexionEmail" size="20" maxlength="60" />
	            <span class="erreur">${traitement.erreurs['connexionEmail']}</span>
	            <br />
	                
	            <label for="connexionMotdepasse">Mot de passe <span class="requis"></span></label>
	            <input type="password" id="connexionMotdepasse" name="connexionMotdepasse" value="" size="20" maxlength="20" />
	            <span class="erreur">${traitement.erreurs['connexionMotdepasse']}</span>
	            <br />
	                
	            <input type="submit" value="connexion" class="sansLabel" />
	            <br />
	                
	            <!-- <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>-->
	     	</fieldset>
		</form>
	</div>
</body>
</html>