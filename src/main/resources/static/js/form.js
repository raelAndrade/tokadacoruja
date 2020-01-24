
$(document).ready(function() {
	
	// Autocomplete
	$("#autocompletePais").combobox({
		idCombo: "autocompletePais",
		idInput: "autocompletePaisInput",
		classe: "form-control",
		placeholder: "Digite o nome do responsável"
	});
	  
	$("#autocompleteCriancas").combobox({
		idCombo: "autocompleteCriancas",
	    idInput: "autocompleteCriancasInput",
	    classe: "form-control",
	    placeholder: "Digite o nome da criança"
	});
	
	// ================== Calendário ================== //
	$('.input-group.date').datepicker({
	    format: "dd-mm-yyyy",
	    language: "pt-BR",
	    clearBtn: true,
	    todayHighlight: true,
	    
	});
	
	$('.input-daterange input').datepicker({
	    format: "dd-mm-yyyy",
	    language: "pt-BR",
	    clearBtn: true,
	    todayHighlight: true,
	    
	});
	// =============================================== //
	
	// ================== Máscara ================== //
	$(".dateFormat").mask('99-99-9999');
	
    //$(".telephone").mask('(00) 0000-0000?9');
    $('.telephone').mask('(00) 0000-00009');
    $('.telephone').blur(function(event) {
    	if ($(this).val().length == 15) { // Celular com 9 dígitos + 2 dígitos DDD e 4 da máscara
			$(this).mask('(00) 00000-0009');
		} else {
			$(this).mask('(00) 0000-00009');
		}
    });
    
	$(".time").mask('00:00');
	
	$(".cpf").mask('000.000.000-00', { reverse: true });
	
	$(".amount").mask("#.##0,00", { reverse: true });
	// ============================================= //
	
	$(".resposibleOption").change(function(){
		if($(this).val() === 'TRUE'){
			$("#responsible").prop('disabled', false);
		}else if($(this).val() === 'FALSE'){
			$("#responsible").prop('disabled', true);
		}
	});
	
	$(".allergy").change(function(){
		if($(this).val() === 'TRUE'){
			$("#allergyDescription").prop('disabled', false);
		}else if($(this).val() === 'FALSE'){
			$("#allergyDescription").prop('disabled', true);
		}
	});
	
	$(".foodRestriction").change(function(){
		if($(this).val() === 'TRUE'){
			$("#foodRestriction").prop('disabled', false);
		}else if($(this).val() === 'FALSE'){
			$("#foodRestriction").prop('disabled', true);
		}
	});
	
	// ======================= ALERT ============================ //
	$(".alert").delay(5000).slideUp(500, function() {
	    $(this).alert('close');
	});

});