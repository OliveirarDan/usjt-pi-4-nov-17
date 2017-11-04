$(document).ready(function(){
	
	var form = $("#formCadastroEst");
	
	form.on("submit", function(e){
		
		e.preventDefault();
			
		data = getFormData($(this));
		
		console.log(data);

			
		$.ajax({
			url: "controller.do",
			data: data,
			method: "POST",
			success: function(data){
				console.log(data);
			}
		})
		
		
		
		
		
	})
	
	function getFormData($form){
	    var unindexed_array = $form.serializeArray();
	    var indexed_array = {};

	    $.map(unindexed_array, function(n, i){
	        indexed_array[n['name']] = n['value'];
	    });

	    return indexed_array;
	}
	
});