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
			
			<div class="commentaire">
				<div class="enTeteCommentaire">
					<p class="nomAuteurCommenatire">Bremec Florian</p>
					<p class="dateCommentaire"> 17 novembre 2016</p>
				</div>
				<div class="corpCommentaire">
					<p class="texteCommentaire">Bonjour j'aimerais savoir comment fait on pour créer une machine virtuel Linux sur un pc Windows ? Si quelqu'un aurait un tuto je suis preneur.</p>
				</div>
			</div>
			<!-- <div class="documents">
				<table>
					
						<td><img src="/PE2I/images/eleves/forum/sujet.jpg"/></td>
						<td><img src="/PE2I/images/eleves/forum/corriger.jpg"/></td>
						<td><img src="/PE2I/images/eleves/forum/documentAImporter.jpg"/></td>
					</tr>
					<tr>
						<td>sujet</td>
						<td>corrigé</td>
						<td>document à importer</td>
					</tr>
				</table>
			</div>-->
			
		</div>
		<script type="text/javascript">
		
			var idModuleClick;
			$( '.semestre' ).click(function(){
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
								$(".listeSujets").remove();
								$(".listeTopics").remove();
								$('.forum').show(200);
								idModuleClick = (this.id).replace('module', '');
								return false;
							});
						},
						dataType : 'text'
					})
				}
			});
			//function ajax pour afficher les sujets d'une matière donnée et d'un forum donnée
			$( '.forum' ).click(function(){
				if(!haut)
					slideBarreModule();
				if(idModuleClick != null){
					$.ajax({
						url : '/PE2I/restreint/forum',
						type : 'POST',
						data : 'idModule=' + idModuleClick + '&idForum='+((this.id).replace('forum','')),
						success : function(valeur){
							$(".listeSujets").remove();
							$(".listeTopics").remove();
							var listeSujets = JSON.parse(valeur);
							//identifiant = identifiant du sujet se trouvant dans la listeSujets.id
							var div = $('<div class="listeSujets">');
							var table = $("<table id='tableauSujets' class='tableau'>");
							var tbody = $('<tbody class="body">');
							var entete = $('<tr class="enteteTableau"> <th>N°</th> <th>Nom</th></tr>');
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
							
							$('.champTableau').click(function(){
								idSujet = ((this.id).replace('sujet',''));
								$.ajax({
									url : '/PE2I/restreint/forum',
									type : 'POST',
									data : 'idSujet=' + idSujet,
									success : function(valeur){
										$(".listeSujets").remove();
										$(".listeTopics").remove();
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
											var td2 = $("<td style='font-size:15px'> document à importer </td>");
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
										for(i = 0; i < listeObjet[1].length; i++){
											var tr = $("<tr class='champTableau' id='sujet"+listeObjet[1][i].id+"'></tr>");
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
										
											
										
									},
									dataType : 'text'
								});
							});
					    },
						dataType : 'text'
					});
				}
			});
			
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
			function checkAnimate() {
	            if( $( '#context' ).is( ':animated' )) {
	                setTimeout(function() {
	                    checkAnimate();
	                }, 0 );
	            }else{
	            	if(haut){
	            		document.getElementById('conteneurGeneral').style.marginLeft="0%";
	            		document.getElementById('conteneurGeneral').style.marginRight="0%";
	            		document.getElementById('conteneurGeneral').style.width="100%";
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