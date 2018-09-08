package com.ahea.nurikabe.ranking;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ranking")
public class RankingController {

	private final RankingRepository rankRepository;
	
	public RankingController(RankingRepository rankRepository) {
		this.rankRepository = rankRepository;
	}
	
    @GetMapping
    public List<RankResultDto> selectRanking() {
    	List<RankResultDto> result = rankRepository.rank();
    	//List<Map<String,Object>> result = rankRepository.rank();
    	System.out.println(result);
        return result;
    	
    }
    
    //localhost:8080/ranking
}
