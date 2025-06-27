package com.codsoft1.guessgame;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class GameController {

    private int targetNumber = -1;
    private int maxGuesses = 0;
    private int guessesMade = 0;

    @GetMapping("/start")
    public Map<String, Object> startGame(@RequestParam int range) {
        targetNumber = new Random().nextInt(range + 1);
        maxGuesses = (int) (Math.log(range) / Math.log(2)) + 1;
        guessesMade = 0;

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Game started!");
        response.put("maxGuesses", maxGuesses);
        return response;
    }

    @PostMapping("/guess")
    public Map<String, Object> makeGuess(@RequestParam int number) {
        Map<String, Object> response = new HashMap<>();

        if (guessesMade >= maxGuesses) {
            response.put("result", "Game over! No guesses left.");
            response.put("answer", targetNumber);
            return response;
        }

        guessesMade++;

        if (number > targetNumber) {
            response.put("result", "Too high");
        } else if (number < targetNumber) {
            response.put("result", "Too low");
        } else {
            response.put("result", "Correct! You guessed it!");
            response.put("attemptsUsed", guessesMade);
            return response;
        }

        response.put("guessesLeft", maxGuesses - guessesMade);
        return response;
    }
}
