package br.com.florafoz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.florafoz.model.FloraAddress;

public interface FloraAddressRepository extends JpaRepository<FloraAddress, Long> {

}
