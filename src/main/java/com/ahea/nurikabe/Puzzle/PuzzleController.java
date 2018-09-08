package com.ahea.nurikabe.Puzzle;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/puzzle")
public class PuzzleController {

    private final PuzzleService puzzleService;
    public PuzzleController(PuzzleService puzzleService) {
        this.puzzleService = puzzleService;
    }

    @GetMapping("/start/{memberId}")
    public List<Puzzle> getPuzzleData(@PathVariable Integer memberId) {
        System.out.println("--------" + memberId);
        List<Puzzle> data = puzzleService.randomPuzzle(memberId);
        System.out.println("--------" + data);
        return data;
    }
}
