package com.ahea.nurikabe.ranking;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table
@Data
public class RankResultDto {
	@Id
    @GeneratedValue
	private int member_id;
    private String user_id;
    private int size;
    private int sum_time;
    private int ranking;

}
