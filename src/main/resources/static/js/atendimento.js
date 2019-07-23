var instalacaoEncerrada = 'S';

jQuery(document).ready(function() {
	
	jQuery("#btn-tratar").click(function() {
		
		jQuery(".demais-campos").hide();
		
		if(jQuery("#numeroInstalacao").val() === '' ){
			alert('Preencha o número da instalação');
			return false;
		}

		jQuery.ajax({
			url : "tratarChamado/" + jQuery("#numeroInstalacao").val(),
			type : "POST",
			dataType : 'json',
			contentType : 'application/json',
			mimeType : 'application/json',
			success : function(data) {
				
				if(data === null || data ==='undefined'){
					alert('Número da instalação não existe');
					return false;
				}
				
				if(data.instalacaoEncerrada === 'S'){
					alert('Chamado Finalizado');
					return false;
				}
				
				jQuery("#idInstalacao").val(data.id);
				jQuery(".demais-campos").show();
				
				
				
			},
			error : function(data, status, er) {
				alert('Número da instalação não existe');
			}
		});
		
	});
	
	
	jQuery("#btn-reportar").click(function() {
		
		
		jQuery.ajax({
			url : "reportarAtendimento",
			type : "POST",
			dataType : 'json',
			data : JSON.stringify(parseJsonAtendimento()),
			contentType : 'application/json',
			mimeType : 'application/json',
			success : function(data) {
				jQuery(".demais-campos").hide();
				limparCampos();
				alert('Atendimento reportado com sucesso!!');
			},
			error : function(data, status, er) {
				alert("error: " + data + " status: " + status + " er:" + er);
			}
		});
		
		
		
		
	});
	
	jQuery('input:radio').click(function(){
              
		if($( "input:checked" ).val() === 'N'){
			jQuery('#idAvarias').prop( "disabled", false );
			jQuery('#textoMotivoNaoInstalacao').prop( "disabled", false );
			instalacaoEncerrada = 'N';
		}else{
			jQuery('#idAvarias').prop( "disabled", true );
			jQuery('#textoMotivoNaoInstalacao').prop( "disabled", true );
			instalacaoEncerrada = 'S';
		}
		
		jQuery('#textoMotivoNaoInstalacao').val('');
		jQuery('#idAvarias').val('');
    });  
	
	
});


function limparCampos() {
	
	 jQuery("#idInstalacao").val('');
	 jQuery("#numeroInstalacao").val('');
	 jQuery("#idModem").val('');
	 jQuery("#instalacaoEncerrada").val('');
	 jQuery("#idAvarias").val('');
	 jQuery('#textoMotivoNaoInstalacao').val('');
}

function parseJsonAtendimento() {

	var atendimento = {

		idInstalacao : jQuery("#idInstalacao").val(),
		numeroInstalacao : jQuery("#numeroInstalacao").val(),
		idModem : jQuery("#idModem").val(),
		instalacaoEncerrada : instalacaoEncerrada,
		idAvarias : jQuery("#idAvarias").val(),
		textoMotivoNaoInstalacao : jQuery("#textoMotivoNaoInstalacao").val()
	};

	return atendimento;
}

