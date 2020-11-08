package com.zeroum.zuz.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zeroum.zuz.model.User;

@Repository
public interface UsuarioRepository extends JpaRepository<User, Long>{

	public List<User> findAllByNomeContainingIgnoreCase(String nome);
	
	public Optional<User> findByUsuario(String usuario);
	
	
}
