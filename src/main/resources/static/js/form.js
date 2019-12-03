
$(document).ready(function() {
	
	// Autocomplete
//    $("#autocompletePais").combobox({
//    	idCombo: "autocompletePais",
//        idInput: "autocompletePaisInput"
//    });
	
//	$('#dataTables-example').DataTable({
//		responsive: true
//    });
	
	 // ================ Calendário ==================
//    $('.date').datepicker({
//        format: "dd/mm/yyyy",
//        language: "pt-BR",
//        clearBtn: true,
//        todayHighlight: true
//    });
	
	$('.dateBirth').datepicker({
	    format: 'dd/mm/yyyy',
	    language: "pt-BR",
	    clearBtn: true,
	    todayHighlight: true
	});
	
	$(".dateBirth").mask('00/00/0000');
	
    $(".telephone").mask('(00) 0000-0000');
	
	$('.time').mask('00:00:00');
	
	$('.cpf').mask('000.000.000-00', {reverse: true});
	
	$(".resposibleOption").change(function(){
		if($(this).val() === 'sim'){
			$("#responsible").prop('disabled', false);
		}else if($(this).val() === 'nao'){
			$("#responsible").prop('disabled', true);
		}
	});
	
	$(".allergy").change(function(){
		if($(this).val() === 'sim'){
			$("#allergyDescription").prop('disabled', false);
		}else if($(this).val() === 'nao'){
			$("#allergyDescription").prop('disabled', true);
		}
	});
	
	$(".foodRestriction").change(function(){
		if($(this).val() === 'sim'){
			$("#foodRestriction").prop('disabled', false);
		}else if($(this).val() === 'nao'){
			$("#foodRestriction").prop('disabled', true);
		}
	});
	
	//	$("#autocompletePais").autocomplete({
	//		source: parents
	//	});
	
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
