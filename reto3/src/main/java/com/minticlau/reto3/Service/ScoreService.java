package com.minticlau.reto3.Service;

import com.minticlau.reto3.Model.Score;
import com.minticlau.reto3.Repository.ScoreRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ScoreService {

    @Autowired

    private ScoreRepository scoreRepository;

    public List<Score> getScoreAll() {
        return scoreRepository.getScoreAll();
    }

    public Optional<Score> getScoreId(Integer id) {
        return scoreRepository.getScoreId(id);
    }

    public Score updateScore(Score score) {
        if (score.getIdScore() != null) {
            Optional<Score> scoreAuxiliar = scoreRepository.getScoreId(score.getIdScore());
            if (!scoreAuxiliar.isEmpty()) {
                if (score.getMessageText() != null) {
                    scoreAuxiliar.get().setMessageText(score.getMessageText());
                }
                if (score.getStars() != null) {
                    scoreAuxiliar.get().setStars(score.getStars());
                }
                scoreRepository.saveScore(scoreAuxiliar.get());
                return scoreAuxiliar.get();
            } else {
                return score;
            }
        } else {
            return score;
        }
    }

    public Score saveScore(Score score) {
        if (score.getIdScore() == null) {
            return scoreRepository.saveScore(score);
        } else {
            Optional<Score> scoreAuxiliar = scoreRepository.getScoreId(score.getIdScore());
            if (scoreAuxiliar.isEmpty()) {
                return scoreRepository.saveScore(score);
            } else {
                return score;
            }
        }
    }

}
