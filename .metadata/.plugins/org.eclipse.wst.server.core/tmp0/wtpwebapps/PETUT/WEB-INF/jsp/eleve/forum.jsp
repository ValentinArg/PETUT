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
		
		</div>
		<script type="text/javascript">
		
			var idModuleClick;
			$( '.semestre' ).click(function(){
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
						url : '/PE2I/eleves/forum',
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
								$('.forum').show(200);
								idModuleClick = (this.id).replace('module', '');
								return false;
							});
						},
						dataType : 'text'
					})
				}
			});
			//function ajax pour afficher les sujets d'une mati�re donn�e et d'un forum donn�e
			$( '.forum' ).click(function(){
				slideBarreModule();
				if(idModuleClick != null){
					$.ajax({
						url : '/PE2I/eleves/forum',
						type : 'POST',
						data : 'idModule=' + idModuleClick + '&idForum='+((this.id).replace('forum','')),
						success : function(valeur){
							$(".listeSujets").remove();
							var listeSujets = JSON.parse(valeur);
							//identifiant = identifiant du sujet se trouvant dans la listeSujets.id
							var div = $('<div class="listeSujets">');
							var table = $("<table id='tableauSujets' class='tableau'>");
							var tbody = $('<tbody class="body">');
							var entete = $('<tr class="enteteTableau"> <th>N�</th> <th>Nom</th> <th>Document</th> </tr>');
							$(div).appendTo($('.conteneurGeneral'));
							$(table).appendTo(div);
							$(tbody).appendTo(table);
							$(entete).appendTo(tbody);
							for(i = 0; i < listeSujets.length; i++){
								var tr = $("<tr class='champTableau' id='sujet"+listeSujets[i].id+"'></tr>");
								var tdNumero = $("<td></td>");
								var tdNom = $('<td></td>');
								var tdDocument = $('<td></td>');
								tdNumero.text(listeSujets[i].numero);
								tdNom.text(listeSujets[i].nom);
								tdDocument.text("14/05/2016");
								$(tr).appendTo(tbody);
								$(tdNumero).appendTo(tr);
								$(tdNom).appendTo(tr);
								$(tdDocument).appendTo(tr);
							}
							
							$('.champTableau').click(function(){
								idSujet = ((this.id).replace('sujet',''));
								$.ajax({
									url : '/PE2I/eleves/forum',
									type : 'POST',
									data : 'idSujet=' + idSujet,
									success : function(valeur){
										$(".listeSujets").remove();
										$(".listeTopics").remove();
										var listeTopics = JSON.parse(valeur);
										//identifiant = identifiant du sujet se trouvant dans la listeSujets.id
										var div = $('<div class="listeTopics">');
										var table = $("<table id='tableauTopic' class='tableau'>");
										var tbody = $('<tbody class="body">');
										var entete = $('<tr class="enteteTableau"> <th>statut</th> <th>question</th> <th>auteur</th> <th>date</th> <th>reponse</th> </tr>');
										$(div).appendTo($('.conteneurGeneral'));
										$(table).appendTo(div);
										$(tbody).appendTo(table);
										$(entete).appendTo(tbody);
										for(i = 0; i < listeSujets.length; i++){
											var tr = $("<tr class='champTableau' id='sujet"+listeTopics[i].id+"'></tr>");
											var tdStatut = $("<td></td>");
											var tdQuestion = $('<td></td>');
											var tdAuteur = $('<td></td>');
											var tdDate = $('<td></td>');
											var tdReponse = $('<td></td>');
											tdStatut.text(listeTopics[i].statut);
											tdQuestion.text(listeTopics[i].question);
											tdAuteur.text(listeTopics[i].auteur);
											tdDate.text(listeTopics[i].date);
											tdReponse.text(listeTopics[i].nbReponse);
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
					document.getElementById('conteneurGeneral').style.width="80%";
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