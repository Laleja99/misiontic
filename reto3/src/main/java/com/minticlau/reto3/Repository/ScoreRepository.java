package com.minticlau.reto3.Repository;

import com.minticlau.reto3.Model.Score;
import com.minticlau.reto3.Repository.Crud.ScoreCrudRepositoryInterface;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository

public class ScoreRepository {

    @Autowired
    private ScoreCrudRepositoryInterface scoreCrudRepositoryInterface;

    public List<Score> getScoreAll() {
        return (List<Score>) scoreCrudRepositoryInterface.findAll();
    }

    public Optional<Score> getScoreId(Integer id){
        return scoreCrudRepositoryInterface.findById(id);
    }

    public Score saveScore(Score score){
        return scoreCrudRepositoryInterface.save(score);
    }
    
}
