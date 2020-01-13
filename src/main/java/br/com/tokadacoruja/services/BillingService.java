package br.com.tokadacoruja.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tokadacoruja.domain.Children;
import br.com.tokadacoruja.domain.Schedule;
import br.com.tokadacoruja.repositories.ScheduleRepository;

@Service
public class BillingService {

	@Autowired
	private ScheduleRepository scheduleRepository;
	
	public List<Schedule> search(Date startDate, Children id){
		return scheduleRepository.search(startDate, id);
	}
}
