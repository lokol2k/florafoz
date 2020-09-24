package br.com.florafoz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.florafoz.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long>{

}
