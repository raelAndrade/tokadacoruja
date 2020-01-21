package br.com.tokadacoruja.resources;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.tokadacoruja.domain.Children;
import br.com.tokadacoruja.domain.Schedule;
import br.com.tokadacoruja.repositories.ChildrenRepository;
import br.com.tokadacoruja.repositories.ScheduleRepository;
import br.com.tokadacoruja.services.BillingService;

@Controller
public class BillingController {

	@Autowired
	private ScheduleRepository scheduleRepository;
	
	@Autowired
	private ChildrenRepository childrenRepository;
	
	@SuppressWarnings("unused")
	@Autowired
	private BillingService billingService;
	
	@GetMapping("/faturamento")
	public ModelAndView form(Schedule schedule) throws ParseException {
		ModelAndView mv = new ModelAndView("billings/billing");
		List<Children> childrens = childrenRepository.findAll();
		mv.addObject("childrens", childrens);
		mv.addObject("schedules", scheduleRepository.findAll());
		return mv;
	}
	
	/*@PostMapping("/faturamento/{id}/{dateInitial}/{dateFinal}")
	public ModelAndView filterPerData(@Param("id") Long id, @Param("dateInitial") String dateInitial, @Param("dateFinal") String dateFinal) {
		ModelAndView mv = new ModelAndView("billings/list");		
		//Schedule schedule = (Schedule) scheduleRepository.buscaCriancaPorDataInicialEDataFinal(dateInitial, dateFinal, id);
		//System.out.println("Total: " + schedule);		
		return mv;
	}*/
	
//	@RequestMapping(value="/search", method = RequestMethod.GET)
//	public String Search(Schedule schedule, @RequestParam("id") Long id, @RequestParam("dateInitial") String dateInitial) {
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-mm-yyyy");
//		LocalTime lt = schedule.getHourInitial();
//		String ltString = lt.format(formatter);
//		System.out.println(ltString);
//		//System.out.println(scheduleRepository.buscaCriancaPorDataInicialEDataFinal(ltString, schedule.getHourFinale(), schedule.getId()));
//		
//	    return "search";
//	}
	
//	@RequestMapping("{id}/billings")
//    public ModelAndView buscaFaturamentoCriancaPorData(@PathVariable("id") Long childrenId,
//              @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
//              @RequestParam("startDate") LocalTime startDate) {
//		ModelAndView mv = new ModelAndView();
//        mv.addObject("faturamento", scheduleRepository.buscaCriancaPorData(startDate, childrenId));
//        System.out.println("TESTE: " + scheduleRepository.buscaCriancaPorData(startDate, childrenId));
//        return mv;
//    }
	
//	@RequestMapping("/faturamento/pesquisar")
//	public ModelAndView buscaSomaFaturamentoCriancaPorId(@RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-mm-dd") Date startDate, @RequestParam("id") Children id, Schedule s ) {
//		List<Schedule> schedule = billingService.search(s.getDate(), s.getChildren());
//		ModelAndView mv = new ModelAndView("billings/list");
//		mv.addObject("schedules", schedule);
//		return mv;
//	}
	
	
	
}
