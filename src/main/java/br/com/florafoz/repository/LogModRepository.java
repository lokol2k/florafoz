package br.com.florafoz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.florafoz.model.LogMod;

public interface LogModRepository extends JpaRepository<LogMod, Long> {

}
