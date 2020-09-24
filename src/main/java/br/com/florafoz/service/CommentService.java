package br.com.florafoz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.florafoz.model.Comment;
import br.com.florafoz.model.Flora;
import br.com.florafoz.repository.CommentRepository;

@Service
public class CommentService {

	@Autowired
	private CommentRepository repository;

	public Comment save(Comment entity) {
		try {
			return repository.save(entity);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public List<Comment> getAll() {
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

	public Comment findById(long id) {
		try {
			return repository.findById(id).get();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public Page<Comment> findByPostId(long postId, int page, int size) {
		try {
			
			PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "createdAt");

			
			return repository.findByPostId(postId, pageRequest);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	

}
