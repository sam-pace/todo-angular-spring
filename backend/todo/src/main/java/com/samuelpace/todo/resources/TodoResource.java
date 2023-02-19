package com.samuelpace.todo.resources;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.samuelpace.todo.domain.Todo;
import com.samuelpace.todo.services.TodoService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/todos")

public class TodoResource {

	@Bean
	CorsConfigurationSource corsConfigurationSource() {

		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

		final String headers = "Authorization, Access-Control-Allow-Headers, " +

				"Origin, Accept, X-Requested-With, Content-Type, " +

				"Access-Control-Request-Method, Custom-Filter-Header";

		CorsConfiguration config = new CorsConfiguration();

		config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE")); // Required for PUT method

		config.addExposedHeader(headers);

		config.setAllowCredentials(true);

		config.applyPermitDefaultValues();

		source.registerCorsConfiguration("/**", config);

		return source;
	}

	@Autowired
	private TodoService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Todo> findById(@PathVariable Integer id) {
		Todo obj = service.findById(id);
		return ResponseEntity.ok().body(obj);

	}

	@GetMapping(value = "/open") // lista todos abertos
	public ResponseEntity<List<Todo>> listOpen() {
		List<Todo> list = service.findAllOpen();
		return ResponseEntity.ok().body(list);

	}

	@GetMapping(value = "/close") // lista todos fechados
	public ResponseEntity<List<Todo>> listClose() {
		List<Todo> list = service.findAllClose();
		return ResponseEntity.ok().body(list);

	}

	@GetMapping
	public ResponseEntity<List<Todo>> listAll() { // listar tudo
		List<Todo> list = service.findAll();
		return ResponseEntity.ok().body(list);

	}

	@PostMapping
	public ResponseEntity<Todo> create(@RequestBody Todo obj) { // criar novo todo
		obj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@DeleteMapping(value = "/{id}") // apaga todo
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}") // atualiza todo
	public ResponseEntity<Todo> update(@PathVariable Integer id, @RequestBody Todo obj) {
		Todo newObj = service.update(id, obj);
		return ResponseEntity.ok().body(newObj);
	}

}
