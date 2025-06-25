package com.codsoft1.guessgame;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="*")

public class GameController {

    private int target = -1;
    private int maxguesses = 0;
    private int guessesMade = 0;

    @PostMapping("/start")
    public Map<String,Object> startGame(@RequestParam int range){
        target = (int)(Math.random() * range);
        maxguesses = (int) (Math.log(range) / Math.log(2));
        guessesMade = 0;

        Map<String, Object>response = new HashMap<>();
        response.put("message","Game started");
        response.put("Maximum guesses",maxguesses);
        return response;
    }
    
    @PostMapping("/guess")
    public Map<String,Object> makeGuess(@RequestParam int number){
        Map<String, Object>response = new HashMap<>();
        if (guessesMade >= maxguesses){
            response.put("result", "Game over!No guesses left");
            response.put("The number was ",target);
            return response;
        }
        guessesMade++;
        if(number > target){
            response.put("result","Too high yo");
        }
        else if(number < target){
            response.put("restult","Too low bro");
        }
        else{
            response.put("result","Yooooooo, you guessed it!");
            response.put("Attempts used",guessesMade);
            return response;
        }
        response.put("Guesses left",maxguesses - guessesMade);
        return response;
    }
}