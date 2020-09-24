package br.com.florafoz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.florafoz.model.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {

}
