package br.com.tokadacoruja.resources;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ModelAndView form(Children children) {
		ModelAndView mv = new ModelAndView("billings/billing");
		List<Children> childrens = childrenRepository.findAll();
		mv.addObject("childrens", childrens);
		mv.addObject("children", children);
		//mv.addObject("schedules", scheduleRepository.findAll());
		return mv;
	}
	
	@GetMapping("/pesquisar")
	public ModelAndView pesquisar(
			@RequestParam("id") Long id, 
			@RequestParam("dataInicial") String dataInicial, 
			@RequestParam("dataFinal") String dataFinal) throws ParseException {
		Children children = childrenRepository.getOne(id);
		ModelAndView mv = new ModelAndView("billings/billing");
		
		//List<Schedule> schedule = scheduleRepository.findAll();
		
		Schedule schedule = scheduleRepository.getOne(id);
		System.out.println(">>>>> SCHEDULE:  " + schedule);
		
		mv.addObject("schedules", schedule);
		mv.addObject("children", children);
		mv.addObject("valorTotal", scheduleRepository.somaFaturamento(children.getId(), new SimpleDateFormat("yyyy-MM-dd").parse(dataInicial), new SimpleDateFormat("yyyy-MM-dd").parse(dataFinal)));
		return mv;
	}
		
	/*@GetMapping("/buscar")
	public ModelAndView Search(
			@RequestParam(value = "id") Long id, 
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam(value = "dateInitial") Date dateInitial, 
			@RequestParam(value = "dateFinal") String dateFinal, 
			HttpServletRequest request, 
			HttpServletResponse response) {
	    ModelAndView mv = new ModelAndView("billings/billing");
	    Children children = childrenRepository.getOne(id);
	    
	    System.out.println("ID: " + children);
	    
	    mv.addObject("searchResult", scheduleRepository.somaFaturamento(id, dateInitial, dateFinal));      

	    return mv;
	}*/
	
	/*@PostMapping("/faturamento/{id}/{dateInitial}/{dateFinal}")
	public ModelAndView filterPerData(@Param("id") Long id, @Param("dateInitial") String dateInitial, @Param("dateFinal") String dateFinal) {
		ModelAndView mv = new ModelAndView("billings/list");		
		//Schedule schedule = (Schedule) scheduleRepository.buscaCriancaPorDataInicialEDataFinal(dateInitial, dateFinal, id);
		//System.out.println("Total: " + schedule);		
		return mv;
	}*/
	
	/*@RequestMapping(value="/search", method = RequestMethod.GET)
	public String Search(Schedule schedule, @RequestParam("id") Long id, @RequestParam("dateInitial") String dateInitial) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-mm-yyyy");
		LocalTime lt = schedule.getHourInitial();
		String ltString = lt.format(formatter);
		System.out.println(ltString);
		//System.out.println(scheduleRepository.buscaCriancaPorDataInicialEDataFinal(ltString, schedule.getHourFinale(), schedule.getId()));
		
	    return "search";
	}*/
	
	/*@RequestMapping("{id}/billings")
    public ModelAndView buscaFaturamentoCriancaPorData(@PathVariable("id") Long childrenId,
              @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
              @RequestParam("startDate") LocalTime startDate) {
		ModelAndView mv = new ModelAndView();
        mv.addObject("faturamento", scheduleRepository.buscaCriancaPorData(startDate, childrenId));
        System.out.println("TESTE: " + scheduleRepository.buscaCriancaPorData(startDate, childrenId));
        return mv;
    }*/
	
	/*@RequestMapping("/faturamento/pesquisar")
	public ModelAndView buscaSomaFaturamentoCriancaPorId(@RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-mm-dd") Date startDate, @RequestParam("id") Children id, Schedule s ) {
		List<Schedule> schedule = billingService.search(s.getDate(), s.getChildren());
		ModelAndView mv = new ModelAndView("billings/list");
		mv.addObject("schedules", schedule);
		return mv;
	}*/	
	
}
