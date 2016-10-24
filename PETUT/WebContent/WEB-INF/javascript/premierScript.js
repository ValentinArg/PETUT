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
		
		function slideDosier(nom,numero,nombrePere){
			for(var i = 1; i<nombrePere+1;i++){
				$(nom+i).slideUp();
			}
			if(!$(nom+numero).is(":visible"))
				$(nom+numero).slideDown();
		}