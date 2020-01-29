package br.com.tokadacoruja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tokadacoruja.domain.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	
	Role findByRole(String role);

}
