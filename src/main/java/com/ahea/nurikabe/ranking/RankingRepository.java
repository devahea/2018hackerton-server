package com.ahea.nurikabe.ranking;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RankingRepository  extends JpaRepository<RankResultDto, Integer> {
	
	String RANK = "SELECT AA.MEMBER_ID\n" + 
			",M.user_id\n" + 
			",AA.SIZE\n" + 
			",AA.SUM_TIME\n" + 
			",RANK() OVER(PARTITION by AA.SIZE ORDER BY AA.SIZE,AA.SUM_TIME) as ranking\n" + 
			"FROM (\n" + 
			"		SELECT \n" + 
			"			DISTINCT A.MEMBER_ID\n" + 
			"			/*,RANK() OVER( ORDER BY A.SUM_TIME) */\n" + 
			"			,RANK() OVER( ORDER BY A.SUM_TIME)\n" + 
			"			,A.SIZE\n" + 
			"			,A.CNT\n" + 
			"			,A.SUM_TIME\n" + 
			"		FROM (\n" + 
			"				select \n" + 
			"						count(pz.id) over(PARTITION by pz.size, mr.member_id order by mr.member_id) as cnt\n" + 
			"					, sum(mr.consumption_time) over(PARTITION by pz.size, mr.member_id) as sum_time\n" + 
			"					, pz.id\n" + 
			"					, pz.size\n" + 
			"					, mr.member_id\n" + 
			"					, mr.consumption_time\n" + 
			"				From puzzle pz\n" + 
			"				left outer join mark_result mr\n" + 
			"						on	pz.id = mr.puzzle_id\n" + 
			"				) A\n" + 
			"		) AA\n" + 
			"		INNER JOIN (\n" + 
			"						SELECT pz.size\n" + 
			"						/* COUNT(*)OVER(PARTITION by pz.size ) AS CNT  */\n" + 
			"						,COUNT(*) CNT\n" + 
			"						FROM puzzle pz\n" + 
			"						GROUP BY pz.size			\n" + 
			"						) B\n" + 
			"					ON AA.SIZE = B.SIZE\n" + 
			"					AND AA.CNT = B.CNT\n" + 
			"		left outer join member M\n" + 
			"		             on AA.MEMBER_ID = M.ID\n" + 
			"		WHERE AA.MEMBER_ID IS NOT NULL\n" + 
			"\n" + 
			"\n";
	
	@Query(value = RANK, nativeQuery=true)
	List<RankResultDto> rank();
	//List<Map<String,Object>> rank();
}
