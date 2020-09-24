package br.com.florafoz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.florafoz.model.Image;
import br.com.florafoz.repository.ImageRepository;

@Service
public class ImageService {

	@Autowired
	private ImageRepository repository;

	public Image save(Image entity) {
		try {
			return repository.save(entity);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public List<Image> getAll() {
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

	public Image findById(long id) {
		try {
			return repository.findById(id).get();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

}
