package com.joaogui.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaogui.dslist.dto.GameMinDTO;
import com.joaogui.dslist.dto.services.GameService;

@RestController
@RequestMapping("/games")
public class GameController {

	@Autowired
	private GameService gameService;
	
	@GetMapping
	public List<GameMinDTO> findAll(){
		List<GameMinDTO> result = gameService.findAll();
		return result;
	}
	// Agora, como lá em GameService eu já transformei Entidades para DTOs, em Controller eu só faço puxar esses DTOs para levar à requisição HTTP do usuário.
}
