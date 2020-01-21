package br.com.tokadacoruja.repositories;


import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.tokadacoruja.domain.Schedule;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

	// SELECT sum(s.sch_amount) as total FROM SCHEDULE s where s.sch_children_id=7 and s.sch_date between '2020-01-01' and '2020-01-31';
	// SELECT c.chi_name, s.sch_total_hours, sum(s.sch_amount) as total FROM SCHEDULE s, CHILDREN c where s.sch_children_id=7 and s.sch_date between '2020-01-01' and '2020-01-31' group by c.chi_name;
	@Query(value = 
			"SELECT SUM(s.amount) AS total "
			+ "FROM Schedule s "
			+ "WHERE s.children.id=:id "
			+ "AND s.date BETWEEN ':dateInitial' AND ':dateFinal'")
	Schedule somaFaturamento(@Param("id") Long id, @Param("dateInitial") Date date, @Param("dateFinal") String dateFinal);
	
	/*@Query("SELECT hourInitial, hourFinale, totalHours, payment "
			+ "FROM Schedule "
			+ "WHERE date >= :dateInitial "
			+ "AND children = :id")
	List<Schedule> search(@Param("dateInitial") Date dateInitial, @Param("id") Children id);*/
	
	/*@Query("SELECT t FROM Todo t WHERE " +
            "LOWER(t.title) LIKE LOWER(CONCAT('%',:searchTerm, '%')) OR " +
            "LOWER(t.description) LIKE LOWER(CONCAT('%',:searchTerm, '%'))")
    List<Todo> findBySearchTerm(@Param("searchTerm") String searchTerm);*/
	
	// select c.chi_name, s.sch_date, s.sch_amount from schedule s, children c where c.chi_id = s.sch_children_id;
	
	
}
