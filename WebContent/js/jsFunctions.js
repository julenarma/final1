/**
 * 
 */

$(document).ready(function(){
	
	$("#btnSendJSON").click(function(){
   	 
  	  var vehicles=	'[{"plate":"8999AAA","brand":"BMW","model":"118","color":"Black","customer":"3"},{"plate":"0000ZZZ","brand":"BMW","model":"120","color":"Blue","customer":"2"},{"plate":"9001KHH","brand":"Seat","model":"Ibiza","color":"White","customer":"2"},{"plate":"9005GHH","brand":"Ford","model":"Focus","color":"Blue","customer":"1"}]'
  	 
  	       
  	 $.ajax({
       	type: "POST",
       	data:{ 'pVehicles':vehicles},
       	url: "CLookUp", 
       	datatype: "json",
       	success: function(result){  
       		
       		$("#container").empty(); // removes all the previous content in the container
       		
			var newRow = "<br><b>New inserted:</b>"+result.insertedVehicles+"<br><b> Repeated, not inserted:</b>"+result.exististingVehicles+"<br><b> Updated:</b>"+result.updatedVehicles;
											// only one json object is received
			$("#container").append(newRow); // add the new row to the container


       	},
       	error : function(xhr) {
   			alert("An error occured: " + xhr.status + " " + xhr.statusText);
   		}
       });
    });
    
	
	
});