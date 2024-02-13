package com.joseluisgonzalezalamo.demo.controller;

import com.joseluisgonzalezalamo.demo.dto.PlayerDTO;
import com.joseluisgonzalezalamo.demo.persistence.model.Player;
import com.joseluisgonzalezalamo.demo.services.PlayerServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/player")
public class PlayerController {
    @Autowired
    private PlayerServiceImp playerServiceImp;

    @GetMapping
    public List<Player> obtenerPlayer(){
     return playerServiceImp.obtenerJugadores();
    }

    @GetMapping("/{id}")
    public Player obtenerJugadorporId(@PathVariable int id) {
        return playerServiceImp.obtenerJugadorID(id);
    }

    private Player convertirDTOaJugador(PlayerDTO playerDTO) {
        return new Player(playerDTO.getName(), playerDTO.getPosition(), playerDTO.getClubName());
    }

    @PostMapping
    public Player anadirJugador(@RequestBody PlayerDTO playerDTO) {
        Player jugador = convertirDTOaJugador(playerDTO);
        return playerServiceImp.anadirJugador(jugador);
    }

    @PutMapping("/{id}")
    public Player actualizarJugador(@PathVariable int id, @RequestBody PlayerDTO playerDTO) {
        Player jugadorActualizado = convertirDTOaJugador(playerDTO);
        return playerServiceImp.actualizarJugador(id ,jugadorActualizado);
    }

    @DeleteMapping("/{id}")
    public void borrarJugador(@PathVariable int id) {
        playerServiceImp.borrarJugador(id);
    }
}
