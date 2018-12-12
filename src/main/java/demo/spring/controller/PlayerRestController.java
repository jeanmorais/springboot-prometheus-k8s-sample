package demo.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.spring.domain.Player;
import demo.spring.repository.PlayerRepository;

@RestController
@RequestMapping("/players")
public class PlayerRestController {
	
	@Autowired
	private PlayerRepository repository;
	
	@GetMapping
	private List<Player> getPlayers() {
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	private List<Player> getById(@PathVariable Integer id) {
		return repository.findById(id);
	}
}
