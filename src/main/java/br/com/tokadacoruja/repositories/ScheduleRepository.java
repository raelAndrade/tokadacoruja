package br.com.tokadacoruja.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.tokadacoruja.domain.Schedule;


@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

	// SELECT SUM(SCH_AMOUNT) AS total FROM SCHEDULE WHERE SCH_CHILDREN_ID=2;
	@Query("SELECT SUM(amount) AS total FROM Schedule s WHERE " +
			"s.children = :id")
	Schedule somaFaturamento(@Param("id") Long id);
	
	@Query("SELECT hourInitial, hourFinale, totalHours, payment "
			+ "FROM Schedule "
			+ "WHERE date >= ':dateInitial' AND date <= ':dateFinal' "
			+ "AND children = :id")
	List<Schedule> buscaCriancaPorDataInicialEDataFinal(@Param("dateInitial") String dateInitial, @Param("dateFinal") String dateFinal, @Param("id") Long id);
	
	/*@Query("SELECT t FROM Todo t WHERE " +
            "LOWER(t.title) LIKE LOWER(CONCAT('%',:searchTerm, '%')) OR " +
            "LOWER(t.description) LIKE LOWER(CONCAT('%',:searchTerm, '%'))")
    List<Todo> findBySearchTerm(@Param("searchTerm") String searchTerm);*/

}
