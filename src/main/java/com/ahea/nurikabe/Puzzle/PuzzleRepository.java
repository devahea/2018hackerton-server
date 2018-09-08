package com.ahea.nurikabe.Puzzle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PuzzleRepository extends JpaRepository<Puzzle,Integer> {

    @Query(value="select a.id as id , a.size as size, a.source as source from puzzle a left outer join post_result b on a.id = b.puzzle_id where a.id != 7 limit 1", nativeQuery = true)
    // List<Puzzle> randomPuzzle(@Param("memberId") Integer id);
    List<Puzzle> randomPuzzle();

    Puzzle findTop1ByIdNot(Integer id);
}
