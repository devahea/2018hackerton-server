package com.ahea.nurikabe.mark;

import com.ahea.nurikabe.calculator.CalculatorService;
import com.ahea.nurikabe.puzzle.Puzzle;
import com.ahea.nurikabe.puzzle.PuzzleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class MarkService {
    private final MarkResultRepository markResultRepository;
    private final PuzzleRepository puzzleRepository;
    private final CalculatorService calculatorService;
    private final ModelMapper modelMapper;

    public MarkService(MarkResultRepository markResultRepository, PuzzleRepository puzzleRepository, CalculatorService calculatorService, ModelMapper modelMapper) {
        this.markResultRepository = markResultRepository;
        this.puzzleRepository = puzzleRepository;
        this.calculatorService = calculatorService;
        this.modelMapper = modelMapper;
    }

    public MarkVo.Response mark(MarkVo.Request request) {
        //post_result에 start_tm가져오기
        int consumptionTime = getConsumptionTime(System.currentTimeMillis() - 2500);

        Puzzle puzzle = this.puzzleRepository.findOne(request.getPuzzleId());

        boolean isRight = false;

        if (isRight(puzzle.getSource(), request.getSource()))
            isRight = true;

        MarkResult markResult = this.modelMapper.map(request, MarkResult.class);
        markResult.setConsumptionTime(consumptionTime);
        markResult.setIsRight(isRight);
        this.markResultRepository.save(markResult);

        MarkVo.Response response = new MarkVo.Response();
        response.setConsumptionTime(consumptionTime);
        response.setIsRight(isRight);
        return response;
    }

    private boolean isRight(String originalSource, String answerSource) {
        return this.calculatorService.getRightAnswer(originalSource).equals(answerSource);
    }

    private int getConsumptionTime(long startTime) {
        long endTime = System.currentTimeMillis();
        return ((int) ((endTime - startTime) / 1000));
    }
}
