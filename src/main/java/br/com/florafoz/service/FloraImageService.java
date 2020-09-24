package br.com.florafoz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.florafoz.model.FloraImage;
import br.com.florafoz.repository.FloraImageRepository;

@Service
public class FloraImageService {

	@Autowired
	private FloraImageRepository repository;

	public FloraImage save(FloraImage entity) {
		try {
			return repository.save(entity);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public List<FloraImage> getAll() {
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

	public FloraImage findById(long id) {
		try {
			return repository.findById(id).get();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

}
