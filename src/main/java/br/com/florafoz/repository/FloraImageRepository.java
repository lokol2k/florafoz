package br.com.florafoz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.florafoz.model.FloraImage;

public interface FloraImageRepository extends JpaRepository<FloraImage, Long> {

}
