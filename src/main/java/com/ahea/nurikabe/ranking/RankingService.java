package com.ahea.nurikabe.ranking;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class RankingService {

    private RankingRepository rankRepository;

    public RankingService(RankingRepository rankRepository) {
        this.rankRepository = rankRepository;
    }

	public List<Ranking> selectRanking(Ranking ranking) {
		// TODO Auto-generated method stub
		List<Ranking> resultList = new ArrayList<Ranking>();
		//List<Ranking> rankList = this.rankRepository.findAll();
		
		return resultList;
	}
	
	public void test(int puzzleSize) {
		//퍼즐사이즈를 통해서 DB에 몇문제인지 확인
		
		
		//mark_result 위의 값을 통해서 문제를 다푼사람 
		//where size 가져온다
		//member_id 그룹핑
		//그룹핑 개수가 == 해당사이즈의 문제인것들을 필터하고
		
		
		//time을 다 더한다
		
		//낮은 사람 순으로 오더바이를 한다.
		
		
	}
    
}
