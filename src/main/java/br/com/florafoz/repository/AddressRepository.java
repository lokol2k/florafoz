package br.com.florafoz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.florafoz.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

}
