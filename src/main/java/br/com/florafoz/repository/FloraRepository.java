package br.com.florafoz.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.florafoz.model.Flora;

public interface FloraRepository extends JpaRepository<Flora, Long> {

	Page<Flora> findByIsPoison(boolean isPoison, Pageable pageable);
	
	Page<Flora> findByIsEatable(boolean isEatable, Pageable pageable);
	
	Page<Flora> findByCientificGroupId(long groupId, Pageable pageable);
	
	Page<Flora> findByPopularNameContaining(String popularName, Pageable pageable);
}
