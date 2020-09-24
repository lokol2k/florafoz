package br.com.florafoz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.florafoz.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
