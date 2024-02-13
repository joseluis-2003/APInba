package com.joseluisgonzalezalamo.demo.services;

import com.joseluisgonzalezalamo.demo.persistence.model.Player;
import com.joseluisgonzalezalamo.demo.persistence.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PlayerServiceImp implements PlayerService{
    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public List<Player> obtenerJugadores() {
        return playerRepository.findAll();
    }

    @Override
    public Player obtenerJugadorID(int id) {
        return playerRepository.findById(id).orElse(null);
    }

    @Override
    public Player anadirJugador(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public Player actualizarJugador(int id, Player player) {
        if (playerRepository.existsById(id)) {
            player.setIdPlayer(id);
            return playerRepository.save(player);
        }
        return null;
    }

    @Override
    public void borrarJugador(int id) {
        playerRepository.deleteById(id);
    }
}
