package br.com.florafoz.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.florafoz.model.Comment;
import br.com.florafoz.service.CommentService;

@Controller
@RequestMapping("/comments")
public class CommentController {

	@Autowired
	private CommentService service;

	@PostMapping
	public ResponseEntity<?> save(@RequestBody Comment entity) {
		try {
			Comment body = service.save(entity);

			return ResponseEntity.ok(body);
		} catch (InternalError | Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}

	@GetMapping
	public ResponseEntity<?> getAll() {
		try {

			List<Comment> response = service.getAll();

			return ResponseEntity.ok(response);
		} catch (InternalError | Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}

	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteById(@PathVariable long id) {
		try {
			service.delete(id);

			return ResponseEntity.ok(true);
		} catch (InternalError | Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}

	@GetMapping("{id}")
	public ResponseEntity<?> findById(@PathVariable long id) {
		try {
			Comment response = service.findById(id);

			return ResponseEntity.ok(response);
		} catch (InternalError | Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}

	
	@GetMapping("/post/{id}")
	public ResponseEntity<?> findByPostId(@PathVariable long postid,
			@RequestParam(value = "page", required = false, defaultValue = "0") int page,
			@RequestParam(value = "size", required = false, defaultValue = "5") int size) {
		try {

			Page<Comment> response = service.findByPostId(postid, page, size);

			return ResponseEntity.ok(response);
		} catch (InternalError | Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	
}
