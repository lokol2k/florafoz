package br.com.florafoz.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.florafoz.model.LogMod;
import br.com.florafoz.service.LogModService;

@Controller
@RequestMapping("/logMods")
public class LogModController {

	@Autowired
	private LogModService service;

	@PostMapping
	public ResponseEntity<?> save(@RequestBody LogMod entity) {
		try {
			LogMod body = service.save(entity);

			return ResponseEntity.ok(body);
		} catch (InternalError | Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}

	@GetMapping
	public ResponseEntity<?> getAll() {
		try {

			List<LogMod> response = service.getAll();

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
			LogMod response = service.findById(id);

			return ResponseEntity.ok(response);
		} catch (InternalError | Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}

}
