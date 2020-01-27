package com.eloratingapp.eloapp.web;

import com.eloratingapp.eloapp.dao.GameRepository;
import com.eloratingapp.eloapp.dao.PlayerRepository;
import com.eloratingapp.eloapp.domain.EloCalc;
import com.eloratingapp.eloapp.entities.Game;
import com.eloratingapp.eloapp.entities.Player;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class GamesController {

    @Autowired
    GameRepository gameRepo;
    @Autowired
    PlayerRepository playerRepo;

    @GetMapping("/games")
    public String getGamesList() {
        List<Game> games = new ArrayList<>();
        gameRepo.findAll().forEach(games::add);
        return new Gson().toJson(games);
    }

    @GetMapping("/games/{gameId}")
    public Optional<Game> getGame(@PathVariable int gameId) {
        return gameRepo.findById(gameId);
    }

    @PostMapping("/games/add")
    public String makeGame(@RequestParam Integer winnerId, @RequestParam Integer loserId) {
        Optional<Player> gameWinner = playerRepo.findById(winnerId);
        Optional<Player> gameLoser = playerRepo.findById(loserId);

        if (gameWinner.isPresent() && gameLoser.isPresent()) {
            double ratingWinnerOld = gameWinner.get().getRating();
            double ratingLoserOld = gameLoser.get().getRating();

            double ratingWinnerNew = EloCalc.winnerRating(ratingWinnerOld, ratingLoserOld);
            double ratingLoserNew = EloCalc.loserRating(ratingLoserOld, ratingWinnerOld);

            double ratingChangeWinner = ratingWinnerNew - ratingWinnerOld;
            double ratingChangeLoser = ratingLoserOld - ratingLoserNew;

            gameWinner.get().setRating(ratingWinnerNew);
            gameLoser.get().setRating(ratingLoserNew);

            Game game = new Game(winnerId, loserId, ratingChangeWinner, ratingChangeLoser);
            gameRepo.save(game);

            return new Gson().toJson(game);
        } else {
            throw new NoSuchElementException();
        }

    }
}
