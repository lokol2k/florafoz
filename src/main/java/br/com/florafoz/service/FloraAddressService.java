package br.com.florafoz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.florafoz.model.FloraAddress;
import br.com.florafoz.repository.FloraAddressRepository;

@Service
public class FloraAddressService {

	@Autowired
	private FloraAddressRepository repository;

	public FloraAddress save(FloraAddress entity) {
		try {
			return repository.save(entity);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public List<FloraAddress> getAll() {
		try {
			return repository.findAll();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public void delete(long id) {
		try {
			repository.deleteById(id);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public FloraAddress findById(long id) {
		try {
			return repository.findById(id).get();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

}
