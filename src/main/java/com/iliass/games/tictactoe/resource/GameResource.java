package com.iliass.games.tictactoe.resource;

import com.iliass.games.tictactoe.dao.GameDao;
import com.iliass.games.tictactoe.model.Position;
import com.iliass.games.tictactoe.services.GameServices;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/game")
public class GameResource {

    public GameResource(GameServices gameServices) {
        this.gameServices = gameServices;
    }

    private  final GameServices gameServices;


    @RequestMapping(method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            path = {"play"})
    public void play(@RequestBody Position position){
        gameServices.play(position);
    }
}
