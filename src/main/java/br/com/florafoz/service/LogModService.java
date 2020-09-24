package br.com.florafoz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.florafoz.model.LogMod;
import br.com.florafoz.repository.LogModRepository;

@Service
public class LogModService {

	@Autowired
	private LogModRepository repository;

	public LogMod save(LogMod entity) {
		try {
			return repository.save(entity);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public List<LogMod> getAll() {
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

	public LogMod findById(long id) {
		try {
			return repository.findById(id).get();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

}
