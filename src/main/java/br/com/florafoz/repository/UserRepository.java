package br.com.florafoz.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.florafoz.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Page<User> findByNameContaining(String name, Pageable pageable);
	
}
