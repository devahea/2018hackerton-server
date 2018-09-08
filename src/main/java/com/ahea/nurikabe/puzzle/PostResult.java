package com.ahea.nurikabe.puzzle;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Data
public class PostResult {

    @Id
    @GeneratedValue
    private Integer post_result_id;
    private Integer member_id;
    private Integer puzzle_id;
    private String puzzle_start_tm;
    private String puzzle_end_tm;
    private String puzzle_comple;
}
