package com.keyin.rest.player;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Player getPlayerById(Long id) {
        return playerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Player not found with id: " + id));
    }

    public Player createPlayer(Player player) {
        // Additional logic can be added here such as validation
        return playerRepository.save(player);
    }

    public Player updatePlayer(Long id, Player updatedPlayer) {
        Player player = getPlayerById(id);
        player.setBirthday(updatedPlayer.getBirthday());
        player.setFirstName(updatedPlayer.getFirstName());
        player.setLastName(updatedPlayer.getLastName());
        return playerRepository.save(player);
    }

    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }
}
