package br.com.florafoz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.florafoz.model.User;
import br.com.florafoz.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public User save(User entity) {
		try {
			return repository.save(entity);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public Page<User> getAll() {
		int page = 0;
		int size = 10;
		try {

			PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "name");

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

	public User findById(long id) {
		try {
			return repository.findById(id).get();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public Page<User> findByName(String name, int page, int size) {
		try {
			PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "name");

			return repository.findByNameContaining(name, pageRequest);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
