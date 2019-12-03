package br.com.tokadacoruja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tokadacoruja.domain.Children;

@Repository
public interface ChildrenRepository extends JpaRepository<Children, Long> {
	
}
