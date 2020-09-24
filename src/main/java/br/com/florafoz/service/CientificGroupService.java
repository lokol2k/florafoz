package br.com.florafoz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.florafoz.model.CientificGroup;
import br.com.florafoz.repository.CientificGroupRepository;

@Service
public class CientificGroupService {

	@Autowired
	private CientificGroupRepository repository;

	public CientificGroup save(CientificGroup entity) {
		try {
			return repository.save(entity);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public List<CientificGroup> getAll() {
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

	public CientificGroup findById(long id) {
		try {
			return repository.findById(id).get();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public List<CientificGroup> findByName(String name) {
		try {
			return repository.findByCientificNameContaining(name);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

}
