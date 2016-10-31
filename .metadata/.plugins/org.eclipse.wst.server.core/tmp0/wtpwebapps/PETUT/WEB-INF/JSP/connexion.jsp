<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel ="stylesheet" href = "/PE2I/css/main.css"/>
<link rel ="stylesheet" href = "/PE2I/css/connexion.css"/>	
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<title>PETUT</title>
</head>
<body>
	<div class="conteneurGeneral">
		<div class="connexion">
			<button class="boutonEnseignant" id="boutonEnseignant" type="button">Enseignant</button>
			<button class="boutonEleve" id="boutonEleve" type="button">El�ve</button>
			<form id="formEnseignant" method="post" action="connexion">
		    	<fieldset>
		        	<legend>Connexion enseignant</legend>
		                           
					<label for="Identifiant">Nom de compte<span class="requis"></span></label>
		            <input type="Identifiant" id="connexionIdentifiant" name="connexionIdentifiant" size="20" maxlength="60" />
		            <span class="erreur">${traitement.erreurs['connexionIdentifiant']}</span>
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
			<form id="formEleve" method="post" action="connexion">
		    	<fieldset>
		        	<legend>Connexion �l�ve</legend>
		                           
					<label for="Identifiant">Identifiant<span class="requis"></span></label>
		            <input type="Identifiant" id="connexionIdentifiant" name="connexionIdentifiant" size="20" maxlength="60" />
		            <span class="erreur">${traitement.erreurs['connexionIdentifiant']}</span>
		            <br />
		                
		            <label for="connexionMotdepasse">Mot de passe <span class="requis"></span></label>
		            <input type="password" id="connexionMotdepasse" name="connexionMotdepasse" value="" size="20" maxlength="20" />
		            <span class="erreur">${traitement.erreurs['connexionMotdepasse']}</span>
		            <br />
		                
		            <input type="submit" value="connexion" class="sansLabel" />
		            <br />
		                
		            <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
		     	</fieldset>
			</form>
		</div>
	</div>
	<script>
	
		document.getElementById('formEnseignant').style.visibility = 'hidden';
		
		
		$( '#boutonEleve' ).click(function(){
			runEffect('boutonEleve')});
		$( '#boutonEnseignant' ).click(function(){
			runEffect('boutonEnseignant')});
		
		function runEffect(bouton){
			if(bouton == 'boutonEleve'){
				document.getElementById('formEleve').style.visibility = 'visible';
				document.getElementById('formEnseignant').style.visibility = 'hidden';
			}else{
				document.getElementById('formEleve').style.visibility = 'hidden';
				document.getElementById('formEnseignant').style.visibility = 'visible';
			}
		}
	</script>
</body>
</html>