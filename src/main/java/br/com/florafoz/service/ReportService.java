package br.com.florafoz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.florafoz.model.Report;
import br.com.florafoz.repository.ReportRepository;

@Service
public class ReportService {

	@Autowired
	private ReportRepository repository;

	public Report save(Report entity) {
		try {
			return repository.save(entity);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public List<Report> getAll() {
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

	public Report findById(long id) {
		try {
			return repository.findById(id).get();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

}
