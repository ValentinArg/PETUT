<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel ="stylesheet" href = "/PE2I/css/forum.css"/>
		<script type="text/javascript" src="http://code.jquery.com/jquery-1.6.1.min.js"></script>
		<title>PE2I</title>
	</head>
	<body>
		<div style="position: fixed;width:100%;z-index:10;">
			<div class=enTete>
				<a href="/PE2I/restreint/moncompte" class="monCompte" ><c:out value="${ utilisateur.prenom }"/> <c:out value="${ utilisateur.nom }"/></a>
				<a class="home" href="/PE2I/restreint/accueil"><img src="/PE2I/images/general/logo_reduit.png"/></a>
				<p class="boutonHautBas" id="boutonHautBas">Modules</p>
				<ul class="nav" id="nav">
					<c:forEach var="forum" items="${listeForum}">
						<li class=" partie"><a class="forum" id="forum${forum.id}"><c:out value="${forum.nom}"/></a></li>
					</c:forEach>
				</ul>
			</div>
			<div class="navigation" id="navigation">
				<ul id="context">
					<li class="semestres" id="semestre">
						<form>
							<c:forEach var="semestre" items="${listeSemestre}">
								<input class= "semestre" id = "${semestre.id}" type="radio" name="semestre"><c:out value="S${semestre.numero}"/></>
							</c:forEach>
						</form>
					</li>
				</ul>
			</div>
		</form>
		</div>
		<div class="conteneurGeneral" id="conteneurGeneral">
			
		<script type="text/javascript">
		
			$('#boutonPoster').click(function(){
				alert(document.getElementById("editeur").value);
			});
			
			var idModuleClick;
			//construction des Mati�res
			$( '.semestre' ).click(function(){
				$(".commentaire").remove();
				$(".listeSujets").remove();
				$(".listeTopics").remove();
				$('.forum').hide(200);
				$("#navigation").find('li').each(
					function(){
						if(this.id != "semestre"){
							$("#"+this.id).remove();
						}
					}
				)
				idSemestre = this.getAttribute('id');
				if(idSemestre != null){
					$.ajax({
						url : '/PE2I/restreint/forum',
						type : 'POST',
						data : 'idSemestre=' + idSemestre,
						success: function(valeur){
							$(".commentaire").remove();
							$(".listeSujets").remove();
							$(".listeTopics").remove();
							$(".documents").remove();
							//listeSemestreCLick.addNumeroSemestre(idSemestre,valeur);
							var listeUes = JSON.parse(valeur);
							for(i = 0; i < listeUes.length; i++){
								var li = $("<li class='parent' id='parent"+i+"'/>");
								var p = $("<p class='ue' id='ue"+i+"'> UE "+listeUes[i].numero + " : " +listeUes[i].libelle+"</p>");
								var div = $("<div class='rubrique' id='rubrique"+i+"'/>");
								var ul = $("<ul id=moduleUe"+i+"></ul>")
								$(li).appendTo($("#context"));
								$(p).appendTo(li);
								$(div).appendTo(li);
								$(ul).appendTo(div);
							}
							for(j = 0; j < listeUes.length; j++){
								for(k=0;k<listeUes[j].l.length;k++){
									var li2 = $("<li class='module' id='module"+listeUes[j].l[k].id+"'><p>"+listeUes[j].l[k].numero+"</p></li>")
									$(li2).appendTo($("#moduleUe"+j));
								}
							}
							$(".module").hide();
							$( '.parent' ).click(function(){
								$(".module").slideUp();
								$("#"+this.id).find('li').each( 
									function(){
										if(($(this)).is(":visible")){
											cacher($(this).attr('id'));
										}else{
											afficher($(this).attr('id'));
										}
										
									}
								)
							});
							function afficher(id){
								$("#"+id).slideDown();
							}
							function cacher(id){
								$("#"+id).slideUp();
							}
							$(".module").click(function(){
								$(".commentaire").remove();
								$(".listeSujets").remove();
								$(".listeTopics").remove();
								$(".documents").remove();
								$('.forum').show(200);
								idModuleClick = (this.id).replace('module', '');
								return false;
							});
						},
						dataType : 'text'
					})
				}
			});
			//Construction des sujets de cours
			$( '.forum' ).click(function(){
				if(!haut)
					slideBarreModule();
				if(idModuleClick != null){
					requetteCreaSujetCours(((this.id).replace('forum','')));
				}
			});
			
			function requetteCreaSujetCours(idForum){
				$.ajax({
					url : '/PE2I/restreint/forum',
					type : 'POST',
					data : 'idModule=' + idModuleClick + '&idForum='+idForum,
					success : function(valeur){
						constructionSujetCours(valeur,idForum);
				    },
					dataType : 'text'
				});
			}
			
			function constructionSujetCours(valeur,idForum){
				$(".commentaire").remove();
				$(".listeSujets").remove();
				$(".listeTopics").remove();
				$(".documents").remove();
				var listeSujets = JSON.parse(valeur);
				//identifiant = identifiant du sujet se trouvant dans la listeSujets.id
				var div = $('<div class="listeSujets">');
				var table = $("<table id='tableauSujets' class='tableau'>");
				var tbody = $('<tbody class="body">');
				var entete = $('<tr class="enteteTableau"> <th>N�</th> <th>Nom</th></tr>');
				$(div).appendTo($('.conteneurGeneral'));
				$(table).appendTo(div);
				$(tbody).appendTo(table);
				$(entete).appendTo(tbody);
				for(i = 0; i < listeSujets.length; i++){
					var tr = $("<tr class='champTableau' id='sujet"+listeSujets[i].id+"'></tr>");
					var tdNumero = $("<td></td>");
					var tdNom = $('<td></td>');
					tdNumero.text(listeSujets[i].numero);
					tdNom.text(listeSujets[i].nom);
					$(tr).appendTo(tbody);
					$(tdNumero).appendTo(tr);
					$(tdNom).appendTo(tr);
				}
				// construction des Topics
				$('.champTableau').click(function(){
					idSujet = ((this.id).replace('sujet',''));
					var fileArrianne = $('<p style="display:inline-block;cursor:pointer;width:160px;" class="fileArrianne" id="'+idForum+'">/liste des sujets de cours </p>');
					$(fileArrianne).appendTo($('.conteneurGeneral'));
					//action au clique sur le file d'arrianne pour le sujet
					
					$('.fileArrianne').click(function(){
						$('.fileArrianne').remove();
						$('.fileArrianne2').remove();
						requetteCreaSujetCours(idForum);
					});
					requetteCreaSujet(idSujet);
				});
			}
			
			function requetteCreaSujet(idSujet){
				$.ajax({
					url : '/PE2I/restreint/forum',
					type : 'POST',
					data : 'idSujet=' + idSujet,
					success : function(valeur){
						
						constructionSujet(valeur);
						//contruit le forum (Commentaire et r�ponse)
						$('.champTableau').click(function(){
							idTopic = ((this.id).replace('topic',''));
							var fileArrianne2 = $('<p style="display:inline-block;cursor:pointer;" class="fileArrianne2" id="'+idSujet+'"> / liste des questions</p>');
							$(fileArrianne2).appendTo($('.conteneurGeneral'));
							$('.fileArrianne2').click(function(){
								$('.fileArrianne2').remove();
								requetteCreaSujet(this.id);
							});
							requetteCreaTopic(idTopic);
						})// fin de la fonction javascript qui construit le forum
						
					},//fin de la function success de cr�ation des Topics
					dataType : 'text'
				});
			}
			
			function requetteCreaTopic(idTopic){
				$.ajax({
					url : '/PE2I/restreint/forum',
					type : 'POST',
					data : 'idTopic=' + idTopic,
					success : function(valeur){
						constructionTopics(valeur);
					},//fin de la function success de la construction du forum
					dataType : 'text'
				})//fin de la fonction ajax qui construit le forum
			}
			
			function constructionSujet( valeur){
				$(".commentaire").remove();
				$(".listeSujets").remove();
				$(".listeTopics").remove();
				$(".documents").remove();
				var listeObjet = JSON.parse(valeur);
				
				var div = $('<div class="documents">');
				var table = $("<table>");
				var tbody = $('<tbody>');
				var tr1 = $("<tr></tr>");
				var tr2 = $("<tr></tr>");
				$(div).appendTo($('.conteneurGeneral'));
				$(table).appendTo(div);
				$(tbody).appendTo(table);
				$(tr1).appendTo(tbody);
				$(tr2).appendTo(tbody);
				if(listeObjet[0].sujet != null){
					var td1 = $("<td></td>");
					var td2 = $("<td style='font-size:15px' sujet </td>");
					var img = $("<img src='/PE2I/images/eleves/forum/"+listeObjet[0].sujet.nom+".jpg'/>");
					$(td1).appendTo(tr1);
					$(td2).appendTo(tr2);
					$(img).appendTo(td1);
				}
				if(listeObjet[0].correction != null){
					var td1 = $("<td></td>");
					var td2 = $("<td style='font-size:15px'> correction </td>");
					var img = $("<img src='/PE2I/images/eleves/forum/"+listeObjet[0].correction.nom+".jpg'/>");
					$(td1).appendTo(tr1);
					$(td2).appendTo(tr2);
					$(img).appendTo(td1);
				}
				if(listeObjet[0].listeDocumentsAImporter[0] != null){
					var td1 = $("<td></td>");
					var td2 = $("<td style='font-size:15px'> document � importer </td>");
					var img = $("<img src='/PE2I/images/eleves/forum/"+listeObjet[0].listeDocumentsAImporter[0].nom+".jpg'/>");
					$(td1).appendTo(tr1);
					$(td2).appendTo(tr2);
					$(img).appendTo(td1);
				}

				//identifiant = identifiant du sujet se trouvant dans la listeSujets.id
				var div = $('<div class="listeTopics">');
				var table = $("<table id='tableauTopic' class='tableau'>");
				var tbody = $('<tbody class="body">');
				var entete = $('<tr class="enteteTableau"> <th>statut</th> <th>question</th> <th>auteur</th> <th>date</th> <th>reponse</th> </tr>');
				$(div).appendTo($('.conteneurGeneral'));
				$(table).appendTo(div);
				$(tbody).appendTo(table);
				$(entete).appendTo(tbody);
				
				//boucle pour r�cup�rer cr�er et afficher tout les sujets du mati�re donn�e et d'un type d'enseignement (TD,TP,CM)
				
				for(i = 0; i < listeObjet[1].length; i++){
					var tr = $("<tr class='champTableau' id='topic"+listeObjet[1][i].id+"'></tr>");
					var tdStatut = $("<td></td>");
					var tdQuestion = $('<td></td>');
					var tdAuteur = $('<td></td>');
					var tdDate = $('<td></td>');
					var tdReponse = $('<td></td>');
					tdStatut.text(listeObjet[1][i].statut);
					tdQuestion.text(listeObjet[1][i].question);
					tdAuteur.text(listeObjet[1][i].auteur);
					tdDate.text(listeObjet[1][i].date);
					tdReponse.text(listeObjet[1][i].nbReponse);
					$(tr).appendTo(tbody);
					$(tdStatut).appendTo(tr);
					$(tdQuestion).appendTo(tr);
					$(tdAuteur).appendTo(tr);
					$(tdDate).appendTo(tr);
					$(tdReponse).appendTo(tr);
				}
			}
			
			function constructionTopics( valeur){
				$(".commentaire").remove();
				$(".documents").remove();
				$(".listeTopics").remove();
				var commentaire = JSON.parse(valeur);
				//alert(commentaire.reponses[0].id);
				var divCommentaire = $('<div class="commentaire">');
				var divEnteteCommentaire = $('<div class="enTeteCommentaire">');
				var divCorpCommentaire = $('<div class="corpCommentaire">');
				var pNomAuteurCommentaire = $('<p class="nomAuteurCommenatire">'+commentaire.auteur+'</p>');
				var pDateCommentaire = $('<p class="dateCommentaire">'+commentaire.date+'</p>');
				var pTexteCommentaire = $('<p class="texteCommentaire">'+commentaire.texte+'</p>');
				//<p class="texteCommentaire">Bonjour j'aimerais savoir comment fait on pour cr�er une machine virtuel Linux sur un pc Windows ? Si quelqu'un aurait un tuto je suis preneur.</p>
				
				$(divCommentaire).appendTo($('.conteneurGeneral'));
				$(divEnteteCommentaire).appendTo(divCommentaire);
				$(divCorpCommentaire).appendTo(divCommentaire);
				$(pNomAuteurCommentaire).appendTo(divEnteteCommentaire);
				$(pDateCommentaire).appendTo(divEnteteCommentaire);
				$(pTexteCommentaire).appendTo(divCorpCommentaire);
				
				// boucle sur la liste des r�ponse de la class BeanCommentaire afin d'afficher les r�ponses
				for(i = 0; i < commentaire.reponses.length; i++){
					
					var divCommentaire = $('<div class="commentaire">');
					var divEnteteCommentaire = $('<div class="enTeteCommentaire">');
					var divCorpCommentaire = $('<div class="corpCommentaire">');
					var pNomAuteurCommentaire = $('<p class="nomAuteurCommenatire">'+commentaire.reponses[i].idUtilisateur+'</p>');
					var pDateCommentaire = $('<p class="dateCommentaire">'+commentaire.reponses[i].date+'</p>');
					var pTexteCommentaire = $('<p class="texteCommentaire">'+commentaire.reponses[i].texte+'</p>');
					
					$(divCommentaire).appendTo($('.conteneurGeneral'));
					$(divEnteteCommentaire).appendTo(divCommentaire);
					$(divCorpCommentaire).appendTo(divCommentaire);
					$(pNomAuteurCommentaire).appendTo(divEnteteCommentaire);
					$(pDateCommentaire).appendTo(divEnteteCommentaire);
					$(pTexteCommentaire).appendTo(divCorpCommentaire);
				}
			}
			
			//fonction d'animation de la bare des mati�res
			var haut = false;
			function slideBarreModule(){
				if(!haut){
					$('#context').slideUp()
					if($('#context').is(':animated')){
						checkAnimate();
					}
					haut = true;
				}else{
					document.getElementById('conteneurGeneral').style.marginLeft="20%";
					document.getElementById('conteneurGeneral').style.marginRight="20%";
					document.getElementById('conteneurGeneral').style.width="60%";
					$('#context').slideDown();
					if($('#context').is(':animated')){
						checkAnimate();
					}
					haut = false;
				}
			}
			//function de gestion du timer pour la bare des mati�re
			function checkAnimate() {
	            if( $( '#context' ).is( ':animated' )) {
	                setTimeout(function() {
	                    checkAnimate();
	                }, 0 );
	            }else{
	            	if(haut){
	            		//document.getElementById('conteneurGeneral').style.marginLeft="0%";
	            		//document.getElementById('conteneurGeneral').style.marginRight="0%";
	            		//document.getElementById('conteneurGeneral').style.width="100%";
	            	}	
	            }
	        }
			$( '#boutonHautBas' ).click(function(){
				slideBarreModule()});
			
			
			
			$('.forum').hide();
			//var longueurDivTableau = ($(".tableau").width()*100);
			//var pourcentage = (longueurDivTableau/($(document).width()));
			//var resultat = ((100-pourcentage)/2)-20;
			//alert(resultat);	
			//var string = resultat+'%';
			//document.getElementById('tableauSujets').style.marginLeft = string;
			
			
		</script>
	</body>
</html>