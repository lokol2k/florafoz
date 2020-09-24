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

import br.com.florafoz.model.Flora;
import br.com.florafoz.service.FloraService;

@Controller
@RequestMapping("/floras")
public class FloraController {

	@Autowired
	private FloraService service;

	@PostMapping
	public ResponseEntity<?> save(@RequestBody Flora entity) {
		try {
			Flora body = service.save(entity);

			return ResponseEntity.ok(body);
		} catch (InternalError | Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}

	@GetMapping
	public ResponseEntity<?> getAll() {
		try {

			Page<Flora> response = service.getAll();

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
			Flora response = service.findById(id);

			return ResponseEntity.ok(response);
		} catch (InternalError | Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}

	@GetMapping("/poison/{isPoison}")
	public ResponseEntity<?> findByPoison(@PathVariable boolean isPoison,
			@RequestParam(value = "page", required = false, defaultValue = "0") int page,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size) {
		try {
			Page<Flora> response = service.findByPoison(isPoison, page, size);

			return ResponseEntity.ok(response);
		} catch (InternalError | Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}

	@GetMapping("/eatable/{isEatable}")
	public ResponseEntity<?> findByEatable(@PathVariable boolean isEatable,
			@RequestParam(value = "page", required = false, defaultValue = "0") int page,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size) {
		try {

			Page<Flora> response = service.findByEatable(isEatable, page, size);

			return ResponseEntity.ok(response);
		} catch (InternalError | Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}

	@GetMapping("/scigroup/{id}")
	public ResponseEntity<?> findByScientificGroupId(@PathVariable long id,
			@RequestParam(value = "page", required = false, defaultValue = "0") int page,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size) {
		try {

			Page<Flora> response = service.findByScientificGroupId(id, page, size);

			return ResponseEntity.ok(response);
		} catch (InternalError | Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}

	@GetMapping("/popularName")
	public ResponseEntity<?> findByPopularName(@RequestParam String popularName,
			@RequestParam(value = "page", required = false, defaultValue = "0") int page,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size) {
		try {
			Page<Flora> response = service.findByPopularNameLike(popularName, page, size);

			return ResponseEntity.ok(response);
		} catch (InternalError | Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}

}
