package com.ahea.nurikabe.puzzle;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/puzzle")
public class PuzzleController {

    private final PuzzleService puzzleService;
    public PuzzleController(PuzzleService puzzleService) {
        this.puzzleService = puzzleService;
    }

    @GetMapping("/start/{memberId}")
    public Puzzle getPuzzleData(@PathVariable Integer memberId) {
        Puzzle data = puzzleService.randomPuzzle(memberId);
        return data;
    }
}
