package com.ahea.nurikabe.Puzzle;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PuzzleService {

    private final PuzzleRepository puzzleRepository;
    private final PostResultRepository postResultRepository;

    public PuzzleService(PuzzleRepository puzzleRepository, PostResultRepository postResultRepository) {
        this.puzzleRepository = puzzleRepository;
        this.postResultRepository = postResultRepository;
    }

    public List<Puzzle> randomPuzzle(Integer memberId) {
        //List<Puzzle> puzzle = puzzleRepository.randomPuzzle(memberId);

        System.out.println(puzzleRepository.findAll().size());

        List<Puzzle> puzzle = Arrays.asList(puzzleRepository.findTop1ByIdNot(memberId));
        System.out.println(puzzle);

        PostResult postResult = new PostResult();

        if (puzzle.size() > 0) {
            postResult.setMember_id(memberId);
            postResult.setPuzzle_id(puzzle.get(0).getId());
            postResultRepository.save(postResult);
        }
        return puzzle;
    }
}
