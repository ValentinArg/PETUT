<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel ="stylesheet" href = "/PETUT/css/main.css"/>
<link rel ="stylesheet" href = "/PETUT/css/allSemestres.css"/>	
<title>Insert title here</title>
</head>
<body>
	
	<p class="boutonHautBas" id="boutonHautBas">module</p>
	<jsp:include page="../enTete.jsp"/>
	<div class="navigation" id="navigation">
		<ul>
			<li class="parent" id="parent1"><p class="module">M1101</p></li>
			<li class="parent" id="parent2"><p class="module">M1102</p></li>
			<li class="parent" id="parent1"><p class="module">M1103</p></li>
			<li class="parent" id="parent2"><p class="module">M1104</p></li>
			<li class="parent" id="parent1"><p class="module">M1105</p></li>
			<li class="parent" id="parent2"><p class="module">M1106</p></li>
			<li class="parent" id="parent1"><p class="module">M1107</p></li>
			<li class="parent" id="parent2"><p class="module">M1201</p></li>
			<li class="parent" id="parent1"><p class="module">M1202</p></li>
			<li class="parent" id="parent2"><p class="module">M1203</p></li>
			<li class="parent" id="parent1"><p class="module">M1204</p></li>
			<li class="parent" id="parent2"><p class="module">M1205</p></li>
			<li class="parent" id="parent1"><p class="module">M1206</p></li>
			<li class="parent" id="parent1"><p class="module">Groupe A</p></li>
			<li class="parent" id="parent2"><p class="module">Groupe B</p></li>
			<li class="parent" id="parent1"><p class="module">Groupe C</p></li>
			<li class="parent" id="parent2"><p class="module">Groupe D</p></li>
			<li class="parent" id="parent1"><p class="module">Groupe E</p></li>
			<li class="parent" id="parent2"><p class="module">Groupe F</p></li>
			<li class="parent" id="parent1"><p class="module">Ev�nement BDE</p></li>
			
		</ul>
		
	</div>
	<div class="conteneurGeneral" id="conteneurGeneral">

		<ul class="selection" id="selection">
			<li class=" type"><p>Cours</p></li>
			<li class="type"><p>Travaux Dirig�es</p></li>
			<li class="type"><p>Travaux Pratiques</p></li>
			<li class="type"><p>Partiels</p></li>
		</ul>
	</div>
	<script type="text/javascript">
		
		var haut = false
		function slideUp(){
			if(!haut){
				$('#navigation').slideUp();
				document.getElementById('conteneurGeneral').style.marginLeft="0px"
				haut = true;
			}else{
				$('#navigation').slideDown();
				document.getElementById('conteneurGeneral').style.marginLeft="20%"
				haut = false;
			}
		}
		
		$( '#boutonHautBas' ).click(function(){
			slideUp()});
	</script>
</body>
</html>