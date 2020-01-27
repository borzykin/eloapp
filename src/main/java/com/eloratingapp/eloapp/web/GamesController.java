package com.eloratingapp.eloapp.web;

import com.eloratingapp.eloapp.dao.GameRepository;
import com.eloratingapp.eloapp.entities.Game;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class GamesController {

    @Autowired
    GameRepository gameRepo;

    @GetMapping("/games")
    public String getGamesList() {
        List<Game> games = new ArrayList<>();
        gameRepo.findAll().forEach(games::add);
        return new Gson().toJson(games);
    }
}
