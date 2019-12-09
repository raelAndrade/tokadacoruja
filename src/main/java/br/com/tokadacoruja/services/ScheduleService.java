package br.com.tokadacoruja.services;

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
	public void save(Schedule schedule) {
		scheduleRepository.save(schedule);
	}
	
}
