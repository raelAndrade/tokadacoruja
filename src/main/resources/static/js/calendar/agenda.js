$(document).ready(function() {
	
	$.get("http://localhost:8081/agendamentos/list-calendar", function(response) {
		
		var data = new Date();
		/*PEGA O DIA*/
		var dia  = data.getDate();	
		/*PEGA O MÊS E SOMA MAIS UM PARA CHEGAR NO MÊS ATUAL(JAVASCRIPT O MÊS COMEÇA EM 0(iNDEX DO MÊS))*/
		var mes  = (data.getMonth() + 1);
		/*PEGA O ANO*/
		var ano  = data.getFullYear();
		
		/*MONTA A DATA*/
		var dataAtual = ano +'-'+mes+'-'+dia;
		
		var datas = JSON.stringify(response);
		var data = $.parseJSON(datas);
		
		var schedule = data.map((item) => {
			return {
				title : item.children.name,
				start : item.date,
				minTime : item.hourInitial,
				maxTime : item.hourFinale,
				className: 'info'
	    	}
	    });	
	
		$('#div-agenda-eventos').fullCalendar({
			header: {
				left: 'prev,next today',
				center: 'title',
				right: 'month,agendaWeek,agendaDay'
			},
			defaultDate: dataAtual,		
			eventLimit: true,
			lang:'pt-br',
			buttonText: {
			    today: 'Hoje',
			    month: 'Mês',
			    week: 'Semana',
			    day: 'Dia',
			},
			timeFormat: 'HH:mm',
			events:
				schedule
		});
	});
	
});