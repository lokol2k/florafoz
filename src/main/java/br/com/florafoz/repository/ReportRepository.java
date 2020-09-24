package br.com.florafoz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.florafoz.model.Report;

public interface ReportRepository extends JpaRepository<Report, Long> {

}
