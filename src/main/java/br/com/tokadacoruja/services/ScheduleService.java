package br.com.tokadacoruja.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tokadacoruja.repositories.ChildrenRepository;

@Service
public class ScheduleService {

	/*@Autowired
	private ScheduleRepository scheduleRepository;*/
	
	@SuppressWarnings("unused")
	@Autowired
	private ChildrenRepository childrenRepository;
	
	/*@Transactional
	public Schedule saveSchedule(Schedule schedule) {
		return scheduleRepository.save(schedule);
	}*/
	
	/*public Schedule findScheduleChildrenById(Children children) {
		return scheduleRepository.findChildrenById(children.getId());
	}*/
	
	
	/*public Schedule findScheduleChildrenByData(Date date) {
		return scheduleRepository.findChildrenByDate(date);
	}*/
	
	
	/*public Schedule saveSchedule(Schedule schedule) {
		schedule.setStatus(true);
		schedule.setTotalHours(schedule.differenceHours(schedule.getHourInitial(), schedule.getHourFinale()));
		calculeOfHours(schedule);
		List<Children> scheduleChildren = childrenRepository.findAll();
		
		/*for (Children children : scheduleChildren) {
			if(schedule.getChildrens().contains(children.getId())){
				//schedule.setChildrens(children.getId());
			}
		}*/
		/*return scheduleRepository.save(schedule);*/
	/*}*/
	
	
	/*private void calculeOfHours(Schedule schedule) {
		String hour = schedule.getTotalHours();
		String hours[] = hour.split(":");
		Long h = Long.parseLong(hours[0]);
		Long m = Long.parseLong(hours[1]);
		Double valuePerHours = 0.0;
		Double valuePerMinutes = 0.0;
		Double totalValuePerHours = 0.0;
		
    	if(h < 0 && m <= 59) {
    		valuePerMinutes = schedule.getAmount();
    		schedule.setAmount(valuePerMinutes);
    	}else if(h >= 1 && m != 0) {
    		valuePerHours = h * schedule.getAmount();
    		valuePerMinutes = (schedule.getAmount() / 60.0) * m;
    		totalValuePerHours = valuePerHours + valuePerMinutes;
    		schedule.setAmount(totalValuePerHours);
    	}else if(h >= 1 && m == 0){
    		valuePerHours = h * schedule.getAmount();
    		schedule.setAmount(valuePerHours);
    	}
	}*/
	
}