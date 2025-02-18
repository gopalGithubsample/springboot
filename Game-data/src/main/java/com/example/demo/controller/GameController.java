package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Player;
import com.example.demo.repository.PlayerRepository;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class GameController {

    @Autowired
    private PlayerRepository playerRepository;

    @PostMapping
    public ResponseEntity<Player> addPlayer(@RequestBody Player player) {
        if (playerRepository.findByName(player.getName()) != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build(); // Player exists
        }
        Player savedPlayer = playerRepository.save(player);
        return ResponseEntity.ok(savedPlayer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Player> updatePlayerScore(@PathVariable Long id, @RequestBody Player player) {
        return playerRepository.findById(id)
                .map(existingPlayer -> {
                    existingPlayer.setScore(player.getScore());
                    Player updatedPlayer = playerRepository.save(existingPlayer);
                    return ResponseEntity.ok(updatedPlayer);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable Long id) {
        playerRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}