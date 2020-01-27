package com.eloratingapp.eloapp.web;

import com.eloratingapp.eloapp.dao.PlayerRepository;
import com.eloratingapp.eloapp.entities.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PlayersController {

    @Autowired
    PlayerRepository playerRepo;

    @GetMapping("/players")
    public List<Player> getPlayersList() {
        List<Player> players = new ArrayList<>();
        playerRepo.findAll().forEach(players::add);
        return players;
    }

    @PostMapping("/players/add")
    public String addPlayer(@RequestParam String name, @RequestParam String score) {
        playerRepo.save(new Player(name.trim(), Double.parseDouble(score)));
        return "success";
    }

}