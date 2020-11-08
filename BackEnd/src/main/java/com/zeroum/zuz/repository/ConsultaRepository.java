package com.zeroum.zuz.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zeroum.zuz.model.Consulta;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long>{

	public List<Consulta> findAllByDescricaoContainingIgnoreCase(String descricao);
}
