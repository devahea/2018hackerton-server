package com.ahea.nurikabe.mark;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MarkResult {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer memberId;
    private Integer puzzleId;
    private Integer size;
    private int consumptionTime;
    private Boolean isRight;
}
