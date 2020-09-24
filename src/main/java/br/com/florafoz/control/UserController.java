package br.com.florafoz.control;

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

import br.com.florafoz.model.User;
import br.com.florafoz.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping
	public ResponseEntity<?> save(@RequestBody User entity) {
		try {
			User body = service.save(entity);

			return ResponseEntity.ok(body);
		} catch (InternalError | Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}

	@GetMapping
	public ResponseEntity<?> getAll() {
		try {

			Page<User> response = service.getAll();

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
			User response = service.findById(id);

			return ResponseEntity.ok(response);
		} catch (InternalError | Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}

	@GetMapping("/name")
	public ResponseEntity<?> findByName(
			@RequestParam String name,
			@RequestParam(value = "page", required = false, defaultValue = "0") int page,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size) {
		
		try {
			
			Page<User> response = service.findByName(name, page, size);

			return ResponseEntity.ok(response);
		} catch (InternalError | Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}

}
