package com.zeroum.zuz.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.zeroum.zuz.model.User;
import com.zeroum.zuz.model.UsuarioLogin;
import com.zeroum.zuz.repository.UsuarioRepository;
import com.zeroum.zuz.service.UsuarioService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
	public ResponseEntity<List<User>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getById(@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<User> post(@RequestBody User usuario){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(usuario));
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<User> cadastrar(@RequestBody User usuario){
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.CadastrarUsuario(usuario));
	}
	
	@PostMapping("/logar")
	public ResponseEntity<UsuarioLogin> logar(@RequestBody Optional<UsuarioLogin> user){
		return usuarioService.Logar(user).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}
	
	
	@PutMapping
	public ResponseEntity<User> put (@RequestBody User usuario){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(usuario));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
}
