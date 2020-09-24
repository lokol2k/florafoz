package br.com.florafoz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.florafoz.model.CientificGroup;

public interface CientificGroupRepository extends JpaRepository<CientificGroup, Long> {

	List<CientificGroup> findByCientificNameContaining(String name);
	
}
