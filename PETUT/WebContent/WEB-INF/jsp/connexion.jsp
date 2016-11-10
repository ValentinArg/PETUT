<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel ="stylesheet" href = "/PE2I/css/connexion.css"/>	
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<title>PETUT</title>
</head>

<header>
<h1>PE2I</h1>
</header>

<body>
	<div class="connexion">
		<form method="post" action="connexion">
		   	<fieldset> 
		   		<h2>Connexion</h2>               
				<label for="identifiant" class="id"></label>
		           <input type="text" id="identifiant" name="identifiant" size="30" maxlength="60" placeholder="Identifiant ..."/>
		           <span class="erreur">${traitement.erreurs['identifiant']}</span>
		        <br />            
		        <label for="motdepasse" class="pw"></label>
		           <input type="password" id="motdepasse" name="motdepasse" value="" size="30" maxlength="20" placeholder="Mot de passe ..."/>
		           <span class="erreur">${traitement.erreurs['motdepasse']}</span>
		        <br />    
		        <input type="checkbox" id="souvenir" name="souvenir" class="check">Se souvenir de moi</br>
		                
		           <input type="submit" value="" class="sansLabel"/>
		        <br />		                
		            <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
		     </fieldset>
		</form>
	</div>

	
	<!--<script>
	
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
	</script>-->
	
</body>
</html>