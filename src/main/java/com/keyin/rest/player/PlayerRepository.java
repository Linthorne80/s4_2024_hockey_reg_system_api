package com.keyin.rest.player;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
}

    public List<Player> findAll() {
    }

    public Optional<Object> findById(Long id) {
    }

    public Player save(Player player) {
    }

    public void deleteById(Long id){}

