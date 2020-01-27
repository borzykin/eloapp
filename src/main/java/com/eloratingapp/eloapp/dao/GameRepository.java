package com.eloratingapp.eloapp.dao;

import com.eloratingapp.eloapp.entities.Game;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<Game, Integer> {

}
