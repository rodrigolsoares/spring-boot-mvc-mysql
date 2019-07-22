jQuery(document).ready(function() {
	
	jQuery("#btn-tratar").click(function() {
		

		jQuery.ajax({
			url : "tratarChamado/" + jQuery("#cadastroNome").val(),
			type : "POST",
			dataType : 'json',
			contentType : 'application/json',
			mimeType : 'application/json',
			complete : function(data) {
				var resposta = JSON.parse(data.responseText);
				
			},
			error : function(data, status, er) {
				alert("error: " + data + " status: " + status + " er:" + er);
			}
		});
		
	});
	
	
});