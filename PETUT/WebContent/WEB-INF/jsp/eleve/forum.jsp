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
	
	<div style="position: fixed;width:100%;z-index:10;">
	<jsp:include page="/WEB-INF/jsp/enTete.jsp"/>
	<div class="navigation" id="navigation">
		<ul>
			<li class="semestre">
				<form>
					<input type="radio" name="semestre" value="0">S1</>
					<input type="radio" name="semestre" value="1">S2</>
					<input type="radio" name="semestre" value="0">S3</>
					<input type="radio" name="semestre" value="1">S4</>
				</form>
			</li>
			<li class="parent" id="parent1"><p class="ue" id="ue1">UE 1</p>
				<div class="rubrique" id="module1">
					<ul >
						<li><p class="module" id="1101" >M1101</p></li>
						<li><p class="module" id="1102">M1102</p></li>
						<li><p class="module">M1103</p></li>
						<li><p class="module">M1104</p></li>
						<li><p class="module">M1105</p></li>
						<li><p class="module">M1106</p></li>
						<li><p class="module">M1107</p></li>
					</ul>
				</div>
			</li>
			
			<li class="parent" id="parent2"><p class="ue" id="ue2">UE 2</p>
				<div class="rubrique" id="module2">
					<ul>
						<li><p class="module">M1201</p></li>
						<li><p class="module">M1202</p></li>
						<li><p class="module">M1203</p></li>
						<li><p class="module">M1204</p></li>
						<li><p class="module">M1205</p></li>
						<li><p class="module">M1206</p></li>
						<li><p class="module">M1207</p></li>
					</ul>
				</div>
			</li>
			
		</ul>
		
	</div>
	</div>
	<div class="conteneurGeneral" id="conteneurGeneral">
		
	</div>
	<script type="text/javascript">
		
		var haut = false
		function slideUp(){
			if(!haut){
				$('#navigation').slideUp()
				if($('#navigation').is(':animated')){
					checkAnimate();
				}
				haut = true;
			}else{
				document.getElementById('conteneurGeneral').style.marginLeft="20%";
				document.getElementById('conteneurGeneral').style.width="80%";
				$('#navigation').slideDown();
				haut = false;
			}
		}
				
		function checkAnimate() {
            if( $( '#navigation' ).is( ':animated' )) {
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
		
		$("#module2").slideUp();
		$("#module1").slideUp();
		
		var hautModule1 = true;
		function sildeModule1(){
			if(!hautModule2){
				$("#module2").slideUp();
				hautModule2=true;
			}
			if(hautModule1){
				$("#module1").slideDown();
				hautModule1=false;
				
			}else{
				$("#module1").slideUp();
				hautModule1=true;
			}
		}
		
		var hautModule2 = true;
		function sildeModule2(){
			if(!hautModule1){
				$("#module1").slideUp();
				hautModule1=true;
			}
			if(hautModule2){
				$("#module2").slideDown();
				hautModule2=false;
				
			}else{
				$("#module2").slideUp();
				hautModule2=true;
			}
		}
		
		$( '#boutonHautBas' ).click(function(){
			slideUp()});
		$( '#ue1' ).click(function(){
			sildeModule1()});
		$( '#ue2' ).click(function(){
			sildeModule2()});
		var idModule = null;
		$( '.module' ).click(function(){
			idModule = this.getAttribute('id');
			
		});
		$( '.forum' ).click(function(){
			if(idModule != null){
				$.ajax({
					url : '/PETUT/eleves/forum',
					type : 'POST',
					data : 'idModule=' + idModule + '&idForum='+this.getAttribute('id'),
					success : function(valeur){
						var user = JSON.parse(valeur);
						alert(user.messages);
				    },
					dataType : 'text'
				});
			}
		});
		
		
		
	</script>
</body>
</html>