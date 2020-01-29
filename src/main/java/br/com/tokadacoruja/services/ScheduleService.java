package br.com.tokadacoruja.services;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.tokadacoruja.domain.Schedule;
import br.com.tokadacoruja.repositories.ScheduleRepository;

@Service
public class ScheduleService {

	@Autowired
	private ScheduleRepository scheduleRepository;
	
	@Transactional
	public Schedule saveSchedule(Schedule schedule) {
		return scheduleRepository.save(schedule);
	}
	
	public Schedule findScheduleChildrenByIdAndData(Long id, Date date) {
		return scheduleRepository.findByIdAndDate(id, date);
	}
	
}