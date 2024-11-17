package com.joaogui.dslist.dto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joaogui.dslist.dto.GameMinDTO;
import com.joaogui.dslist.entities.Game;
import com.joaogui.dslist.repositories.GameRepository;

// registrar o componente ⬇️
@Service


public class GameService {

	// Injetar um componente no outro (composição de componentes) = injeção de dependências de componentes no sistema.
	
	// Repository devolve Entidades 
	// Service pega Entidades e devolve DTO para o "mundo exterior".
	
	// Como GameRepository é um componente do sistema, deve-se injetar uns nos outros para compor o sistema em vários componentes. 
	@Autowired // Anotação que instancia(puxa) (sem construtor) a camada de baixo(GameRepository). 
	private GameRepository gameRepository; // Injeção de GameRepository dentro de GameService. GameService é uma camada acima de Repository. Ela puxa as Entidades. 
	
	public List<GameMinDTO> findAll(){
		List<Game> result = gameRepository.findAll();
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList(); // Transforma de entidade para dto. 
		return dto;
	}
	// stream é uma lib que permite fazer operações com sequências de dados.
	// .map() transforma de uma coisa para outra ("todo objeto x original que é Game, desejo transformar (->) em um new GameMinDTO(x)". 
	// GameMinDTO(x) >>> "transforme para GameMinDTO o que tiver como parâmetro, nesse caso, x"💭
}
