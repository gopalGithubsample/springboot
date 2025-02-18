package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    Player findByName(String name); // Custom query to find by name
}