package demo.spring.repository;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import demo.spring.domain.Player;

@Repository
public class PlayerRepository {

	private static final Logger log = LoggerFactory.getLogger(PlayerRepository.class);

	List<Player> players;

	@PostConstruct
	public void init() {
		players = Arrays.asList(
				new Player(1, "Hugo Lloris", "GK"),
				new Player(2, "Matts Hummels", "DF"),
				new Player(3, "James Rodriguez", "MF"),
				new Player(4, "Antoine Griezmann", "FW"),
				new Player(5, "Kylian Mbappé", "FW"),
				new Player(6, "Cristiano Ronaldo", "FW"));

	}

	public List<Player> findAll() {
		log.info("Total players found {}", this.players.size());
		return this.players;
	}

	public List<Player> findById(Integer id) {
		log.info("Finding by ID. id={}", id);
		return players.stream().filter(player -> id.equals(player.getId())).collect(Collectors.toList());
	}

}
