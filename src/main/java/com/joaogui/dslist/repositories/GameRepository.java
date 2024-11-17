package com.joaogui.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joaogui.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long>{

	// Extende a interface JpaRepository que contém os métodos findAll, findById, delete, save, update etc. 
	// Essa interface GameRepository faz consulta ao banco, por isso os métodos acima. 
}
