
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
	    format: "dd/mm/yyyy",
	    language: "pt-BR",
	    clearBtn: true,
	    todayHighlight: true,
	    
	});
	
	$('.input-daterange input').datepicker({
	    format: "dd/mm/yyyy",
	    language: "pt-BR",
	    clearBtn: true,
	    todayHighlight: true,
	    
	});
	// =============================================== //
	
	// ================== Máscara ================== //
	$(".dateFormat").mask('99/99/9999');
	
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
	
	function valid_cpf(cpf) {
	    cpf = replaceAll(replaceAll(cpf, ".", ""), "-", "");
	    var numeros, digitos, soma, i, resultado, digitos_iguais;
	    digitos_iguais = 1;
	    if (cpf.length < 11)
	        return false;
	    for (i = 0; i < cpf.length - 1; i++)
	        if (cpf.charAt(i) != cpf.charAt(i + 1)) {
	            digitos_iguais = 0;
	            break;
	        }
	    if (!digitos_iguais) {
	        numeros = cpf.substring(0, 9);
	        digitos = cpf.substring(9);
	        soma = 0;
	        for (i = 10; i > 1; i--)
	            soma += numeros.charAt(10 - i) * i;
	        resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;
	        if (resultado != digitos.charAt(0))
	            return false;
	        numeros = cpf.substring(0, 10);
	        soma = 0;
	        for (i = 11; i > 1; i--)
	            soma += numeros.charAt(11 - i) * i;
	        resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;
	        if (resultado != digitos.charAt(1))
	            return false;
	        return true;
	    } else
	        return false;
	}
	
	function replaceAll(string, token, newtoken) {
	    while (string.indexOf(token) != -1) {
	        string = string.replace(token, newtoken);
	    }
	    return string;
	}

});