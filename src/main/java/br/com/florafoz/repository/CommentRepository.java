package br.com.florafoz.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.florafoz.model.Comment;
import br.com.florafoz.model.Flora;

public interface CommentRepository extends JpaRepository<Comment, Long> {
	
	Page<Comment> findByPostId(long postId, Pageable pageable);

}
