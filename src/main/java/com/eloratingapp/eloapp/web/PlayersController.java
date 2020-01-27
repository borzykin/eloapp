package com.eloratingapp.eloapp.web;

import com.eloratingapp.eloapp.dao.PlayerRepository;
import com.eloratingapp.eloapp.entities.Player;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PlayersController {

    @Autowired
    PlayerRepository playerRepo;

    @GetMapping("/players")
    public String getPlayersList() {
        List<Player> players = new ArrayList<>();
        playerRepo.findAll().forEach(players::add);
        return new Gson().toJson(players);
    }

    @GetMapping("/players/{playerId}")
    public Optional<Player> getPlayer(@PathVariable int playerId) {
        return playerRepo.findById(playerId);
    }

    @PostMapping("/players/add")
    public String addPlayer(@RequestParam String name, @RequestParam String score) {
        playerRepo.save(new Player(name.trim(), Double.parseDouble(score)));
        return "success";
    }

}
