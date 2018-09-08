package com.ahea.nurikabe.mark;

import lombok.Data;

public class MarkVo {

    @Data
    public static class Request {
        private Integer memberId;
        private Integer puzzleId;
        private Integer size;
        private String source;
    }

    @Data
    public static class Response {
        private Boolean isRight;
        private Integer consumptionTime;
    }
}
