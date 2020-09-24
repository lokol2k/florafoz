package br.com.florafoz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.florafoz.model.Flora;
import br.com.florafoz.repository.FloraRepository;

@Service
public class FloraService {

	@Autowired
	private FloraRepository repository;

	public Flora save(Flora entity) {
		try {
			return repository.save(entity);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public Page<Flora> getAll() {
		int page = 0;
		int size = 10;
		try {

			PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "popularName");

			return new PageImpl<>(repository.findAll(), pageRequest, size);
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

	public Flora findById(long id) {
		try {
			return repository.findById(id).get();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public Page<Flora> findByPoison(boolean isPoison, int page, int size) {
		try {
			
			PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "popularName");

			
			return repository.findByIsPoison(isPoison, pageRequest);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public Page<Flora> findByEatable(boolean isEatable, int page, int size) {
		try {
			PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "popularName");

			
			return repository.findByIsEatable(isEatable, pageRequest);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public Page<Flora> findByScientificGroupId(long groupId, int page, int size) {
		try {
			
			PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "popularName");

			
			return repository.findByCientificGroupId(groupId, pageRequest);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public Page<Flora> findByPopularNameLike(String popularName, int page, int size) {
		try {
			PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "popularName");

			
			return repository.findByPopularNameContaining(popularName, pageRequest);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

}
