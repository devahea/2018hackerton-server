package com.ahea.nurikabe.puzzle;

import org.springframework.stereotype.Service;

@Service
public class PuzzleService {

    private final PuzzleRepository puzzleRepository;
    private final PostResultRepository postResultRepository;

    public PuzzleService(PuzzleRepository puzzleRepository, PostResultRepository postResultRepository) {
        this.puzzleRepository = puzzleRepository;
        this.postResultRepository = postResultRepository;
    }

    public Puzzle randomPuzzle(Integer memberId) {
        Puzzle puzzle = puzzleRepository.randomPuzzle(memberId);

        PostResult postResult = new PostResult();

        if (puzzle != null) {
            postResult.setMember_id(memberId);
            postResult.setPuzzle_id(puzzle.getId());
            postResultRepository.save(postResult);
        }
        return puzzle;
    }
}
