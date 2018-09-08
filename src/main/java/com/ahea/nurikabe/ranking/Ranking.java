package com.ahea.nurikabe.ranking;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table
@Data
public class Ranking {
    @Id
    @GeneratedValue
    private int id;
    private int member_id;
    //private Integer rankId;			/*랭킹id*/
    //private Integer rankNum;		/*랭킹순위*/
    private int puzzle_id;
    private int size;
    private int consumption_time;
    private int isRight;
    
}
