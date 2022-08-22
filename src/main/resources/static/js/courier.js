/**
 * 
 */


 function ClearFormFields(){
	console.log("i've been pressed'")	
	$(':input','#addCourier')
	  .not(':button, :submit, :reset, :hidden')
	  .val('')
	  .prop('checked', false)
	  .prop('selected', false);
}