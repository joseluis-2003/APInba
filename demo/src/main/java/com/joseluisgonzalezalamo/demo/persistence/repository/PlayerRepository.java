package com.joseluisgonzalezalamo.demo.persistence.repository;

import com.joseluisgonzalezalamo.demo.persistence.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Integer> { }
