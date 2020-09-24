package br.com.florafoz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.florafoz.model.Post;
import br.com.florafoz.repository.PostRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository repository;

	public Post save(Post entity) {
		try {
			return repository.save(entity);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public Page<Post> getAll() {
		try {

			int page = 0;
			int size = 10;
			try {

				PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "popularName");

				return new PageImpl<>(repository.findAll(), pageRequest, size);
			} catch (Exception ex) {
				ex.printStackTrace();
				return null;
			}
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

	public Post findById(long id) {
		try {
			return repository.findById(id).get();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

}
