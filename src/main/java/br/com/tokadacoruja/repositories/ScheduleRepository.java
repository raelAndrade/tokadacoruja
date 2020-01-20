package br.com.tokadacoruja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tokadacoruja.domain.Schedule;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

	// SELECT SUM(SCH_AMOUNT) AS total FROM SCHEDULE WHERE SCH_CHILDREN_ID=2;
	/*@Query(value = "SELECT SUM(amount) AS total FROM Schedule s WHERE " +
			"s.children=(:id)")
	Schedule somaFaturamento(@Param("id") Long id);*/
	
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
