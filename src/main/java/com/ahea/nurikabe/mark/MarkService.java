package com.ahea.nurikabe.mark;

import antlr.StringUtils;
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

        int[][] arrays = MarkUtils.Convert2Array(answerSource);

        return isEmptyCheck(arrays) && poolOverCheck(arrays) && isOnePoolCheck(arrays);

    }

    private boolean isEmptyCheck(int[][] source) {

        for(int i = 0 ; i < source.length; i++) {
            for(int j = 0 ; j < source[0].length; j++) {
                if( !(isRoom(source[i][j]) && isPool(source[i][j]) && isEmptyBlock(source[i][j]))) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean poolOverCheck(int[][] source) {
        for(int i = 0 ; i < source.length -1; i++) {
            for(int j = 0 ; j < source[0].length -1; j++) {
                if( isPool(source[i][j]) && isPool(source[i+1][j]) && isPool(source[i][j+1]) && isPool(source[i+1][j+1]) ) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isOnePoolCheck(int[][] source) {
        for(int i = 0 ; i < source.length ; i++) {
            for(int j = 0 ; j < source[0].length ; j++) {
                if( isPool(source[i][j])) {
                    if(
                        (i == source.length || !isPool(source[i+1][j])) &&
                        (j == source[0].length || !isPool(source[i][j+1]))  &&
                        (i == 0 || !isPool(source[i-1][j])) &&
                        (j == 0 || !isPool(source[i][j-1]))
                        ) {

                        return false;

                    }
                }
            }
        }
        return true;
    }

    private boolean isPool(int item) {
        return item == 1;
    }
    private boolean isEmptyBlock(int item) {
        return item == -1;
    }
    private boolean isRoom(int item) {
        return item == 0;
    }

    private int getConsumptionTime(long startTime) {
        long endTime = System.currentTimeMillis();
        return ((int) ((endTime - startTime) / 1000));
    }
}
