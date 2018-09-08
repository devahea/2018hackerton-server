package com.ahea.nurikabe.puzzle;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Puzzle {
    @Id
    @GeneratedValue
    public Integer id;

    public Integer size;

    @Lob
    public String source;
}
