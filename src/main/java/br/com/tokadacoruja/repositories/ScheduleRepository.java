package br.com.tokadacoruja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tokadacoruja.domain.Schedule;


@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

}
