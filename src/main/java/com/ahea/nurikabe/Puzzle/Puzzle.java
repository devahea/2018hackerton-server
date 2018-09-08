package com.ahea.nurikabe.Puzzle;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Puzzle {

    @Id
    @GeneratedValue
    private Integer id;
    private Integer size;
    private String source;
}
