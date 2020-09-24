package br.com.florafoz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.florafoz.model.ApprobationLog;

public interface ApprobationLogRepository extends JpaRepository<ApprobationLog, Long>{

}
