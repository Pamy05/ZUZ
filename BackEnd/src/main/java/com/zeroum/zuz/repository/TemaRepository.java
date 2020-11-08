package com.zeroum.zuz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zeroum.zuz.model.Tema;

@Repository
public interface TemaRepository extends JpaRepository<Tema, Long> {

	public List<Tema> findAllByNometemaContainingIgnoreCase(String nometema);
}
