package br.com.tokadacoruja.resources;

import org.springframework.stereotype.Controller;

@Controller
public class ScheduleController {
	
	/*@Autowired
	private ScheduleRepository scheduleRepository;*/
	
	/*@Autowired
	private ScheduleService scheduleService;*/ 
	
	/*@Autowired
	private ChildrenRepository childrenRepository;*/
	
	/*@GetMapping("/agendamentos/calendario")
	public ModelAndView getCalendar(Schedule schedule) {
		ModelAndView mv = new ModelAndView("schedule/calendar");
		List<Children> childrens = childrenRepository.findAll();
		mv.addObject("payments", Payment.values());
		mv.addObject("childrens", childrens);
		mv.addObject("schedule", schedule);
		return mv;
	}*/
	
	/*@GetMapping("/agendamentos/agendar")
	public ModelAndView form(Schedule schedule) {
		ModelAndView mv = new ModelAndView("schedule/form");
		List<Children> childrens = childrenRepository.findAll();
		mv.addObject("payments", Payment.values());
		mv.addObject("childrens", childrens);
		mv.addObject("schedule", schedule);
		return mv;
	}*/
	
	/*@GetMapping("/agendamentos/listar")
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("schedule/list");
		mv.addObject("schedules", scheduleRepository.findAll());
		return mv;
	}*/
	
	/*@PostMapping("/agendamentos/salvar")
	public ModelAndView save(@Valid Schedule schedule, final Children children, BindingResult result, RedirectAttributes attributes) {
		final ModelAndView mv = new ModelAndView();	
		if(schedule.getChildrens() != null) {
			mv.addObject("mensagem", "Usuário já cadastrado!");
			mv.addObject("user", new User());
		}		
		if(result.hasErrors()) {
			return form(schedule);
		}
		scheduleService.saveSchedule(schedule);					
		return new ModelAndView("redirect:/agendamentos/calendario");
	}*/

	/*@GetMapping("/agendamentos/editar/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		Optional<Schedule> schedule = scheduleRepository.findById(id);
		ModelAndView mv = new ModelAndView("schedule/form");
		List<Children> childrens = childrenRepository.findAll();
		mv.addObject("childrens", childrens);
		mv.addObject("schedule", schedule.get());
		return mv;
	}*/
	
	/*@GetMapping("/agendamentos/remover/{id}")
	public ModelAndView remove(@PathVariable Long id){
		final Schedule schedule = scheduleRepository.getOne(id);
		schedule.setStatus(false);
		scheduleRepository.save(schedule);
		
		ModelAndView mv = new ModelAndView("schedule/list");
		mv.addObject("schedules", childrenRepository.findAll());
		mv.addObject("schedule", new Schedule());
		return mv;
	}*/
	
	/*@ResponseBody
	@RequestMapping(value = "/agendamentos/list-calendar", method = RequestMethod.GET)
	public List<Schedule> fullCalendar(Schedule schedule) {
		List<Schedule> schedules = scheduleRepository.findAll();
		return schedules;
	}*/
	
}
