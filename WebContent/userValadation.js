/**
 * 
 */


$(document).ready(function(){

	  
	
 $("#pass").on("click", function(){
		var user = $('#user').val();
		if(user==''){
			alert("Enter username");
		}
		else{
   $.ajax({
       type: 'GET',
       url: 'UserCheck',
       data: 'user='+ user,
       cache: false,
       success: function(responseText){
       alert(responseText);
           return responseText;  
       }
});
 }
 });
});

		
	






