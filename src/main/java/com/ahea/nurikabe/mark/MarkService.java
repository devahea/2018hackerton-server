package com.ahea.nurikabe.mark;

import com.ahea.nurikabe.calculator.CalculatorService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class MarkService {
    private final MarkResultRepository markResultRepository;
    private final CalculatorService calculatorService;
    private final ModelMapper modelMapper;

    public MarkService(MarkResultRepository markResultRepository, CalculatorService calculatorService, ModelMapper modelMapper) {
        this.markResultRepository = markResultRepository;
        this.calculatorService = calculatorService;
        this.modelMapper = modelMapper;
    }

    public MarkVo.Response mark(MarkVo.Request request) {
        //post_result에 start_tm가져오기
        int consumptionTime = getConsumptionTime(System.currentTimeMillis() - 2500);

        boolean isRight = false;

        if (this.calculatorService.isRight(request.getSource()))
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

    private int getConsumptionTime(long startTime) {
        long endTime = System.currentTimeMillis();
        return ((int) ((endTime - startTime) / 1000));
    }
}
